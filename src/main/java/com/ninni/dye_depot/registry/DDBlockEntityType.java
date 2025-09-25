package com.ninni.dye_depot.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

public class DDBlockEntityType {

    public static void register(IEventBus modBus) {
        modBus.addListener(DDBlockEntityType::extendBlockTypes);
    }

    private static void extendBlockTypes(BlockEntityTypeAddBlocksEvent event) {
        DDBlocks.SHULKER_BOXES.values().forEach(it -> event.modify(BlockEntityType.SHULKER_BOX, it));
        DDBlocks.BEDS.values().forEach(it -> event.modify(BlockEntityType.BED, it));
        DDBlocks.BANNERS.values().forEach(it -> event.modify(BlockEntityType.BANNER, it));
        DDBlocks.WALL_BANNERS.values().forEach(it -> event.modify(BlockEntityType.BANNER, it));
    }

}
