package com.ninni.dye_depot.data.client;

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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
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
        DDBlocks.STAINED_GLASS.values().forEach(this::simpleBlock);
        DDBlocks.STAINED_GLASS_PANES.forEach(this::stainedGlassPane);
        DDBlocks.SHULKER_BOXES.holders().forEach(this::particleOnly);
        DDBlocks.CANDLES.holders().forEach(this::candle);
        DDBlocks.CANDLE_CAKES.forEach(this::candleCake);
        DDBlocks.BANNERS.holders().forEach(this::banner);
        DDBlocks.WALL_BANNERS.holders().forEach(this::banner);
        DDBlocks.BEDS.holders().forEach(this::bed);
        DDBlocks.DYE_BASKETS.holders().forEach(this::basket);

        ModCompat.supplementariesHolders(blockLookup, "flag").holders().forEach(this::flag);
        ModCompat.supplementariesHolders(blockLookup, "present").forEach(this::present);
        ModCompat.supplementariesHolders(blockLookup, "trapped_present").forEach(this::present);
        ModCompat.supplementariesHolders(blockLookup, "candle_holder").forEach(this::candleHolder);
        ModCompat.supplementariesSquaredHolders(blockLookup, "gold_candle_holder").forEach(this::candleHolder);
    }

    private void carpet(DyeColor color, Holder<? extends Block> block) {
        var wool = DDBlocks.WOOL.holderOrThrow(color);
        simpleBlock(block.value(), models().carpet(name(block), blockTexture(wool)));
    }

    private void glazedTerracotta(Holder<? extends Block> block) {
        var model = models().withExistingParent(name(block), vanillaResource("template_glazed_terracotta"))
                .texture("pattern", blockTexture(block));
        horizontalBlock(block.value(), model);
    }

    private void stainedGlassPane(DyeColor color, Holder<? extends StainedGlassPaneBlock> block) {
        paneBlock(block.value(), blockTexture(DDBlocks.STAINED_GLASS.getOrNull(color)), blockTexture(block).withSuffix("_top"));
    }

    private void particleOnly(Holder<? extends Block> block) {
        var texture = blockTexture(block);
        simpleBlock(block.value(), models().getBuilder(name(block)).texture("particle", texture));
    }

    private void candle(Holder<? extends Block> block) {
        getVariantBuilder(block.value()).forAllStatesExcept(state -> {
            var lit = state.getValue(CandleBlock.LIT);
            var count = state.getValue(CandleBlock.CANDLES);
            var litSuffix = lit ? "_lit" : "";
            var countSuffix = List.of("_candle", "_two_candles", "_three_candles", "_four_candles").get(count - 1);

            var model = models().withExistingParent(name(block) + "_" + count + litSuffix, vanillaResource("template" + countSuffix))
                    .texture("all", blockTexture(block) + litSuffix)
                    .texture("particle", blockTexture(block) + litSuffix);

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .build();
        }, BlockStateProperties.WATERLOGGED);
    }

    private void candleCake(DyeColor color, Holder<? extends Block> block) {
        getVariantBuilder(block.value()).forAllStates(state -> {
            var lit = state.getValue(CandleCakeBlock.LIT);
            var suffix = lit ? "_lit" : "";
            var model = models().withExistingParent(name(block) + suffix, vanillaResource("template_cake_with_candle"))
                    .texture("candle", blockTexture(DDBlocks.CANDLES.getOrThrow(color)).withSuffix(suffix))
                    .texture("bottom", vanillaResource("cake_bottom"))
                    .texture("top", vanillaResource("cake_top"))
                    .texture("side", vanillaResource("cake_side"))
                    .texture("particle", vanillaResource("cake_side"));
            return ConfiguredModel.builder()
                    .modelFile(model)
                    .build();
        });
    }

    private void banner(Holder<? extends Block> block) {
        simpleBlock(block.value(), models().getExistingFile(vanillaResource("banner")));
    }

    private void bed(Holder<? extends Block> block) {
        simpleBlock(block.value(), models().getExistingFile(vanillaResource("bed")));
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
    }

    private void flag(Holder<? extends Block> block) {
        simpleBlock(block.value(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, "block/flag")));
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
    }

    private ResourceLocation vanillaResource(String name) {
        return ResourceLocation.withDefaultNamespace("block/" + name);
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

}
