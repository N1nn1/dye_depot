package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.dispenser.ShulkerBoxDispenseBehavior;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings("unused")
public class DDBlocks {
    public static final Block MAROON_WOOL = wool(DDDyes.MAROON);
    public static final Block ROSE_WOOL = wool(DDDyes.ROSE);
    public static final Block CORAL_WOOL = wool(DDDyes.CORAL);
    public static final Block INDIGO_WOOL = wool(DDDyes.INDIGO);
    public static final Block NAVY_WOOL = wool(DDDyes.NAVY);
    public static final Block SLATE_WOOL = wool(DDDyes.SLATE);
    public static final Block OLIVE_WOOL = wool(DDDyes.OLIVE);
    public static final Block AMBER_WOOL = wool(DDDyes.AMBER);
    public static final Block BEIGE_WOOL = wool(DDDyes.BEIGE);
    public static final Block TEAL_WOOL = wool(DDDyes.TEAL);
    public static final Block MINT_WOOL = wool(DDDyes.MINT);
    public static final Block AQUA_WOOL = wool(DDDyes.AQUA);
    public static final Block VERDANT_WOOL = wool(DDDyes.VERDANT);
    public static final Block FOREST_WOOL = wool(DDDyes.FOREST);
    public static final Block GINGER_WOOL = wool(DDDyes.GINGER);
    public static final Block TAN_WOOL = wool(DDDyes.TAN);

    public static final Block MAROON_CARPET = carpet(DDDyes.MAROON);
    public static final Block ROSE_CARPET = carpet(DDDyes.ROSE);
    public static final Block CORAL_CARPET = carpet(DDDyes.CORAL);
    public static final Block INDIGO_CARPET = carpet(DDDyes.INDIGO);
    public static final Block NAVY_CARPET = carpet(DDDyes.NAVY);
    public static final Block SLATE_CARPET = carpet(DDDyes.SLATE);
    public static final Block OLIVE_CARPET = carpet(DDDyes.OLIVE);
    public static final Block AMBER_CARPET = carpet(DDDyes.AMBER);
    public static final Block BEIGE_CARPET = carpet(DDDyes.BEIGE);
    public static final Block TEAL_CARPET = carpet(DDDyes.TEAL);
    public static final Block MINT_CARPET = carpet(DDDyes.MINT);
    public static final Block AQUA_CARPET = carpet(DDDyes.AQUA);
    public static final Block VERDANT_CARPET = carpet(DDDyes.VERDANT);
    public static final Block FOREST_CARPET = carpet(DDDyes.FOREST);
    public static final Block GINGER_CARPET = carpet(DDDyes.GINGER);
    public static final Block TAN_CARPET = carpet(DDDyes.TAN);

    public static final Block MAROON_TERRACOTTA = terracotta(DDDyes.MAROON, MapColor.CRIMSON_HYPHAE);
    public static final Block ROSE_TERRACOTTA = terracotta(DDDyes.ROSE, MapColor.COLOR_RED);
    public static final Block CORAL_TERRACOTTA = terracotta(DDDyes.CORAL, MapColor.PODZOL);
    public static final Block INDIGO_TERRACOTTA = terracotta(DDDyes.INDIGO, MapColor.WARPED_HYPHAE);
    public static final Block NAVY_TERRACOTTA = terracotta(DDDyes.NAVY, MapColor.TERRACOTTA_BLACK);
    public static final Block SLATE_TERRACOTTA = terracotta(DDDyes.SLATE, MapColor.COLOR_GRAY);
    public static final Block OLIVE_TERRACOTTA = terracotta(DDDyes.OLIVE, MapColor.COLOR_BROWN);
    public static final Block AMBER_TERRACOTTA = terracotta(DDDyes.AMBER, MapColor.WOOD);
    public static final Block BEIGE_TERRACOTTA = terracotta(DDDyes.BEIGE, MapColor.TERRACOTTA_WHITE);
    public static final Block TEAL_TERRACOTTA = terracotta(DDDyes.TEAL, MapColor.COLOR_GRAY);
    public static final Block MINT_TERRACOTTA = terracotta(DDDyes.MINT, MapColor.DEEPSLATE);
    public static final Block AQUA_TERRACOTTA = terracotta(DDDyes.AQUA, MapColor.WARPED_WART_BLOCK);
    public static final Block VERDANT_TERRACOTTA = terracotta(DDDyes.VERDANT, MapColor.TERRACOTTA_BLACK);
    public static final Block FOREST_TERRACOTTA = terracotta(DDDyes.FOREST, MapColor.COLOR_GREEN);
    public static final Block GINGER_TERRACOTTA = terracotta(DDDyes.GINGER, MapColor.NETHER);
    public static final Block TAN_TERRACOTTA = terracotta(DDDyes.TAN, MapColor.DIRT);

