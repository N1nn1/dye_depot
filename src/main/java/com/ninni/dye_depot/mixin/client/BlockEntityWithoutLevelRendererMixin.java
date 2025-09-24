package com.ninni.dye_depot.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.ninni.dye_depot.registry.DDDyes;
import java.util.Arrays;
import java.util.Comparator;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntityWithoutLevelRenderer.class)
public class BlockEntityWithoutLevelRendererMixin {
    @Shadow
    @Final
    private BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    @Unique
    private static final ShulkerBoxBlockEntity[] SHULKER_BOXES =
            Arrays.stream(DDDyes.values())
                    .sorted(Comparator.comparingInt(DDDyes::getId))
                    .map((dyeColor) -> new ShulkerBoxBlockEntity(dyeColor.get(), BlockPos.ZERO, Blocks.SHULKER_BOX.defaultBlockState()))
                    .toArray(ShulkerBoxBlockEntity[]::new);


    @Inject(method = "renderByItem", at = @At("HEAD"), cancellable = true)
    private void DD$renderShulkerBoxes(ItemStack stack, ItemDisplayContext context, PoseStack poseStack, MultiBufferSource bufferSource, int i, int j, CallbackInfo ci) {
        if (!(stack.getItem() instanceof BlockItem blockItem)) return;
        if (!(blockItem.getBlock() instanceof ShulkerBoxBlock shulkerBox)) return;
        var color = shulkerBox.getColor();
        if (color == null) return;
        if (!DDDyes.isModDye(color)) return;

        ci.cancel();
        var be = SHULKER_BOXES[color.getId() - 16];
        blockEntityRenderDispatcher.renderItem(be, poseStack, bufferSource, i, j);
    }
}
