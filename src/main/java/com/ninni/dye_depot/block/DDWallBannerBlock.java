package com.ninni.dye_depot.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class DDWallBannerBlock extends WallBannerBlock {

    public DDWallBannerBlock(DyeColor dyeColor, BlockBehaviour.Properties properties) {
        super(dyeColor, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DDBannerBlockEntity(blockPos, blockState, this.getColor());
    }

}