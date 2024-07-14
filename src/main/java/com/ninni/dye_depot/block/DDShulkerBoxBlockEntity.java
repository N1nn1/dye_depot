package com.ninni.dye_depot.block;

import com.ninni.dye_depot.registry.DDBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DDShulkerBoxBlockEntity extends ShulkerBoxBlockEntity {
    @Nullable
    private final DyeColor color;

    public DDShulkerBoxBlockEntity(@Nullable DyeColor dyeColor, BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
        this.color = dyeColor;
    }

    public DDShulkerBoxBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
        this.color = DDShulkerBoxBlock.getColorFromBlock(blockState.getBlock());
    }

    @Nullable
    public DyeColor getColor() {
        return this.color;
    }

    @Override
    public BlockEntityType<?> getType() {
        return DDBlockEntityTypes.SHULKER_BOX;
    }
}