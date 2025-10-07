package com.ninni.dye_depot.registry;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

public class DDFlammables {

    public static void register() {
        var fire = (FireBlock) Blocks.FIRE;

        DDBlocks.CARPETS.values().forEach(block -> fire.setFlammable(block, 60, 20));
        DDBlocks.WOOL.values().forEach(block -> fire.setFlammable(block, 60, 100));
    }

}
