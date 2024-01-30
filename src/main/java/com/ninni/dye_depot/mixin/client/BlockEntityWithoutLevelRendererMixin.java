package com.ninni.dye_depot.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.ninni.dye_depot.block.DDShulkerBoxBlock;
import com.ninni.dye_depot.block.DDShulkerBoxBlockEntity;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.Comparator;

@Environment(EnvType.CLIENT)
@Mixin(BlockEntityWithoutLevelRenderer.class)
public class BlockEntityWithoutLevelRendererMixin {
    @Shadow @Final private BlockEntityRenderDispatcher blockEntityRenderDispatcher;
    @Unique
    private static final DDShulkerBoxBlockEntity[] SHULKER_BOXES =
            Arrays.stream(DDDyes.values())
                    .sorted(Comparator.comparingInt(DDDyes::getId))
                    .map((dyeColor) -> new DDShulkerBoxBlockEntity(dyeColor.get(), BlockPos.ZERO, DDBlocks.MAROON_SHULKER_BOX.defaultBlockState()))
                    .toArray(DDShulkerBoxBlockEntity[]::new);


    @Inject(method = "renderByItem", at = @At("HEAD"), cancellable = true)
    private void DD$renderShulkerItems(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, CallbackInfo ci) {

        if (itemStack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof DDShulkerBoxBlock) {
            ci.cancel();

            Object blockEntity;
            DyeColor dyeColor = DDShulkerBoxBlock.getColorFromBlock(blockItem.getBlock());
            if (dyeColor == null) {
                blockEntity = new ShulkerBoxBlockEntity(BlockPos.ZERO, Blocks.SHULKER_BOX.defaultBlockState());;
            } else {
                blockEntity = SHULKER_BOXES[dyeColor.getId() - 16];
            }

            this.blockEntityRenderDispatcher.renderItem((BlockEntity)blockEntity, poseStack, multiBufferSource, i, j);
        }


    }
}
