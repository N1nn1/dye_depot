package com.ninni.dye_depot.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.ninni.dye_depot.DyeDepot;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.sprite.SpriteId;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Sheets.class)
public class SheetsMixin {

    @ModifyReturnValue(
        method = "createShulkerSprite",
        at = @At("RETURN")
    )
    private static SpriteId overwriteShulkerTexture(SpriteId original) {
        var texture = DyeDepot.modLoc(original.texture().getPath());
        return new SpriteId(original.atlasLocation(), texture);
    }

    @ModifyReturnValue(
        method = "createBedSprite",
        at = @At("RETURN")
    )
    private static SpriteId overwriteBedTexture(SpriteId original) {
        var texture = DyeDepot.modLoc(original.texture().getPath());
        return new SpriteId(original.atlasLocation(), texture);
    }

}
