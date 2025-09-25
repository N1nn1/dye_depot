package com.ninni.dye_depot.registry;

import com.mojang.serialization.MapCodec;
import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDParticles {

    private static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, DyeDepot.MOD_ID);

    private static class PoofParticleType extends ParticleType<BlockParticleOption> {
        public PoofParticleType() {
            super(false);
        }

        @Override
        public MapCodec<BlockParticleOption> codec() {
            return BlockParticleOption.codec(this);
        }

        @Override
        public StreamCodec<? super RegistryFriendlyByteBuf, BlockParticleOption> streamCodec() {
            return BlockParticleOption.streamCodec(this);
        }
    }

    public static final DeferredHolder<ParticleType<?>, ParticleType<BlockParticleOption>> DYE_POOF = REGISTRY.register("dye_poof", PoofParticleType::new);


    public static void register(IEventBus modBus) {
        REGISTRY.register(modBus);
    }

}
