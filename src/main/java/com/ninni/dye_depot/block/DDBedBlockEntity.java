package com.ninni.dye_depot.block;

import com.ninni.dye_depot.registry.DDBlockEntityType;
import com.ninni.dye_depot.registry.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class DDBedBlockEntity extends BedBlockEntity {
    private DyeColor color;

    public DDBedBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
        this.color = ((BedBlock) blockState.getBlock()).getColor();
    }

    public DDBedBlockEntity(BlockPos blockPos, BlockState blockState, DyeColor dyeColor) {
        super(blockPos, blockState);
        this.color = dyeColor;
    }

    @Override
    public BlockEntityType<?> getType() {
        return DDBlockEntityType.BED;
    }

    public DyeColor getColor() {
        return this.color;
    }

    public void setColor(DyeColor dyeColor) {
        this.color = dyeColor;
    }

    @Override
    public boolean isValidBlockState(BlockState state) {
        return DDBlocks.BEDS.values().anyMatch(state::is);
    }

}
