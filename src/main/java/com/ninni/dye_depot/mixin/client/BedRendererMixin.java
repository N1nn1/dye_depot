package com.ninni.dye_depot.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDSheets;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ShulkerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BedRenderer;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.renderer.blockentity.ShulkerBoxRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(BedRenderer.class)
public abstract class BedRendererMixin {
    @Shadow
    @Final
    private ModelPart headRoot;

    @Shadow
    @Final
    private ModelPart footRoot;

    @Shadow
    protected abstract void renderPiece(PoseStack poseStack, MultiBufferSource multiBufferSource, ModelPart modelPart, Direction direction, Material material, int i, int j, boolean bl);

    @Inject(
        method = "render(Lnet/minecraft/world/level/block/entity/BedBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void DD$injectShulkerSheet(BedBlockEntity bedBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, CallbackInfo ci) {
        DyeColor dyeColor = bedBlockEntity.getColor();
        if (DDDyes.getAll().contains(dyeColor)) {
            Material material = DDSheets.BED_TEXTURE_LOCATION.get(bedBlockEntity.getColor().getId() - 16);
            Level level = bedBlockEntity.getLevel();
            if (level != null) {
                BlockState blockState = bedBlockEntity.getBlockState();
                DoubleBlockCombiner.NeighborCombineResult<BedBlockEntity> neighborCombineResult = DoubleBlockCombiner.combineWithNeigbour(BlockEntityType.BED, BedBlock::getBlockType, BedBlock::getConnectedDirection, ChestBlock.FACING, blockState, level, bedBlockEntity.getBlockPos(), (levelAccessor, blockPos) -> false);
                int k = ((Int2IntFunction)neighborCombineResult.apply(new BrightnessCombiner())).get(i);
                this.renderPiece(poseStack, multiBufferSource, blockState.getValue(BedBlock.PART) == BedPart.HEAD ? this.headRoot : this.footRoot, blockState.getValue(BedBlock.FACING), material, k, j, false);
            } else {
                this.renderPiece(poseStack, multiBufferSource, this.headRoot, Direction.SOUTH, material, i, j, false);
                this.renderPiece(poseStack, multiBufferSource, this.footRoot, Direction.SOUTH, material, i, j, true);
            }

            ci.cancel();
        }
    }
}
