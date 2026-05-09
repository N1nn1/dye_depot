package com.ninni.dye_depot.registry;

import net.minecraft.core.dispenser.ShulkerBoxDispenseBehavior;
import net.minecraft.world.level.block.DispenserBlock;

public class DDVanillaIntegration {

    public static void commonInit() {
        registerDispenserBehaviours();
    }

    private static void registerDispenserBehaviours() {
        ShulkerBoxDispenseBehavior shulkerBoxBehaviour = new ShulkerBoxDispenseBehavior();
        DDBlocks.SHULKER_BOXES.values().forEach((block) ->
            DispenserBlock.registerBehavior(block, shulkerBoxBehaviour)
        );
    }
}
