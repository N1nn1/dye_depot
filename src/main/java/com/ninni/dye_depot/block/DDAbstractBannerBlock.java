package com.ninni.dye_depot.block;

import com.ninni.dye_depot.registry.DDBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractBannerBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DDAbstractBannerBlock extends AbstractBannerBlock {
    private final DyeColor color;

    protected DDAbstractBannerBlock(DyeColor dyeColor, Properties properties) {
        super(dyeColor, properties);
        this.color = dyeColor;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DDBannerBlockEntity(blockPos, blockState, this.getColor());
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity livingEntity, ItemStack itemStack) {
        if (level.isClientSide) {
            level.getBlockEntity(blockPos, DDBlockEntityType.BANNER.get()).ifPresent(bannerBlockEntity -> bannerBlockEntity.fromItem(itemStack));
        } else if (itemStack.hasCustomHoverName()) {
            level.getBlockEntity(blockPos, DDBlockEntityType.BANNER.get()).ifPresent(bannerBlockEntity -> bannerBlockEntity.setCustomName(itemStack.getHoverName()));
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
        if (blockEntity instanceof DDBannerBlockEntity) {
            return ((DDBannerBlockEntity)blockEntity).getItem();
        }
        return super.getCloneItemStack(blockGetter, blockPos, blockState);
    }

    public DyeColor getColor() {
        return this.color;
    }
}
