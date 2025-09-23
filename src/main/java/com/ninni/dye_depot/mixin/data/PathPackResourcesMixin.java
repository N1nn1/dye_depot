package com.ninni.dye_depot.mixin.data;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.ninni.dye_depot.data.ModPathPackResources;
import io.github.fabricators_of_create.porting_lib.resources.PathPackResources;
import net.fabricmc.loader.api.ModContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * This is only present to fix <a href="https://github.com/Fabricators-of-Create/Porting-Lib/issues/188">an issue in porting lib</a> regarding datagen
 */
@Mixin(value = PathPackResources.class, remap = false)
public class PathPackResourcesMixin {

    @ModifyReturnValue(
            require = 0,
            method = "createPackForMod",
            at = @At("RETURN")
    )
    private static PathPackResources overwriteModResources(PathPackResources original, @Local ModContainer mf) {
        return new ModPathPackResources(mf);
    }

}
