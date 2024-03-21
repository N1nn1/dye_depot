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
import java.util.function.Supplier;

@Mixin(Sheep.class)
public abstract class SheepMixin extends Animal {
    @Shadow
    @Final
    private static EntityDataAccessor<Byte> DATA_WOOL_ID;

    protected SheepMixin(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
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
