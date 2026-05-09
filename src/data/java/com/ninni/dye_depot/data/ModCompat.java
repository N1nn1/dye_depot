package com.ninni.dye_depot.data;

import com.ninni.dye_depot.registry.DyedHolders;
import java.util.stream.Stream;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;

public class ModCompat {

    public static final String SUPPLEMENTARIES = "supplementaries";
    public static final String SUPPLEMENTARIES_SQUARED = "suppsquared";

    public static <T> DyedHolders<T, T> supplementariesHolders(HolderLookup.RegistryLookup<T> registry, String name) {
        return supplementariesHolders(registry, name, DyedHolders.modColors());
    }

    public static <T> DyedHolders<T, T> supplementariesHolders(HolderLookup.RegistryLookup<T> registry, String name, Stream<DyeColor> colors) {
        return DyedHolders.fromRegistry(registry, colors, color -> Identifier.fromNamespaceAndPath(SUPPLEMENTARIES, name + "_" + color));
    }

    public static <T> DyedHolders<T, T> supplementariesSquaredHolders(HolderLookup.RegistryLookup<T> registry, String name) {
        return supplementariesSquaredHolders(registry, name, DyedHolders.modColors());
    }

    public static <T> DyedHolders<T, T> supplementariesSquaredHolders(HolderLookup.RegistryLookup<T> registry, String name, Stream<DyeColor> colors) {
        return DyedHolders.fromRegistry(registry, colors, color -> Identifier.fromNamespaceAndPath(SUPPLEMENTARIES_SQUARED, name + "_" + color));
    }

    /*
    public static ICondition[] supplementariesFlag(String flag) {
        var serializerId = ResourceKey.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Identifier.fromNamespaceAndPath(SUPPLEMENTARIES, "flag"));
        var serializer = NeoForgeRegistries.CONDITION_SERIALIZERS.getOrThrow(serializerId);

        var supplementariesJson = new JsonObject();
        supplementariesJson.addProperty("type", serializerId.identifier().toString());
        supplementariesJson.addProperty("flag", flag);

        return new ICondition[]{
                new ModLoadedCondition(SUPPLEMENTARIES),
                serializer.value().parse(JsonOps.INSTANCE, supplementariesJson).getOrThrow()
        };
    }
    */

}
