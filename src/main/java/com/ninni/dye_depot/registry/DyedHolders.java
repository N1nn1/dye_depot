package com.ninni.dye_depot.registry;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.IntComparator;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Comparator;
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

    @SafeVarargs
    public static <T> DyedHolders<T> merge(DyedHolders<? extends T>... from) {
        var entries = ImmutableMap.<DyeColor, T>builder();

        for (var holders : from) {
            entries.putAll(holders.entries);
        }

        return new DyedHolders<>(entries.build());
    }

    public static Stream<DyeColor> vanillaColors() {
        return Arrays.stream(DyeColor.values()).filter(it -> it.getId() < 16);
    }

    public static Stream<DyeColor> modColors() {
        return Arrays.stream(DDDyes.values()).map(DDDyes::get);
    }

    public static <T> DyedHolders<T> createWithVanilla(Function<DyeColor, T> mapper) {
        return create(
                Stream.of(
                        vanillaColors(),
                        modColors()
                ).flatMap(Function.identity()),
                mapper
        );
    }

    public static <T> DyedHolders<T> fromRegistry(Registry<T> registry, Stream<DyeColor> colors, ResourceLocation baseName) {
        return fromRegistry(registry, colors, color -> baseName.withPrefix(color + "_"));
    }

    public static <T> DyedHolders<T> fromRegistry(Registry<T> registry, Stream<DyeColor> colors, Function<DyeColor, ResourceLocation> idMapper) {
        return create(colors, color ->
                registry.getOrThrow(ResourceKey.create(registry.key(), idMapper.apply(color)))
        );
    }

    public @Nullable T getOrNull(DyeColor color) {
        return entries.get(color);
    }

    public Optional<T> get(DyeColor color) {
        return Optional.ofNullable(getOrNull(color));
    }

    public T getOrThrow(DyeColor color) {
        return Objects.requireNonNull(getOrNull(color), () -> "holders does not contain block of color " + color);
    }

    public Stream<T> values() {
        return entries.entrySet().stream()
                .sorted(Comparator.comparing(it -> it.getKey().getId()))
                .map(Map.Entry::getValue);
    }

    public void forEach(BiConsumer<DyeColor, T> consumer) {
        entries.entrySet().stream()
                .sorted(Comparator.comparing(it -> it.getKey().getId()))
                .forEach(it -> consumer.accept(it.getKey(), it.getValue()));
    }

    public <R> Stream<R> map(BiFunction<DyeColor, T, R> mapper) {
        return entries.entrySet().stream().map(it -> mapper.apply(it.getKey(), it.getValue()));
    }

}
