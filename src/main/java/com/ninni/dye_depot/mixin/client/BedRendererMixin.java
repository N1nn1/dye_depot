package com.ninni.dye_depot.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDSheets;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BedRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BedRenderer.class)
public class BedRendererMixin {

    @WrapOperation(
            method = "render(Lnet/minecraft/world/level/block/entity/BedBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/DyeColor;getId()I")
    )
    private int DD$fixBedRenderer(DyeColor color, Operation<Integer> original) {
        if (DDDyes.isModDye(color)) return DyeColor.WHITE.getId();
        return original.call(color);
    }

    @WrapOperation(
            method = "render(Lnet/minecraft/world/level/block/entity/BedBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/blockentity/BedRenderer;renderPiece(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/model/geom/ModelPart;Lnet/minecraft/core/Direction;Lnet/minecraft/client/resources/model/Material;IIZ)V")
    )
    private void DD$useOtherMaterial(BedRenderer instance, PoseStack poseStack, MultiBufferSource multiBufferSource, ModelPart modelPart, Direction direction, Material material, int i, int j, boolean bl, Operation<Void> original, @Local BedBlockEntity be) {
        var color = be.getColor();
        if (DDDyes.isModDye(color)) material = DDSheets.BED_TEXTURE_LOCATION.get(color.getId() - 16);
        original.call(instance, poseStack, multiBufferSource, modelPart, direction, material, i, j, bl);
    }

}
