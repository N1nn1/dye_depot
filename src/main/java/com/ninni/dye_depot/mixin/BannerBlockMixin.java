package com.ninni.dye_depot.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.ninni.dye_depot.registry.DDBlocks;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BannerBlock.class)
public class BannerBlockMixin {

    @ModifyReturnValue(
            method = "byColor",
            at = @At("RETURN")
    )
    private static Block byColor(Block original, @Local DyeColor color) {
        return DDBlocks.BANNERS.get(color).orElse(original);
    }

}
