package com.ninni.dye_depot.mixin;

import com.google.common.collect.Maps;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDLootTables;
import com.ninni.dye_depot.registry.DDMapDecorationType;
import net.minecraft.Util;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(Sheep.class)
public abstract class SheepMixin extends Animal {

   @Unique
   private static final Map<DyeColor, ItemLike> MORE_ITEM_BY_DYE = Util.make(Maps.newEnumMap(DyeColor.class), (enumMap) -> {
       enumMap.put(DDDyes.MAROON.get(), DDBlocks.MAROON_WOOL);
       enumMap.put(DDDyes.ROSE.get(), DDBlocks.ROSE_WOOL);
       enumMap.put(DDDyes.CORAL.get(), DDBlocks.CORAL_WOOL);
       enumMap.put(DDDyes.INDIGO.get(), DDBlocks.INDIGO_WOOL);
       enumMap.put(DDDyes.NAVY.get(), DDBlocks.NAVY_WOOL);
       enumMap.put(DDDyes.SLATE.get(), DDBlocks.SLATE_WOOL);
       enumMap.put(DDDyes.OLIVE.get(), DDBlocks.OLIVE_WOOL);
       enumMap.put(DDDyes.AMBER.get(), DDBlocks.AMBER_WOOL);
       enumMap.put(DDDyes.BEIGE.get(), DDBlocks.BEIGE_WOOL);
       enumMap.put(DDDyes.TEAL.get(), DDBlocks.TEAL_WOOL);
       enumMap.put(DDDyes.MINT.get(), DDBlocks.MINT_WOOL);
       enumMap.put(DDDyes.AQUA.get(), DDBlocks.AQUA_WOOL);
       enumMap.put(DDDyes.VERDANT.get(), DDBlocks.VERDANT_WOOL);
       enumMap.put(DDDyes.FOREST.get(), DDBlocks.FOREST_WOOL);
       enumMap.put(DDDyes.GINGER.get(), DDBlocks.GINGER_WOOL);
       enumMap.put(DDDyes.TAN.get(), DDBlocks.TAN_WOOL);
   });
    @Shadow
    @Final
    private static EntityDataAccessor<Byte> DATA_WOOL_ID;

    @Shadow
    public abstract DyeColor getColor();

    protected SheepMixin(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }


    //TODO client server desync

    @Inject(method = "shear", at = @At(value = "TAIL"))
    private void DD$shear(SoundSource soundSource, CallbackInfo ci) {
        int i = 1 + this.random.nextInt(3);

        for (int j = 0; j < i; ++j) {
            ItemEntity itemEntity = this.spawnAtLocation(MORE_ITEM_BY_DYE.get(this.getColor()), 1);
            if (itemEntity != null) {
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add((this.random.nextFloat() - this.random.nextFloat()) * 0.1F, (this.random.nextFloat() * 0.05F), ((this.random.nextFloat() - this.random.nextFloat()) * 0.1F)));
            }
        }
    }

    @Inject(method = "getDefaultLootTable", at = @At(value = "HEAD"), cancellable = true)
    private void DD$shear(CallbackInfoReturnable<ResourceLocation> cir) {
        //TODO crashes

        ResourceLocation var10000 = this.getType().getDefaultLootTable();

        for (DDDyes color : DDDyes.values()) {
            if (this.getColor().name().matches(color.name())) {
                switch (color) {
                    case MAROON -> var10000 = DDLootTables.SHEEP_MAROON;
                    case AMBER -> var10000 = DDLootTables.SHEEP_AMBER;
                    case AQUA -> var10000 = DDLootTables.SHEEP_AQUA;
                    case BEIGE -> var10000 = DDLootTables.SHEEP_BEIGE;
                    case CORAL -> var10000 = DDLootTables.SHEEP_CORAL;
                    case FOREST -> var10000 = DDLootTables.SHEEP_FOREST;
                    case GINGER -> var10000 = DDLootTables.SHEEP_GINGER;
                    case INDIGO -> var10000 = DDLootTables.SHEEP_INDIGO;
                    case MINT -> var10000 = DDLootTables.SHEEP_MINT;
                    case NAVY -> var10000 = DDLootTables.SHEEP_NAVY;
                    case OLIVE -> var10000 = DDLootTables.SHEEP_OLIVE;
                    case ROSE -> var10000 = DDLootTables.SHEEP_ROSE;
                    case SLATE -> var10000 = DDLootTables.SHEEP_SLATE;
                    case TAN -> var10000 = DDLootTables.SHEEP_TAN;
                    case VERDANT -> var10000 = DDLootTables.SHEEP_VERDANT;
                    case TEAL -> var10000 = DDLootTables.SHEEP_TEAL;
                    default -> throw new IncompatibleClassChangeError();
                }
            } else {
                switch (this.getColor()) {
                    case WHITE -> var10000 = BuiltInLootTables.SHEEP_WHITE;
                    case ORANGE -> var10000 = BuiltInLootTables.SHEEP_ORANGE;
                    case MAGENTA -> var10000 = BuiltInLootTables.SHEEP_MAGENTA;
                    case LIGHT_BLUE -> var10000 = BuiltInLootTables.SHEEP_LIGHT_BLUE;
                    case YELLOW -> var10000 = BuiltInLootTables.SHEEP_YELLOW;
                    case LIME -> var10000 = BuiltInLootTables.SHEEP_LIME;
                    case PINK -> var10000 = BuiltInLootTables.SHEEP_PINK;
                    case GRAY -> var10000 = BuiltInLootTables.SHEEP_GRAY;
                    case LIGHT_GRAY -> var10000 = BuiltInLootTables.SHEEP_LIGHT_GRAY;
                    case CYAN -> var10000 = BuiltInLootTables.SHEEP_CYAN;
                    case PURPLE -> var10000 = BuiltInLootTables.SHEEP_PURPLE;
                    case BLUE -> var10000 = BuiltInLootTables.SHEEP_BLUE;
                    case BROWN -> var10000 = BuiltInLootTables.SHEEP_BROWN;
                    case GREEN -> var10000 = BuiltInLootTables.SHEEP_GREEN;
                    case RED -> var10000 = BuiltInLootTables.SHEEP_RED;
                    case BLACK -> var10000 = BuiltInLootTables.SHEEP_BLACK;
                    default -> throw new IncompatibleClassChangeError();
                }
            }
            break;
        }
        cir.setReturnValue(var10000);
        cir.cancel();
    }


    @Inject(method = "getColor", at = @At(value = "HEAD"), cancellable = true)
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
