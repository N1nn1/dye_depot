package com.ninni.dye_depot.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.ninni.dye_depot.block.DDBedBlock;
import com.ninni.dye_depot.block.DDBedBlockEntity;
import com.ninni.dye_depot.block.DDShulkerBoxBlock;
import com.ninni.dye_depot.block.DDShulkerBoxBlockEntity;
import com.ninni.dye_depot.registry.DDDyes;
import java.util.Arrays;
import java.util.Comparator;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(BlockEntityWithoutLevelRenderer.class)
public class BlockEntityWithoutLevelRendererMixin {
    @Shadow @Final private BlockEntityRenderDispatcher blockEntityRenderDispatcher;
    @Shadow @Final private static ShulkerBoxBlockEntity DEFAULT_SHULKER_BOX;
    @Unique
    private static final DDShulkerBoxBlockEntity[] SHULKER_BOXES =
            Arrays.stream(DDDyes.values())
                    .sorted(Comparator.comparingInt(DDDyes::getId))
                    .map((dyeColor) -> new DDShulkerBoxBlockEntity(dyeColor.get(), BlockPos.ZERO, Blocks.SHULKER_BOX.defaultBlockState()))
                    .toArray(DDShulkerBoxBlockEntity[]::new);




    @Inject(method = "renderByItem", at = @At("HEAD"), cancellable = true)
    private void DD$renderDyedItems(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, CallbackInfo ci) {

        if (itemStack.getItem() instanceof BlockItem blockItem && (blockItem.getBlock() instanceof DDShulkerBoxBlock || blockItem.getBlock() instanceof DDBedBlock)) {
            ci.cancel();

            Block block = blockItem.getBlock();
            BlockEntity blockEntity;

            if (block instanceof DDShulkerBoxBlock) {
                DyeColor dyeColor = DDShulkerBoxBlock.getColorFromBlock(block);
                if (dyeColor == null) blockEntity = DEFAULT_SHULKER_BOX;
                else blockEntity = SHULKER_BOXES[dyeColor.getId() - 16];
            }
            else if (block instanceof DDBedBlock) {
                DDBedBlockEntity ddBed = new DDBedBlockEntity(BlockPos.ZERO, block.defaultBlockState());
                ddBed.setColor(((DDBedBlock)block).getColor());
                blockEntity = ddBed;
            } else blockEntity = null;


            this.blockEntityRenderDispatcher.renderItem(blockEntity, poseStack, multiBufferSource, i, j);
        }


    }
}
