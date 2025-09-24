package com.ninni.dye_depot.registry;

import com.mojang.datafixers.util.Either;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraftforge.registries.RegistryObject;

public class DeferredHolder<T> implements Holder<T> {

    private final ResourceKey<T> key;
    private final Supplier<T> value;

    public static <T> DeferredHolder<T> from(RegistryObject<T> object) {
        return new DeferredHolder<>(object.getKey(), object);
    }

    private DeferredHolder(ResourceKey<T> key, Supplier<T> value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public T value() {
        return value.get();
    }

    @Override
    public boolean isBound() {
        return false;
    }

    @Override
    public boolean is(ResourceLocation other) {
        return key.location().equals(other);
    }

    @Override
    public boolean is(ResourceKey<T> other) {
        return key.equals(other);
    }

    @Override
    public boolean is(Predicate<ResourceKey<T>> predicate) {
        return predicate.test(key);
    }

    @Override
    public boolean is(TagKey<T> tag) {
        return false;
    }

    @Override
    public Stream<TagKey<T>> tags() {
        return Stream.empty();
    }

    @Override
    public Either<ResourceKey<T>, T> unwrap() {
        return Either.right(value());
    }

    @Override
    public Optional<ResourceKey<T>> unwrapKey() {
        return Optional.of(key);
    }

    @Override
    public Kind kind() {
        return Kind.REFERENCE;
    }

    @Override
    public boolean canSerializeIn(HolderOwner<T> holderOwner) {
        return false;
    }
}
