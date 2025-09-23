package com.ninni.dye_depot.data.server;

import com.ninni.dye_depot.data.ModCompat;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DyedHolders;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class DDBlockTags extends FabricTagProvider.BlockTagProvider {

    private final CompletableFuture<HolderLookup.Provider> lookup;

    public DDBlockTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
        this.lookup = lookup;
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        var lookup = this.lookup.join();
        var blockLookup = lookup.lookupOrThrow(Registries.BLOCK);

        tagDyed(DDBlocks.SHULKER_BOXES, BlockTags.SHULKER_BOXES);
        tagDyed(DDBlocks.BANNERS, BlockTags.BANNERS);
        tagDyed(DDBlocks.WALL_BANNERS, BlockTags.BANNERS);
        tagDyed(DDBlocks.CARPETS, BlockTags.WOOL_CARPETS);
        tagDyed(DDBlocks.CANDLES, BlockTags.CANDLES);
        tagDyed(DDBlocks.CANDLE_CAKES, BlockTags.CANDLE_CAKES);
        tagDyed(DDBlocks.BEDS, BlockTags.BEDS);
        tagDyed(DDBlocks.WOOL, BlockTags.WOOL);
        tagDyed(DDBlocks.TERRACOTTA, BlockTags.TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE);
        tagDyed(DDBlocks.GLAZED_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE);
        tagDyed(DDBlocks.CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE);
        tagDyed(DDBlocks.CONCRETE_POWDER, BlockTags.MINEABLE_WITH_SHOVEL);
        tagDyed(DDBlocks.STAINED_GLASS, loaderTag("glass_blocks"), BlockTags.IMPERMEABLE);
        tagDyed(DDBlocks.STAINED_GLASS_PANES, loaderTag("glass_panes"), BlockTags.IMPERMEABLE);
        tagDyed(DDBlocks.DYE_BASKETS, BlockTags.MINEABLE_WITH_HOE);

        tagDyed(ModCompat.supplementariesHolders(blockLookup, "candle_holder"), supplementariesTag("candle_holders"));
        tagDyed(ModCompat.supplementariesSquaredHolders(blockLookup, "gold_candle_holder"), supplementariesTag("candle_holders"), BlockTags.GUARDED_BY_PIGLINS);
        tagDyed(ModCompat.supplementariesHolders(blockLookup, "flag"), supplementariesTag("flags"));
        tagDyed(ModCompat.supplementariesHolders(blockLookup, "present"), supplementariesTag("presents"));
        tagDyed(ModCompat.supplementariesHolders(blockLookup, "trapped_present"), supplementariesTag("trapped_presents"));
    }

    private void tag(DyedHolders<?, Block> values, TagKey<Block> tag) {
        values.holders()
                .map(it -> it.unwrapKey().orElseThrow().location())
                .forEach(it -> tag(tag).addOptional(it));
    }

    @SafeVarargs
    private void tagDyed(DyedHolders<?, Block> values, TagKey<Block>... additionalTags) {
        values.forEach((dye, block) -> {
            var key = block.unwrapKey().orElseThrow().location();
            tag(loaderTag("dyed")).addOptional(key);
            tag(loaderTag("dyed/" + dye)).addOptional(key);
        });

        for (var tag : additionalTags) {
            tag(values, tag);
        }
    }

    private TagKey<Block> loaderTag(String path) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", path));
    }

    private TagKey<Block> supplementariesTag(String path) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, path));
    }

}
