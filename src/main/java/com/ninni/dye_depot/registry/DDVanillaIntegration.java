package com.ninni.dye_depot.registry;

import net.minecraft.core.cauldron.CauldronInteractions;
import net.minecraft.core.dispenser.ShulkerBoxDispenseBehavior;
import net.minecraft.world.level.block.DispenserBlock;

public class DDVanillaIntegration {

    public static void commonInit() {
        registerDispenserBehaviours();
        registerCauldronInteractions();
    }

    private static void registerDispenserBehaviours() {
        var behavior = new ShulkerBoxDispenseBehavior();
        DDBlocks.SHULKER_BOXES.values().forEach((block) ->
            DispenserBlock.registerBehavior(block, behavior)
        );
    }

    private static void registerCauldronInteractions() {
        var interactions = CauldronInteractions.WATER;

        DDItems.SHULKER_BOXES.values().forEach(it -> interactions.put(it, CauldronInteractions::shulkerBoxInteraction));
        DDItems.BANNERS.values().forEach(it -> interactions.put(it, CauldronInteractions::bannerInteraction));
    }

}
