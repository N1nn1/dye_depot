package com.ninni.dye_depot.mixin;

import com.ninni.dye_depot.registry.DDBlocks;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBoxBlock.class)
public class ShulkerBoxBlockMixin {

    @Inject(
            method = "getColoredItemStack",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void injectModShulkers(DyeColor dye, CallbackInfoReturnable<ItemStack> cir) {
        if (dye == null) return;
        var box = DDBlocks.SHULKER_BOXES.getOrNull(dye);
        if (box != null) cir.setReturnValue(new ItemStack(box));
    }

}
