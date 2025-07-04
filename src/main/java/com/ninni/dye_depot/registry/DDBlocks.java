package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Map;

@SuppressWarnings("unused")
public class DDBlocks {

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
    public static final Block MINT_WOOL = register("mint_wool", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(DDDyes.MINT.getMapColor())));
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
    public static final Block MINT_CARPET = register("mint_carpet", new WoolCarpetBlock(DDDyes.MINT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.MINT.getMapColor())));
    public static final Block AQUA_CARPET = register("aqua_carpet", new WoolCarpetBlock(DDDyes.AQUA.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_CARPET = register("verdant_carpet", new WoolCarpetBlock(DDDyes.VERDANT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_CARPET = register("forest_carpet", new WoolCarpetBlock(DDDyes.FOREST.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_CARPET = register("ginger_carpet", new WoolCarpetBlock(DDDyes.GINGER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_CARPET = register("tan_carpet", new WoolCarpetBlock(DDDyes.TAN.get(), FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_TERRACOTTA = register("maroon_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_TERRACOTTA = register("rose_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_TERRACOTTA = register("coral_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_TERRACOTTA = register("indigo_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_TERRACOTTA = register("navy_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_TERRACOTTA = register("slate_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_TERRACOTTA = register("olive_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_TERRACOTTA = register("amber_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_TERRACOTTA = register("beige_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_TERRACOTTA = register("teal_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block MINT_TERRACOTTA = register("mint_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.MINT.getMapColor())));
    public static final Block AQUA_TERRACOTTA = register("aqua_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_TERRACOTTA = register("verdant_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_TERRACOTTA = register("forest_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_TERRACOTTA = register("ginger_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_TERRACOTTA = register("tan_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_CONCRETE = register("maroon_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.CRIMSON_HYPHAE)));
    public static final Block ROSE_CONCRETE = register("rose_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.COLOR_RED)));
    public static final Block CORAL_CONCRETE = register("coral_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.PODZOL)));
    public static final Block INDIGO_CONCRETE = register("indigo_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.WARPED_HYPHAE)));
    public static final Block NAVY_CONCRETE = register("navy_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block SLATE_CONCRETE = register("slate_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.COLOR_GRAY)));
    public static final Block OLIVE_CONCRETE = register("olive_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.COLOR_BROWN)));
    public static final Block AMBER_CONCRETE = register("amber_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.WOOD)));
    public static final Block BEIGE_CONCRETE = register("beige_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final Block TEAL_CONCRETE = register("teal_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.COLOR_GRAY)));
    public static final Block MINT_CONCRETE = register("mint_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.DEEPSLATE)));
    public static final Block AQUA_CONCRETE = register("aqua_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.WARPED_WART_BLOCK)));
    public static final Block VERDANT_CONCRETE = register("verdant_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block FOREST_CONCRETE = register("forest_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.COLOR_GREEN)));
    public static final Block GINGER_CONCRETE = register("ginger_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.NETHER)));
    public static final Block TAN_CONCRETE = register("tan_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(MapColor.DIRT)));

    public static final Block MAROON_CONCRETE_POWDER = register("maroon_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_CONCRETE_POWDER = register("rose_concrete_powder", new ConcretePowderBlock(ROSE_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_CONCRETE_POWDER = register("coral_concrete_powder", new ConcretePowderBlock(CORAL_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_CONCRETE_POWDER = register("indigo_concrete_powder", new ConcretePowderBlock(INDIGO_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_CONCRETE_POWDER = register("navy_concrete_powder", new ConcretePowderBlock(NAVY_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_CONCRETE_POWDER = register("slate_concrete_powder", new ConcretePowderBlock(SLATE_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_CONCRETE_POWDER = register("olive_concrete_powder", new ConcretePowderBlock(OLIVE_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_CONCRETE_POWDER = register("amber_concrete_powder", new ConcretePowderBlock(AMBER_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_CONCRETE_POWDER = register("beige_concrete_powder", new ConcretePowderBlock(BEIGE_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_CONCRETE_POWDER = register("teal_concrete_powder", new ConcretePowderBlock(TEAL_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block MINT_CONCRETE_POWDER = register("mint_concrete_powder", new ConcretePowderBlock(MINT_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.MINT.getMapColor())));
    public static final Block AQUA_CONCRETE_POWDER = register("aqua_concrete_powder", new ConcretePowderBlock(AQUA_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_CONCRETE_POWDER = register("verdant_concrete_powder", new ConcretePowderBlock(VERDANT_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_CONCRETE_POWDER = register("forest_concrete_powder", new ConcretePowderBlock(FOREST_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_CONCRETE_POWDER = register("ginger_concrete_powder", new ConcretePowderBlock(GINGER_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_CONCRETE_POWDER = register("tan_concrete_powder", new ConcretePowderBlock(TAN_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_GLAZED_TERRACOTTA = register("maroon_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_GLAZED_TERRACOTTA = register("rose_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_GLAZED_TERRACOTTA = register("coral_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_GLAZED_TERRACOTTA = register("indigo_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_GLAZED_TERRACOTTA = register("navy_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_GLAZED_TERRACOTTA = register("slate_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_GLAZED_TERRACOTTA = register("olive_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_GLAZED_TERRACOTTA = register("amber_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_GLAZED_TERRACOTTA = register("beige_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_GLAZED_TERRACOTTA = register("teal_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block MINT_GLAZED_TERRACOTTA = register("mint_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.MINT.getMapColor())));
    public static final Block AQUA_GLAZED_TERRACOTTA = register("aqua_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_GLAZED_TERRACOTTA = register("verdant_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_GLAZED_TERRACOTTA = register("forest_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_GLAZED_TERRACOTTA = register("ginger_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_GLAZED_TERRACOTTA = register("tan_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_STAINED_GLASS = register("maroon_stained_glass", new StainedGlassBlock(DDDyes.MAROON.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block ROSE_STAINED_GLASS = register("rose_stained_glass", new StainedGlassBlock(DDDyes.ROSE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block CORAL_STAINED_GLASS = register("coral_stained_glass", new StainedGlassBlock(DDDyes.CORAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block INDIGO_STAINED_GLASS = register("indigo_stained_glass", new StainedGlassBlock(DDDyes.INDIGO.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block NAVY_STAINED_GLASS = register("navy_stained_glass", new StainedGlassBlock(DDDyes.NAVY.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block SLATE_STAINED_GLASS = register("slate_stained_glass", new StainedGlassBlock(DDDyes.SLATE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block OLIVE_STAINED_GLASS = register("olive_stained_glass", new StainedGlassBlock(DDDyes.OLIVE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block AMBER_STAINED_GLASS = register("amber_stained_glass", new StainedGlassBlock(DDDyes.AMBER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block BEIGE_STAINED_GLASS = register("beige_stained_glass", new StainedGlassBlock(DDDyes.BEIGE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block TEAL_STAINED_GLASS = register("teal_stained_glass", new StainedGlassBlock(DDDyes.TEAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block MINT_STAINED_GLASS = register("mint_stained_glass", new StainedGlassBlock(DDDyes.MINT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block AQUA_STAINED_GLASS = register("aqua_stained_glass", new StainedGlassBlock(DDDyes.AQUA.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block VERDANT_STAINED_GLASS = register("verdant_stained_glass", new StainedGlassBlock(DDDyes.VERDANT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block FOREST_STAINED_GLASS = register("forest_stained_glass", new StainedGlassBlock(DDDyes.FOREST.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block GINGER_STAINED_GLASS = register("ginger_stained_glass", new StainedGlassBlock(DDDyes.GINGER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));
    public static final Block TAN_STAINED_GLASS = register("tan_stained_glass", new StainedGlassBlock(DDDyes.TAN.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));

    public static final Block MAROON_STAINED_GLASS_PANE = register("maroon_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.MAROON.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block ROSE_STAINED_GLASS_PANE = register("rose_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.ROSE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block CORAL_STAINED_GLASS_PANE = register("coral_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.CORAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block INDIGO_STAINED_GLASS_PANE = register("indigo_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.INDIGO.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block NAVY_STAINED_GLASS_PANE = register("navy_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.NAVY.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block SLATE_STAINED_GLASS_PANE = register("slate_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.SLATE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block OLIVE_STAINED_GLASS_PANE = register("olive_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.OLIVE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block AMBER_STAINED_GLASS_PANE = register("amber_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.AMBER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block BEIGE_STAINED_GLASS_PANE = register("beige_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.BEIGE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block TEAL_STAINED_GLASS_PANE = register("teal_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.TEAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block MINT_STAINED_GLASS_PANE = register("mint_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.MINT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block AQUA_STAINED_GLASS_PANE = register("aqua_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.AQUA.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block VERDANT_STAINED_GLASS_PANE = register("verdant_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.VERDANT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block FOREST_STAINED_GLASS_PANE = register("forest_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.FOREST.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block GINGER_STAINED_GLASS_PANE = register("ginger_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.GINGER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final Block TAN_STAINED_GLASS_PANE = register("tan_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.TAN.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));

    public static final Map<DyeColor, Block> SHULKER_BOXES = DDDyes.createDyed(dye ->
            register(dye + "_shulker_box", shulkerBox(dye, FabricBlockSettings.create().mapColor(dye.getMapColor())))
    );

    public static final Block MAROON_CANDLE = register("maroon_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_CANDLE = register("rose_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_CANDLE = register("coral_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_CANDLE = register("indigo_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_CANDLE = register("navy_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_CANDLE = register("slate_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_CANDLE = register("olive_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_CANDLE = register("amber_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_CANDLE = register("beige_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_CANDLE = register("teal_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block MINT_CANDLE = register("mint_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.MINT.getMapColor())));
    public static final Block AQUA_CANDLE = register("aqua_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_CANDLE = register("verdant_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_CANDLE = register("forest_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_CANDLE = register("ginger_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_CANDLE = register("tan_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_CANDLE_CAKE = register("maroon_candle_cake", new CandleCakeBlock(MAROON_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block ROSE_CANDLE_CAKE = register("rose_candle_cake", new CandleCakeBlock(ROSE_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block CORAL_CANDLE_CAKE = register("coral_candle_cake", new CandleCakeBlock(CORAL_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block INDIGO_CANDLE_CAKE = register("indigo_candle_cake", new CandleCakeBlock(INDIGO_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block NAVY_CANDLE_CAKE = register("navy_candle_cake", new CandleCakeBlock(NAVY_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block SLATE_CANDLE_CAKE = register("slate_candle_cake", new CandleCakeBlock(SLATE_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block OLIVE_CANDLE_CAKE = register("olive_candle_cake", new CandleCakeBlock(OLIVE_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block AMBER_CANDLE_CAKE = register("amber_candle_cake", new CandleCakeBlock(AMBER_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block BEIGE_CANDLE_CAKE = register("beige_candle_cake", new CandleCakeBlock(BEIGE_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block TEAL_CANDLE_CAKE = register("teal_candle_cake", new CandleCakeBlock(TEAL_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block MINT_CANDLE_CAKE = register("mint_candle_cake", new CandleCakeBlock(MINT_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block AQUA_CANDLE_CAKE = register("aqua_candle_cake", new CandleCakeBlock(AQUA_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block VERDANT_CANDLE_CAKE = register("verdant_candle_cake", new CandleCakeBlock(VERDANT_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block FOREST_CANDLE_CAKE = register("forest_candle_cake", new CandleCakeBlock(FOREST_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block GINGER_CANDLE_CAKE = register("ginger_candle_cake", new CandleCakeBlock(GINGER_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));
    public static final Block TAN_CANDLE_CAKE = register("tan_candle_cake", new CandleCakeBlock(TAN_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE)));

    public static final Block MAROON_BANNER = register("maroon_banner", new DDBannerBlock(DDDyes.MAROON.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block ROSE_BANNER = register("rose_banner", new DDBannerBlock(DDDyes.ROSE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block CORAL_BANNER = register("coral_banner", new DDBannerBlock(DDDyes.CORAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block INDIGO_BANNER = register("indigo_banner", new DDBannerBlock(DDDyes.INDIGO.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block NAVY_BANNER = register("navy_banner", new DDBannerBlock(DDDyes.NAVY.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block SLATE_BANNER = register("slate_banner", new DDBannerBlock(DDDyes.SLATE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block OLIVE_BANNER = register("olive_banner", new DDBannerBlock(DDDyes.OLIVE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block AMBER_BANNER = register("amber_banner", new DDBannerBlock(DDDyes.AMBER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block BEIGE_BANNER = register("beige_banner", new DDBannerBlock(DDDyes.BEIGE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block TEAL_BANNER = register("teal_banner", new DDBannerBlock(DDDyes.TEAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block MINT_BANNER = register("mint_banner", new DDBannerBlock(DDDyes.MINT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block AQUA_BANNER = register("aqua_banner", new DDBannerBlock(DDDyes.AQUA.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block VERDANT_BANNER = register("verdant_banner", new DDBannerBlock(DDDyes.VERDANT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block FOREST_BANNER = register("forest_banner", new DDBannerBlock(DDDyes.FOREST.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block GINGER_BANNER = register("ginger_banner", new DDBannerBlock(DDDyes.GINGER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block TAN_BANNER = register("tan_banner", new DDBannerBlock(DDDyes.TAN.get(), FabricBlockSettings.copyOf(Blocks.WHITE_BANNER)));
    public static final Block MAROON_WALL_BANNER = register("maroon_wall_banner", new DDWallBannerBlock(DDDyes.MAROON.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(MAROON_BANNER)));
    public static final Block ROSE_WALL_BANNER = register("rose_wall_banner", new DDWallBannerBlock(DDDyes.ROSE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(ROSE_BANNER)));
    public static final Block CORAL_WALL_BANNER = register("coral_wall_banner", new DDWallBannerBlock(DDDyes.CORAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(CORAL_BANNER)));
    public static final Block INDIGO_WALL_BANNER = register("indigo_wall_banner", new DDWallBannerBlock(DDDyes.INDIGO.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(INDIGO_BANNER)));
    public static final Block NAVY_WALL_BANNER = register("navy_wall_banner", new DDWallBannerBlock(DDDyes.NAVY.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(NAVY_BANNER)));
    public static final Block SLATE_WALL_BANNER = register("slate_wall_banner", new DDWallBannerBlock(DDDyes.SLATE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(SLATE_BANNER)));
    public static final Block OLIVE_WALL_BANNER = register("olive_wall_banner", new DDWallBannerBlock(DDDyes.OLIVE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(OLIVE_BANNER)));
    public static final Block AMBER_WALL_BANNER = register("amber_wall_banner", new DDWallBannerBlock(DDDyes.AMBER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(AMBER_BANNER)));
    public static final Block BEIGE_WALL_BANNER = register("beige_wall_banner", new DDWallBannerBlock(DDDyes.BEIGE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(BEIGE_BANNER)));
    public static final Block TEAL_WALL_BANNER = register("teal_wall_banner", new DDWallBannerBlock(DDDyes.TEAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(TEAL_BANNER)));
    public static final Block MINT_WALL_BANNER = register("mint_wall_banner", new DDWallBannerBlock(DDDyes.MINT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(MINT_BANNER)));
    public static final Block AQUA_WALL_BANNER = register("aqua_wall_banner", new DDWallBannerBlock(DDDyes.AQUA.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(AQUA_BANNER)));
    public static final Block VERDANT_WALL_BANNER = register("verdant_wall_banner", new DDWallBannerBlock(DDDyes.VERDANT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(VERDANT_BANNER)));
    public static final Block FOREST_WALL_BANNER = register("forest_wall_banner", new DDWallBannerBlock(DDDyes.FOREST.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(FOREST_BANNER)));
    public static final Block GINGER_WALL_BANNER = register("ginger_wall_banner", new DDWallBannerBlock(DDDyes.GINGER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(GINGER_BANNER)));
    public static final Block TAN_WALL_BANNER = register("tan_wall_banner", new DDWallBannerBlock(DDDyes.TAN.get(), FabricBlockSettings.copyOf(Blocks.WHITE_WALL_BANNER).dropsLike(TAN_BANNER)));

    public static final Block MAROON_BED = register("maroon_bed", bed(DDDyes.MAROON.get()));
    public static final Block ROSE_BED = register("rose_bed", bed(DDDyes.ROSE.get()));
    public static final Block CORAL_BED = register("coral_bed", bed(DDDyes.CORAL.get()));
    public static final Block INDIGO_BED = register("indigo_bed", bed(DDDyes.INDIGO.get()));
    public static final Block NAVY_BED = register("navy_bed", bed(DDDyes.NAVY.get()));
    public static final Block SLATE_BED = register("slate_bed", bed(DDDyes.SLATE.get()));
    public static final Block OLIVE_BED = register("olive_bed", bed(DDDyes.OLIVE.get()));
    public static final Block AMBER_BED = register("amber_bed", bed(DDDyes.AMBER.get()));
    public static final Block BEIGE_BED = register("beige_bed", bed(DDDyes.BEIGE.get()));
    public static final Block TEAL_BED = register("teal_bed", bed(DDDyes.TEAL.get()));
    public static final Block MINT_BED = register("mint_bed", bed(DDDyes.MINT.get()));
    public static final Block AQUA_BED = register("aqua_bed", bed(DDDyes.AQUA.get()));
    public static final Block VERDANT_BED = register("verdant_bed", bed(DDDyes.VERDANT.get()));
    public static final Block FOREST_BED = register("forest_bed", bed(DDDyes.FOREST.get()));
    public static final Block GINGER_BED = register("ginger_bed", bed(DDDyes.GINGER.get()));
    public static final Block TAN_BED = register("tan_bed", bed(DDDyes.TAN.get()));

    public static final Block MAROON_DYE_BASKET = register("maroon_dye_basket", new DyeBasketBlock(DDDyes.MAROON.get(), FabricBlockSettings.create().strength(0.8f).sound(SoundType.WOOL).ignitedByLava().mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_DYE_BASKET = register("rose_dye_basket", new DyeBasketBlock(DDDyes.ROSE.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_DYE_BASKET = register("coral_dye_basket", new DyeBasketBlock(DDDyes.CORAL.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_DYE_BASKET = register("indigo_dye_basket", new DyeBasketBlock(DDDyes.INDIGO.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_DYE_BASKET = register("navy_dye_basket", new DyeBasketBlock(DDDyes.NAVY.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_DYE_BASKET = register("slate_dye_basket", new DyeBasketBlock(DDDyes.SLATE.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_DYE_BASKET = register("olive_dye_basket", new DyeBasketBlock(DDDyes.OLIVE.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_DYE_BASKET = register("amber_dye_basket", new DyeBasketBlock(DDDyes.AMBER.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_DYE_BASKET = register("beige_dye_basket", new DyeBasketBlock(DDDyes.BEIGE.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_DYE_BASKET = register("teal_dye_basket", new DyeBasketBlock(DDDyes.TEAL.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block MINT_DYE_BASKET = register("mint_dye_basket", new DyeBasketBlock(DDDyes.MINT.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.MINT.getMapColor())));
    public static final Block AQUA_DYE_BASKET = register("aqua_dye_basket", new DyeBasketBlock(DDDyes.AQUA.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_DYE_BASKET = register("verdant_dye_basket", new DyeBasketBlock(DDDyes.VERDANT.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_DYE_BASKET = register("forest_dye_basket", new DyeBasketBlock(DDDyes.FOREST.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_DYE_BASKET = register("ginger_dye_basket", new DyeBasketBlock(DDDyes.GINGER.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_DYE_BASKET = register("tan_dye_basket", new DyeBasketBlock(DDDyes.TAN.get(), FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DDDyes.TAN.getMapColor())));
    public static final Block WHITE_DYE_BASKET = register("white_dye_basket", new DyeBasketBlock(DyeColor.WHITE, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.WHITE.getMapColor())));
    public static final Block LIGHT_GRAY_DYE_BASKET = register("light_gray_dye_basket", new DyeBasketBlock(DyeColor.LIGHT_GRAY, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.LIGHT_GRAY.getMapColor())));
    public static final Block GRAY_DYE_BASKET = register("gray_dye_basket", new DyeBasketBlock(DyeColor.GRAY, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.GRAY.getMapColor())));
    public static final Block BLACK_DYE_BASKET = register("black_dye_basket", new DyeBasketBlock(DyeColor.BLACK, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.BLACK.getMapColor())));
    public static final Block BROWN_DYE_BASKET = register("brown_dye_basket", new DyeBasketBlock(DyeColor.BROWN, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.BROWN.getMapColor())));
    public static final Block RED_DYE_BASKET = register("red_dye_basket", new DyeBasketBlock(DyeColor.RED, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.RED.getMapColor())));
    public static final Block ORANGE_DYE_BASKET = register("orange_dye_basket", new DyeBasketBlock(DyeColor.ORANGE, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.ORANGE.getMapColor())));
    public static final Block YELLOW_DYE_BASKET = register("yellow_dye_basket", new DyeBasketBlock(DyeColor.YELLOW, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.YELLOW.getMapColor())));
    public static final Block LIME_DYE_BASKET = register("lime_dye_basket", new DyeBasketBlock(DyeColor.LIME, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.LIME.getMapColor())));
    public static final Block CYAN_DYE_BASKET = register("cyan_dye_basket", new DyeBasketBlock(DyeColor.CYAN, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.CYAN.getMapColor())));
    public static final Block GREEN_DYE_BASKET = register("green_dye_basket", new DyeBasketBlock(DyeColor.GREEN, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.GREEN.getMapColor())));
    public static final Block BLUE_DYE_BASKET = register("blue_dye_basket", new DyeBasketBlock(DyeColor.BLUE, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.BLUE.getMapColor())));
    public static final Block LIGHT_BLUE_DYE_BASKET = register("light_blue_dye_basket", new DyeBasketBlock(DyeColor.LIGHT_BLUE, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.LIGHT_BLUE.getMapColor())));
    public static final Block PURPLE_DYE_BASKET = register("purple_dye_basket", new DyeBasketBlock(DyeColor.PURPLE, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.PURPLE.getMapColor())));
    public static final Block MAGENTA_DYE_BASKET = register("magenta_dye_basket", new DyeBasketBlock(DyeColor.MAGENTA, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.MAGENTA.getMapColor())));
    public static final Block PINK_DYE_BASKET = register("pink_dye_basket", new DyeBasketBlock(DyeColor.PINK, FabricBlockSettings.copyOf(MAROON_DYE_BASKET).mapColor(DyeColor.PINK.getMapColor())));

    private static DDBedBlock bed(DyeColor dyeColor) {
        return new DDBedBlock(dyeColor, BlockBehaviour.Properties.of().mapColor((blockState) -> blockState.getValue(DDBedBlock.PART) == BedPart.FOOT ? dyeColor.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }

    private static DDShulkerBoxBlock shulkerBox(DyeColor dyeColor, BlockBehaviour.Properties properties) {
        BlockBehaviour.StatePredicate statePredicate = (blockState, blockGetter, blockPos) -> {
            BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
            if (blockEntity instanceof ShulkerBoxBlockEntity shulkerBoxBlockEntity) return shulkerBoxBlockEntity.isClosed();
            else return true;
        };
        return new DDShulkerBoxBlock(dyeColor, properties.forceSolidOn().strength(2.0F).dynamicShape().noOcclusion().isSuffocating(statePredicate).isViewBlocking(statePredicate).pushReaction(PushReaction.DESTROY).isRedstoneConductor(Blocks::always));
    }
    
    private static Block register(String id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(DyeDepot.MOD_ID, id), block);
    }
}
