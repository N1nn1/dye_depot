package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import java.util.stream.Collectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDPoiTypes {

    private static final DeferredRegister<PoiType> REGISTRY = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, DyeDepot.MOD_ID);

    public static final DeferredHolder<PoiType, PoiType> HOME = REGISTRY.register("home", () ->
            new PoiType(DDBlocks.BEDS.values()
                    .map(Block::getStateDefinition)
                    .flatMap(it -> it.getPossibleStates().stream())
                    .filter(it -> it.getValue(BedBlock.PART) == BedPart.HEAD)
                    .collect(Collectors.toSet()),
                    1, 1
            )
    );

    public static void register(IEventBus modBus) {
        REGISTRY.register(modBus);
    }

}
