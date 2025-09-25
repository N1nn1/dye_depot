package com.ninni.dye_depot.registry;

import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.Nullable;

public final class DyedHolders<TImplementation extends RRegistry, RRegistry> {

    private final Map<DyeColor, Holder<TImplementation>> entries;

    private DyedHolders(Map<DyeColor, Holder<TImplementation>> entries) {
        this.entries = entries;
    }

    public static <T extends R, R> DyedHolders<T, R> create(Stream<DyeColor> colors, Function<DyeColor, Holder<T>> mapper) {
        var entries = colors
                .collect(Collectors.toMap(Function.identity(), mapper));
        return new DyedHolders<>(entries);
    }

    public static <T extends R, R> DyedHolders<T, R> createModded(Function<DyeColor, Holder<T>> mapper) {
        return create(Arrays.stream(DDDyes.values()).map(DDDyes::get), mapper);
    }

    @SafeVarargs
    public static <T extends R, R> DyedHolders<T, R> merge(DyedHolders<T, R>... from) {
        var entries = ImmutableMap.<DyeColor, Holder<T>>builder();

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

    public static <T extends R, R> DyedHolders<T, R> createWithVanilla(Function<DyeColor, Holder<T>> mapper) {
        return create(
                Stream.concat(
                        vanillaColors(),
                        modColors()
                ),
                mapper
        );
    }

    public static <T extends R, R> DyedHolders<T, R> fromRegistry(HolderLookup.RegistryLookup<R> registry, Stream<DyeColor> colors, ResourceLocation baseName) {
        return fromRegistry(registry, colors, color -> baseName.withPrefix(color + "_"));
    }

    @SuppressWarnings("unchecked")
    public static <T extends R, R> DyedHolders<T, R> fromRegistry(HolderLookup.RegistryLookup<R> registry, Stream<DyeColor> colors, Function<DyeColor, ResourceLocation> idMapper) {
        var registryKey = (ResourceKey<Registry<R>>) registry.key();
        Function<DyeColor, ResourceKey<R>> keyMapper = idMapper.andThen(id -> ResourceKey.create(registryKey, id));
        return fromLookup(registry, colors, keyMapper);
    }

    @SuppressWarnings("unchecked")
    public static <T extends R, R> DyedHolders<T, R> fromLookup(HolderLookup<R> registry, Stream<DyeColor> colors, Function<DyeColor, ResourceKey<R>> idMapper) {
        return create(colors, color ->
                (Holder<T>) registry.getOrThrow(idMapper.apply(color))
        );
    }

    public @Nullable Holder<TImplementation> holderOrNull(DyeColor color) {
        return entries.get(color);
    }

    public Optional<Holder<TImplementation>> holder(DyeColor color) {
        return Optional.ofNullable(holderOrNull(color));
    }

    public @Nullable TImplementation getOrNull(DyeColor color) {
        return get(color).orElse(null);
    }

    public Optional<TImplementation> get(DyeColor color) {
        return holder(color).map(Holder::value);
    }

    public Holder<TImplementation> holderOrThrow(DyeColor color) {
        return Objects.requireNonNull(holderOrNull(color), () -> "holders does not contain block of color " + color);
    }

    public TImplementation getOrThrow(DyeColor color) {
        return holderOrThrow(color).value();
    }

    public Stream<Holder<TImplementation>> holders() {
        return entries.entrySet().stream()
                .sorted(Comparator.comparing(it -> it.getKey().getId()))
                .map(Map.Entry::getValue);
    }

    public Stream<TImplementation> values() {
        return holders().map(Holder::value);
    }

    public void forEach(BiConsumer<DyeColor, Holder<TImplementation>> consumer) {
        entries.entrySet().stream()
                .sorted(Comparator.comparing(it -> it.getKey().getId()))
                .forEach(it -> consumer.accept(it.getKey(), it.getValue()));
    }

    public <R> Stream<R> map(BiFunction<DyeColor, TImplementation, R> mapper) {
        return entries.entrySet().stream().map(it -> mapper.apply(it.getKey(), it.getValue().value()));
    }

    public DyedHolders<TImplementation, RRegistry> filter(Supplier<Stream<DyeColor>> colors) {
        return filter((color, $) -> colors.get().anyMatch(it -> it == color));
    }

    public DyedHolders<TImplementation, RRegistry> filter(BiPredicate<DyeColor, Holder<TImplementation>> predicate) {
        var entries = ImmutableMap.<DyeColor, Holder<TImplementation>>builder();
        forEach((color, value) -> {
            if (predicate.test(color, value)) entries.put(color, value);
        });
        return new DyedHolders<>(entries.build());
    }

    public String detectBaseName() {
        var entry = entries.entrySet().stream().findFirst().orElseThrow(() -> new NoSuchElementException("DyedHolders is empty"));
        var id = entry.getValue().unwrapKey().orElseThrow().location();
        return Pattern.compile("_?" + entry.getKey() + "_?")
                .matcher(id.getPath())
                .replaceFirst("");
    }

    public DyedHolders<TImplementation, RRegistry> mergeVanilla(HolderLookup.RegistryLookup<RRegistry> registry) {
        var base = detectBaseName();
        var vanillaVariants = DyedHolders.<TImplementation, RRegistry>fromRegistry(registry, DyedHolders.vanillaColors(), ResourceLocation.withDefaultNamespace(base));
        return merge(vanillaVariants, this);
    }

}
