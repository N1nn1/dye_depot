package com.ninni.dye_depot.mixin;

import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDMapDecorationType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.saveddata.maps.MapBanner;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MapBanner.class)
public class MapBannerMixin {
    @Shadow @Final private DyeColor color;


    @Inject(method = "getDecoration", at = @At(value = "HEAD"), cancellable = true)
    private void DD$addCustomDecoration(CallbackInfoReturnable<MapDecoration.Type> cir) {
        if (color == DDDyes.MAROON.get()) cir.setReturnValue(DDMapDecorationType.BANNER_MAROON.get());
        else if (color == DDDyes.ROSE.get()) cir.setReturnValue(DDMapDecorationType.BANNER_ROSE.get());
        else if (color == DDDyes.CORAL.get()) cir.setReturnValue(DDMapDecorationType.BANNER_CORAL.get());
        else if (color == DDDyes.INDIGO.get()) cir.setReturnValue(DDMapDecorationType.BANNER_INDIGO.get());
        else if (color == DDDyes.NAVY.get()) cir.setReturnValue(DDMapDecorationType.BANNER_NAVY.get());
        else if (color == DDDyes.SLATE.get()) cir.setReturnValue(DDMapDecorationType.BANNER_SLATE.get());
        else if (color == DDDyes.OLIVE.get()) cir.setReturnValue(DDMapDecorationType.BANNER_OLIVE.get());
        else if (color == DDDyes.AMBER.get()) cir.setReturnValue(DDMapDecorationType.BANNER_AMBER.get());
        else if (color == DDDyes.BEIGE.get()) cir.setReturnValue(DDMapDecorationType.BANNER_BEIGE.get());
        else if (color == DDDyes.TEAL.get()) cir.setReturnValue(DDMapDecorationType.BANNER_TEAL.get());
        else if (color == DDDyes.MINT.get()) cir.setReturnValue(DDMapDecorationType.BANNER_MINT.get());
        else if (color == DDDyes.AQUA.get()) cir.setReturnValue(DDMapDecorationType.BANNER_AQUA.get());
        else if (color == DDDyes.VERDANT.get()) cir.setReturnValue(DDMapDecorationType.BANNER_VERDANT.get());
        else if (color == DDDyes.FOREST.get()) cir.setReturnValue(DDMapDecorationType.BANNER_FOREST.get());
        else if (color == DDDyes.GINGER.get()) cir.setReturnValue(DDMapDecorationType.BANNER_GINGER.get());
        else if (color == DDDyes.TAN.get()) cir.setReturnValue(DDMapDecorationType.BANNER_TAN.get());

    }
}
