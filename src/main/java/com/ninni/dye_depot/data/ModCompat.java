package com.ninni.dye_depot.data;

import com.ninni.dye_depot.registry.DyedHolders;
import java.util.List;
import java.util.stream.Stream;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.impl.resource.conditions.conditions.AllModsLoadedResourceCondition;
import net.fabricmc.fabric.impl.resource.conditions.conditions.AndResourceCondition;
import net.mehvahdjukaar.moonlight.api.resources.recipe.fabric.OptionalRecipeCondition;
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
        return DyedHolders.fromRegistry(registry, colors, color -> ResourceLocation.fromNamespaceAndPath(SUPPLEMENTARIES, name + "_" + color));
    }

    public static <T> DyedHolders<T, T> supplementariesSquaredHolders(HolderLookup.RegistryLookup<T> registry, String name) {
        return supplementariesSquaredHolders(registry, name, DyedHolders.modColors());
    }

    public static <T> DyedHolders<T, T> supplementariesSquaredHolders(HolderLookup.RegistryLookup<T> registry, String name, Stream<DyeColor> colors) {
        return DyedHolders.fromRegistry(registry, colors, color -> ResourceLocation.fromNamespaceAndPath(SUPPLEMENTARIES_SQUARED, name + "_" + color));
    }

    public static ResourceCondition supplementariesFlag(String flag) {
        return new AndResourceCondition(List.of(
                new AllModsLoadedResourceCondition(List.of(SUPPLEMENTARIES)),
                new OptionalRecipeCondition(
                        ResourceLocation.fromNamespaceAndPath(SUPPLEMENTARIES, "flag"),
                        $ -> true,
                        flag
                )
        ));
    }

}
