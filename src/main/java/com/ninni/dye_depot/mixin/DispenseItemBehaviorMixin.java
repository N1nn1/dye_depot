package com.ninni.dye_depot.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DispenseItemBehavior.class)
public interface DispenseItemBehaviorMixin {
    @WrapOperation(
        method = "bootStrap",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/ShulkerBoxBlock;getBlockByColor(Lnet/minecraft/world/item/DyeColor;)Lnet/minecraft/world/level/block/Block;"
        )
    )
    private static Block DD$bootstrap(DyeColor dyeColor, Operation<Block> original) {
        // Can't call DDShulkerBoxBlock.getBlockByColor(), it'll cause crashing whenever any DD block is placed.
        if (DDDyes.getAll().contains(dyeColor)) {
            return Blocks.SHULKER_BOX;
        }
        return original.call(dyeColor);
    }
}
