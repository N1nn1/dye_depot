package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WoolCarpetBlock;

public class DDBlocks {

    //TODO MapColors

    public static final Block MAROON_WOOL = register("maroon_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_WOOL = register("rose_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_WOOL = register("coral_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_WOOL = register("indigo_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_WOOL = register("navy_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_WOOL = register("slate_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_WOOL = register("olive_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_WOOL = register("amber_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_WOOL = register("beige_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_WOOL = register("teal_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block TURQUOISE_WOOL = register("turquoise_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.TURQUOISE.getMapColor())));
    public static final Block AQUA_WOOL = register("aqua_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_WOOL = register("verdant_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_WOOL = register("forest_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_WOOL = register("ginger_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_WOOL = register("tan_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_CARPET = register("maroon_carpet", new WoolCarpetBlock(DDDyes.MAROON.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_CARPET = register("rose_carpet", new WoolCarpetBlock(DDDyes.ROSE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_CARPET = register("coral_carpet", new WoolCarpetBlock(DDDyes.CORAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_CARPET = register("indigo_carpet", new WoolCarpetBlock(DDDyes.INDIGO.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_CARPET = register("navy_carpet", new WoolCarpetBlock(DDDyes.NAVY.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_CARPET = register("slate_carpet", new WoolCarpetBlock(DDDyes.SLATE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_CARPET = register("olive_carpet", new WoolCarpetBlock(DDDyes.OLIVE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_CARPET = register("amber_carpet", new WoolCarpetBlock(DDDyes.AMBER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_CARPET = register("beige_carpet", new WoolCarpetBlock(DDDyes.BEIGE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_CARPET = register("teal_carpet", new WoolCarpetBlock(DDDyes.TEAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block TURQUOISE_CARPET = register("turquoise_carpet", new WoolCarpetBlock(DDDyes.TURQUOISE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.TURQUOISE.getMapColor())));
    public static final Block AQUA_CARPET = register("aqua_carpet", new WoolCarpetBlock(DDDyes.AQUA.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_CARPET = register("verdant_carpet", new WoolCarpetBlock(DDDyes.VERDANT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_CARPET = register("forest_carpet", new WoolCarpetBlock(DDDyes.FOREST.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_CARPET = register("ginger_carpet", new WoolCarpetBlock(DDDyes.GINGER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_CARPET = register("tan_carpet", new WoolCarpetBlock(DDDyes.TAN.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.TAN.getMapColor())));
    
    private static Block register(String id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(DyeDepot.MOD_ID, id), block);
    }
}
