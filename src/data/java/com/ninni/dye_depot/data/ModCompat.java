package com.ninni.dye_depot.data;

import com.google.gson.JsonObject;
import com.ninni.dye_depot.registry.DyedHolders;
import java.util.stream.Stream;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

public class ModCompat {

    public static final String SUPPLEMENTARIES = "supplementaries";
    public static final String SUPPLEMENTARIES_SQUARED = "suppsquared";

    public static <T> DyedHolders<T, T> supplementariesHolders(HolderLookup.RegistryLookup<T> registry, String name) {
        return supplementariesHolders(registry, name, DyedHolders.modColors());
    }

    public static <T> DyedHolders<T, T> supplementariesHolders(HolderLookup.RegistryLookup<T> registry, String name, Stream<DyeColor> colors) {
        return DyedHolders.fromRegistry(registry, colors, color -> new ResourceLocation(SUPPLEMENTARIES, name + "_" + color));
    }

    public static <T> DyedHolders<T, T> supplementariesSquaredHolders(HolderLookup.RegistryLookup<T> registry, String name) {
        return supplementariesSquaredHolders(registry, name, DyedHolders.modColors());
    }

    public static <T> DyedHolders<T, T> supplementariesSquaredHolders(HolderLookup.RegistryLookup<T> registry, String name, Stream<DyeColor> colors) {
        return DyedHolders.fromRegistry(registry, colors, color -> new ResourceLocation(SUPPLEMENTARIES_SQUARED, name + "_" + color));
    }

    public static ConditionJsonProvider supplementariesFlag(String flag) {
        return DefaultResourceConditions.and(
                DefaultResourceConditions.allModsLoaded(SUPPLEMENTARIES),
                new ConditionJsonProvider() {
                    @Override
                    public ResourceLocation getConditionId() {
                        return new ResourceLocation(SUPPLEMENTARIES, "flag");
                    }

                    @Override
                    public void writeParameters(JsonObject json) {
                        json.addProperty("flag", flag);
                    }
                }
        );
    }

}
