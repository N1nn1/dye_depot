package com.ninni.dye_depot.data;

import com.ninni.dye_depot.registry.DyedHolders;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class ModCompat {

    public static <T> DyedHolders<T> supplementariesHolders(Registry<T> registry, String name) {
        return DyedHolders.fromRegistry(registry, com.ninni.dye_depot.registry.DyedHolders.modColors(), color -> new ResourceLocation("supplementaries", name + "_" + color));
    }

}
