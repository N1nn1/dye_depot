package com.ninni.dye_depot.data.server;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.data.ModCompat;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DyedHolders;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import net.mehvahdjukaar.supplementaries.reg.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DDBlockTags extends BlockTagsProvider {

    private final CompletableFuture<HolderLookup.Provider> lookup;

    public DDBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, ExistingFileHelper fileHelper) {
        super(output, lookup, DyeDepot.MOD_ID, fileHelper);
        this.lookup = lookup;
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        var lookup = this.lookup.join();
        var blockLookup = lookup.lookupOrThrow(Registries.BLOCK);

        groupDyedTag("dyed");

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
        tagDyed(DDBlocks.CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, loaderTag("concrete"));
        tagDyed(DDBlocks.CONCRETE_POWDER, BlockTags.MINEABLE_WITH_SHOVEL);
        tagDyed(DDBlocks.STAINED_GLASS, loaderTag("glass_blocks"), BlockTags.IMPERMEABLE);
        tagDyed(DDBlocks.STAINED_GLASS_PANES, loaderTag("glass_panes"), BlockTags.IMPERMEABLE);
        tagDyed(DDBlocks.DYE_BASKETS, BlockTags.MINEABLE_WITH_HOE, ModTags.SOAP_BLACKLIST_BLOCK);

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

    private void groupDyedTag(String base) {
        Stream.concat(DyedHolders.vanillaColors(), DyedHolders.modColors()).forEach(color ->
                tag(loaderTag(base)).addOptionalTag(loaderTag(base + "/" + color))
        );
    }

    @SafeVarargs
    private void tagDyed(DyedHolders<?, Block> values, TagKey<Block>... additionalTags) {
        values.forEach((dye, block) -> {
            var id = block.unwrapKey().orElseThrow().location();
            var tag = loaderTag("dyed/" + dye);
            tag(tag).addOptional(id);
        });

        for (var tag : additionalTags) {
            tag(values, tag);
        }
    }

    private TagKey<Block> loaderTag(String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation("forge", path));
    }

    private TagKey<Block> supplementariesTag(String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(ModCompat.SUPPLEMENTARIES, path));
    }

}
