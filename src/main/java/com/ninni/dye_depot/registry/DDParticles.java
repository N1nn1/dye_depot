package com.ninni.dye_depot.registry;

import com.mojang.serialization.MapCodec;
import com.ninni.dye_depot.DyeDepot;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Function;

public class DDParticles {
    public static final ParticleType<BlockParticleOption> DYE_POOF = Registry.register(BuiltInRegistries.PARTICLE_TYPE, DyeDepot.id("dye_poof"), FabricParticleTypes.complex(BlockParticleOption::codec, BlockParticleOption::streamCodec));


    public static void init() {

    }
}
