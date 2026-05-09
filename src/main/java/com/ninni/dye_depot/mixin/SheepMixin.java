package com.ninni.dye_depot.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import java.util.function.Function;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Util;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.loot.LootTable;
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
    private static final Function<DyeColor, ResourceKey<LootTable>> LOOT_TABLES = Util.memoize(color ->
        ResourceKey.create(Registries.LOOT_TABLE, DyeDepot.modLoc("entities/sheep/" + color))
    );

    @Inject(method = "getRandomSheepColor", at = @At(value = "RETURN"), cancellable = true)
    private static void DD$getRandomSheepColor(ServerLevelAccessor level, BlockPos pos, CallbackInfoReturnable<DyeColor> cir) {
        var randomSource = level.getRandom();
        int i = randomSource.nextInt(100);
        if (i < 23) {
            cir.setReturnValue(DDDyes.BEIGE.get());
        }
        if (randomSource.nextInt(500) == 0) {
            cir.setReturnValue(DDDyes.AQUA.get());
        }
    }

    @WrapOperation(method = "lambda$shear$0", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/sheep/Sheep;spawnAtLocation(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/item/ItemStack;F)Lnet/minecraft/world/entity/item/ItemEntity;"))
    private ItemEntity DD$shear(Sheep $this, ServerLevel serverLevel, ItemStack stack, float v, Operation<ItemEntity> original) {
        if (DDDyes.isModDye($this.getColor())) {
            return original.call($this, serverLevel, new ItemStack(DDBlocks.WOOL.getOrThrow($this.getColor()), stack.count()), v);
        }

        return original.call($this, serverLevel, stack, v);
    }

    @Inject(method = "getDefaultLootTable", at = @At(value = "HEAD"), cancellable = true)
    private void DD$getDefaultLootTable(CallbackInfoReturnable<ResourceKey<LootTable>> cir) {
        Sheep $this = (Sheep) (Object) this;

        if (!$this.isSheared() && DDDyes.isModDye($this.getColor())) {
            cir.setReturnValue(LOOT_TABLES.apply($this.getColor()));
        }
    }

    @ModifyConstant(method = {
        "getColor()Lnet/minecraft/world/item/DyeColor;",
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
