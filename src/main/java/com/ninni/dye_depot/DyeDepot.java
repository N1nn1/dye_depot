package com.ninni.dye_depot;

import com.ninni.dye_depot.registry.*;
import net.minecraft.core.dispenser.ShulkerBoxDispenseBehavior;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DyeDepot.MOD_ID)
public class DyeDepot {
    public static final String MOD_ID = "dye_depot";

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public DyeDepot() {
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDMigration.migrateBlockEntities();

        DDItems.register(modBus);
        DDBlocks.register(modBus);
        DDBlockEntityType.register(modBus);
        DDParticles.register(modBus);
        DDSoundEvents.register(modBus);
        DDLootModifiers.register(modBus);
        DDPoiTypes.register(modBus);

        modBus.addListener(this::setup);
    }

    private void setup(FMLCommonSetupEvent event) {
        DDVanillaIntegration.commonInit();
        DDFlammables.register();
        DDBlocks.SHULKER_BOXES.forEach((dye, shulkerBox) ->
                DispenserBlock.registerBehavior(shulkerBox.value(), new ShulkerBoxDispenseBehavior())
        );
    }

}