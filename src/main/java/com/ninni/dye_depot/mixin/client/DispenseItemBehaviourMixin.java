package com.ninni.dye_depot.mixin.client;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DispenseItemBehavior.class)
public interface DispenseItemBehaviourMixin {

    @WrapWithCondition(
            method = "bootStrap",
            at = @At(value = "INVOKE", ordinal = 64, target = "Lnet/minecraft/world/level/block/DispenserBlock;registerBehavior(Lnet/minecraft/world/level/ItemLike;Lnet/minecraft/core/dispenser/DispenseItemBehavior;)V")
    )
    private static boolean cancelDyedBehaviour(ItemLike item, DispenseItemBehavior behaviour) {
        return item != Items.SHULKER_BOX;
    }

    @WrapOperation(
            method = "bootStrap",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/ShulkerBoxBlock;getBlockByColor(Lnet/minecraft/world/item/DyeColor;)Lnet/minecraft/world/level/block/Block;")
    )
    private static Block cancelDyedBehaviour(DyeColor color, Operation<Block> original) {
        if (DDDyes.isModDye(color)) return Blocks.SHULKER_BOX;
        return original.call(color);
    }

}
