package com.ninni.dye_depot.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ninni.dye_depot.DyeDepot;
import net.minecraft.client.model.LlamaModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.LlamaDecorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LlamaDecorLayer.class)
public class LlamaDecorLayerMixin {
    @Shadow @Final private LlamaModel<Llama> model;
    @Unique
    private static final ResourceLocation[] TEXTURE_LOCATION = new ResourceLocation[]{
            DyeDepot.modLoc("textures/entity/llama/decor/maroon.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/rose.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/coral.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/indigo.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/navy.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/slate.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/olive.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/amber.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/beige.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/teal.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/mint.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/aqua.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/verdant.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/forest.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/ginger.png"),
            DyeDepot.modLoc("textures/entity/llama/decor/tan.png")
    };


    @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Llama;FFFFFF)V", at = @At("HEAD"), cancellable = true)
    private void DD$llamaCarpets(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, Llama llama, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {


        DyeColor dyeColor = llama.getSwag();

        if (dyeColor != null && dyeColor.getId() >= 16) {
            ci.cancel();
            LlamaDecorLayer that = LlamaDecorLayer.class.cast(this);

            ResourceLocation resourceLocation = TEXTURE_LOCATION[dyeColor.getId() - 16];

            that.getParentModel().copyPropertiesTo(this.model);
            this.model.setupAnim(llama, f, g, j, k, l);
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(resourceLocation));
            this.model.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }


    }
}
