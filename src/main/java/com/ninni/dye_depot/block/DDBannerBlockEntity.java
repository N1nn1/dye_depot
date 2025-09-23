package com.ninni.dye_depot.block;

import com.ninni.dye_depot.registry.DDBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class DDBannerBlockEntity extends BannerBlockEntity {

    public DDBannerBlockEntity(BlockPos blockPos, BlockState state) {
        super(blockPos, state);
    }

    public DDBannerBlockEntity(BlockPos blockPos, BlockState state, DyeColor color) {
        super(blockPos, state, color);
    }

    @Override
    public BlockEntityType<?> getType() {
        return DDBlockEntityType.BANNER;
    }

}
