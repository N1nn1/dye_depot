package com.ninni.dye_depot.block;

import com.ninni.dye_depot.registry.DDBlockEntityType;
import com.ninni.dye_depot.registry.DDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DDShulkerBoxBlock extends ShulkerBoxBlock {

    public DDShulkerBoxBlock(@Nullable DyeColor dyeColor, Properties properties) {
        super(dyeColor, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DDShulkerBoxBlockEntity(this.getColor(), blockPos, blockState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, DDBlockEntityType.SHULKER_BOX, ShulkerBoxBlockEntity::tick);
    }

    public ItemStack getCloneItemStack(LevelReader blockGetter, BlockPos blockPos, BlockState blockState) {
        ItemStack itemStack = super.getCloneItemStack(blockGetter, blockPos, blockState);
        blockGetter.getBlockEntity(blockPos, DDBlockEntityType.SHULKER_BOX).ifPresent((shulkerBoxBlockEntity) -> shulkerBoxBlockEntity.saveToItem(itemStack));
        return itemStack;
    }

    @Nullable
    public static DyeColor getColorFromBlock(Block block) {
        if (block instanceof DDShulkerBoxBlock shulker) {
            return shulker.getColor();
        }
        return null;
    }

    @Override
    public Item asItem() {
        return DDItems.SHULKER_BOXES.getOrThrow(getColor());
    }
}
