package com.ninni.dye_depot.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AbstractBannerBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public abstract class DDAbstractBannerBlock extends AbstractBannerBlock {
    private final DyeColor color;

    protected DDAbstractBannerBlock(DyeColor dyeColor, Properties properties) {
        super(dyeColor, properties);
        this.color = dyeColor;
    }

    protected abstract MapCodec<? extends AbstractBannerBlock> codec();

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DDBannerBlockEntity(blockPos, blockState, this.getColor());
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        BlockEntity var5 = levelReader.getBlockEntity(blockPos);
        if (var5 instanceof DDBannerBlockEntity blockEntity) {
            return blockEntity.getItem();
        } else {
            return super.getCloneItemStack(levelReader, blockPos, blockState);
        }
    }

    public DyeColor getColor() {
        return this.color;
    }
}
