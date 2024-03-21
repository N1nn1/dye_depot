package com.ninni.dye_depot.block;

import com.mojang.datafixers.util.Pair;
import com.ninni.dye_depot.registry.DDBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.AbstractBannerBlock;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DDBannerBlockEntity extends BannerBlockEntity {
    private DyeColor baseColor;
    @Nullable
    private Component name;
    @Nullable
    private ListTag itemPatterns;
    @Nullable
    private List<Pair<Holder<BannerPattern>, DyeColor>> patterns;

    public DDBannerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
        this.baseColor = ((AbstractBannerBlock)blockState.getBlock()).getColor();
    }

    public DDBannerBlockEntity(BlockPos blockPos, BlockState blockState, DyeColor dyeColor) {
        super(blockPos, blockState, dyeColor);
        this.baseColor = dyeColor;
    }

    public void fromItem(ItemStack itemStack, DyeColor dyeColor) {
        this.baseColor = dyeColor;
        this.fromItem(itemStack);
    }

    public void fromItem(ItemStack itemStack) {
        this.itemPatterns = BannerBlockEntity.getItemPatterns(itemStack);
        this.patterns = null;
        this.name = itemStack.hasCustomHoverName() ? itemStack.getHoverName() : null;
    }

    @Override
    public Component getName() {
        if (this.name != null) {
            return this.name;
        }
        return Component.translatable("block.minecraft.banner");
    }

    @Override
    @Nullable
    public Component getCustomName() {
        return this.name;
    }

    public void setCustomName(Component component) {
        this.name = component;
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        if (this.itemPatterns != null) {
            compoundTag.put(TAG_PATTERNS, this.itemPatterns);
        }
        if (this.name != null) {
            compoundTag.putString("CustomName", Component.Serializer.toJson(this.name));
        }
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        if (compoundTag.contains("CustomName", 8)) {
            this.name = Component.Serializer.fromJson(compoundTag.getString("CustomName"));
        }
        this.itemPatterns = compoundTag.getList(TAG_PATTERNS, 10);
        this.patterns = null;
    }

    public ItemStack getItem() {
        ItemStack itemStack = new ItemStack(DDBannerBlock.byColor(this.baseColor));
        if (this.itemPatterns != null && !this.itemPatterns.isEmpty()) {
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.put(TAG_PATTERNS, this.itemPatterns.copy());
            BlockItem.setBlockEntityData(itemStack, this.getType(), compoundTag);
        }
        if (this.name != null) {
            itemStack.setHoverName(this.name);
        }
        return itemStack;
    }

    public List<Pair<Holder<BannerPattern>, DyeColor>> getPatterns() {
        if (this.patterns == null) {
            this.patterns = BannerBlockEntity.createPatterns(this.baseColor, this.itemPatterns);
        }
        return this.patterns;
    }

    public DyeColor getBaseColor() {
        return this.baseColor;
    }

    @Override
    public BlockEntityType<?> getType() {
        return DDBlockEntityType.BANNER.get();
    }
}
