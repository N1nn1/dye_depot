package com.ninni.dye_depot.data.client;

import com.ninni.dye_depot.data.ModCompat;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDItems;
import com.ninni.dye_depot.registry.DyedHolders;
import java.util.function.Function;
import java.util.stream.Stream;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public abstract class DDLangProvider extends FabricLanguageProvider {

    protected DDLangProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public final void generateTranslations(TranslationBuilder builder) {
        colors("general").forEach(color -> {
            builder.add("color.minecraft." + color, translate(color));
            builder.add("item.minecraft.firework_star." + color, translate(color));
            builder.add("item.minecraft.shield." + color, translate(color) + " Shield");
        });

        dyedBannerPattern(builder, "base", color -> "Fully " + color + " Field");
        dyedBannerPattern(builder, "border", color -> color + " Bordure");
        dyedBannerPattern(builder, "bricks", color -> color + " Field Masoned");
        dyedBannerPattern(builder, "circle", color -> color + " Roundel");
        dyedBannerPattern(builder, "creeper", color -> color + " Creeper Charge");
        dyedBannerPattern(builder, "cross", color -> color + " Saltire");
        dyedBannerPattern(builder, "curly_border", color -> color + " Bordure Indented");
        dyedBannerPattern(builder, "diagonal_left", color -> color + " Per Bend Sinister");
        dyedBannerPattern(builder, "diagonal_right", color -> color + " Per Bend");
        dyedBannerPattern(builder, "diagonal_up_left", color -> color + " Per Bend Inverted");
        dyedBannerPattern(builder, "diagonal_up_right", color -> color + " Per Bend Sinister Inverted");
        dyedBannerPattern(builder, "flower", color -> color + " Flower Charge");
        dyedBannerPattern(builder, "globe", color -> color + " Globe");
        dyedBannerPattern(builder, "gradient_up", color -> color + " Base Gradient");
        dyedBannerPattern(builder, "gradient", color -> color + " Gradient");
        dyedBannerPattern(builder, "half_horizontal_bottom", color -> color + " Per Fess Inverted");
        dyedBannerPattern(builder, "half_horizontal", color -> color + " Per Fess");
        dyedBannerPattern(builder, "half_vertical_right", color -> color + " Per Pale Inverted");
        dyedBannerPattern(builder, "half_vertical", color -> color + " Per Pale");
        dyedBannerPattern(builder, "mojang", color -> color + " Thing");
        dyedBannerPattern(builder, "piglin", color -> color + " Snout");
        dyedBannerPattern(builder, "rhombus", color -> color + " Lozenge");
        dyedBannerPattern(builder, "skull", color -> color + " Skull Charge");
        dyedBannerPattern(builder, "small_stripes", color -> color + " Paly");
        dyedBannerPattern(builder, "square_bottom_left", color -> color + " Base Dexter Canton");
        dyedBannerPattern(builder, "square_bottom_right", color -> color + " Base Sinister Canton");
        dyedBannerPattern(builder, "square_top_left", color -> color + " Chief Dexter Canton");
        dyedBannerPattern(builder, "square_top_right", color -> color + " Chief Sinister Canton");
        dyedBannerPattern(builder, "straight_cross", color -> color + " Cross");
        dyedBannerPattern(builder, "stripe_bottom", color -> color + " Base");
        dyedBannerPattern(builder, "stripe_center", color -> color + " Pale");
        dyedBannerPattern(builder, "stripe_downleft", color -> color + " Bend Sinister");
        dyedBannerPattern(builder, "stripe_downright", color -> color + " Bend");
        dyedBannerPattern(builder, "stripe_left", color -> color + " Pale Dexter");
        dyedBannerPattern(builder, "stripe_middle", color -> color + " Fess");
        dyedBannerPattern(builder, "stripe_right", color -> color + " Pale Sinister");
        dyedBannerPattern(builder, "stripe_top", color -> color + " Chief");
        dyedBannerPattern(builder, "triangle_bottom", color -> color + " Chevron");
        dyedBannerPattern(builder, "triangle_top", color -> color + " Inverted Chevron");
        dyedBannerPattern(builder, "triangles_bottom", color -> color + " Base Indented");
        dyedBannerPattern(builder, "triangles_top", color -> color + " Chief Indented");

        dyed(builder, filterAndMerge(DDItems.DYES, BuiltInRegistries.ITEM), "Dye");
        dyed(builder, filterAndMerge(DDBlocks.BANNERS, BuiltInRegistries.BLOCK), "Banner");
        dyed(builder, filterAndMerge(DDBlocks.BEDS, BuiltInRegistries.BLOCK), "Bed");
        dyed(builder, filterAndMerge(DDBlocks.CANDLES, BuiltInRegistries.BLOCK), "Candle");
        dyed(builder, filterAndMerge(DDBlocks.CANDLE_CAKES, BuiltInRegistries.BLOCK), it -> "Cake with " + it + " Candle");
        dyed(builder, filterAndMerge(DDBlocks.CARPETS, BuiltInRegistries.BLOCK), "Carpet");
        dyed(builder, filterAndMerge(DDBlocks.CONCRETE, BuiltInRegistries.BLOCK), "Concrete");
        dyed(builder, filterAndMerge(DDBlocks.CONCRETE_POWDER, BuiltInRegistries.BLOCK), "Concrete Powder");
        dyed(builder, filterAndMerge(DDBlocks.GLAZED_TERRACOTTA, BuiltInRegistries.BLOCK), "Glazed Terracotta");
        dyed(builder, filterAndMerge(DDBlocks.SHULKER_BOXES, BuiltInRegistries.BLOCK), "Shulker Box");
        dyed(builder, filterAndMerge(DDBlocks.STAINED_GLASS, BuiltInRegistries.BLOCK), "Stained Glass");
        dyed(builder, filterAndMerge(DDBlocks.STAINED_GLASS_PANES, BuiltInRegistries.BLOCK), "Stained Glass Pane");
        dyed(builder, filterAndMerge(DDBlocks.TERRACOTTA, BuiltInRegistries.BLOCK), "Terracotta");
        dyed(builder, filterAndMerge(DDBlocks.WOOL, BuiltInRegistries.BLOCK), "Wool");
        dyed(builder, filter(DDBlocks.DYE_BASKETS, BuiltInRegistries.BLOCK), "Dye Basket");

        dyed(builder, supplementariesHolders(BuiltInRegistries.BLOCK.asLookup(), "present"), "Present");
        dyed(builder, supplementariesHolders(BuiltInRegistries.BLOCK.asLookup(), "trapped_present"), "Trapped Present");
        dyed(builder, supplementariesHolders(BuiltInRegistries.BLOCK.asLookup(), "flag"), "Flag");
        dyed(builder, supplementariesHolders(BuiltInRegistries.BLOCK.asLookup(), "candle_holder"), "Candle Holder");
        dyed(builder, supplementariesSquaredHolders(BuiltInRegistries.BLOCK.asLookup(), "gold_candle_holder"), it -> "Gold " + it + " Candle Holder");

        translateAdditional(builder);
    }

    protected void translateAdditional(TranslationBuilder builder) {
    }

    protected abstract Stream<DyeColor> colors(String group);

    protected abstract String translate(DyeColor dye);

    private <R> DyedHolders<R, R> supplementariesHolders(HolderLookup.RegistryLookup<R> registry, String name) {
        return ModCompat.supplementariesHolders(registry, name, colors(name));
    }

    private <R> DyedHolders<R, R> supplementariesSquaredHolders(HolderLookup.RegistryLookup<R> registry, String name) {
        return ModCompat.supplementariesSquaredHolders(registry, name, colors(name));
    }

    private <T extends R, R> DyedHolders<T, R> filterAndMerge(DyedHolders<T, R> dyed, Registry<R> registry) {
        return filter(dyed.mergeVanilla(registry), registry);
    }

    private <T extends R, R> DyedHolders<T, R> filter(DyedHolders<T, R> dyed, Registry<R> registry) {
        var baseName = dyed.detectBaseName(registry);
        return dyed.filter(() -> colors(baseName));
    }

    private void dyed(TranslationBuilder builder, DyedHolders<?, ? extends ItemLike> dyed, String suffix) {
        dyed(builder, dyed, it -> it + " " + suffix);
    }

    private void dyed(TranslationBuilder builder, DyedHolders<?, ? extends ItemLike> dyed, Function<String, String> translation) {
        dyed.forEach((color, item) ->
                add(builder, item, translation.apply(translate(color)))
        );
    }

    private void add(TranslationBuilder builder, ItemLike item, String translation) {
        if (item instanceof Block block) builder.add(block, translation);
        else builder.add(item.asItem(), translation);
    }

    private void dyedBannerPattern(TranslationBuilder builder, String id, Function<String, String> translation) {
        colors("banner_patterns").forEach(color ->
                builder.add("block.minecraft.banner." + id + "." + color, translation.apply(translate(color)))
        );
    }

}
