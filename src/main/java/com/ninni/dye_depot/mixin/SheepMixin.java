package com.ninni.dye_depot.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import java.util.function.Function;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheep.class)
public abstract class SheepMixin {
    @Unique
    private static final Function<DyeColor, ResourceLocation> LOOT_TABLES = Util.memoize(color -> DyeDepot.modLoc("entities/sheep/" + color));

    @Inject(method = "getRandomSheepColor", at = @At(value = "RETURN"), cancellable = true)
    private static void DD$getRandomSheepColor(RandomSource randomSource, CallbackInfoReturnable<DyeColor> cir) {
        int i = randomSource.nextInt(100);
        if (i < 23) {
            cir.setReturnValue(DDDyes.BEIGE.get());
        }
        if (randomSource.nextInt(500) == 0) {
            cir.setReturnValue(DDDyes.AQUA.get());
        }
    }

    @WrapOperation(method = "shear", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Sheep;spawnAtLocation(Lnet/minecraft/world/level/ItemLike;I)Lnet/minecraft/world/entity/item/ItemEntity;"))
    private ItemEntity DD$shear(Sheep $this, ItemLike item, int count, Operation<ItemEntity> original) {
        if (DDDyes.isModDye($this.getColor())) {
            return original.call($this, DDBlocks.WOOL.getOrThrow($this.getColor()), count);
        }

        return original.call($this, item, count);
    }

    @WrapOperation(method = "onSheared", remap = false, at = @At(value = "NEW", target = "(Lnet/minecraft/world/level/ItemLike;)Lnet/minecraft/world/item/ItemStack;"))
    private ItemStack DD$shear(ItemLike item, Operation<ItemStack> original) {
        var $this = (Sheep) (Object) this;
        if (DDDyes.isModDye($this.getColor())) {
            return new ItemStack(DDBlocks.WOOL.getOrThrow($this.getColor()));
        }

        return original.call(item);
    }

    @Inject(method = "getDefaultLootTable", at = @At(value = "HEAD"), cancellable = true)
    private void DD$getDefaultLootTable(CallbackInfoReturnable<ResourceLocation> cir) {
        Sheep $this = (Sheep) (Object) this;

        if (!$this.isSheared() && DDDyes.isModDye($this.getColor())) {
            cir.setReturnValue(LOOT_TABLES.apply($this.getColor()));
        }
    }

    @ModifyConstant(method = {
            "getColor",
            "setColor",
            "isSheared",
    }, constant = {
            @Constant(intValue = 15),
    })
    private int DD$modifyColorCount(int constant) {
        return constant + 16;
    }

    @ModifyConstant(method = "setColor", constant = @Constant(intValue = 240))
    private int DD$modifyColorCount2(int constant) {
        return constant - 16;
    }

    @ModifyConstant(method = {
            "isSheared",
            "setSheared"
    }, constant = @Constant(intValue = 16))
    private int DD$modifyColorCount3(int constant) {
        return constant + 16;
    }

    @ModifyConstant(method = {
            "setSheared"
    }, constant = @Constant(intValue = -17))
    private int DD$modifyColorCount4(int constant) {
        return constant - 16;
    }
}
