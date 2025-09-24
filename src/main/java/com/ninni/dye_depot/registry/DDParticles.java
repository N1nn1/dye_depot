package com.ninni.dye_depot.registry;

import com.mojang.serialization.Codec;
import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DDParticles {

    private static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, DyeDepot.MOD_ID);

    private static class PoofParticleType extends ParticleType<BlockParticleOption> {
        public PoofParticleType() {
            super(false, BlockParticleOption.DESERIALIZER);
        }

        @Override
        public Codec<BlockParticleOption> codec() {
            return BlockParticleOption.codec(this);
        }
    }

    public static final RegistryObject<ParticleType<BlockParticleOption>> DYE_POOF = REGISTRY.register("dye_poof", PoofParticleType::new);


    public static void register(IEventBus modBus) {
        REGISTRY.register(modBus);
    }

}
