package com.ninni.dye_depot.mixin.client;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheets.class)
public class SheetsMixin {

    @Inject(
        method = {
            "colorToShulkerMaterial",
            "colorToResourceMaterial"
        },
        at = @At("HEAD"),
        cancellable = true
    )
    private static void fixDDyeColorNamespaces(DyeColor dyeColor, CallbackInfoReturnable<ResourceLocation> cir) {
        if (DDDyes.contains(dyeColor)) {
            cir.setReturnValue(DyeDepot.id(dyeColor.getName()));
        }
    }
}
