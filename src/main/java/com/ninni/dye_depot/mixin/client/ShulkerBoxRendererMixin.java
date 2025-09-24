package com.ninni.dye_depot.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDSheets;
import java.util.List;
import net.minecraft.client.renderer.blockentity.ShulkerBoxRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ShulkerBoxRenderer.class)
public class ShulkerBoxRendererMixin {

    @WrapOperation(
            method = "render(Lnet/minecraft/world/level/block/entity/ShulkerBoxBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
            at = @At(value = "INVOKE", target = "Ljava/util/List;get(I)Ljava/lang/Object;")
    )
    private Object DD$fixShulkerRenderer(List<Material> instance, int id, Operation<Material> original, @Local DyeColor color) {
        if (DDDyes.isModDye(color)) return DDSheets.SHULKER_TEXTURE_LOCATION.get(id - 16);
        return original.call(instance, id);
    }

}
