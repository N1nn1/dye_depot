package com.ninni.dye_depot.data;

import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DyedHolders;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.mehvahdjukaar.supplementaries.common.block.blocks.CandleHolderBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class DDBlockLoot extends FabricBlockLootTableProvider {

    public DDBlockLoot(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
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

        var supplementariesLoot = withConditions(DefaultResourceConditions.allModsLoaded("supplementaries"));
        supplementariesHolders("candle_holder").values().forEach(it -> supplementariesLoot.add(it, createCandleHolderDrops(it)));
        supplementariesHolders("flag").values().forEach(it -> supplementariesLoot.add(it, createFlagDrops(it)));
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

    private DyedHolders<Block> supplementariesHolders(String name) {
        return ModCompat.supplementariesHolders(BuiltInRegistries.BLOCK, name);
    }

    private LootTable.Builder createTable(Block block, LootPoolEntryContainer.Builder<?> entry) {
        return LootTable.lootTable().withPool(
                applyExplosionDecay(block, LootPool.lootPool().add(entry))
        );
    }

    private LootTable.Builder createCandleHolderDrops(Block block) {
        var entry = LootItem.lootTableItem(block)
                .apply(CandleHolderBlock.CANDLES.getPossibleValues(), count ->
                        SetItemCountFunction.setCount(ConstantValue.exactly(count))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CandleHolderBlock.CANDLES, count))
                                )
                );

        return createTable(block, entry);
    }

    private LootTable.Builder createFlagDrops(Block block) {
        var entry = LootItem.lootTableItem(block)
                .apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY))
                .apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY)
                        .copy("Patterns", "BlockEntityTag.Patterns")
                );

        return createTable(block, entry);
    }

}
