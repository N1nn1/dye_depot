package com.ninni.dye_depot.mixin;

import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DeferredHolder;
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
        var box = (DeferredHolder<ShulkerBoxBlock>) DDBlocks.SHULKER_BOXES.holderOrThrow(dye);
        // this check is necessary on forge because it is still using mixin 0.8.5
        // which does not support mixin into public static interface methods yet,
        // making DispenseItemBehaviourMixin useless
        if (!box.isRegistered()) return;
        cir.setReturnValue(box.value());
    }

}
