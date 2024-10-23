package com.ninni.dye_depot.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDSheets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ShulkerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
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

@Environment(EnvType.CLIENT)
@Mixin(ShulkerBoxRenderer.class)
public class ShulkerBoxRendererMixin {
    @Shadow
    @Final
    private ShulkerModel<?> model;

    @Inject(
        method = "render(Lnet/minecraft/world/level/block/entity/ShulkerBoxBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void DD$injectShulkerSheet(ShulkerBoxBlockEntity shulkerBoxBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, CallbackInfo ci) {
        DyeColor dyeColor = shulkerBoxBlockEntity.getColor();
        if (dyeColor != null && DDDyes.getAll().contains(dyeColor)) {
            BlockState blockState;
            Direction direction = Direction.UP;
            if (shulkerBoxBlockEntity.hasLevel() && (blockState = shulkerBoxBlockEntity.getLevel().getBlockState(shulkerBoxBlockEntity.getBlockPos())).getBlock() instanceof ShulkerBoxBlock) {
                direction = blockState.getValue(ShulkerBoxBlock.FACING);
            }
            Material material = DDSheets.SHULKER_TEXTURE_LOCATION.get(dyeColor.getId() - 16);
            poseStack.pushPose();
            poseStack.translate(0.5f, 0.5f, 0.5f);
            float g = 0.9995f;
            poseStack.scale(g, g, g);
            poseStack.mulPose(direction.getRotation());
            poseStack.scale(1.0f, -1.0f, -1.0f);
            poseStack.translate(0.0f, -1.0f, 0.0f);
            ModelPart modelPart = this.model.getLid();
            modelPart.setPos(0.0f, 24.0f - shulkerBoxBlockEntity.getProgress(f) * 0.5f * 16.0f, 0.0f);
            modelPart.yRot = 270.0f * shulkerBoxBlockEntity.getProgress(f) * ((float)Math.PI / 180);
            VertexConsumer vertexConsumer = material.buffer(multiBufferSource, RenderType::entityCutoutNoCull);
            this.model.renderToBuffer(poseStack, vertexConsumer, i, j);
            poseStack.popPose();

            ci.cancel();
        }
    }
}
