package com.ninni.dye_depot;

import com.google.common.reflect.Reflection;
import com.ninni.dye_depot.registry.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.ShulkerBoxDispenseBehavior;
import net.minecraft.world.level.block.DispenserBlock;

public class DyeDepot implements ModInitializer {
    public static final String MOD_ID = "dye_depot";

    @Override
    public void onInitialize() {
        DDVanillaIntegration.serverInit();
        Reflection.initialize(
                DDItems.class,
                DDBlocks.class,
                DDBlockEntityType.class,
                DDParticles.class,
                DDSoundEvents.class,
                DDLootTables.class,
                DDCreativeModeTabs.class
        );

        DDBlocks.SHULKER_BOXES.forEach((dye, shulkerBox) ->
            DispenserBlock.registerBehavior(shulkerBox, new ShulkerBoxDispenseBehavior())
        );
    }
}