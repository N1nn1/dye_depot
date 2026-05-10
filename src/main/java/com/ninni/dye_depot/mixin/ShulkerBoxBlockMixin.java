package com.ninni.dye_depot.mixin;

import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBoxBlock.class)
public class ShulkerBoxBlockMixin {

    @Inject(
            method = "getBlockByColor",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void injectModShulkers(DyeColor dye, CallbackInfoReturnable<Block> cir) {
        if (dye == null || !DDDyes.isModDye(dye)) return;
        var box = DDBlocks.SHULKER_BOXES.getOrThrow(dye);
        cir.setReturnValue(box);
    }

}