    public static final Block MAROON_CONCRETE = concrete(DDDyes.MAROON);
    public static final Block ROSE_CONCRETE = concrete(DDDyes.ROSE);
    public static final Block CORAL_CONCRETE = concrete(DDDyes.CORAL);
    public static final Block INDIGO_CONCRETE = concrete(DDDyes.INDIGO);
    public static final Block NAVY_CONCRETE = concrete(DDDyes.NAVY);
    public static final Block SLATE_CONCRETE = concrete(DDDyes.SLATE);
    public static final Block OLIVE_CONCRETE = concrete(DDDyes.OLIVE);
    public static final Block AMBER_CONCRETE = concrete(DDDyes.AMBER);
    public static final Block BEIGE_CONCRETE = concrete(DDDyes.BEIGE);
    public static final Block TEAL_CONCRETE = concrete(DDDyes.TEAL);
    public static final Block MINT_CONCRETE = concrete(DDDyes.MINT);
    public static final Block AQUA_CONCRETE = concrete(DDDyes.AQUA);
    public static final Block VERDANT_CONCRETE = concrete(DDDyes.VERDANT);
    public static final Block FOREST_CONCRETE = concrete(DDDyes.FOREST);
    public static final Block GINGER_CONCRETE = concrete(DDDyes.GINGER);
    public static final Block TAN_CONCRETE = concrete(DDDyes.TAN);

    public static final Block MAROON_CONCRETE_POWDER = concretePowder(MAROON_CONCRETE, DDDyes.MAROON);
    public static final Block ROSE_CONCRETE_POWDER = concretePowder(ROSE_CONCRETE, DDDyes.ROSE);
    public static final Block CORAL_CONCRETE_POWDER = concretePowder(CORAL_CONCRETE, DDDyes.CORAL);
    public static final Block INDIGO_CONCRETE_POWDER = concretePowder(INDIGO_CONCRETE, DDDyes.INDIGO);
    public static final Block NAVY_CONCRETE_POWDER = concretePowder(NAVY_CONCRETE, DDDyes.NAVY);
    public static final Block SLATE_CONCRETE_POWDER = concretePowder(SLATE_CONCRETE, DDDyes.SLATE);
    public static final Block OLIVE_CONCRETE_POWDER = concretePowder(OLIVE_CONCRETE, DDDyes.OLIVE);
    public static final Block AMBER_CONCRETE_POWDER = concretePowder(AMBER_CONCRETE, DDDyes.AMBER);
    public static final Block BEIGE_CONCRETE_POWDER = concretePowder(BEIGE_CONCRETE, DDDyes.BEIGE);
    public static final Block TEAL_CONCRETE_POWDER = concretePowder(TEAL_CONCRETE, DDDyes.TEAL);
    public static final Block MINT_CONCRETE_POWDER = concretePowder(MINT_CONCRETE, DDDyes.MINT);
    public static final Block AQUA_CONCRETE_POWDER = concretePowder(AQUA_CONCRETE, DDDyes.AQUA);
    public static final Block VERDANT_CONCRETE_POWDER = concretePowder(VERDANT_CONCRETE, DDDyes.VERDANT);
    public static final Block FOREST_CONCRETE_POWDER = concretePowder(FOREST_CONCRETE, DDDyes.FOREST);
    public static final Block GINGER_CONCRETE_POWDER = concretePowder(GINGER_CONCRETE, DDDyes.GINGER);
    public static final Block TAN_CONCRETE_POWDER = concretePowder(TAN_CONCRETE, DDDyes.TAN);

