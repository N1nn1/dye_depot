package com.ninni.dye_depot.mixin;

import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheep.class)
public abstract class SheepMixin extends Animal {
    @Shadow
    @Final
    private static EntityDataAccessor<Byte> DATA_WOOL_ID;


    protected SheepMixin(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

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

    @Inject(method = "getColor()Lnet/minecraft/world/item/DyeColor;", at = @At(value = "HEAD"), cancellable = true)
    private void DD$getColor(CallbackInfoReturnable<DyeColor> cir) {
        cir.setReturnValue(DyeColor.byId(this.entityData.get(DATA_WOOL_ID) & 31));
    }

    @Inject(method = "setColor", at = @At(value = "HEAD"), cancellable = true)
    private void DD$setColor(DyeColor dyeColor, CallbackInfo ci) {
        byte b = this.entityData.get(DATA_WOOL_ID);
        this.entityData.set(DATA_WOOL_ID, (byte)(b & 224 | dyeColor.getId() & 31));
        ci.cancel();
    }

    @Inject(method = "isSheared", at = @At(value = "HEAD"), cancellable = true)
    private void DD$isSheared(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue((this.entityData.get(DATA_WOOL_ID) & 32) != 0);
    }

    @Inject(method = "setSheared", at = @At(value = "HEAD"), cancellable = true)
    private void DD$setSheared(boolean bl, CallbackInfo ci) {
        byte b = this.entityData.get(DATA_WOOL_ID);
        if (bl) {
            this.entityData.set(DATA_WOOL_ID, (byte)(b | 32));
        } else {
            this.entityData.set(DATA_WOOL_ID, (byte)(b & -33));
        }
        ci.cancel();
    }
}
