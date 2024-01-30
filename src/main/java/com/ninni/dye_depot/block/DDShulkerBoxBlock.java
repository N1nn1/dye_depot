package com.ninni.dye_depot.block;

import com.ninni.dye_depot.registry.DDBlockEntityType;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class DDShulkerBoxBlock extends ShulkerBoxBlock {
    public DDShulkerBoxBlock(@Nullable DyeColor dyeColor, Properties properties) {
        super(dyeColor, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DDShulkerBoxBlockEntity(this.getColor(), blockPos, blockState);
    }

    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof ShulkerBoxBlockEntity shulkerBoxBlockEntity) {
            if (!level.isClientSide && player.isCreative() && !shulkerBoxBlockEntity.isEmpty()) {
                ItemStack itemStack = getColoredItemStack(this.getColor());
                blockEntity.saveToItem(itemStack);
                if (shulkerBoxBlockEntity.hasCustomName()) {
                    itemStack.setHoverName(shulkerBoxBlockEntity.getCustomName());
                }

                ItemEntity itemEntity = new ItemEntity(level, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, itemStack);
                itemEntity.setDefaultPickUpDelay();
                level.addFreshEntity(itemEntity);
            } else {
                shulkerBoxBlockEntity.unpackLootTable(player);
            }
        }

        this.spawnDestroyParticles(level, player, blockPos, blockState);
        if (blockState.is(BlockTags.GUARDED_BY_PIGLINS)) {
            PiglinAi.angerNearbyPiglins(player, false);
        }

        level.gameEvent(GameEvent.BLOCK_DESTROY, blockPos, GameEvent.Context.of(player, blockState));
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, DDBlockEntityType.SHULKER_BOX, ShulkerBoxBlockEntity::tick);
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        ItemStack itemStack = super.getCloneItemStack(blockGetter, blockPos, blockState);
        blockGetter.getBlockEntity(blockPos, DDBlockEntityType.SHULKER_BOX).ifPresent((shulkerBoxBlockEntity) -> shulkerBoxBlockEntity.saveToItem(itemStack));
        return itemStack;
    }

    @Nullable
    public static DyeColor getColorFromBlock(Block block) {
        if (block instanceof DDShulkerBoxBlock) {
            return ((DDShulkerBoxBlock)block).getColor();
        }
        return null;
    }

    public static Block getBlockByColor(@Nullable DyeColor dyeColor) {
        if (dyeColor == DDDyes.MAROON.get()) return DDBlocks.MAROON_SHULKER_BOX;
        else if (dyeColor == DDDyes.ROSE.get()) return DDBlocks.ROSE_SHULKER_BOX;
        else if (dyeColor == DDDyes.CORAL.get()) return DDBlocks.CORAL_SHULKER_BOX;
        else if (dyeColor == DDDyes.INDIGO.get()) return DDBlocks.INDIGO_SHULKER_BOX;
        else if (dyeColor == DDDyes.NAVY.get()) return DDBlocks.NAVY_SHULKER_BOX;
        else if (dyeColor == DDDyes.SLATE.get()) return DDBlocks.SLATE_SHULKER_BOX;
        else if (dyeColor == DDDyes.OLIVE.get()) return DDBlocks.OLIVE_SHULKER_BOX;
        else if (dyeColor == DDDyes.AMBER.get()) return DDBlocks.AMBER_SHULKER_BOX;
        else if (dyeColor == DDDyes.BEIGE.get()) return DDBlocks.BEIGE_SHULKER_BOX;
        else if (dyeColor == DDDyes.TEAL.get()) return DDBlocks.TEAL_SHULKER_BOX;
        else if (dyeColor == DDDyes.TURQUOISE.get()) return DDBlocks.TURQUOISE_SHULKER_BOX;
        else if (dyeColor == DDDyes.AQUA.get()) return DDBlocks.AQUA_SHULKER_BOX;
        else if (dyeColor == DDDyes.VERDANT.get()) return DDBlocks.VERDANT_SHULKER_BOX;
        else if (dyeColor == DDDyes.FOREST.get()) return DDBlocks.FOREST_SHULKER_BOX;
        else if (dyeColor == DDDyes.GINGER.get()) return DDBlocks.GINGER_SHULKER_BOX;
        else if (dyeColor == DDDyes.TAN.get()) return DDBlocks.TAN_SHULKER_BOX;
        else return Blocks.SHULKER_BOX;
    }

    public static ItemStack getColoredItemStack(@Nullable DyeColor dyeColor) {
        return new ItemStack(getBlockByColor(dyeColor));
    }
}
