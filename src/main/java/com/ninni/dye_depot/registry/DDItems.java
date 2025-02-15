package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class DDItems {
    public static final List<Item> ALL_ITEMS = new ArrayList<>();

    public static final Item MAROON_DYE = dye(DDDyes.MAROON);
    public static final Item ROSE_DYE = dye(DDDyes.ROSE);
    public static final Item CORAL_DYE = dye(DDDyes.CORAL);
    public static final Item INDIGO_DYE = dye(DDDyes.INDIGO);
    public static final Item NAVY_DYE = dye(DDDyes.NAVY);
    public static final Item SLATE_DYE = dye(DDDyes.SLATE);
    public static final Item OLIVE_DYE = dye(DDDyes.OLIVE);
    public static final Item AMBER_DYE = dye(DDDyes.AMBER);
    public static final Item BEIGE_DYE = dye(DDDyes.BEIGE);
    public static final Item TEAL_DYE = dye(DDDyes.TEAL);
    public static final Item MINT_DYE = dye(DDDyes.MINT);
    public static final Item AQUA_DYE = dye(DDDyes.AQUA);
    public static final Item VERDANT_DYE = dye(DDDyes.VERDANT);
    public static final Item FOREST_DYE = dye(DDDyes.FOREST);
    public static final Item GINGER_DYE = dye(DDDyes.GINGER);
    public static final Item TAN_DYE = dye(DDDyes.TAN);

    public static final Item MAROON_WOOL = fromBlock(DDBlocks.MAROON_WOOL);
    public static final Item ROSE_WOOL = fromBlock(DDBlocks.ROSE_WOOL);
    public static final Item CORAL_WOOL = fromBlock(DDBlocks.CORAL_WOOL);
    public static final Item INDIGO_WOOL = fromBlock(DDBlocks.INDIGO_WOOL);
    public static final Item NAVY_WOOL = fromBlock(DDBlocks.NAVY_WOOL);
    public static final Item SLATE_WOOL = fromBlock(DDBlocks.SLATE_WOOL);
    public static final Item OLIVE_WOOL = fromBlock(DDBlocks.OLIVE_WOOL);
    public static final Item AMBER_WOOL = fromBlock(DDBlocks.AMBER_WOOL);
    public static final Item BEIGE_WOOL = fromBlock(DDBlocks.BEIGE_WOOL);
    public static final Item TEAL_WOOL = fromBlock(DDBlocks.TEAL_WOOL);
    public static final Item MINT_WOOL = fromBlock(DDBlocks.MINT_WOOL);
    public static final Item AQUA_WOOL = fromBlock(DDBlocks.AQUA_WOOL);
    public static final Item VERDANT_WOOL = fromBlock(DDBlocks.VERDANT_WOOL);
    public static final Item FOREST_WOOL = fromBlock(DDBlocks.FOREST_WOOL);
    public static final Item GINGER_WOOL = fromBlock(DDBlocks.GINGER_WOOL);
    public static final Item TAN_WOOL = fromBlock(DDBlocks.TAN_WOOL);

    public static final Item MAROON_CARPET = fromBlock(DDBlocks.MAROON_CARPET);
    public static final Item ROSE_CARPET = fromBlock(DDBlocks.ROSE_CARPET);
    public static final Item CORAL_CARPET = fromBlock(DDBlocks.CORAL_CARPET);
    public static final Item INDIGO_CARPET = fromBlock(DDBlocks.INDIGO_CARPET);
    public static final Item NAVY_CARPET = fromBlock(DDBlocks.NAVY_CARPET);
    public static final Item SLATE_CARPET = fromBlock(DDBlocks.SLATE_CARPET);
    public static final Item OLIVE_CARPET = fromBlock(DDBlocks.OLIVE_CARPET);
    public static final Item AMBER_CARPET = fromBlock(DDBlocks.AMBER_CARPET);
    public static final Item BEIGE_CARPET = fromBlock(DDBlocks.BEIGE_CARPET);
    public static final Item TEAL_CARPET = fromBlock(DDBlocks.TEAL_CARPET);
    public static final Item MINT_CARPET = fromBlock(DDBlocks.MINT_CARPET);
    public static final Item AQUA_CARPET = fromBlock(DDBlocks.AQUA_CARPET);
    public static final Item VERDANT_CARPET = fromBlock(DDBlocks.VERDANT_CARPET);
    public static final Item FOREST_CARPET = fromBlock(DDBlocks.FOREST_CARPET);
    public static final Item GINGER_CARPET = fromBlock(DDBlocks.GINGER_CARPET);
    public static final Item TAN_CARPET = fromBlock(DDBlocks.TAN_CARPET);

    public static final Item MAROON_TERRACOTTA = fromBlock(DDBlocks.MAROON_TERRACOTTA);
    public static final Item ROSE_TERRACOTTA = fromBlock(DDBlocks.ROSE_TERRACOTTA);
    public static final Item CORAL_TERRACOTTA = fromBlock(DDBlocks.CORAL_TERRACOTTA);
    public static final Item INDIGO_TERRACOTTA = fromBlock(DDBlocks.INDIGO_TERRACOTTA);
    public static final Item NAVY_TERRACOTTA = fromBlock(DDBlocks.NAVY_TERRACOTTA);
    public static final Item SLATE_TERRACOTTA = fromBlock(DDBlocks.SLATE_TERRACOTTA);
    public static final Item OLIVE_TERRACOTTA = fromBlock(DDBlocks.OLIVE_TERRACOTTA);
    public static final Item AMBER_TERRACOTTA = fromBlock(DDBlocks.AMBER_TERRACOTTA);
    public static final Item BEIGE_TERRACOTTA = fromBlock(DDBlocks.BEIGE_TERRACOTTA);
    public static final Item TEAL_TERRACOTTA = fromBlock(DDBlocks.TEAL_TERRACOTTA);
    public static final Item MINT_TERRACOTTA = fromBlock(DDBlocks.MINT_TERRACOTTA);
    public static final Item AQUA_TERRACOTTA = fromBlock(DDBlocks.AQUA_TERRACOTTA);
    public static final Item VERDANT_TERRACOTTA = fromBlock(DDBlocks.VERDANT_TERRACOTTA);
    public static final Item FOREST_TERRACOTTA = fromBlock(DDBlocks.FOREST_TERRACOTTA);
    public static final Item GINGER_TERRACOTTA = fromBlock(DDBlocks.GINGER_TERRACOTTA);
    public static final Item TAN_TERRACOTTA = fromBlock(DDBlocks.TAN_TERRACOTTA);

    public static final Item MAROON_CONCRETE = fromBlock(DDBlocks.MAROON_CONCRETE);
    public static final Item ROSE_CONCRETE = fromBlock(DDBlocks.ROSE_CONCRETE);
    public static final Item CORAL_CONCRETE = fromBlock(DDBlocks.CORAL_CONCRETE);
    public static final Item INDIGO_CONCRETE = fromBlock(DDBlocks.INDIGO_CONCRETE);
    public static final Item NAVY_CONCRETE = fromBlock(DDBlocks.NAVY_CONCRETE);
    public static final Item SLATE_CONCRETE = fromBlock(DDBlocks.SLATE_CONCRETE);
    public static final Item OLIVE_CONCRETE = fromBlock(DDBlocks.OLIVE_CONCRETE);
    public static final Item AMBER_CONCRETE = fromBlock(DDBlocks.AMBER_CONCRETE);
    public static final Item BEIGE_CONCRETE = fromBlock(DDBlocks.BEIGE_CONCRETE);
    public static final Item TEAL_CONCRETE = fromBlock(DDBlocks.TEAL_CONCRETE);
    public static final Item MINT_CONCRETE = fromBlock(DDBlocks.MINT_CONCRETE);
    public static final Item AQUA_CONCRETE = fromBlock(DDBlocks.AQUA_CONCRETE);
    public static final Item VERDANT_CONCRETE = fromBlock(DDBlocks.VERDANT_CONCRETE);
    public static final Item FOREST_CONCRETE = fromBlock(DDBlocks.FOREST_CONCRETE);
    public static final Item GINGER_CONCRETE = fromBlock(DDBlocks.GINGER_CONCRETE);
    public static final Item TAN_CONCRETE = fromBlock(DDBlocks.TAN_CONCRETE);

    public static final Item MAROON_CONCRETE_POWDER = fromBlock(DDBlocks.MAROON_CONCRETE_POWDER);
    public static final Item ROSE_CONCRETE_POWDER = fromBlock(DDBlocks.ROSE_CONCRETE_POWDER);
    public static final Item CORAL_CONCRETE_POWDER = fromBlock(DDBlocks.CORAL_CONCRETE_POWDER);
    public static final Item INDIGO_CONCRETE_POWDER = fromBlock(DDBlocks.INDIGO_CONCRETE_POWDER);
    public static final Item NAVY_CONCRETE_POWDER = fromBlock(DDBlocks.NAVY_CONCRETE_POWDER);
    public static final Item SLATE_CONCRETE_POWDER = fromBlock(DDBlocks.SLATE_CONCRETE_POWDER);
    public static final Item OLIVE_CONCRETE_POWDER = fromBlock(DDBlocks.OLIVE_CONCRETE_POWDER);
    public static final Item AMBER_CONCRETE_POWDER = fromBlock(DDBlocks.AMBER_CONCRETE_POWDER);
    public static final Item BEIGE_CONCRETE_POWDER = fromBlock(DDBlocks.BEIGE_CONCRETE_POWDER);
    public static final Item TEAL_CONCRETE_POWDER = fromBlock(DDBlocks.TEAL_CONCRETE_POWDER);
    public static final Item MINT_CONCRETE_POWDER = fromBlock(DDBlocks.MINT_CONCRETE_POWDER);
    public static final Item AQUA_CONCRETE_POWDER = fromBlock(DDBlocks.AQUA_CONCRETE_POWDER);
    public static final Item VERDANT_CONCRETE_POWDER = fromBlock(DDBlocks.VERDANT_CONCRETE_POWDER);
    public static final Item FOREST_CONCRETE_POWDER = fromBlock(DDBlocks.FOREST_CONCRETE_POWDER);
    public static final Item GINGER_CONCRETE_POWDER = fromBlock(DDBlocks.GINGER_CONCRETE_POWDER);
    public static final Item TAN_CONCRETE_POWDER = fromBlock(DDBlocks.TAN_CONCRETE_POWDER);

    public static final Item MAROON_GLAZED_TERRACOTTA = fromBlock(DDBlocks.MAROON_GLAZED_TERRACOTTA);
    public static final Item ROSE_GLAZED_TERRACOTTA = fromBlock(DDBlocks.ROSE_GLAZED_TERRACOTTA);
    public static final Item CORAL_GLAZED_TERRACOTTA = fromBlock(DDBlocks.CORAL_GLAZED_TERRACOTTA);
    public static final Item INDIGO_GLAZED_TERRACOTTA = fromBlock(DDBlocks.INDIGO_GLAZED_TERRACOTTA);
    public static final Item NAVY_GLAZED_TERRACOTTA = fromBlock(DDBlocks.NAVY_GLAZED_TERRACOTTA);
    public static final Item SLATE_GLAZED_TERRACOTTA = fromBlock(DDBlocks.SLATE_GLAZED_TERRACOTTA);
    public static final Item OLIVE_GLAZED_TERRACOTTA = fromBlock(DDBlocks.OLIVE_GLAZED_TERRACOTTA);
    public static final Item AMBER_GLAZED_TERRACOTTA = fromBlock(DDBlocks.AMBER_GLAZED_TERRACOTTA);
    public static final Item BEIGE_GLAZED_TERRACOTTA = fromBlock(DDBlocks.BEIGE_GLAZED_TERRACOTTA);
    public static final Item TEAL_GLAZED_TERRACOTTA = fromBlock(DDBlocks.TEAL_GLAZED_TERRACOTTA);
    public static final Item MINT_GLAZED_TERRACOTTA = fromBlock(DDBlocks.MINT_GLAZED_TERRACOTTA);
    public static final Item AQUA_GLAZED_TERRACOTTA = fromBlock(DDBlocks.AQUA_GLAZED_TERRACOTTA);
    public static final Item VERDANT_GLAZED_TERRACOTTA = fromBlock(DDBlocks.VERDANT_GLAZED_TERRACOTTA);
    public static final Item FOREST_GLAZED_TERRACOTTA = fromBlock(DDBlocks.FOREST_GLAZED_TERRACOTTA);
    public static final Item GINGER_GLAZED_TERRACOTTA = fromBlock(DDBlocks.GINGER_GLAZED_TERRACOTTA);
    public static final Item TAN_GLAZED_TERRACOTTA = fromBlock(DDBlocks.TAN_GLAZED_TERRACOTTA);

    public static final Item MAROON_STAINED_GLASS = fromBlock(DDBlocks.MAROON_STAINED_GLASS);
    public static final Item ROSE_STAINED_GLASS = fromBlock(DDBlocks.ROSE_STAINED_GLASS);
    public static final Item CORAL_STAINED_GLASS = fromBlock(DDBlocks.CORAL_STAINED_GLASS);
    public static final Item INDIGO_STAINED_GLASS = fromBlock(DDBlocks.INDIGO_STAINED_GLASS);
    public static final Item NAVY_STAINED_GLASS = fromBlock(DDBlocks.NAVY_STAINED_GLASS);
    public static final Item SLATE_STAINED_GLASS = fromBlock(DDBlocks.SLATE_STAINED_GLASS);
    public static final Item OLIVE_STAINED_GLASS = fromBlock(DDBlocks.OLIVE_STAINED_GLASS);
    public static final Item AMBER_STAINED_GLASS = fromBlock(DDBlocks.AMBER_STAINED_GLASS);
    public static final Item BEIGE_STAINED_GLASS = fromBlock(DDBlocks.BEIGE_STAINED_GLASS);
    public static final Item TEAL_STAINED_GLASS = fromBlock(DDBlocks.TEAL_STAINED_GLASS);
    public static final Item MINT_STAINED_GLASS = fromBlock(DDBlocks.MINT_STAINED_GLASS);
    public static final Item AQUA_STAINED_GLASS = fromBlock(DDBlocks.AQUA_STAINED_GLASS);
    public static final Item VERDANT_STAINED_GLASS = fromBlock(DDBlocks.VERDANT_STAINED_GLASS);
    public static final Item FOREST_STAINED_GLASS = fromBlock(DDBlocks.FOREST_STAINED_GLASS);
    public static final Item GINGER_STAINED_GLASS = fromBlock(DDBlocks.GINGER_STAINED_GLASS);
    public static final Item TAN_STAINED_GLASS = fromBlock(DDBlocks.TAN_STAINED_GLASS);

    public static final Item MAROON_STAINED_GLASS_PANE = fromBlock(DDBlocks.MAROON_STAINED_GLASS_PANE);
    public static final Item ROSE_STAINED_GLASS_PANE = fromBlock(DDBlocks.ROSE_STAINED_GLASS_PANE);
    public static final Item CORAL_STAINED_GLASS_PANE = fromBlock(DDBlocks.CORAL_STAINED_GLASS_PANE);
    public static final Item INDIGO_STAINED_GLASS_PANE = fromBlock(DDBlocks.INDIGO_STAINED_GLASS_PANE);
    public static final Item NAVY_STAINED_GLASS_PANE = fromBlock(DDBlocks.NAVY_STAINED_GLASS_PANE);
    public static final Item SLATE_STAINED_GLASS_PANE = fromBlock(DDBlocks.SLATE_STAINED_GLASS_PANE);
    public static final Item OLIVE_STAINED_GLASS_PANE = fromBlock(DDBlocks.OLIVE_STAINED_GLASS_PANE);
    public static final Item AMBER_STAINED_GLASS_PANE = fromBlock(DDBlocks.AMBER_STAINED_GLASS_PANE);
    public static final Item BEIGE_STAINED_GLASS_PANE = fromBlock(DDBlocks.BEIGE_STAINED_GLASS_PANE);
    public static final Item TEAL_STAINED_GLASS_PANE = fromBlock(DDBlocks.TEAL_STAINED_GLASS_PANE);
    public static final Item MINT_STAINED_GLASS_PANE = fromBlock(DDBlocks.MINT_STAINED_GLASS_PANE);
    public static final Item AQUA_STAINED_GLASS_PANE = fromBlock(DDBlocks.AQUA_STAINED_GLASS_PANE);
    public static final Item VERDANT_STAINED_GLASS_PANE = fromBlock(DDBlocks.VERDANT_STAINED_GLASS_PANE);
    public static final Item FOREST_STAINED_GLASS_PANE = fromBlock(DDBlocks.FOREST_STAINED_GLASS_PANE);
    public static final Item GINGER_STAINED_GLASS_PANE = fromBlock(DDBlocks.GINGER_STAINED_GLASS_PANE);
    public static final Item TAN_STAINED_GLASS_PANE = fromBlock(DDBlocks.TAN_STAINED_GLASS_PANE);

    public static final Item MAROON_SHULKER_BOX = shulkerBox(DDBlocks.MAROON_SHULKER_BOX);
    public static final Item ROSE_SHULKER_BOX = shulkerBox(DDBlocks.ROSE_SHULKER_BOX);
    public static final Item CORAL_SHULKER_BOX = shulkerBox(DDBlocks.CORAL_SHULKER_BOX);
    public static final Item INDIGO_SHULKER_BOX = shulkerBox(DDBlocks.INDIGO_SHULKER_BOX);
    public static final Item NAVY_SHULKER_BOX = shulkerBox(DDBlocks.NAVY_SHULKER_BOX);
    public static final Item SLATE_SHULKER_BOX = shulkerBox(DDBlocks.SLATE_SHULKER_BOX);
    public static final Item OLIVE_SHULKER_BOX = shulkerBox(DDBlocks.OLIVE_SHULKER_BOX);
    public static final Item AMBER_SHULKER_BOX = shulkerBox(DDBlocks.AMBER_SHULKER_BOX);
    public static final Item BEIGE_SHULKER_BOX = shulkerBox(DDBlocks.BEIGE_SHULKER_BOX);
    public static final Item TEAL_SHULKER_BOX = shulkerBox(DDBlocks.TEAL_SHULKER_BOX);
    public static final Item MINT_SHULKER_BOX = shulkerBox(DDBlocks.MINT_SHULKER_BOX);
    public static final Item AQUA_SHULKER_BOX = shulkerBox(DDBlocks.AQUA_SHULKER_BOX);
    public static final Item VERDANT_SHULKER_BOX = shulkerBox(DDBlocks.VERDANT_SHULKER_BOX);
    public static final Item FOREST_SHULKER_BOX = shulkerBox(DDBlocks.FOREST_SHULKER_BOX);
    public static final Item GINGER_SHULKER_BOX = shulkerBox(DDBlocks.GINGER_SHULKER_BOX);
    public static final Item TAN_SHULKER_BOX = shulkerBox(DDBlocks.TAN_SHULKER_BOX);

    public static final Item MAROON_CANDLE = fromBlock(DDBlocks.MAROON_CANDLE);
    public static final Item ROSE_CANDLE = fromBlock(DDBlocks.ROSE_CANDLE);
    public static final Item CORAL_CANDLE = fromBlock(DDBlocks.CORAL_CANDLE);
    public static final Item INDIGO_CANDLE = fromBlock(DDBlocks.INDIGO_CANDLE);
    public static final Item NAVY_CANDLE = fromBlock(DDBlocks.NAVY_CANDLE);
    public static final Item SLATE_CANDLE = fromBlock(DDBlocks.SLATE_CANDLE);
    public static final Item OLIVE_CANDLE = fromBlock(DDBlocks.OLIVE_CANDLE);
    public static final Item AMBER_CANDLE = fromBlock(DDBlocks.AMBER_CANDLE);
    public static final Item BEIGE_CANDLE = fromBlock(DDBlocks.BEIGE_CANDLE);
    public static final Item TEAL_CANDLE = fromBlock(DDBlocks.TEAL_CANDLE);
    public static final Item MINT_CANDLE = fromBlock(DDBlocks.MINT_CANDLE);
    public static final Item AQUA_CANDLE = fromBlock(DDBlocks.AQUA_CANDLE);
    public static final Item VERDANT_CANDLE = fromBlock(DDBlocks.VERDANT_CANDLE);
    public static final Item FOREST_CANDLE = fromBlock(DDBlocks.FOREST_CANDLE);
    public static final Item GINGER_CANDLE = fromBlock(DDBlocks.GINGER_CANDLE);
    public static final Item TAN_CANDLE = fromBlock(DDBlocks.TAN_CANDLE);

    public static final Item MAROON_BANNER = banner(DDBlocks.MAROON_BANNER, DDBlocks.MAROON_WALL_BANNER);
    public static final Item ROSE_BANNER = banner(DDBlocks.ROSE_BANNER, DDBlocks.ROSE_WALL_BANNER);
    public static final Item CORAL_BANNER = banner(DDBlocks.CORAL_BANNER, DDBlocks.CORAL_WALL_BANNER);
    public static final Item INDIGO_BANNER = banner(DDBlocks.INDIGO_BANNER, DDBlocks.INDIGO_WALL_BANNER);
    public static final Item NAVY_BANNER = banner(DDBlocks.NAVY_BANNER, DDBlocks.NAVY_WALL_BANNER);
    public static final Item SLATE_BANNER = banner(DDBlocks.SLATE_BANNER, DDBlocks.SLATE_WALL_BANNER);
    public static final Item OLIVE_BANNER = banner(DDBlocks.OLIVE_BANNER, DDBlocks.OLIVE_WALL_BANNER);
    public static final Item AMBER_BANNER = banner(DDBlocks.AMBER_BANNER, DDBlocks.AMBER_WALL_BANNER);
    public static final Item BEIGE_BANNER = banner(DDBlocks.BEIGE_BANNER, DDBlocks.BEIGE_WALL_BANNER);
    public static final Item TEAL_BANNER = banner(DDBlocks.TEAL_BANNER, DDBlocks.TEAL_WALL_BANNER);
    public static final Item MINT_BANNER = banner(DDBlocks.MINT_BANNER, DDBlocks.MINT_WALL_BANNER);
    public static final Item AQUA_BANNER = banner(DDBlocks.AQUA_BANNER, DDBlocks.AQUA_WALL_BANNER);
    public static final Item VERDANT_BANNER = banner(DDBlocks.VERDANT_BANNER, DDBlocks.VERDANT_WALL_BANNER);
    public static final Item FOREST_BANNER = banner(DDBlocks.FOREST_BANNER, DDBlocks.FOREST_WALL_BANNER);
    public static final Item GINGER_BANNER = banner(DDBlocks.GINGER_BANNER, DDBlocks.GINGER_WALL_BANNER);
    public static final Item TAN_BANNER = banner(DDBlocks.TAN_BANNER, DDBlocks.TAN_WALL_BANNER);

    public static final Item MAROON_BED = bed(DDBlocks.MAROON_BED);
    public static final Item ROSE_BED = bed(DDBlocks.ROSE_BED);
    public static final Item CORAL_BED = bed(DDBlocks.CORAL_BED);
    public static final Item INDIGO_BED = bed(DDBlocks.INDIGO_BED);
    public static final Item NAVY_BED = bed(DDBlocks.NAVY_BED);
    public static final Item SLATE_BED = bed(DDBlocks.SLATE_BED);
    public static final Item OLIVE_BED = bed(DDBlocks.OLIVE_BED);
    public static final Item AMBER_BED = bed(DDBlocks.AMBER_BED);
    public static final Item BEIGE_BED = bed(DDBlocks.BEIGE_BED);
    public static final Item TEAL_BED = bed(DDBlocks.TEAL_BED);
    public static final Item MINT_BED = bed(DDBlocks.MINT_BED);
    public static final Item AQUA_BED = bed(DDBlocks.AQUA_BED);
    public static final Item VERDANT_BED = bed(DDBlocks.VERDANT_BED);
    public static final Item FOREST_BED = bed(DDBlocks.FOREST_BED);
    public static final Item GINGER_BED = bed(DDBlocks.GINGER_BED);
    public static final Item TAN_BED = bed(DDBlocks.TAN_BED);

    public static final Item MAROON_DYE_BASKET = fromBlock(DDBlocks.MAROON_DYE_BASKET);
    public static final Item ROSE_DYE_BASKET = fromBlock(DDBlocks.ROSE_DYE_BASKET);
    public static final Item CORAL_DYE_BASKET = fromBlock(DDBlocks.CORAL_DYE_BASKET);
    public static final Item INDIGO_DYE_BASKET = fromBlock(DDBlocks.INDIGO_DYE_BASKET);
    public static final Item NAVY_DYE_BASKET = fromBlock(DDBlocks.NAVY_DYE_BASKET);
    public static final Item SLATE_DYE_BASKET = fromBlock(DDBlocks.SLATE_DYE_BASKET);
    public static final Item OLIVE_DYE_BASKET = fromBlock(DDBlocks.OLIVE_DYE_BASKET);
    public static final Item AMBER_DYE_BASKET = fromBlock(DDBlocks.AMBER_DYE_BASKET);
    public static final Item BEIGE_DYE_BASKET = fromBlock(DDBlocks.BEIGE_DYE_BASKET);
    public static final Item TEAL_DYE_BASKET = fromBlock(DDBlocks.TEAL_DYE_BASKET);
    public static final Item MINT_DYE_BASKET = fromBlock(DDBlocks.MINT_DYE_BASKET);
    public static final Item AQUA_DYE_BASKET = fromBlock(DDBlocks.AQUA_DYE_BASKET);
    public static final Item VERDANT_DYE_BASKET = fromBlock(DDBlocks.VERDANT_DYE_BASKET);
    public static final Item FOREST_DYE_BASKET = fromBlock(DDBlocks.FOREST_DYE_BASKET);
    public static final Item GINGER_DYE_BASKET = fromBlock(DDBlocks.GINGER_DYE_BASKET);
    public static final Item TAN_DYE_BASKET = fromBlock(DDBlocks.TAN_DYE_BASKET);
    public static final Item WHITE_DYE_BASKET = fromBlock(DDBlocks.WHITE_DYE_BASKET);
    public static final Item LIGHT_GRAY_DYE_BASKET = fromBlock(DDBlocks.LIGHT_GRAY_DYE_BASKET);
    public static final Item GRAY_DYE_BASKET = fromBlock(DDBlocks.GRAY_DYE_BASKET);
    public static final Item BLACK_DYE_BASKET = fromBlock(DDBlocks.BLACK_DYE_BASKET);
    public static final Item BROWN_DYE_BASKET = fromBlock(DDBlocks.BROWN_DYE_BASKET);
    public static final Item RED_DYE_BASKET = fromBlock(DDBlocks.RED_DYE_BASKET);
    public static final Item ORANGE_DYE_BASKET = fromBlock(DDBlocks.ORANGE_DYE_BASKET);
    public static final Item YELLOW_DYE_BASKET = fromBlock(DDBlocks.YELLOW_DYE_BASKET);
    public static final Item LIME_DYE_BASKET = fromBlock(DDBlocks.LIME_DYE_BASKET);
    public static final Item CYAN_DYE_BASKET = fromBlock(DDBlocks.CYAN_DYE_BASKET);
    public static final Item GREEN_DYE_BASKET = fromBlock(DDBlocks.GREEN_DYE_BASKET);
    public static final Item BLUE_DYE_BASKET = fromBlock(DDBlocks.BLUE_DYE_BASKET);
    public static final Item LIGHT_BLUE_DYE_BASKET = fromBlock(DDBlocks.LIGHT_BLUE_DYE_BASKET);
    public static final Item PURPLE_DYE_BASKET = fromBlock(DDBlocks.PURPLE_DYE_BASKET);
    public static final Item MAGENTA_DYE_BASKET = fromBlock(DDBlocks.MAGENTA_DYE_BASKET);
    public static final Item PINK_DYE_BASKET = fromBlock(DDBlocks.PINK_DYE_BASKET);

    private static Item dye(DDDyes dye) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, DyeDepot.id(dye.getName() + "_dye"));
        return register(key, new DyeItem(dye.get(), properties(key)));
    }

    private static Item banner(Block banner, Block wallBanner) {
        return register(key(banner), new BannerItem(banner, wallBanner, properties(key(banner)).useBlockDescriptionPrefix()));
    }
    
    private static Item shulkerBox(Block block) {
        return register(key(block), new BlockItem(block, properties(key(block)).stacksTo(1).useBlockDescriptionPrefix()));
    }
    
    private static Item bed(Block block) {
        return register(key(block), new BedItem(block, properties(key(block)).stacksTo(1).useBlockDescriptionPrefix()));
    }

    private static Item fromBlock(Block block) {
        return register(key(block), new BlockItem(block, properties(key(block)).useBlockDescriptionPrefix()));
    }

    private static Item register(ResourceKey<Item> key, Item item) {
        ALL_ITEMS.add(item);
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    private static Item.Properties properties(ResourceKey<Item> key) {
        return new Item.Properties().setId(key);
    }

    @SuppressWarnings("deprecation")
    private static ResourceKey<Item> key(Block block) {
        ResourceKey<Block> blockKey = block.builtInRegistryHolder().key();
        return ResourceKey.create(Registries.ITEM, blockKey.location());
    }
    public static void init() {

    }
}
