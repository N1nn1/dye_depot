package com.ninni.dye_depot.block;

import com.mojang.logging.LogUtils;
import com.ninni.dye_depot.registry.DDBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Nameable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.AbstractBannerBlock;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class DDBannerBlockEntity extends BlockEntity implements Nameable {
    private static final Logger LOGGER = LogUtils.getLogger();
    @Nullable
    private Component name;
    private DyeColor baseColor;
    private BannerPatternLayers patterns;

    public DDBannerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(DDBlockEntityTypes.BANNER, blockPos, blockState);
        this.patterns = BannerPatternLayers.EMPTY;
        this.baseColor = ((AbstractBannerBlock)blockState.getBlock()).getColor();
    }

    public DDBannerBlockEntity(BlockPos blockPos, BlockState blockState, DyeColor dyeColor) {
        this(blockPos, blockState);
        this.baseColor = dyeColor;
    }

    public void fromItem(ItemStack itemStack, DyeColor dyeColor) {
        this.baseColor = dyeColor;
        this.applyComponentsFromItemStack(itemStack);
    }

    public Component getName() {
        return this.name != null ? this.name : Component.translatable("block.minecraft.banner");
    }

    @Nullable
    public Component getCustomName() {
        return this.name;
    }

    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        if (!this.patterns.equals(BannerPatternLayers.EMPTY)) {
            compoundTag.put("patterns", BannerPatternLayers.CODEC.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), this.patterns).getOrThrow());
        }

        if (this.name != null) {
            compoundTag.putString("CustomName", Component.Serializer.toJson(this.name, provider));
        }

    }

    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        if (compoundTag.contains("CustomName", 8)) {
            this.name = parseCustomNameSafe(compoundTag.getString("CustomName"), provider);
        }

        if (compoundTag.contains("patterns")) {
            BannerPatternLayers.CODEC.parse(provider.createSerializationContext(NbtOps.INSTANCE), compoundTag.get("patterns")).resultOrPartial((string) -> {
                LOGGER.error("Failed to parse banner patterns: '{}'", string);
            }).ifPresent((bannerPatternLayers) -> {
                this.patterns = bannerPatternLayers;
            });
        }

    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        return this.saveWithoutMetadata(provider);
    }

    public BannerPatternLayers getPatterns() {
        return this.patterns;
    }

    public ItemStack getItem() {
        ItemStack itemStack = new ItemStack(DDBannerBlock.byColor(this.baseColor));
        itemStack.applyComponents(this.collectComponents());
        return itemStack;
    }

    public DyeColor getBaseColor() {
        return this.baseColor;
    }

    protected void applyImplicitComponents(BlockEntity.DataComponentInput dataComponentInput) {
        super.applyImplicitComponents(dataComponentInput);
        this.patterns = dataComponentInput.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY);
        this.name = dataComponentInput.get(DataComponents.CUSTOM_NAME);
    }

    protected void collectImplicitComponents(DataComponentMap.Builder builder) {
        super.collectImplicitComponents(builder);
        builder.set(DataComponents.BANNER_PATTERNS, this.patterns);
        builder.set(DataComponents.CUSTOM_NAME, this.name);
    }

    public void removeComponentsFromTag(CompoundTag compoundTag) {
        compoundTag.remove("patterns");
        compoundTag.remove("CustomName");
    }
}
