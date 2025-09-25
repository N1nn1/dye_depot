package com.ninni.dye_depot.data;

import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import com.ninni.dye_depot.registry.DyedHolders;
import java.util.stream.Stream;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

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

    public static ICondition[] supplementariesFlag(String flag) {
        var serializerId = ResourceKey.create(NeoForgeRegistries.Keys.CONDITION_CODECS, ResourceLocation.fromNamespaceAndPath(SUPPLEMENTARIES, "flag"));
        var serializer = NeoForgeRegistries.CONDITION_SERIALIZERS.getOrThrow(serializerId);

        var supplementariesJson = new JsonObject();
        supplementariesJson.addProperty("type", serializerId.location().toString());
        supplementariesJson.addProperty("flag", flag);

        return new ICondition[]{
                new ModLoadedCondition(SUPPLEMENTARIES),
                serializer.codec().parse(JsonOps.INSTANCE, supplementariesJson).getOrThrow()
        };
    }

}
