package com.ninni.dye_depot.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDSheets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.ShulkerBoxRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Environment(EnvType.CLIENT)
@Mixin(ShulkerBoxRenderer.class)
public class ShulkerBoxRendererMixin {
    @Shadow
    @Final
    private ShulkerBoxRenderer.ShulkerBoxModel model;

    @Inject(
        method = "render(Lnet/minecraft/world/level/block/entity/ShulkerBoxBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void DD$injectShulkerSheet(ShulkerBoxBlockEntity shulkerBoxBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, CallbackInfo ci) {
        DyeColor dyeColor = shulkerBoxBlockEntity.getColor();
        if (dyeColor != null && DDDyes.getAll().contains(dyeColor)) {
            Direction direction = Direction.UP;
            if (shulkerBoxBlockEntity.hasLevel()) {
                BlockState blockState = shulkerBoxBlockEntity.getLevel().getBlockState(shulkerBoxBlockEntity.getBlockPos());
                if (blockState.getBlock() instanceof ShulkerBoxBlock) {
                    direction = blockState.getValue(ShulkerBoxBlock.FACING);
                }
            }

            Material material = DDSheets.SHULKER_TEXTURE_LOCATION.get(dyeColor.getId() - 16);

            poseStack.pushPose();
            poseStack.translate(0.5F, 0.5F, 0.5F);
            float g = 0.9995F;
            poseStack.scale(g, g, g);
            poseStack.mulPose(direction.getRotation());
            poseStack.scale(1.0F, -1.0F, -1.0F);
            poseStack.translate(0.0F, -1.0F, 0.0F);
            this.model.animate(shulkerBoxBlockEntity, f);
            ShulkerBoxRenderer.ShulkerBoxModel var10002 = this.model;
            Objects.requireNonNull(var10002);
            VertexConsumer vertexConsumer = material.buffer(multiBufferSource, var10002::renderType);
            this.model.renderToBuffer(poseStack, vertexConsumer, i, j);
            poseStack.popPose();

            ci.cancel();
        }
    }
}
