package com.ninni.dye_depot.data.client;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.data.ModCompat;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDItems;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import io.github.fabricators_of_create.porting_lib.models.generators.ItemModelProvider;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class DDItemModels extends ItemModelProvider {

    private final CompletableFuture<HolderLookup.Provider> lookup;

    public DDItemModels(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, ExistingFileHelper fileHelper) {
        super(output, DyeDepot.MOD_ID, fileHelper);
        this.lookup = lookup;
    }

    @Override
    protected void registerModels() {
        var lookup = this.lookup.join();
        var itemLookup = lookup.lookupOrThrow(Registries.ITEM);

        DDItems.DYES.holders().forEach(this::basicItem);
        DDBlocks.WOOL.holders().forEach(this::blockReference);
        DDBlocks.CARPETS.holders().forEach(this::blockReference);
        DDBlocks.TERRACOTTA.holders().forEach(this::blockReference);
        DDBlocks.CONCRETE.holders().forEach(this::blockReference);
        DDBlocks.CONCRETE_POWDER.holders().forEach(this::blockReference);
        DDBlocks.GLAZED_TERRACOTTA.holders().forEach(this::blockReference);
        DDBlocks.STAINED_GLASS.holders().forEach(this::blockReference);
        DDBlocks.STAINED_GLASS_PANES.forEach(this::glassPane);
        DDBlocks.SHULKER_BOXES.holders().forEach(this::shulkerBox);
        DDBlocks.CANDLES.holders().forEach(this::basicItem);
        DDBlocks.BANNERS.holders().forEach(this::banner);
        DDBlocks.BEDS.forEach(this::bed);
        DDBlocks.DYE_BASKETS.holders().forEach(this::blockReference);

        ModCompat.supplementariesHolders(itemLookup, "flag").holders().forEach(this::flag);
        ModCompat.supplementariesHolders(itemLookup, "present").forEach(this::present);
        ModCompat.supplementariesHolders(itemLookup, "trapped_present").forEach(this::present);
        ModCompat.supplementariesHolders(itemLookup, "candle_holder").forEach(this::candleHolder);
        ModCompat.supplementariesSquaredHolders(itemLookup, "gold_candle_holder").forEach(this::candleHolder);
    }

    private void basicItem(Holder<? extends ItemLike> item) {
        basicItem(item.value().asItem());
    }

    private void basicItem(Holder<? extends ItemLike> item, ResourceLocation texture) {
        withExistingParent(key(item).toString(), vanillaResource("generated"))
                .texture("layer0", texture);
    }

    private void glassPane(DyeColor color, Holder<? extends ItemLike> item) {
        basicItem(item, blockTexture(DDBlocks.STAINED_GLASS.holderOrThrow(color)));
    }

    private ResourceLocation blockTexture(Holder<? extends Block> block) {
        return block.unwrapKey().orElseThrow().location().withPrefix("block/");
    }

    private void blockReference(Holder<? extends Block> block) {
        withExistingParent(name(block), blockTexture(block));
    }

    private void shulkerBox(Holder<? extends Block> block) {
        withExistingParent(name(block), vanillaResource("template_shulker_box"))
                .texture("particle", blockTexture(block));
    }

    private void banner(Holder<? extends ItemLike> item) {
        withExistingParent(name(item), vanillaResource("template_banner"));
    }

    private void bed(DyeColor color, Holder<? extends ItemLike> item) {
        withExistingParent(name(item), vanillaResource("template_bed"))
                .texture("particle", blockTexture(DDBlocks.WOOL.holderOrThrow(color)));
    }

    private void candleHolder(DyeColor color, Holder<? extends ItemLike> item) {
        var namespace = key(item).getNamespace();
        basicItem(item, ResourceLocation.fromNamespaceAndPath(namespace, "item/candle_holders/" + color));
    }

    private void flag(Holder<? extends ItemLike> item) {
        withExistingParent(key(item).toString(), ResourceLocation.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, "item/flag_black"));
    }

    private void present(DyeColor color, Holder<? extends ItemLike> item) {
        var type = name(item).replace("_" + color, "");
        withExistingParent(key(item).toString(), ResourceLocation.fromNamespaceAndPath(ModCompat.SUPPLEMENTARIES, "block/" + type + "s/" + color + "_closed"));
    }

    private ResourceLocation vanillaResource(String name) {
        return ResourceLocation.withDefaultNamespace("item/" + name);
    }

    private String name(Holder<? extends ItemLike> item) {
        return key(item).getPath();
    }

    private ResourceLocation key(Holder<? extends ItemLike> item) {
        return item.unwrapKey().orElseThrow().location();
    }

}
