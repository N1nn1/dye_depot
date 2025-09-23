package com.ninni.dye_depot.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import com.ninni.dye_depot.block.DDBannerBlock;
import com.ninni.dye_depot.block.DDBannerBlockEntity;
import com.ninni.dye_depot.block.DDWallBannerBlock;
import java.util.List;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;

public class DDBannerRenderer implements BlockEntityRenderer<DDBannerBlockEntity> {
    private final ModelPart flag;
    private final ModelPart pole;
    private final ModelPart bar;

    public DDBannerRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart modelPart = context.bakeLayer(ModelLayers.BANNER);
        this.flag = modelPart.getChild("flag");
        this.pole = modelPart.getChild("pole");
        this.bar = modelPart.getChild("bar");
    }

    public void render(DDBannerBlockEntity bannerBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        List<Pair<Holder<BannerPattern>, DyeColor>> list = bannerBlockEntity.getPatterns();
        boolean bl = bannerBlockEntity.getLevel() == null;
        poseStack.pushPose();
        long l;
        if (bl) {
            l = 0L;
            poseStack.translate(0.5F, 0.5F, 0.5F);
            this.pole.visible = true;
        } else {
            l = bannerBlockEntity.getLevel().getGameTime();
            BlockState blockState = bannerBlockEntity.getBlockState();
            float h;
            if (blockState.getBlock() instanceof DDBannerBlock) {
                poseStack.translate(0.5F, 0.5F, 0.5F);
                h = -RotationSegment.convertToDegrees((Integer)blockState.getValue(DDBannerBlock.ROTATION));
                poseStack.mulPose(Axis.YP.rotationDegrees(h));
                this.pole.visible = true;
            } else {
                poseStack.translate(0.5F, -0.16666667F, 0.5F);
                h = -blockState.getValue(DDWallBannerBlock.FACING).toYRot();
                poseStack.mulPose(Axis.YP.rotationDegrees(h));
                poseStack.translate(0.0F, -0.3125F, -0.4375F);
                this.pole.visible = false;
            }
        }

        poseStack.pushPose();
        poseStack.scale(0.6666667F, -0.6666667F, -0.6666667F);
        VertexConsumer vertexConsumer = ModelBakery.BANNER_BASE.buffer(multiBufferSource, RenderType::entitySolid);
        this.pole.render(poseStack, vertexConsumer, i, j);
        this.bar.render(poseStack, vertexConsumer, i, j);
        BlockPos blockPos = bannerBlockEntity.getBlockPos();
        float k = ((float)Math.floorMod((long)(blockPos.getX() * 7 + blockPos.getY() * 9 + blockPos.getZ() * 13) + l, 100L) + f) / 100.0F;
        this.flag.xRot = (-0.0125F + 0.01F * Mth.cos(6.2831855F * k)) * 3.1415927F;
        this.flag.y = -32.0F;
        renderPatterns(poseStack, multiBufferSource, i, j, this.flag, ModelBakery.BANNER_BASE, true, list);
        poseStack.popPose();
        poseStack.popPose();
    }

    public static void renderPatterns(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, ModelPart modelPart, Material material, boolean bl, List<Pair<Holder<BannerPattern>, DyeColor>> list) {
        BannerRenderer.renderPatterns(poseStack, multiBufferSource, i, j, modelPart, material, bl, list);
    }

}
