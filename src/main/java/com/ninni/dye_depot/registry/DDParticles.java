package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class DDParticles {
    public static final ParticleType<BlockParticleOption> DYE_POOF = Registry.register(BuiltInRegistries.PARTICLE_TYPE, DyeDepot.modLoc("dye_poof"), FabricParticleTypes.complex(false, BlockParticleOption.DESERIALIZER));
}
