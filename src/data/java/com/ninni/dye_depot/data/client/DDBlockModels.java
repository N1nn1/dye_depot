package com.ninni.dye_depot.data.client;

import static net.minecraft.resources.ResourceLocation.withDefaultNamespace;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.data.ModCompat;
import com.ninni.dye_depot.registry.DDBlocks;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.mehvahdjukaar.supplementaries.common.block.blocks.PresentBlock;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DDBlockModels extends BlockStateProvider {

    private final CompletableFuture<HolderLookup.Provider> lookup;

    public DDBlockModels(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, ExistingFileHelper fileHelper) {
        super(output, DyeDepot.MOD_ID, fileHelper);
        this.lookup = lookup;
    }

    @Override
    protected void registerStatesAndModels() {
        var lookup = this.lookup.join();
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

    @Override
    public void simpleBlock(Block block, ModelFile model) {
        super.simpleBlock(block, model);
        super.simpleBlockItem(block, model);
    }

    private void carpet(DyeColor color, Holder<? extends Block> block) {
        var wool = DDBlocks.WOOL.holderOrThrow(color);
        simpleBlock(block.value(), models().carpet(name(block), blockTexture(wool)));
    }

    private void glazedTerracotta(Holder<? extends Block> block) {
        var model = models().withExistingParent(name(block), withDefaultNamespace("template_glazed_terracotta"))
            .texture("pattern", blockTexture(block));
        horizontalBlock(block.value(), model, 0);
        simpleBlockItem(block.value(), model);
    }

    private void stainedGlassPane(Holder<? extends StainedGlassPaneBlock> pane, Holder<? extends Block> full) {
        simpleBlock(full.value());
        paneBlock(pane.value(), blockTexture(full.value()), blockTexture(pane).withSuffix("_top"));
        basicItem(pane, blockTexture(full));
    }

    private void shulkerBox(Holder<? extends ShulkerBoxBlock> block) {
        var texture = blockTexture(block);
        simpleBlock(block.value(), models().getBuilder(name(block)).texture("particle", texture));
        itemModels()
            .withExistingParent(name(block), withDefaultNamespace("template_shulker_box"))
            .texture("particle", blockTexture(block));
    }

    private void candleAndCake(Holder<CandleBlock> candle, Holder<CandleCakeBlock> cake) {
        candle(candle);
        candleCake(cake, candle);
    }

    private void candle(Holder<? extends Block> block) {
        getVariantBuilder(block.value()).forAllStatesExcept(state -> {
            var lit = state.getValue(CandleBlock.LIT);
            var count = state.getValue(CandleBlock.CANDLES);
            var litSuffix = lit ? "_lit" : "";
            var countSuffix = List.of("_candle", "_two_candles", "_three_candles", "_four_candles").get(count - 1);

            var model = models().withExistingParent(name(block) + "_" + count + litSuffix, withDefaultNamespace("template" + countSuffix))
                .texture("all", blockTexture(block) + litSuffix)
                .texture("particle", blockTexture(block) + litSuffix);

            return ConfiguredModel.builder()
                .modelFile(model)
                .build();
        }, BlockStateProperties.WATERLOGGED);

        itemModels().basicItem(block.value().asItem());
    }

    private void candleCake(Holder<? extends Block> block, Holder<? extends Block> candle) {
        getVariantBuilder(block.value()).forAllStates(state -> {
            var lit = state.getValue(CandleCakeBlock.LIT);
            var suffix = lit ? "_lit" : "";
            var model = models().withExistingParent(name(block) + suffix, withDefaultNamespace("template_cake_with_candle"))
                .texture("candle", blockTexture(candle.value()).withSuffix(suffix))
                .texture("bottom", withDefaultNamespace("block/cake_bottom"))
                .texture("top", withDefaultNamespace("block/cake_top"))
                .texture("side", withDefaultNamespace("block/cake_side"))
                .texture("particle", withDefaultNamespace("block/cake_side"));
            return ConfiguredModel.builder()
                .modelFile(model)
                .build();
        });
    }

    private void banners(Holder<BannerBlock> standing, Holder<WallBannerBlock> wall) {
        banner(standing);
        banner(wall);
        itemModels().withExistingParent(name(standing), withDefaultNamespace("template_banner"));
    }

    private void banner(Holder<? extends Block> block) {
        simpleBlock(block.value(), models().getExistingFile(withDefaultNamespace("banner")));
    }

    private void bed(Holder<? extends Block> block, Holder<? extends Block> wool) {
        simpleBlock(block.value(), models().getExistingFile(withDefaultNamespace("bed")));
        itemModels()
            .withExistingParent(name(block), withDefaultNamespace("template_bed"))
            .texture("particle", blockTexture(wool));
    }

    private void basket(Holder<? extends Block> block) {
        var texture = blockTexture(block);
        var model = models().orientableWithBottom(
            name(block),
            texture.withSuffix("_side"),
            texture.withSuffix("_front"),
            texture.withSuffix("_bottom"),
            texture.withSuffix("_top")
        );
        horizontalBlock(block.value(), model);
        simpleBlockItem(block.value(), model);
    }

    private void candleHolder(DyeColor color, Holder<? extends Block> block) {
        getVariantBuilder(block.value()).forAllStatesExcept(state -> {
            var lit = state.getValue(BlockStateProperties.LIT);
            var candles = state.getValue(BlockStateProperties.CANDLES);
            var facing = state.getValue(HorizontalDirectionalBlock.FACING);
            var face = state.getValue(BlockStateProperties.ATTACH_FACE);

            var suffix = face.getSerializedName() + "_" + candles;
            var litSuffix = lit ? "_lit" : "";
            var namespace = key(block).getNamespace();
            var parent = ResourceLocation.fromNamespaceAndPath(namespace, "block/candle_holders/" + suffix);
            var model = models()
                .withExistingParent(namespace + ":block/candle_holders/" + color + "_" + suffix + litSuffix, parent)
                .texture("all", blockTexture(DDBlocks.CANDLES.getOrNull(color)) + litSuffix);

            return ConfiguredModel.builder()
                .modelFile(model)
                .rotationY((int) facing.toYRot() + 180)
                .build();
        }, BlockStateProperties.WATERLOGGED);

        basicItem(block, key(block).withPath("item/candle_holders/" + color));
    }

    private void flag(Holder<? extends Block> block) {
        simpleBlock(block.value(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, "block/flag")));
        itemModels()
            .withExistingParent(key(block).toString(), ResourceLocation.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, "item/flag_black"));
    }

    private void present(DyeColor color, Holder<? extends Block> block) {
        var type = name(block).replace("_" + color, "");

        getVariantBuilder(block.value()).forAllStatesExcept(state -> {
            var packed = state.getValue(PresentBlock.PACKED);

            var suffix = packed ? "_closed" : "_opened";

            var parent = ResourceLocation.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, "block/present" + suffix + "_template");
            var sideTexture = ResourceLocation.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, "block/" + type + "s/side_" + color);
            var model = models().withExistingParent(ModCompat.SUPPLEMENTARIES + ":block/" + type + "s/" + color + suffix, parent)
                .texture("bottom", ResourceLocation.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, "block/presents/bottom_" + color))
                .texture("top", ResourceLocation.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, "block/presents/top_" + color))
                .texture("side", sideTexture)
                .texture("particle", sideTexture);

            return ConfiguredModel.builder()
                .modelFile(model)
                .build();
        }, BlockStateProperties.WATERLOGGED);


        itemModels()
            .withExistingParent(key(block).toString(), ResourceLocation.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, "block/" + type + "s/" + color + "_closed"));
    }

    private ResourceLocation key(Holder<? extends Block> block) {
        return block.unwrapKey().orElseThrow().location();
    }

    private String name(Holder<? extends Block> block) {
        return key(block).getPath();
    }

    private ResourceLocation blockTexture(Holder<? extends Block> block) {
        return block.unwrapKey().orElseThrow().location().withPrefix("block/");
    }

    private void basicItem(Holder<? extends Block> block, ResourceLocation texture) {
        itemModels().withExistingParent(key(block).toString(), withDefaultNamespace("generated"))
            .texture("layer0", texture);
    }

}
