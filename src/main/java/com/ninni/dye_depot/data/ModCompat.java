package com.ninni.dye_depot.data;

import com.ninni.dye_depot.registry.DyedHolders;
import java.util.stream.Stream;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.crafting.conditions.AndCondition;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

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

    public static ICondition supplementariesFlag(String flag) {
        return new AndCondition(
                new ModLoadedCondition(SUPPLEMENTARIES)//,
               // new SuppFlag
        );
    }

}
