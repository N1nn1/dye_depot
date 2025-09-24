package com.ninni.dye_depot.data.server;

import com.ninni.dye_depot.data.ModCompat;
import com.ninni.dye_depot.registry.DDBlocks;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
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
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;

public class DDBlockLoot extends BlockLootSubProvider {

    private final CompletableFuture<HolderLookup.Provider> lookup;

    public DDBlockLoot(CompletableFuture<HolderLookup.Provider> lookup) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        this.lookup = lookup;
    }

    @Override
    public void generate() {
        var lookup = this.lookup.join();
        var blockLookup = lookup.lookupOrThrow(Registries.BLOCK);

        DDBlocks.BANNERS.values().forEach(this::dropBanner);
        DDBlocks.BEDS.values().forEach(this::dropBed);
        DDBlocks.CANDLES.values().forEach(this::dropCandle);
        DDBlocks.CANDLE_CAKES.values().forEach(this::dropCandleCake);
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

        // TODO this is not possible in forge, use forge-fix?
        // var supplementariesLoot = withConditions(DefaultResourceConditions.allModsLoaded(ModCompat.SUPPLEMENTARIES));
        var supplementariesLoot = this;
        ModCompat.supplementariesHolders(blockLookup, "flag").values()
                .forEach(it -> supplementariesLoot.add(it, createFlagDrops(it)));
        ModCompat.supplementariesHolders(blockLookup, "candle_holder").values()
                .forEach(it -> supplementariesLoot.add(it, createCandleDrops(it)));
        ModCompat.supplementariesSquaredHolders(blockLookup, "gold_candle_holder").values()
                .forEach(it -> supplementariesLoot.add(it, createCandleDrops(it)));
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

    private void dropCandleCake(Block block) {
        add(block, createCandleCakeDrops(block));
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
                .apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY))
                .apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY)
                        .copy("Patterns", "BlockEntityTag.Patterns")
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
