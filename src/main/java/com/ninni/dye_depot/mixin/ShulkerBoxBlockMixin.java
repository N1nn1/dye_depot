package com.ninni.dye_depot.mixin;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBoxBlock.class)
public class ShulkerBoxBlockMixin {
    @Inject(method = "getBlockByColor", at = @At("HEAD"), cancellable = true)
    private static void DD$addDDShulkerBoxes(DyeColor dyeColor, CallbackInfoReturnable<Block> cir) {
        if (!DyeDepot.isInitialized()) {
            if (DDDyes.getAll().contains(dyeColor)) {
                cir.setReturnValue(Blocks.SHULKER_BOX);
            }
        } else {
            if (dyeColor != null) {
                Block block = DDBlocks.getShulkerBox(dyeColor);
                if (block != null) {
                    cir.setReturnValue(block);
                }
            }
        }
    }
}