    public static final Block MAROON_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.MAROON);
    public static final Block ROSE_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.ROSE);
    public static final Block CORAL_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.CORAL);
    public static final Block INDIGO_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.INDIGO);
    public static final Block NAVY_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.NAVY);
    public static final Block SLATE_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.SLATE);
    public static final Block OLIVE_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.OLIVE);
    public static final Block AMBER_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.AMBER);
    public static final Block BEIGE_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.BEIGE);
    public static final Block TEAL_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.TEAL);
    public static final Block MINT_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.MINT);
    public static final Block AQUA_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.AQUA);
    public static final Block VERDANT_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.VERDANT);
    public static final Block FOREST_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.FOREST);
    public static final Block GINGER_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.GINGER);
    public static final Block TAN_GLAZED_TERRACOTTA = glazedTerracotta(DDDyes.TAN);

    public static final Block MAROON_STAINED_GLASS = stainedGlass(DDDyes.MAROON);
    public static final Block ROSE_STAINED_GLASS = stainedGlass(DDDyes.ROSE);
    public static final Block CORAL_STAINED_GLASS = stainedGlass(DDDyes.CORAL);
    public static final Block INDIGO_STAINED_GLASS = stainedGlass(DDDyes.INDIGO);
    public static final Block NAVY_STAINED_GLASS = stainedGlass(DDDyes.NAVY);
    public static final Block SLATE_STAINED_GLASS = stainedGlass(DDDyes.SLATE);
    public static final Block OLIVE_STAINED_GLASS = stainedGlass(DDDyes.OLIVE);
    public static final Block AMBER_STAINED_GLASS = stainedGlass(DDDyes.AMBER);
    public static final Block BEIGE_STAINED_GLASS = stainedGlass(DDDyes.BEIGE);
    public static final Block TEAL_STAINED_GLASS = stainedGlass(DDDyes.TEAL);
    public static final Block MINT_STAINED_GLASS = stainedGlass(DDDyes.MINT);
    public static final Block AQUA_STAINED_GLASS = stainedGlass(DDDyes.AQUA);
    public static final Block VERDANT_STAINED_GLASS = stainedGlass(DDDyes.VERDANT);
    public static final Block FOREST_STAINED_GLASS = stainedGlass(DDDyes.FOREST);
    public static final Block GINGER_STAINED_GLASS = stainedGlass(DDDyes.GINGER);
    public static final Block TAN_STAINED_GLASS = stainedGlass(DDDyes.TAN);

    public static final Block MAROON_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.MAROON);
    public static final Block ROSE_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.ROSE);
    public static final Block CORAL_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.CORAL);
    public static final Block INDIGO_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.INDIGO);
    public static final Block NAVY_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.NAVY);
    public static final Block SLATE_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.SLATE);
    public static final Block OLIVE_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.OLIVE);
    public static final Block AMBER_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.AMBER);
    public static final Block BEIGE_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.BEIGE);
    public static final Block TEAL_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.TEAL);
    public static final Block MINT_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.MINT);
    public static final Block AQUA_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.AQUA);
    public static final Block VERDANT_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.VERDANT);
    public static final Block FOREST_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.FOREST);
    public static final Block GINGER_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.GINGER);
    public static final Block TAN_STAINED_GLASS_PANE = stainedGlassPane(DDDyes.TAN);

    public static final Block MAROON_SHULKER_BOX = shulkerBox(DDDyes.MAROON);
    public static final Block ROSE_SHULKER_BOX = shulkerBox(DDDyes.ROSE);
    public static final Block CORAL_SHULKER_BOX = shulkerBox(DDDyes.CORAL);
    public static final Block INDIGO_SHULKER_BOX = shulkerBox(DDDyes.INDIGO);
    public static final Block NAVY_SHULKER_BOX = shulkerBox(DDDyes.NAVY);
    public static final Block SLATE_SHULKER_BOX = shulkerBox(DDDyes.SLATE);
    public static final Block OLIVE_SHULKER_BOX = shulkerBox(DDDyes.OLIVE);
    public static final Block AMBER_SHULKER_BOX = shulkerBox(DDDyes.AMBER);
    public static final Block BEIGE_SHULKER_BOX = shulkerBox(DDDyes.BEIGE);
    public static final Block TEAL_SHULKER_BOX = shulkerBox(DDDyes.TEAL);
    public static final Block MINT_SHULKER_BOX = shulkerBox(DDDyes.MINT);
    public static final Block AQUA_SHULKER_BOX = shulkerBox(DDDyes.AQUA);
    public static final Block VERDANT_SHULKER_BOX = shulkerBox(DDDyes.VERDANT);
    public static final Block FOREST_SHULKER_BOX = shulkerBox(DDDyes.FOREST);
    public static final Block GINGER_SHULKER_BOX = shulkerBox(DDDyes.GINGER);
    public static final Block TAN_SHULKER_BOX = shulkerBox(DDDyes.TAN);

    public static final Block MAROON_CANDLE = candle(DDDyes.MAROON);
    public static final Block ROSE_CANDLE = candle(DDDyes.ROSE);
    public static final Block CORAL_CANDLE = candle(DDDyes.CORAL);
    public static final Block INDIGO_CANDLE = candle(DDDyes.INDIGO);
    public static final Block NAVY_CANDLE = candle(DDDyes.NAVY);
    public static final Block SLATE_CANDLE = candle(DDDyes.SLATE);
    public static final Block OLIVE_CANDLE = candle(DDDyes.OLIVE);
    public static final Block AMBER_CANDLE = candle(DDDyes.AMBER);
    public static final Block BEIGE_CANDLE = candle(DDDyes.BEIGE);
    public static final Block TEAL_CANDLE = candle(DDDyes.TEAL);
    public static final Block MINT_CANDLE = candle(DDDyes.MINT);
    public static final Block AQUA_CANDLE = candle(DDDyes.AQUA);
    public static final Block VERDANT_CANDLE = candle(DDDyes.VERDANT);
    public static final Block FOREST_CANDLE = candle(DDDyes.FOREST);
    public static final Block GINGER_CANDLE = candle(DDDyes.GINGER);
    public static final Block TAN_CANDLE = candle(DDDyes.TAN);

    public static final Block MAROON_CANDLE_CAKE = candleCake(DDDyes.MAROON, MAROON_CANDLE);
    public static final Block ROSE_CANDLE_CAKE = candleCake(DDDyes.ROSE, ROSE_CANDLE);
    public static final Block CORAL_CANDLE_CAKE = candleCake(DDDyes.CORAL, CORAL_CANDLE);
    public static final Block INDIGO_CANDLE_CAKE = candleCake(DDDyes.INDIGO, INDIGO_CANDLE);
    public static final Block NAVY_CANDLE_CAKE = candleCake(DDDyes.NAVY, NAVY_CANDLE);
    public static final Block SLATE_CANDLE_CAKE = candleCake(DDDyes.SLATE, SLATE_CANDLE);
    public static final Block OLIVE_CANDLE_CAKE = candleCake(DDDyes.OLIVE, OLIVE_CANDLE);
    public static final Block AMBER_CANDLE_CAKE = candleCake(DDDyes.AMBER, AMBER_CANDLE);
    public static final Block BEIGE_CANDLE_CAKE = candleCake(DDDyes.BEIGE, BEIGE_CANDLE);
    public static final Block TEAL_CANDLE_CAKE = candleCake(DDDyes.TEAL, TEAL_CANDLE);
    public static final Block MINT_CANDLE_CAKE = candleCake(DDDyes.MINT, MINT_CANDLE);
    public static final Block AQUA_CANDLE_CAKE = candleCake(DDDyes.AQUA, AQUA_CANDLE);
    public static final Block VERDANT_CANDLE_CAKE = candleCake(DDDyes.VERDANT, VERDANT_CANDLE);
    public static final Block FOREST_CANDLE_CAKE = candleCake(DDDyes.FOREST, FOREST_CANDLE);
    public static final Block GINGER_CANDLE_CAKE = candleCake(DDDyes.GINGER, GINGER_CANDLE);
    public static final Block TAN_CANDLE_CAKE = candleCake(DDDyes.TAN, TAN_CANDLE);

    public static final Block MAROON_BANNER = banner(DDDyes.MAROON);
    public static final Block ROSE_BANNER = banner(DDDyes.ROSE);
    public static final Block CORAL_BANNER = banner(DDDyes.CORAL);
    public static final Block INDIGO_BANNER = banner(DDDyes.INDIGO);
    public static final Block NAVY_BANNER = banner(DDDyes.NAVY);
    public static final Block SLATE_BANNER = banner(DDDyes.SLATE);
    public static final Block OLIVE_BANNER = banner(DDDyes.OLIVE);
    public static final Block AMBER_BANNER = banner(DDDyes.AMBER);
    public static final Block BEIGE_BANNER = banner(DDDyes.BEIGE);
    public static final Block TEAL_BANNER = banner(DDDyes.TEAL);
    public static final Block MINT_BANNER = banner(DDDyes.MINT);
    public static final Block AQUA_BANNER = banner(DDDyes.AQUA);
    public static final Block VERDANT_BANNER = banner(DDDyes.VERDANT);
    public static final Block FOREST_BANNER = banner(DDDyes.FOREST);
    public static final Block GINGER_BANNER = banner(DDDyes.GINGER);
    public static final Block TAN_BANNER = banner(DDDyes.TAN);
    public static final Block MAROON_WALL_BANNER = wallBanner(DDDyes.MAROON, MAROON_BANNER);
    public static final Block ROSE_WALL_BANNER = wallBanner(DDDyes.ROSE, ROSE_BANNER);
    public static final Block CORAL_WALL_BANNER = wallBanner(DDDyes.CORAL, CORAL_BANNER);
    public static final Block INDIGO_WALL_BANNER = wallBanner(DDDyes.INDIGO, INDIGO_BANNER);
    public static final Block NAVY_WALL_BANNER = wallBanner(DDDyes.NAVY, NAVY_BANNER);
    public static final Block SLATE_WALL_BANNER = wallBanner(DDDyes.SLATE, SLATE_BANNER);
    public static final Block OLIVE_WALL_BANNER = wallBanner(DDDyes.OLIVE, OLIVE_BANNER);
    public static final Block AMBER_WALL_BANNER = wallBanner(DDDyes.AMBER, AMBER_BANNER);
    public static final Block BEIGE_WALL_BANNER = wallBanner(DDDyes.BEIGE, BEIGE_BANNER);
    public static final Block TEAL_WALL_BANNER = wallBanner(DDDyes.TEAL, TEAL_BANNER);
    public static final Block MINT_WALL_BANNER = wallBanner(DDDyes.MINT, MINT_BANNER);
    public static final Block AQUA_WALL_BANNER = wallBanner(DDDyes.AQUA, AQUA_BANNER);
    public static final Block VERDANT_WALL_BANNER = wallBanner(DDDyes.VERDANT, VERDANT_BANNER);
    public static final Block FOREST_WALL_BANNER = wallBanner(DDDyes.FOREST, FOREST_BANNER);
    public static final Block GINGER_WALL_BANNER = wallBanner(DDDyes.GINGER, GINGER_BANNER);
    public static final Block TAN_WALL_BANNER = wallBanner(DDDyes.TAN, TAN_BANNER);

    public static final Block MAROON_BED = bed(DDDyes.MAROON);
    public static final Block ROSE_BED = bed(DDDyes.ROSE);
    public static final Block CORAL_BED = bed(DDDyes.CORAL);
    public static final Block INDIGO_BED = bed(DDDyes.INDIGO);
    public static final Block NAVY_BED = bed(DDDyes.NAVY);
    public static final Block SLATE_BED = bed(DDDyes.SLATE);
    public static final Block OLIVE_BED = bed(DDDyes.OLIVE);
    public static final Block AMBER_BED = bed(DDDyes.AMBER);
    public static final Block BEIGE_BED = bed(DDDyes.BEIGE);
    public static final Block TEAL_BED = bed(DDDyes.TEAL);
    public static final Block MINT_BED = bed(DDDyes.MINT);
    public static final Block AQUA_BED = bed(DDDyes.AQUA);
    public static final Block VERDANT_BED = bed(DDDyes.VERDANT);
    public static final Block FOREST_BED = bed(DDDyes.FOREST);
    public static final Block GINGER_BED = bed(DDDyes.GINGER);
    public static final Block TAN_BED = bed(DDDyes.TAN);

    public static final Block MAROON_DYE_BASKET = dyeBasket(DDDyes.MAROON);
    public static final Block ROSE_DYE_BASKET = dyeBasket(DDDyes.ROSE);
    public static final Block CORAL_DYE_BASKET = dyeBasket(DDDyes.CORAL);
    public static final Block INDIGO_DYE_BASKET = dyeBasket(DDDyes.INDIGO);
    public static final Block NAVY_DYE_BASKET = dyeBasket(DDDyes.NAVY);
    public static final Block SLATE_DYE_BASKET = dyeBasket(DDDyes.SLATE);
    public static final Block OLIVE_DYE_BASKET = dyeBasket(DDDyes.OLIVE);
    public static final Block AMBER_DYE_BASKET = dyeBasket(DDDyes.AMBER);
    public static final Block BEIGE_DYE_BASKET = dyeBasket(DDDyes.BEIGE);
    public static final Block TEAL_DYE_BASKET = dyeBasket(DDDyes.TEAL);
    public static final Block MINT_DYE_BASKET = dyeBasket(DDDyes.MINT);
    public static final Block AQUA_DYE_BASKET = dyeBasket(DDDyes.AQUA);
    public static final Block VERDANT_DYE_BASKET = dyeBasket(DDDyes.VERDANT);
    public static final Block FOREST_DYE_BASKET = dyeBasket(DDDyes.FOREST);
    public static final Block GINGER_DYE_BASKET = dyeBasket(DDDyes.GINGER);
    public static final Block TAN_DYE_BASKET = dyeBasket(DDDyes.TAN);
    public static final Block WHITE_DYE_BASKET = dyeBasket(DyeColor.WHITE);
    public static final Block LIGHT_GRAY_DYE_BASKET = dyeBasket(DyeColor.LIGHT_GRAY);
    public static final Block GRAY_DYE_BASKET = dyeBasket(DyeColor.GRAY);
    public static final Block BLACK_DYE_BASKET = dyeBasket(DyeColor.BLACK);
    public static final Block BROWN_DYE_BASKET = dyeBasket(DyeColor.BROWN);
    public static final Block RED_DYE_BASKET = dyeBasket(DyeColor.RED);
    public static final Block ORANGE_DYE_BASKET = dyeBasket(DyeColor.ORANGE);
    public static final Block YELLOW_DYE_BASKET = dyeBasket(DyeColor.YELLOW);
    public static final Block LIME_DYE_BASKET = dyeBasket(DyeColor.LIME);
    public static final Block CYAN_DYE_BASKET = dyeBasket(DyeColor.CYAN);
    public static final Block GREEN_DYE_BASKET = dyeBasket(DyeColor.GREEN);
    public static final Block BLUE_DYE_BASKET = dyeBasket(DyeColor.BLUE);
    public static final Block LIGHT_BLUE_DYE_BASKET = dyeBasket(DyeColor.LIGHT_BLUE);
    public static final Block PURPLE_DYE_BASKET = dyeBasket(DyeColor.PURPLE);
    public static final Block MAGENTA_DYE_BASKET = dyeBasket(DyeColor.MAGENTA);
    public static final Block PINK_DYE_BASKET = dyeBasket(DyeColor.PINK);

    private static Block wool(DDDyes dddye) {
        return baseUndyed(key(dddye, "wool"), Block::new, copy(Blocks.WHITE_WOOL).mapColor(dddye.get()));
    }

    private static Block terracotta(DDDyes dddye, MapColor mapColor) {
        return baseUndyed(key(dddye, "terracotta"), Block::new, copy(Blocks.WHITE_TERRACOTTA).mapColor(mapColor));
    }

    private static Block glazedTerracotta(DDDyes dddye) {
        return baseUndyed(key(dddye, "glazed_terracotta"), GlazedTerracottaBlock::new, copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(dddye.get()));
    }

    private static Block concrete(DDDyes dddye) {
        return baseUndyed(key(dddye, "concrete"), Block::new, copy(Blocks.WHITE_TERRACOTTA).mapColor(dddye.get()));
    }

    private static Block concretePowder(Block concrete, DDDyes dddye) {
        return baseBlockDependent(key(dddye, "concrete_powder"), concrete, ConcretePowderBlock::new, copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(dddye.get()));
    }

    private static Block candle(DDDyes dddye) {
        return baseUndyed(key(dddye, "candle"), CandleBlock::new, copy(Blocks.WHITE_CANDLE).mapColor(dddye.get()));
    }

    private static Block candleCake(DDDyes dddye, Block concrete) {
        return baseBlockDependent(key(dddye, "candle_cake"), concrete, CandleCakeBlock::new, copy(Blocks.WHITE_CANDLE_CAKE));
    }

    private static Block carpet(DDDyes dddye) {
        DyeColor dyeColor = dddye.get();
        return baseDyed(key(dddye, "carpet"), dyeColor, WoolCarpetBlock::new, copy(Blocks.WHITE_CARPET).mapColor(dyeColor));
    }

    private static Block stainedGlass(DDDyes dddye) {
        DyeColor dyeColor = dddye.get();
        return baseDyed(key(dddye, "stained_glass"), dyeColor, StainedGlassBlock::new, copy(Blocks.WHITE_STAINED_GLASS));
    }
    
    private static Block stainedGlassPane(DDDyes dddye) {
        DyeColor dyeColor = dddye.get();
        return baseDyed(key(dddye, "stained_glass_pane"), dyeColor, StainedGlassPaneBlock::new, copy(Blocks.WHITE_STAINED_GLASS_PANE));
    }

    private static Block banner(DDDyes dddye) {
        DyeColor dyeColor = dddye.get();
        return baseDyed(key(dddye, "banner"), dyeColor, BannerBlock::new, copy(Blocks.WHITE_BANNER));
    }

    private static Block wallBanner(DDDyes dddye, Block baseBanner) {
        DyeColor dyeColor = dddye.get();
        return baseDyed(key(dddye, "wall_banner"), dyeColor, WallBannerBlock::new, copy(Blocks.WHITE_WALL_BANNER).overrideLootTable(baseBanner.getLootTable()));
    }

    private static Block shulkerBox(DDDyes dddye) {
        DyeColor dyeColor = dddye.get();
        BlockBehaviour.StatePredicate statePredicate = (blockState, blockGetter, blockPos) -> {
            BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
            if (blockEntity instanceof ShulkerBoxBlockEntity shulkerBoxBlockEntity) return shulkerBoxBlockEntity.isClosed();
            else return true;
        };
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
                .mapColor(dyeColor)
                .forceSolidOn()
                .strength(2.0F)
                .dynamicShape()
                .noOcclusion()
                .isSuffocating(statePredicate)
                .isViewBlocking(statePredicate)
                .pushReaction(PushReaction.DESTROY)
                .isRedstoneConductor(Blocks::always);
        return baseDyed(key(dddye, "shulker_box"), dyeColor, ShulkerBoxBlock::new, properties);
    }
    
    private static Block bed(DDDyes dddye) {
        DyeColor dyeColor = dddye.get();
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
            .mapColor((blockState) -> blockState.getValue(BedBlock.PART) == BedPart.FOOT ? dyeColor.getMapColor() : MapColor.WOOL)
            .sound(SoundType.WOOD)
            .strength(0.2F)
            .noOcclusion()
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
        return baseDyed(key(dddye, "bed"), dyeColor, BedBlock::new, properties);
    }

    private static Block dyeBasket(DDDyes dddye) {
        return dyeBasket(dddye.get());
    }

    private static Block dyeBasket(DyeColor dyeColor) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
                .strength(0.8f)
                .sound(SoundType.WOOL)
                .ignitedByLava()
                .mapColor(dyeColor);
        return baseDyed(key(dyeColor, "dye_basket"), dyeColor, DyeBasketBlock::new, properties);
    }

    private static Block baseDyed(ResourceKey<Block> key, DyeColor dyeColor, BiFunction<DyeColor, BlockBehaviour.Properties, Block> builder, BlockBehaviour.Properties properties) {
        return register(key, builder.apply(dyeColor, properties.setId(key)));
    }

    private static Block baseBlockDependent(ResourceKey<Block> key, Block block, BiFunction<Block, BlockBehaviour.Properties, Block> builder, BlockBehaviour.Properties properties) {
        return register(key, builder.apply(block, properties.setId(key)));
    }

    private static Block baseUndyed(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> builder, BlockBehaviour.Properties properties) {
        return register(key, builder.apply(properties.setId(key)));
    }

    private static Block register(ResourceKey<Block> key, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }
    
    private static BlockBehaviour.Properties copy(Block block) {
        return BlockBehaviour.Properties.ofFullCopy(block);
    }

    private static ResourceKey<Block> key(DDDyes dye, String suffix) {
        return ResourceKey.create(Registries.BLOCK, DyeDepot.id(dye.getName() + "_" + suffix));
    }

    private static ResourceKey<Block> key(DyeColor dye, String suffix) {
        return ResourceKey.create(Registries.BLOCK, DyeDepot.id(dye.getName() + "_" + suffix));
    }

    private static ResourceKey<Block> key(String name) {
        return ResourceKey.create(Registries.BLOCK, DyeDepot.id(name));
    }

    public static void init() {
        for (DyeColor dyeColor : DDDyes.getAll()) {
            DispenserBlock.registerBehavior(ShulkerBoxBlock.getBlockByColor(dyeColor).asItem(), new ShulkerBoxDispenseBehavior());
        }
    }

    public static Block getShulkerBox(DyeColor dyeColor) {
        if (dyeColor == DDDyes.MAROON.get()) return DDBlocks.MAROON_SHULKER_BOX;
        else if (dyeColor == DDDyes.ROSE.get()) return DDBlocks.ROSE_SHULKER_BOX;
        else if (dyeColor == DDDyes.CORAL.get()) return DDBlocks.CORAL_SHULKER_BOX;
        else if (dyeColor == DDDyes.INDIGO.get()) return DDBlocks.INDIGO_SHULKER_BOX;
        else if (dyeColor == DDDyes.NAVY.get()) return DDBlocks.NAVY_SHULKER_BOX;
        else if (dyeColor == DDDyes.SLATE.get()) return DDBlocks.SLATE_SHULKER_BOX;
        else if (dyeColor == DDDyes.OLIVE.get()) return DDBlocks.OLIVE_SHULKER_BOX;
        else if (dyeColor == DDDyes.AMBER.get()) return DDBlocks.AMBER_SHULKER_BOX;
        else if (dyeColor == DDDyes.BEIGE.get()) return DDBlocks.BEIGE_SHULKER_BOX;
        else if (dyeColor == DDDyes.TEAL.get()) return DDBlocks.TEAL_SHULKER_BOX;
        else if (dyeColor == DDDyes.MINT.get()) return DDBlocks.MINT_SHULKER_BOX;
        else if (dyeColor == DDDyes.AQUA.get()) return DDBlocks.AQUA_SHULKER_BOX;
        else if (dyeColor == DDDyes.VERDANT.get()) return DDBlocks.VERDANT_SHULKER_BOX;
        else if (dyeColor == DDDyes.FOREST.get()) return DDBlocks.FOREST_SHULKER_BOX;
        else if (dyeColor == DDDyes.GINGER.get()) return DDBlocks.GINGER_SHULKER_BOX;
        else if (dyeColor == DDDyes.TAN.get()) return DDBlocks.TAN_SHULKER_BOX;
        else return null;
    }
}
