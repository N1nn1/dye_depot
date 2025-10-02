package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;

public class DDPoiTypes {

    public static final ResourceKey<PoiType> HOME = register("home", DDBlocks.BEDS.values()
            .map(Block::getStateDefinition)
            .flatMap(it -> it.getPossibleStates().stream())
            .filter(it -> it.getValue(BedBlock.PART) == BedPart.HEAD)
    );

    private static ResourceKey<PoiType> register(String name, Stream<BlockState> possibleStates) {
        var possibleStatesSet = possibleStates.collect(Collectors.toSet());
        var holder = Registry.registerForHolder(
                BuiltInRegistries.POINT_OF_INTEREST_TYPE,
                DyeDepot.modLoc(name),
                new PoiType(possibleStatesSet, 1, 1)
        );
        PoiTypes.registerBlockStates(holder, possibleStatesSet);
        return holder.key();
    }

}
