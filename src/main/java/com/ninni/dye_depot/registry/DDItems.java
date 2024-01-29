package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;

public class DDItems {

    public static final Item MAROON_DYE = register("maroon_dye", new DyeItem(DDDyes.MAROON.get(), new Item.Properties()));
    public static final Item ROSE_DYE = register("rose_dye", new DyeItem(DDDyes.ROSE.get(), new Item.Properties()));
    public static final Item CORAL_DYE = register("coral_dye", new DyeItem(DDDyes.CORAL.get(), new Item.Properties()));
    public static final Item INDIGO_DYE = register("indigo_dye", new DyeItem(DDDyes.INDIGO.get(), new Item.Properties()));
    public static final Item NAVY_DYE = register("navy_dye", new DyeItem(DDDyes.NAVY.get(), new Item.Properties()));
    public static final Item SLATE_DYE = register("slate_dye", new DyeItem(DDDyes.SLATE.get(), new Item.Properties()));
    public static final Item OLIVE_DYE = register("olive_dye", new DyeItem(DDDyes.OLIVE.get(), new Item.Properties()));
    public static final Item AMBER_DYE = register("amber_dye", new DyeItem(DDDyes.AMBER.get(), new Item.Properties()));
    public static final Item BEIGE_DYE = register("beige_dye", new DyeItem(DDDyes.BEIGE.get(), new Item.Properties()));
    public static final Item TEAL_DYE = register("teal_dye", new DyeItem(DDDyes.TEAL.get(), new Item.Properties()));
    public static final Item TURQUOISE_DYE = register("turquoise_dye", new DyeItem(DDDyes.TURQUOISE.get(), new Item.Properties()));
    public static final Item AQUA_DYE = register("aqua_dye", new DyeItem(DDDyes.AQUA.get(), new Item.Properties()));
    public static final Item VERDANT_DYE = register("verdant_dye", new DyeItem(DDDyes.VERDANT.get(), new Item.Properties()));
    public static final Item FOREST_DYE = register("forest_dye", new DyeItem(DDDyes.FOREST.get(), new Item.Properties()));
    public static final Item GINGER_DYE = register("ginger_dye", new DyeItem(DDDyes.GINGER.get(), new Item.Properties()));
    public static final Item TAN_DYE = register("tan_dye", new DyeItem(DDDyes.TAN.get(), new Item.Properties()));

    public static final Item MAROON_WOOL = register("maroon_wool", new BlockItem(DDBlocks.MAROON_WOOL, new Item.Properties()));
    public static final Item ROSE_WOOL = register("rose_wool", new BlockItem(DDBlocks.ROSE_WOOL, new Item.Properties()));
    public static final Item CORAL_WOOL = register("coral_wool", new BlockItem(DDBlocks.CORAL_WOOL, new Item.Properties()));
    public static final Item INDIGO_WOOL = register("indigo_wool", new BlockItem(DDBlocks.INDIGO_WOOL, new Item.Properties()));
    public static final Item NAVY_WOOL = register("navy_wool", new BlockItem(DDBlocks.NAVY_WOOL, new Item.Properties()));
    public static final Item SLATE_WOOL = register("slate_wool", new BlockItem(DDBlocks.SLATE_WOOL, new Item.Properties()));
    public static final Item OLIVE_WOOL = register("olive_wool", new BlockItem(DDBlocks.OLIVE_WOOL, new Item.Properties()));
    public static final Item AMBER_WOOL = register("amber_wool", new BlockItem(DDBlocks.AMBER_WOOL, new Item.Properties()));
    public static final Item BEIGE_WOOL = register("beige_wool", new BlockItem(DDBlocks.BEIGE_WOOL, new Item.Properties()));
    public static final Item TEAL_WOOL = register("teal_wool", new BlockItem(DDBlocks.TEAL_WOOL, new Item.Properties()));
    public static final Item TURQUOISE_WOOL = register("turquoise_wool", new BlockItem(DDBlocks.TURQUOISE_WOOL, new Item.Properties()));
    public static final Item AQUA_WOOL = register("aqua_wool", new BlockItem(DDBlocks.AQUA_WOOL, new Item.Properties()));
    public static final Item VERDANT_WOOL = register("verdant_wool", new BlockItem(DDBlocks.VERDANT_WOOL, new Item.Properties()));
    public static final Item FOREST_WOOL = register("forest_wool", new BlockItem(DDBlocks.FOREST_WOOL, new Item.Properties()));
    public static final Item GINGER_WOOL = register("ginger_wool", new BlockItem(DDBlocks.GINGER_WOOL, new Item.Properties()));
    public static final Item TAN_WOOL = register("tan_wool", new BlockItem(DDBlocks.TAN_WOOL, new Item.Properties()));

    public static final Item MAROON_CARPET = register("maroon_carpet", new BlockItem(DDBlocks.MAROON_CARPET, new Item.Properties()));
    public static final Item ROSE_CARPET = register("rose_carpet", new BlockItem(DDBlocks.ROSE_CARPET, new Item.Properties()));
    public static final Item CORAL_CARPET = register("coral_carpet", new BlockItem(DDBlocks.CORAL_CARPET, new Item.Properties()));
    public static final Item INDIGO_CARPET = register("indigo_carpet", new BlockItem(DDBlocks.INDIGO_CARPET, new Item.Properties()));
    public static final Item NAVY_CARPET = register("navy_carpet", new BlockItem(DDBlocks.NAVY_CARPET, new Item.Properties()));
    public static final Item SLATE_CARPET = register("slate_carpet", new BlockItem(DDBlocks.SLATE_CARPET, new Item.Properties()));
    public static final Item OLIVE_CARPET = register("olive_carpet", new BlockItem(DDBlocks.OLIVE_CARPET, new Item.Properties()));
    public static final Item AMBER_CARPET = register("amber_carpet", new BlockItem(DDBlocks.AMBER_CARPET, new Item.Properties()));
    public static final Item BEIGE_CARPET = register("beige_carpet", new BlockItem(DDBlocks.BEIGE_CARPET, new Item.Properties()));
    public static final Item TEAL_CARPET = register("teal_carpet", new BlockItem(DDBlocks.TEAL_CARPET, new Item.Properties()));
    public static final Item TURQUOISE_CARPET = register("turquoise_carpet", new BlockItem(DDBlocks.TURQUOISE_CARPET, new Item.Properties()));
    public static final Item AQUA_CARPET = register("aqua_carpet", new BlockItem(DDBlocks.AQUA_CARPET, new Item.Properties()));
    public static final Item VERDANT_CARPET = register("verdant_carpet", new BlockItem(DDBlocks.VERDANT_CARPET, new Item.Properties()));
    public static final Item FOREST_CARPET = register("forest_carpet", new BlockItem(DDBlocks.FOREST_CARPET, new Item.Properties()));
    public static final Item GINGER_CARPET = register("ginger_carpet", new BlockItem(DDBlocks.GINGER_CARPET, new Item.Properties()));
    public static final Item TAN_CARPET = register("tan_carpet", new BlockItem(DDBlocks.TAN_CARPET, new Item.Properties()));

    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(DyeDepot.MOD_ID, id), item);
    }
}
