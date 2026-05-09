package com.ninni.dye_depot.data.server;

import com.ninni.dye_depot.data.ModCompat;
import com.ninni.dye_depot.registry.DDBlocks;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class DDBlockLoot extends BlockLootSubProvider {

    public DDBlockLoot(HolderLookup.Provider lookup) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookup);
    }

    @Override
    public void generate() {
        var blockLookup = registries.lookupOrThrow(Registries.BLOCK);

        DDBlocks.BANNERS.values().forEach(this::dropBanner);
        DDBlocks.BEDS.values().forEach(this::dropBed);
        DDBlocks.CANDLES.values().forEach(this::dropCandle);
        DDBlocks.CANDLE_CAKES.forEachWith(DDBlocks.CANDLES, this::dropCandleCake);
        DDBlocks.CARPETS.values().forEach(this::dropSelf);
        DDBlocks.CONCRETE.values().forEach(this::dropSelf);
        DDBlocks.CONCRETE_POWDER.values().forEach(this::dropSelf);
        DDBlocks.DYE_BASKETS.values().forEach(this::dropSelf);
        DDBlocks.GLAZED_TERRACOTTA.values().forEach(this::dropSelf);
        DDBlocks.SHULKER_BOXES.values().forEach(this::dropShulkerBox);
        DDBlocks.STAINED_GLASS.values().forEach(this::dropWhenSilkTouch);
        DDBlocks.STAINED_GLASS_PANES.values().forEach(this::dropWhenSilkTouch);
        DDBlocks.TERRACOTTA.values().forEach(this::dropSelf);
        DDBlocks.WOOL.values().forEach(this::dropSelf);

        // TODO waiting for supplementaries
        // var supplementariesLoot = withConditions(DefaultResourceConditions.allModsLoaded(ModCompat.SUPPLEMENTARIES));
        // var supplementariesLoot = this;
        // ModCompat.supplementariesHolders(blockLookup, "flag").values()
        //         .forEach(it -> supplementariesLoot.add(it, createFlagDrops(it)));
        // ModCompat.supplementariesHolders(blockLookup, "candle_holder").values()
        //         .forEach(it -> supplementariesLoot.add(it, createCandleDrops(it)));
        // ModCompat.supplementariesSquaredHolders(blockLookup, "gold_candle_holder").values()
        //         .forEach(it -> supplementariesLoot.add(it, createCandleDrops(it)));
    }

    private void dropBanner(Block block) {
        add(block, createBannerDrop(block));
    }

    private void dropBed(Block block) {
        add(block, createSinglePropConditionTable(block, BedBlock.PART, BedPart.HEAD));
    }

    private void dropCandle(Block block) {
        add(block, createCandleDrops(block));
    }

    private void dropCandleCake(Holder<? extends Block> block, Holder<? extends Block> candle) {
        add(block.value(), createCandleCakeDrops(candle.value()));
    }

    private void dropShulkerBox(Block block) {
        add(block, createShulkerBoxDrop(block));
    }

    private LootTable.Builder createTable(Block block, LootPoolEntryContainer.Builder<?> entry) {
        return LootTable.lootTable().withPool(
                applyExplosionDecay(block, LootPool.lootPool().add(entry))
        );
    }

    private LootTable.Builder createFlagDrops(Block block) {
        var entry = LootItem.lootTableItem(block)
                .apply(CopyComponentsFunction.copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY)
                        .include(DataComponents.CUSTOM_NAME)
                        .include(DataComponents.ITEM_NAME)
                        .include(DataComponents.TOOLTIP_DISPLAY)
                        .include(DataComponents.RARITY)
                        .include(DataComponents.BANNER_PATTERNS)
                );

        return createTable(block, entry);
    }

    private final Collection<Block> knownBlocks = new HashSet<>();

    @Override
    protected void add(Block block, LootTable.Builder builder) {
        super.add(block, builder);
        knownBlocks.add(block);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return knownBlocks;
    }
}
