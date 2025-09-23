package com.ninni.dye_depot.data;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ninni.dye_depot.registry.DyedHolders;

import java.util.List;
import java.util.stream.Stream;

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.fabricmc.fabric.impl.resource.conditions.conditions.AllModsLoadedResourceCondition;
import net.fabricmc.fabric.impl.resource.conditions.conditions.AndResourceCondition;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.Nullable;

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
                new SupplementariesResourceCondition(flag)
        ));
    }

    public record SupplementariesResourceCondition(String flag) implements ResourceCondition {

        private static final MapCodec<SupplementariesResourceCondition> CODEC = RecordCodecBuilder.mapCodec(builder ->
                builder.group(
                        Codec.STRING.fieldOf("flag").forGetter(it -> it.flag)
                ).apply(builder, SupplementariesResourceCondition::new)
        );

        private static final ResourceConditionType<SupplementariesResourceCondition> TYPE = ResourceConditionType.create(
                ResourceLocation.fromNamespaceAndPath(SUPPLEMENTARIES, "flag"),
                CODEC
        );

        @Override
        public ResourceConditionType<?> getType() {
            return TYPE;
        }

        @Override
        public boolean test(HolderLookup.@Nullable Provider provider) {
            return false;
        }

    }

}
