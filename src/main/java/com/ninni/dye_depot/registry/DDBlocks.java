package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.DDShulkerBoxBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

@SuppressWarnings("unused")
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
    public static final Block TURQUOISE_TERRACOTTA = register("turquoise_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.TURQUOISE.getMapColor())));
    public static final Block AQUA_TERRACOTTA = register("aqua_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_TERRACOTTA = register("verdant_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_TERRACOTTA = register("forest_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_TERRACOTTA = register("ginger_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_TERRACOTTA = register("tan_terracotta", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_CONCRETE = register("maroon_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_CONCRETE = register("rose_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_CONCRETE = register("coral_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_CONCRETE = register("indigo_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_CONCRETE = register("navy_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_CONCRETE = register("slate_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_CONCRETE = register("olive_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_CONCRETE = register("amber_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_CONCRETE = register("beige_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_CONCRETE = register("teal_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block TURQUOISE_CONCRETE = register("turquoise_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.TURQUOISE.getMapColor())));
    public static final Block AQUA_CONCRETE = register("aqua_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_CONCRETE = register("verdant_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_CONCRETE = register("forest_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_CONCRETE = register("ginger_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_CONCRETE = register("tan_concrete", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_CONCRETE_POWDER = register("maroon_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_CONCRETE_POWDER = register("rose_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_CONCRETE_POWDER = register("coral_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_CONCRETE_POWDER = register("indigo_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_CONCRETE_POWDER = register("navy_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_CONCRETE_POWDER = register("slate_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_CONCRETE_POWDER = register("olive_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_CONCRETE_POWDER = register("amber_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_CONCRETE_POWDER = register("beige_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_CONCRETE_POWDER = register("teal_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block TURQUOISE_CONCRETE_POWDER = register("turquoise_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.TURQUOISE.getMapColor())));
    public static final Block AQUA_CONCRETE_POWDER = register("aqua_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_CONCRETE_POWDER = register("verdant_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_CONCRETE_POWDER = register("forest_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_CONCRETE_POWDER = register("ginger_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_CONCRETE_POWDER = register("tan_concrete_powder", new ConcretePowderBlock(MAROON_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).mapColor(DDDyes.TAN.getMapColor())));

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
    public static final Block TURQUOISE_GLAZED_TERRACOTTA = register("turquoise_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.TURQUOISE.getMapColor())));
    public static final Block AQUA_GLAZED_TERRACOTTA = register("aqua_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_GLAZED_TERRACOTTA = register("verdant_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_GLAZED_TERRACOTTA = register("forest_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_GLAZED_TERRACOTTA = register("ginger_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_GLAZED_TERRACOTTA = register("tan_glazed_terracotta", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_STAINED_GLASS = register("maroon_stained_glass", new StainedGlassBlock(DDDyes.MAROON.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_STAINED_GLASS = register("rose_stained_glass", new StainedGlassBlock(DDDyes.ROSE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_STAINED_GLASS = register("coral_stained_glass", new StainedGlassBlock(DDDyes.CORAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_STAINED_GLASS = register("indigo_stained_glass", new StainedGlassBlock(DDDyes.INDIGO.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_STAINED_GLASS = register("navy_stained_glass", new StainedGlassBlock(DDDyes.NAVY.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_STAINED_GLASS = register("slate_stained_glass", new StainedGlassBlock(DDDyes.SLATE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_STAINED_GLASS = register("olive_stained_glass", new StainedGlassBlock(DDDyes.OLIVE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_STAINED_GLASS = register("amber_stained_glass", new StainedGlassBlock(DDDyes.AMBER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_STAINED_GLASS = register("beige_stained_glass", new StainedGlassBlock(DDDyes.BEIGE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_STAINED_GLASS = register("teal_stained_glass", new StainedGlassBlock(DDDyes.TEAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block TURQUOISE_STAINED_GLASS = register("turquoise_stained_glass", new StainedGlassBlock(DDDyes.TURQUOISE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.TURQUOISE.getMapColor())));
    public static final Block AQUA_STAINED_GLASS = register("aqua_stained_glass", new StainedGlassBlock(DDDyes.AQUA.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_STAINED_GLASS = register("verdant_stained_glass", new StainedGlassBlock(DDDyes.VERDANT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_STAINED_GLASS = register("forest_stained_glass", new StainedGlassBlock(DDDyes.FOREST.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_STAINED_GLASS = register("ginger_stained_glass", new StainedGlassBlock(DDDyes.GINGER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_STAINED_GLASS = register("tan_stained_glass", new StainedGlassBlock(DDDyes.TAN.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_STAINED_GLASS_PANE = register("maroon_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.MAROON.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_STAINED_GLASS_PANE = register("rose_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.ROSE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_STAINED_GLASS_PANE = register("coral_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.CORAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_STAINED_GLASS_PANE = register("indigo_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.INDIGO.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_STAINED_GLASS_PANE = register("navy_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.NAVY.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_STAINED_GLASS_PANE = register("slate_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.SLATE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_STAINED_GLASS_PANE = register("olive_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.OLIVE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_STAINED_GLASS_PANE = register("amber_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.AMBER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_STAINED_GLASS_PANE = register("beige_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.BEIGE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_STAINED_GLASS_PANE = register("teal_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.TEAL.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block TURQUOISE_STAINED_GLASS_PANE = register("turquoise_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.TURQUOISE.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.TURQUOISE.getMapColor())));
    public static final Block AQUA_STAINED_GLASS_PANE = register("aqua_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.AQUA.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_STAINED_GLASS_PANE = register("verdant_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.VERDANT.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_STAINED_GLASS_PANE = register("forest_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.FOREST.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_STAINED_GLASS_PANE = register("ginger_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.GINGER.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_STAINED_GLASS_PANE = register("tan_stained_glass_pane", new StainedGlassPaneBlock(DDDyes.TAN.get(), FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_SHULKER_BOX = register("maroon_shulker_box", shulkerBox(DDDyes.MAROON.get(), FabricBlockSettings.create().mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_SHULKER_BOX = register("rose_shulker_box", shulkerBox(DDDyes.ROSE.get(), FabricBlockSettings.create().mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_SHULKER_BOX = register("coral_shulker_box", shulkerBox(DDDyes.CORAL.get(), FabricBlockSettings.create().mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_SHULKER_BOX = register("indigo_shulker_box", shulkerBox(DDDyes.INDIGO.get(), FabricBlockSettings.create().mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_SHULKER_BOX = register("navy_shulker_box", shulkerBox(DDDyes.NAVY.get(), FabricBlockSettings.create().mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_SHULKER_BOX = register("slate_shulker_box", shulkerBox(DDDyes.SLATE.get(), FabricBlockSettings.create().mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_SHULKER_BOX = register("olive_shulker_box", shulkerBox(DDDyes.OLIVE.get(), FabricBlockSettings.create().mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_SHULKER_BOX = register("amber_shulker_box", shulkerBox(DDDyes.AMBER.get(), FabricBlockSettings.create().mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_SHULKER_BOX = register("beige_shulker_box", shulkerBox(DDDyes.BEIGE.get(), FabricBlockSettings.create().mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_SHULKER_BOX = register("teal_shulker_box", shulkerBox(DDDyes.TEAL.get(), FabricBlockSettings.create().mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block TURQUOISE_SHULKER_BOX = register("turquoise_shulker_box", shulkerBox(DDDyes.TURQUOISE.get(), FabricBlockSettings.create().mapColor(DDDyes.TURQUOISE.getMapColor())));
    public static final Block AQUA_SHULKER_BOX = register("aqua_shulker_box", shulkerBox(DDDyes.AQUA.get(), FabricBlockSettings.create().mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_SHULKER_BOX = register("verdant_shulker_box", shulkerBox(DDDyes.VERDANT.get(), FabricBlockSettings.create().mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_SHULKER_BOX = register("forest_shulker_box", shulkerBox(DDDyes.FOREST.get(), FabricBlockSettings.create().mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_SHULKER_BOX = register("ginger_shulker_box", shulkerBox(DDDyes.GINGER.get(), FabricBlockSettings.create().mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_SHULKER_BOX = register("tan_shulker_box", shulkerBox(DDDyes.TAN.get(), FabricBlockSettings.create().mapColor(DDDyes.TAN.getMapColor())));

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
    public static final Block TURQUOISE_CANDLE = register("turquoise_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.TURQUOISE.getMapColor())));
    public static final Block AQUA_CANDLE = register("aqua_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_CANDLE = register("verdant_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_CANDLE = register("forest_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_CANDLE = register("ginger_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_CANDLE = register("tan_candle", new CandleBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE).mapColor(DDDyes.TAN.getMapColor())));

    public static final Block MAROON_CANDLE_CAKE = register("maroon_candle_cake", new CandleCakeBlock(MAROON_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.MAROON.getMapColor())));
    public static final Block ROSE_CANDLE_CAKE = register("rose_candle_cake", new CandleCakeBlock(ROSE_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.ROSE.getMapColor())));
    public static final Block CORAL_CANDLE_CAKE = register("coral_candle_cake", new CandleCakeBlock(CORAL_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.CORAL.getMapColor())));
    public static final Block INDIGO_CANDLE_CAKE = register("indigo_candle_cake", new CandleCakeBlock(INDIGO_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.INDIGO.getMapColor())));
    public static final Block NAVY_CANDLE_CAKE = register("navy_candle_cake", new CandleCakeBlock(NAVY_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.NAVY.getMapColor())));
    public static final Block SLATE_CANDLE_CAKE = register("slate_candle_cake", new CandleCakeBlock(SLATE_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.SLATE.getMapColor())));
    public static final Block OLIVE_CANDLE_CAKE = register("olive_candle_cake", new CandleCakeBlock(OLIVE_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.OLIVE.getMapColor())));
    public static final Block AMBER_CANDLE_CAKE = register("amber_candle_cake", new CandleCakeBlock(AMBER_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.AMBER.getMapColor())));
    public static final Block BEIGE_CANDLE_CAKE = register("beige_candle_cake", new CandleCakeBlock(BEIGE_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.BEIGE.getMapColor())));
    public static final Block TEAL_CANDLE_CAKE = register("teal_candle_cake", new CandleCakeBlock(TEAL_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.TEAL.getMapColor())));
    public static final Block TURQUOISE_CANDLE_CAKE = register("turquoise_candle_cake", new CandleCakeBlock(TURQUOISE_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.TURQUOISE.getMapColor())));
    public static final Block AQUA_CANDLE_CAKE = register("aqua_candle_cake", new CandleCakeBlock(AQUA_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.AQUA.getMapColor())));
    public static final Block VERDANT_CANDLE_CAKE = register("verdant_candle_cake", new CandleCakeBlock(VERDANT_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.VERDANT.getMapColor())));
    public static final Block FOREST_CANDLE_CAKE = register("forest_candle_cake", new CandleCakeBlock(FOREST_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.FOREST.getMapColor())));
    public static final Block GINGER_CANDLE_CAKE = register("ginger_candle_cake", new CandleCakeBlock(GINGER_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.GINGER.getMapColor())));
    public static final Block TAN_CANDLE_CAKE = register("tan_candle_cake", new CandleCakeBlock(TAN_CANDLE, FabricBlockSettings.copyOf(Blocks.WHITE_CANDLE_CAKE).mapColor(DDDyes.TAN.getMapColor())));

    private static ShulkerBoxBlock shulkerBox(DyeColor dyeColor, BlockBehaviour.Properties properties) {
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
