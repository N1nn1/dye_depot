package com.ninni.dye_depot;

import com.google.common.reflect.Reflection;
import com.ninni.dye_depot.registry.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.dispenser.ShulkerBoxDispenseBehavior;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.DispenserBlock;

public class DyeDepot implements ModInitializer {
    public static final String MOD_ID = "dye_depot";

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        DDVanillaIntegration.commonInit();
        Reflection.initialize(
                DDItems.class,
                DDBlocks.class,
                DDBlockEntityType.class,
                DDParticles.class,
                DDSoundEvents.class,
                DDCreativeModeTabs.class
        );

        DDBlocks.SHULKER_BOXES.forEach((dye, shulkerBox) ->
            DispenserBlock.registerBehavior(shulkerBox.value(), new ShulkerBoxDispenseBehavior())
        );
    }
}