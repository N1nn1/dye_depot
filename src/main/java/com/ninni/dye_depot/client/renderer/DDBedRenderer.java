package com.ninni.dye_depot.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.ninni.dye_depot.block.DDBedBlock;
import com.ninni.dye_depot.block.DDBedBlockEntity;
import com.ninni.dye_depot.registry.DDBlockEntityType;
import com.ninni.dye_depot.registry.DDSheets;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;

@Environment(EnvType.CLIENT)
public class DDBedRenderer implements BlockEntityRenderer<DDBedBlockEntity> {
    private final ModelPart headRoot;
    private final ModelPart footRoot;

    public DDBedRenderer(BlockEntityRendererProvider.Context context) {
        this.headRoot = context.bakeLayer(ModelLayers.BED_HEAD);
        this.footRoot = context.bakeLayer(ModelLayers.BED_FOOT);
    }


    public void render(DDBedBlockEntity bedBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {

        Material material = DDSheets.BED_TEXTURE_LOCATION.get(bedBlockEntity.getColor().getId() - 16);

        Level level = bedBlockEntity.getLevel();
        if (level != null) {
            BlockState blockState = bedBlockEntity.getBlockState();
            DoubleBlockCombiner.NeighborCombineResult<? extends DDBedBlockEntity> neighborCombineResult = DoubleBlockCombiner.combineWithNeigbour(DDBlockEntityType.BED, DDBedBlock::getBlockType, DDBedBlock::getConnectedDirection, ChestBlock.FACING, blockState, level, bedBlockEntity.getBlockPos(), (levelAccessor, blockPos) -> false);
            int k = neighborCombineResult.apply(new BrightnessCombiner<>()).get(i);
            this.renderPiece(poseStack, multiBufferSource, blockState.getValue(DDBedBlock.PART) == BedPart.HEAD ? this.headRoot : this.footRoot, blockState.getValue(DDBedBlock.FACING), material, k, j, false);
        } else {
            this.renderPiece(poseStack, multiBufferSource, this.headRoot, Direction.SOUTH, material, i, j, false);
            this.renderPiece(poseStack, multiBufferSource, this.footRoot, Direction.SOUTH, material, i, j, true);
        }

    }

    private void renderPiece(PoseStack poseStack, MultiBufferSource multiBufferSource, ModelPart modelPart, Direction direction, Material material, int i, int j, boolean bl) {
        poseStack.pushPose();
        poseStack.translate(0.0F, 0.5625F, bl ? -1.0F : 0.0F);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F + direction.toYRot()));
        poseStack.translate(-0.5F, -0.5F, -0.5F);
        VertexConsumer vertexConsumer = material.buffer(multiBufferSource, RenderType::entitySolid);
        modelPart.render(poseStack, vertexConsumer, i, j);
        poseStack.popPose();
    }
}
