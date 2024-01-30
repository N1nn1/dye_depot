package com.ninni.dye_depot.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DDBedBlock extends BedBlock {
    private final DyeColor color;

    public DDBedBlock(DyeColor dyeColor, Properties properties) {
        super(dyeColor, properties);
        this.color = dyeColor;
    }

    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DDBedBlockEntity(blockPos, blockState, this.color);
    }
}
