package com.ninni.dye_depot.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ninni.dye_depot.block.DDShulkerBoxBlockEntity;
import com.ninni.dye_depot.registry.DDSheets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ShulkerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.state.BlockState;

@Environment(EnvType.CLIENT)
public class DDShulkerBoxRenderer implements BlockEntityRenderer<DDShulkerBoxBlockEntity> {
    private final ShulkerModel<?> model;

    public DDShulkerBoxRenderer(BlockEntityRendererProvider.Context context) {
        this.model = new ShulkerModel<>(context.bakeLayer(ModelLayers.SHULKER));
    }



    public void render(DDShulkerBoxBlockEntity shulkerBoxBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        Direction direction = Direction.UP;
        if (shulkerBoxBlockEntity.hasLevel()) {
            BlockState blockState = shulkerBoxBlockEntity.getLevel().getBlockState(shulkerBoxBlockEntity.getBlockPos());
            if (blockState.getBlock() instanceof ShulkerBoxBlock) {
                direction = blockState.getValue(ShulkerBoxBlock.FACING);
            }
        }

        Material material = DDSheets.SHULKER_TEXTURE_LOCATION.get(shulkerBoxBlockEntity.getColor().getId() - 16);

        poseStack.pushPose();
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.scale(0.9995F, 0.9995F, 0.9995F);
        poseStack.mulPose(direction.getRotation());
        poseStack.scale(1.0F, -1.0F, -1.0F);
        poseStack.translate(0.0F, -1.0F, 0.0F);
        ModelPart modelPart = this.model.getLid();
        modelPart.setPos(0.0F, 24.0F - shulkerBoxBlockEntity.getProgress(f) * 0.5F * 16.0F, 0.0F);
        modelPart.yRot = 270.0F * shulkerBoxBlockEntity.getProgress(f) * 0.017453292F;
        VertexConsumer vertexConsumer = material.buffer(multiBufferSource, RenderType::entityCutoutNoCull);
        this.model.renderToBuffer(poseStack, vertexConsumer, i, j);
        poseStack.popPose();
    }
}
