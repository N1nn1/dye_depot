package com.ninni.dye_depot.data.client;

import static net.minecraft.client.data.models.BlockModelGenerators.*;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

import com.ninni.dye_depot.data.ModCompat;
import com.ninni.dye_depot.registry.DDBlocks;
import net.mehvahdjukaar.supplementaries.common.block.blocks.PresentBlock;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;

public class DDBlockModels {

    private final BlockModelGenerators generator;

    public DDBlockModels(BlockModelGenerators generator) {
        this.generator = generator;
    }

    protected void registerStatesAndModels(HolderLookup.Provider lookup) {
        var blockLookup = lookup.lookupOrThrow(Registries.BLOCK);

        DDBlocks.WOOL.values().forEach(this::simpleBlock);
        DDBlocks.CARPETS.forEach(this::carpet);
        DDBlocks.TERRACOTTA.values().forEach(this::simpleBlock);
        DDBlocks.CONCRETE.values().forEach(this::simpleBlock);
        DDBlocks.CONCRETE_POWDER.values().forEach(this::simpleBlock);
        DDBlocks.GLAZED_TERRACOTTA.holders().forEach(this::glazedTerracotta);
        DDBlocks.STAINED_GLASS_PANES.forEachWith(DDBlocks.STAINED_GLASS, this::stainedGlassPane);
        DDBlocks.SHULKER_BOXES.holders().forEach(this::shulkerBox);
        DDBlocks.CANDLES.forEachWith(DDBlocks.CANDLE_CAKES, this::candleAndCake);
        DDBlocks.BANNERS.forEachWith(DDBlocks.WALL_BANNERS, this::banners);
        DDBlocks.BEDS.forEachWith(DDBlocks.WOOL, this::bed);
        DDBlocks.DYE_BASKETS.holders().forEach(this::basket);

        ModCompat.supplementariesHolders(blockLookup, "flag").holders().forEach(this::flag);
        ModCompat.supplementariesHolders(blockLookup, "present").forEach(this::present);
        ModCompat.supplementariesHolders(blockLookup, "trapped_present").forEach(this::present);
        ModCompat.supplementariesHolders(blockLookup, "candle_holder").forEach(this::candleHolder);
        ModCompat.supplementariesSquaredHolders(blockLookup, "gold_candle_holder").forEach(this::candleHolder);
    }

    private void simpleBlock(Block block) {
        generator.createTrivialCube(block);
    }

    private void simpleBlock(Block block, Identifier model) {
        generator.blockStateOutput.accept(createSimpleBlock(block, plainVariant(model)));
    }

    private void carpet(DyeColor color, Holder<? extends Block> block) {
        var wool = DDBlocks.WOOL.holderOrThrow(color);
        var model = TexturedModel.CARPET.get(wool.value()).create(block.value(), generator.modelOutput);
        simpleBlock(block.value(), model);
    }

    private void glazedTerracotta(Holder<? extends Block> block) {
        var model = TexturedModel.GLAZED_TERRACOTTA.get(block.value()).create(block.value(), generator.modelOutput);
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block.value(), plainVariant(model)).with(ROTATION_HORIZONTAL_FACING_ALT));
    }

    private void stainedGlassPane(Holder<? extends StainedGlassPaneBlock> pane, Holder<? extends Block> fullBlock) {
        generator.createGlassBlocks(fullBlock.value(), pane.value());
    }

    private void shulkerBox(Holder<? extends ShulkerBoxBlock> block) {
        generator.createShulkerBox(block.value(), block.value().getColor());
    }

    private void candleAndCake(Holder<? extends Block> candle, Holder<? extends Block> candleCake) {
        generator.createCandleAndCandleCake(candle.value(), candleCake.value());
    }

    private void banners(Holder<? extends BannerBlock> block, Holder<? extends WallBannerBlock> wall) {
        generator.createBanner(block.value(), wall.value(), block.value().getColor());
    }

    private void bed(Holder<? extends BedBlock> block, Holder<? extends Block> wool) {
        generator.createBed(block.value(), wool.value(), block.value().getColor());
    }

    private void basket(Holder<? extends Block> block) {
        generator.createHorizontallyRotatedBlock(block.value(), TexturedModel.ORIENTABLE);
    }

    private void candleHolder(DyeColor color, Holder<? extends Block> block) {
        var variant = MultiVariantGenerator.dispatch(block.value())
            .with(SupplementariesTexturedModels.candleDispatch((count, lit) ->
                plainVariant(SupplementariesTexturedModels.candleHolderWall(count, lit).create(block.value(), generator.modelOutput))
            ))
            .with(ROTATION_HORIZONTAL_FACING);

        generator.blockStateOutput.accept(variant);
    }

    private void flag(Holder<? extends Block> block) {
        var model = plainVariant(Identifier.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, "block/flag"));
        generator.blockStateOutput.accept(createSimpleBlock(block.value(), model));
    }

    private void present(DyeColor color, Holder<? extends Block> block) {
        var open = plainVariant(SupplementariesTexturedModels.present(true).createWithSuffix(block.value(), "_closed", generator.modelOutput));
        var closed = plainVariant(SupplementariesTexturedModels.present(false).createWithSuffix(block.value(), "_opened", generator.modelOutput));

        var variant = MultiVariantGenerator.dispatch(block.value())
            .with(BlockModelGenerators.createBooleanModelDispatch(PresentBlock.PACKED, open, closed));

        generator.blockStateOutput.accept(variant);
    }

}
