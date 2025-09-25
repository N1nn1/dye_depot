package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDMapDecorationType {

    private static final DeferredRegister<MapDecorationType> REGISTRY = DeferredRegister.create(Registries.MAP_DECORATION_TYPE, DyeDepot.MOD_ID);

    public static final DyedHolders<MapDecorationType, MapDecorationType> BANNERS = DyedHolders.createModded(color -> {
        var id = DyeDepot.modLoc(color + "_banner");
        return REGISTRY.register(
                id.getPath(),
                () -> new MapDecorationType(id, true, -1, true, false)
        );
    });

    public static void register(IEventBus modBus) {
        REGISTRY.register(modBus);
    }

}