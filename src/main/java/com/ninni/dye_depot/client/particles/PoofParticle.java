package com.ninni.dye_depot.client.particles;

import com.ninni.dye_depot.block.DyeBasketBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PoofParticle extends TextureSheetParticle {
    private final float rotSpeed;
    private final SpriteSet sprites;

    PoofParticle(ClientLevel clientLevel, double d, double e, double f, float g, float h, float i, SpriteSet spriteSet) {
        super(clientLevel, d, e, f);
        this.sprites = spriteSet;
        this.rCol = g;
        this.gCol = h;
        this.bCol = i;
        float j = 0.9f;
        this.quadSize *= 0.67499995f;
        int k = (int)(32.0 / (Math.random() * 0.8 + 0.2));
        this.lifetime = (int)Math.max((float)k * 0.9f, 1.0f);
        this.setSpriteFromAge(spriteSet);
        this.rotSpeed = ((float)Math.random() - 0.5f) * 0.1f;
        this.roll = (float)Math.random() * ((float)Math.PI * 2);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public float getQuadSize(float f) {
        return this.quadSize * Mth.clamp(((float)this.age + f) / (float)this.lifetime * 32.0f, 0.0f, 1.0f);
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
            return;
        }
        this.setSpriteFromAge(this.sprites);
        this.oRoll = this.roll;
        this.roll += (float)Math.PI * this.rotSpeed * 2.0f;
        if (this.onGround) {
            this.roll = 0.0f;
            this.oRoll = 0.0f;
        }
        this.move(this.xd, this.yd, this.zd);
        this.yd -= (double)0.003f;
        this.yd = Math.max(this.yd, (double)-0.14f);
    }

    @Environment(value= EnvType.CLIENT)
    public static class Provider implements ParticleProvider<BlockParticleOption> {
        private final SpriteSet sprite;

        public Provider(SpriteSet spriteSet) {
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
                DyeColor dyeColor = ((DyeBasketBlock)blockState.getBlock()).getDyeColor();

                if (dyeColor == DyeColor.BLUE) j = 0x345eb6;
                else if (dyeColor == DyeColor.GREEN) j = 0x5b8221;
                else if (dyeColor == DyeColor.MAGENTA) j = 0xcb69c5;
                else if (dyeColor == DyeColor.CYAN) j = 0x29a9b0;
                else if (dyeColor == DyeColor.RED) j = 0xb53c39;
                else if (dyeColor == DyeColor.ORANGE) j = 0xd7710a;
                else j = dyeColor.getTextColor();
            }
            float k = (float)(j >> 16 & 0xFF) / 255.0f;
            float l = (float)(j >> 8 & 0xFF) / 255.0f;
            float m = (float)(j & 0xFF) / 255.0f;
            return new PoofParticle(clientLevel, d, e, f, k, l, m, this.sprite);
        }
    }
}