package com.ninni.dye_depot.mixin;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(BannerBlock.class)
public interface BannerBlockAccessor {
    @Accessor("BY_COLOR")
    static Map<DyeColor, Block> getByColor() {
        throw new AssertionError();
    }
}
