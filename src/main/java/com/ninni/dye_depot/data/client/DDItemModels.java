package com.ninni.dye_depot.data.client;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.data.ModCompat;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDItems;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import io.github.fabricators_of_create.porting_lib.models.generators.item.ItemModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class DDItemModels extends ItemModelProvider {

    public DDItemModels(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, DyeDepot.MOD_ID, fileHelper);
    }

    @Override
    protected void registerModels() {
        DDItems.DYES.values().forEach(this::basicItem);
        DDBlocks.WOOL.values().forEach(this::blockReference);
        DDBlocks.CARPETS.values().forEach(this::blockReference);
        DDBlocks.TERRACOTTA.values().forEach(this::blockReference);
        DDBlocks.CONCRETE.values().forEach(this::blockReference);
        DDBlocks.CONCRETE_POWDER.values().forEach(this::blockReference);
        DDBlocks.GLAZED_TERRACOTTA.values().forEach(this::blockReference);
        DDBlocks.STAINED_GLASS.values().forEach(this::blockReference);
        DDBlocks.STAINED_GLASS_PANES.forEach(this::glassPane);
        DDBlocks.SHULKER_BOXES.values().forEach(this::shulkerBox);
        DDBlocks.CANDLES.values().forEach(this::basicItem);
        DDBlocks.BANNERS.values().forEach(this::banner);
        DDBlocks.WALL_BANNERS.values().forEach(this::banner);
        DDBlocks.BEDS.forEach(this::bed);
        DDBlocks.DYE_BASKETS.values().forEach(this::blockReference);

        ModCompat.supplementariesHolders(BuiltInRegistries.ITEM, "flag").values().forEach(this::flag);
        ModCompat.supplementariesHolders(BuiltInRegistries.ITEM, "present").forEach(this::present);
        ModCompat.supplementariesHolders(BuiltInRegistries.ITEM, "trapped_present").forEach(this::present);
        ModCompat.supplementariesHolders(BuiltInRegistries.ITEM, "candle_holder").forEach(this::candleHolder);
        ModCompat.supplementariesSquaredHolders(BuiltInRegistries.ITEM, "gold_candle_holder").forEach(this::candleHolder);
    }

    private void basicItem(ItemLike item) {
        basicItem(item.asItem());
    }

    private void basicItem(ItemLike item, ResourceLocation texture) {
        withExistingParent(key(item).toString(), vanillaResource("generated"))
                .texture("layer0", texture);
    }

    private void glassPane(DyeColor color, ItemLike item) {
        basicItem(item, blockTexture(DDBlocks.STAINED_GLASS.getOrNull(color)));
    }

    private ResourceLocation blockTexture(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/");
    }

    private void blockReference(Block block) {
        withExistingParent(name(block), blockTexture(block));
    }

    private void shulkerBox(Block block) {
        withExistingParent(name(block), vanillaResource("template_shulker_box"))
                .texture("particle", blockTexture(block));
    }

    private void banner(ItemLike item) {
        withExistingParent(name(item), vanillaResource("template_banner"));
    }

    private void bed(DyeColor color, ItemLike item) {
        withExistingParent(name(item), vanillaResource("template_bed"))
                .texture("particle", blockTexture(DDBlocks.WOOL.getOrThrow(color)));
    }

    private void candleHolder(DyeColor color, ItemLike item) {
        var namespace = key(item).getNamespace();
        basicItem(item, new ResourceLocation(namespace, "item/candle_holders/" + color));
    }

    private void flag(ItemLike item) {
        withExistingParent(key(item).toString(), new ResourceLocation(ModCompat.SUPPLEMENTARIES, "item/flag_black"));
    }

    private void present(DyeColor color, ItemLike item) {
        var type = name(item).replace("_" + color, "");
        withExistingParent(key(item).toString(), new ResourceLocation(ModCompat.SUPPLEMENTARIES, "block/" + type + "s/" + color + "_closed"));
    }

    private ResourceLocation vanillaResource(String name) {
        return new ResourceLocation("item/" + name);
    }

    private String name(ItemLike item) {
        return key(item).getPath();
    }

    private ResourceLocation key(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem());
    }

}
