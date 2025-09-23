package com.ninni.dye_depot.client.particles;

import com.ninni.dye_depot.block.DyeBasketBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PoofParticleProvider implements ParticleProvider<BlockParticleOption> {
    private final SpriteSet sprite;

    public PoofParticleProvider(SpriteSet spriteSet) {
        this.sprite = spriteSet;
    }

    @Nullable
    @Override
    public Particle createParticle(BlockParticleOption particleOptions, ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
        BlockState blockState = particleOptions.getState();
        if (!blockState.isAir() && blockState.getRenderShape() == RenderShape.INVISIBLE) return null;
        BlockPos blockPos = BlockPos.containing(d, e, f);
        int j = Minecraft.getInstance().getBlockColors().getColor(blockState, clientLevel, blockPos);
        if (blockState.getBlock() instanceof DyeBasketBlock) {
            DyeColor dyeColor = ((DyeBasketBlock) blockState.getBlock()).getDyeColor();

            if (dyeColor == DyeColor.BLUE) j = 0x345eb6;
            else if (dyeColor == DyeColor.GREEN) j = 0x5b8221;
            else if (dyeColor == DyeColor.MAGENTA) j = 0xcb69c5;
            else if (dyeColor == DyeColor.CYAN) j = 0x29a9b0;
            else if (dyeColor == DyeColor.RED) j = 0xb53c39;
            else if (dyeColor == DyeColor.ORANGE) j = 0xd7710a;
            else j = dyeColor.getTextColor();
        }
        float k = (float) (j >> 16 & 0xFF) / 255.0f;
        float l = (float) (j >> 8 & 0xFF) / 255.0f;
        float m = (float) (j & 0xFF) / 255.0f;
        return new PoofParticle(clientLevel, d, e, f, k, l, m, this.sprite);
    }
}
