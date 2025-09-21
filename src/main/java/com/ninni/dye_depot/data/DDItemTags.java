package com.ninni.dye_depot.data;

import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDItems;
import com.ninni.dye_depot.registry.DDTags;
import com.ninni.dye_depot.registry.DyedHolders;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class DDItemTags extends FabricTagProvider.ItemTagProvider {

    public DDItemTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, BlockTagProvider blockTags) {
        super(output, registriesFuture, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(DDItems.DYES, loaderTag("dyes"));

        tagDyed(DDBlocks.SHULKER_BOXES, loaderTag("skulker_boxes"));
        tagDyed(DDBlocks.BANNERS, ItemTags.BANNERS);
        tagDyed(DDBlocks.CARPETS, ItemTags.WOOL_CARPETS);
        tagDyed(DDBlocks.CANDLES, ItemTags.CANDLES);
        tagDyed(DDBlocks.BEDS, ItemTags.BEDS);
        tagDyed(DDBlocks.WOOL, ItemTags.WOOL);
        tagDyed(DDBlocks.TERRACOTTA, ItemTags.TERRACOTTA);
        tagDyed(DDBlocks.STAINED_GLASS, loaderTag("glass_blocks"));
        tagDyed(DDBlocks.STAINED_GLASS_PANES, loaderTag("glass_panes"));
        tagDyed(DDBlocks.DYE_BASKETS);

        copy(ModCompat.SUPPLEMENTARIES, "candle_holders");
        copy(ModCompat.SUPPLEMENTARIES, "flags");
        copy(ModCompat.SUPPLEMENTARIES, "presents");
        copy(ModCompat.SUPPLEMENTARIES, "trapped_presents");

        getOrCreateTagBuilder(DDTags.SMELTS_INTO_CORAL_DYE).add(
                Items.TUBE_CORAL,
                Items.BRAIN_CORAL,
                Items.BUBBLE_CORAL,
                Items.FIRE_CORAL,
                Items.HORN_CORAL,
                Items.TUBE_CORAL_FAN,
                Items.BRAIN_CORAL_FAN,
                Items.BUBBLE_CORAL_FAN,
                Items.FIRE_CORAL_FAN,
                Items.HORN_CORAL_FAN,
                Items.TUBE_CORAL_BLOCK,
                Items.BRAIN_CORAL_BLOCK,
                Items.BUBBLE_CORAL_BLOCK,
                Items.FIRE_CORAL_BLOCK,
                Items.HORN_CORAL_BLOCK
        );
    }

    private void tag(DyedHolders<? extends ItemLike> values, TagKey<Item> tag) {
        values.values()
                .map(ItemLike::asItem)
                .map(this::reverseLookup)
                .map(ResourceKey::location)
                .forEach(it -> tag(tag).addOptional(it));
    }

    @SafeVarargs
    private void tagDyed(DyedHolders<? extends ItemLike> values, TagKey<Item>... additionalTags) {
        values.forEach((dye, item) -> {
            var id = reverseLookup(item.asItem()).location();
            tag(loaderTag("dyed")).addOptional(id);
            tag(loaderTag("dyed/" + dye)).addOptional(id);
        });

        for (var tag : additionalTags) {
            tag(values, tag);
        }
    }

    private TagKey<Item> loaderTag(String path) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("c", path));
    }

    private void copy(String namespace, String path) {
        var key = new ResourceLocation(namespace, path);
        copy(TagKey.create(Registries.BLOCK, key), TagKey.create(Registries.ITEM, key));
    }

}
