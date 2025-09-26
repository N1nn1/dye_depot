package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.mixin.BlockEntityTypeAccessor;
import java.util.HashSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegisterEvent;

public class DDBlockEntityType {

    public static void register(IEventBus modBus) {
        modBus.addListener(DDBlockEntityType::extendBlockTypes);
    }

    private static void extendBlockTypes(RegisterEvent event) {
        if (!event.getRegistryKey().equals(Registries.BLOCK_ENTITY_TYPE)) return;
        DDBlocks.SHULKER_BOXES.values().forEach(it -> modify(BlockEntityType.SHULKER_BOX, it));
        DDBlocks.BEDS.values().forEach(it -> modify(BlockEntityType.BED, it));
        DDBlocks.BANNERS.values().forEach(it -> modify(BlockEntityType.BANNER, it));
        DDBlocks.WALL_BANNERS.values().forEach(it -> modify(BlockEntityType.BANNER, it));
    }

    private static void modify(BlockEntityType<?> type, Block block) {
        var accessor = (BlockEntityTypeAccessor) type;
        var current = accessor.getValidBlocks();
        if (!(current instanceof HashSet<Block>)) current = new HashSet<>(current);
        current.add(block);
        accessor.setValidBlocks(current);
    }

}
