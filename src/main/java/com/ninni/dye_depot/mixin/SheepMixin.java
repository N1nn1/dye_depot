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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
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


    protected SheepMixin(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }


    @Inject(method = "shear", at = @At(value = "HEAD"), cancellable = true)
    private void DD$shear(SoundSource soundSource, CallbackInfo ci) {
        Sheep $this = (Sheep) (Object) this;

        if ($this.getColor().getId() > 15) {
            ci.cancel();
            $this.level().playSound(null, this, SoundEvents.SHEEP_SHEAR, soundSource, 1.0f, 1.0f);
            $this.setSheared(true);
            int i = 1 + $this.getRandom().nextInt(3);

            for (int j = 0; j < i; ++j) {
                ItemEntity itemEntity = $this.spawnAtLocation(MORE_ITEM_BY_DYE.get($this.getColor()), 1);
                if (itemEntity == null)  continue;
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add(($this.getRandom().nextFloat() - $this.getRandom().nextFloat()) * 0.1F, ($this.getRandom().nextFloat() * 0.05F), (($this.getRandom().nextFloat() - $this.getRandom().nextFloat()) * 0.1F)));
            }
        }
    }

    @Inject(method = "getDefaultLootTable", at = @At(value = "HEAD"), cancellable = true)
    private void DD$getDefaultLootTable(CallbackInfoReturnable<ResourceLocation> cir) {
        Sheep $this = (Sheep) (Object) this;

        if ($this.isSheared()) {
            cir.setReturnValue($this.getType().getDefaultLootTable());
        } else {
            if ($this.getColor().getId() > 15) {
                if ($this.getColor() == DDDyes.MAROON.get()) cir.setReturnValue(DDLootTables.SHEEP_MAROON);
                else if ($this.getColor() == DDDyes.AMBER.get()) cir.setReturnValue(DDLootTables.SHEEP_AMBER);
                else if ($this.getColor() == DDDyes.AQUA.get()) cir.setReturnValue(DDLootTables.SHEEP_AQUA);
                else if ($this.getColor() == DDDyes.BEIGE.get()) cir.setReturnValue(DDLootTables.SHEEP_BEIGE);
                else if ($this.getColor() == DDDyes.CORAL.get()) cir.setReturnValue(DDLootTables.SHEEP_CORAL);
                else if ($this.getColor() == DDDyes.FOREST.get()) cir.setReturnValue(DDLootTables.SHEEP_FOREST);
                else if ($this.getColor() == DDDyes.GINGER.get()) cir.setReturnValue(DDLootTables.SHEEP_GINGER);
                else if ($this.getColor() == DDDyes.INDIGO.get()) cir.setReturnValue(DDLootTables.SHEEP_INDIGO);
                else if ($this.getColor() == DDDyes.MINT.get()) cir.setReturnValue(DDLootTables.SHEEP_MINT);
                else if ($this.getColor() == DDDyes.NAVY.get()) cir.setReturnValue(DDLootTables.SHEEP_NAVY);
                else if ($this.getColor() == DDDyes.OLIVE.get()) cir.setReturnValue(DDLootTables.SHEEP_OLIVE);
                else if ($this.getColor() == DDDyes.ROSE.get()) cir.setReturnValue(DDLootTables.SHEEP_ROSE);
                else if ($this.getColor() == DDDyes.SLATE.get()) cir.setReturnValue(DDLootTables.SHEEP_SLATE);
                else if ($this.getColor() == DDDyes.TAN.get()) cir.setReturnValue(DDLootTables.SHEEP_TAN);
                else if ($this.getColor() == DDDyes.VERDANT.get()) cir.setReturnValue(DDLootTables.SHEEP_VERDANT);
                else if ($this.getColor() == DDDyes.TEAL.get()) cir.setReturnValue(DDLootTables.SHEEP_TEAL);
            } else cir.setReturnValue(switch ($this.getColor()) {
                case WHITE -> BuiltInLootTables.SHEEP_WHITE;
                case ORANGE -> BuiltInLootTables.SHEEP_ORANGE;
                case MAGENTA -> BuiltInLootTables.SHEEP_MAGENTA;
                case LIGHT_BLUE -> BuiltInLootTables.SHEEP_LIGHT_BLUE;
                case YELLOW -> BuiltInLootTables.SHEEP_YELLOW;
                case LIME -> BuiltInLootTables.SHEEP_LIME;
                case PINK -> BuiltInLootTables.SHEEP_PINK;
                case GRAY -> BuiltInLootTables.SHEEP_GRAY;
                case LIGHT_GRAY -> BuiltInLootTables.SHEEP_LIGHT_GRAY;
                case CYAN -> BuiltInLootTables.SHEEP_CYAN;
                case PURPLE -> BuiltInLootTables.SHEEP_PURPLE;
                case BLUE -> BuiltInLootTables.SHEEP_BLUE;
                case BROWN -> BuiltInLootTables.SHEEP_BROWN;
                case GREEN -> BuiltInLootTables.SHEEP_GREEN;
                case RED -> BuiltInLootTables.SHEEP_RED;
                case BLACK -> BuiltInLootTables.SHEEP_BLACK;
            });
        }
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
