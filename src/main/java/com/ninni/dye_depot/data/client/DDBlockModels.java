package com.ninni.dye_depot.data.client;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDBlocks;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import io.github.fabricators_of_create.porting_lib.models.generators.ConfiguredModel;
import io.github.fabricators_of_create.porting_lib.models.generators.block.BlockStateProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.List;

public class DDBlockModels extends BlockStateProvider {

    public DDBlockModels(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, DyeDepot.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        DDBlocks.WOOL.values().forEach(this::simpleBlock);
        DDBlocks.CARPETS.forEach(this::carpet);
        DDBlocks.TERRACOTTA.values().forEach(this::simpleBlock);
        DDBlocks.CONCRETE.values().forEach(this::simpleBlock);
        DDBlocks.CONCRETE_POWDER.values().forEach(this::simpleBlock);
        DDBlocks.GLAZED_TERRACOTTA.values().forEach(this::glazedTerracotta);
        DDBlocks.STAINED_GLASS.values().forEach(this::simpleBlock);
        DDBlocks.STAINED_GLASS_PANES.forEach(this::stainedGlassPane);
        DDBlocks.SHULKER_BOXES.values().forEach(this::particleOnly);
        DDBlocks.CANDLES.values().forEach(this::candle);
        DDBlocks.CANDLE_CAKES.forEach(this::candleCake);
        DDBlocks.BANNERS.values().forEach(this::banner);
        DDBlocks.WALL_BANNERS.values().forEach(this::banner);
        DDBlocks.BEDS.values().forEach(this::bed);
        DDBlocks.DYE_BASKETS.values().forEach(this::basket);
    }

    private void carpet(DyeColor color, Block block) {
        var wool = DDBlocks.WOOL.getOrThrow(color);
        simpleBlock(block, models().carpet(name(block), blockTexture(wool)));
    }

    private void glazedTerracotta(Block block) {
        var model = models().withExistingParent(name(block), vanillaResource("template_glazed_terracotta"))
                .texture("pattern", blockTexture(block));
        horizontalBlock(block, model);
    }

    private void stainedGlassPane(DyeColor color, StainedGlassPaneBlock block) {
        paneBlock(block, blockTexture(DDBlocks.STAINED_GLASS.getOrNull(color)), blockTexture(block).withSuffix("_top"));
    }

    private void particleOnly(Block block) {
        var texture = blockTexture(block);
        simpleBlock(block, models().getBuilder(name(block)).texture("particle", texture));
    }

    private void candle(Block block) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
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

    private void candleCake(DyeColor color, Block block) {
        getVariantBuilder(block).forAllStates(state -> {
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

    private void banner(Block block) {
        simpleBlock(block, models().getExistingFile(vanillaResource("banner")));
    }

    private void bed(Block block) {
        simpleBlock(block, models().getExistingFile(vanillaResource("bed")));
    }

    private void basket(Block block) {
        var texture = blockTexture(block);
        var model = models().orientableWithBottom(
                name(block),
                texture.withSuffix("_side"),
                texture.withSuffix("_front"),
                texture.withSuffix("_bottom"),
                texture.withSuffix("_top")
        );
        horizontalBlock(block, model);
    }

    private ResourceLocation vanillaResource(String name) {
        return new ResourceLocation("block/" + name);
    }

    private String name(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

}
