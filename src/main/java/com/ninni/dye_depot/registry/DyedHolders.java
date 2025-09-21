package com.ninni.dye_depot.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class DyedHolders<T> {

    private final Map<DyeColor, T> entries;

    public DyedHolders(Map<DyeColor, T> entries) {
        this.entries = entries;
    }

    public static <T> DyedHolders<T> create(Stream<DyeColor> colors, Function<DyeColor, T> mapper) {
        var entries = colors
                .collect(Collectors.toMap(Function.identity(), mapper));
        return new DyedHolders<>(entries);
    }

    public static <T> DyedHolders<T> create(Function<DyeColor, T> mapper) {
        return create(Arrays.stream(DDDyes.values()).map(DDDyes::get), mapper);
    }

    public static <T> DyedHolders<T> createWithVanilla(Function<DyeColor, T> mapper) {
        return create(
                Stream.of(
                        Arrays.stream(DyeColor.values()).filter(it -> it.getId() < 16),
                        Arrays.stream(DDDyes.values()).map(DDDyes::get)
                ).flatMap(Function.identity()),
                mapper
        );
    }

    public static <T> DyedHolders<T> fromRegistry(Registry<T> registry, ResourceLocation baseName) {
        return DyedHolders.create(color ->
                registry.getOrThrow(ResourceKey.create(registry.key(), baseName.withPrefix(color + "_")))
        );
    }

    public @Nullable T getOrNull(DyeColor color) {
        return entries.get(color);
    }

    public Optional<T> get(DyeColor color) {
        return Optional.ofNullable(getOrNull(color));
    }

    public T getOrThrow(DyeColor color) {
        return Objects.requireNonNull(getOrNull(color));
    }

    public Stream<T> values() {
        return entries.values().stream();
    }

    public void forEach(BiConsumer<DyeColor, T> consumer) {
        entries.entrySet().stream().forEach(it -> consumer.accept(it.getKey(), it.getValue()));
    }

    public <R> Stream<R> map(BiFunction<DyeColor, T, R> mapper) {
        return entries.entrySet().stream().map(it -> mapper.apply(it.getKey(), it.getValue()));
    }

}
