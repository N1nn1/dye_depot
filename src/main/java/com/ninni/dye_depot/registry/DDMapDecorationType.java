package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;

public class DDMapDecorationType {

    public static final DyedHolders<MapDecorationType, MapDecorationType> BANNERS = DyedHolders.createModded(color -> {
        var id = DyeDepot.modLoc(color + "_banner");
        return Registry.registerForHolder(
                BuiltInRegistries.MAP_DECORATION_TYPE,
                id,
                new MapDecorationType(id, true, -1, true, false)
        );
    });

}
