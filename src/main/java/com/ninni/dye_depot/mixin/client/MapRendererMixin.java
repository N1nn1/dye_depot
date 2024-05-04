package com.ninni.dye_depot.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDMapDecorationType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.MapRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Environment(EnvType.CLIENT)
@Mixin(MapRenderer.MapInstance.class)
public abstract class MapRendererMixin {
    @Shadow private MapItemSavedData data;

    @Inject(method = "draw", at = @At(value = "TAIL"))
    private void DD$addCustomDecoration(PoseStack poseStack, MultiBufferSource multiBufferSource, boolean bl, int i, CallbackInfo ci) {

        int l = 0;

        for (MapDecoration decor : this.data.getDecorations()) {

            for(DDMapDecorationType decoType : DDMapDecorationType.values()) {
                if (decoType.name().matches(decor.getType().name())) {
                    poseStack.pushPose();
                    poseStack.translate(0.0F + (float)decor.getX() / 2.0F + 64.0F, 0.0F + (float)decor.getY() / 2.0F + 64.0F, -0.02F);
                    poseStack.mulPose(Axis.ZP.rotationDegrees((float)(decor.getRot() * 360) / 16.0F));
                    poseStack.scale(4.0F, 4.0F, 3.0F);
                    poseStack.translate(-0.125F, 0.125F, 0.0F);
                    byte b = decor.getImage();
                    float g = (float)(b % 16 + 0) / 16.0F;
                    float h = (float)(b / 16 + 0) / 16.0F;
                    float m = (float)(b % 16 + 1) / 16.0F;
                    float n = (float)(b / 16 + 1) / 16.0F;
                    Matrix4f matrix4f2 = poseStack.last().pose();
                    float j = (l * -0.001F) - 0.01F;
                    VertexConsumer vertexConsumer2 = multiBufferSource.getBuffer(RenderType.text(DyeDepot.asResource("textures/map/map_icons.png")));
                    vertexConsumer2.vertex(matrix4f2, -1.0F, 1.0F, j).color(255, 255, 255, 255).uv(g, h).uv2(i).endVertex();
                    vertexConsumer2.vertex(matrix4f2, 1.0F, 1.0F, j).color(255, 255, 255, 255).uv(m, h).uv2(i).endVertex();
                    vertexConsumer2.vertex(matrix4f2, 1.0F, -1.0F, j).color(255, 255, 255, 255).uv(m, n).uv2(i).endVertex();
                    vertexConsumer2.vertex(matrix4f2, -1.0F, -1.0F, j).color(255, 255, 255, 255).uv(g, n).uv2(i).endVertex();
                    poseStack.popPose();
                }
            }
            ++l;
        }

    }
}
