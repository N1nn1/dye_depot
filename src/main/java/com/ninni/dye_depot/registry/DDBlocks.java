package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.DDBedBlock;
import com.ninni.dye_depot.block.DDShulkerBoxBlock;
import com.ninni.dye_depot.block.DDShulkerBoxBlockEntity;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.WallBannerBlock;
import net.minecraft.world.level.block.WoolCarpetBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = DyeDepot.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DDBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DyeDepot.MOD_ID);

    public static final RegistryObject<Block> MAROON_WOOL = register("maroon_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.MAROON)));
    public static final RegistryObject<Block> ROSE_WOOL = register("rose_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.ROSE)));
    public static final RegistryObject<Block> CORAL_WOOL = register("coral_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.CORAL)));
    public static final RegistryObject<Block> INDIGO_WOOL = register("indigo_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.INDIGO)));
    public static final RegistryObject<Block> NAVY_WOOL = register("navy_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.NAVY)));
    public static final RegistryObject<Block> SLATE_WOOL = register("slate_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.SLATE)));
    public static final RegistryObject<Block> OLIVE_WOOL = register("olive_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.OLIVE)));
    public static final RegistryObject<Block> AMBER_WOOL = register("amber_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.AMBER)));
    public static final RegistryObject<Block> BEIGE_WOOL = register("beige_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.BEIGE)));
    public static final RegistryObject<Block> TEAL_WOOL = register("teal_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.TEAL)));
    public static final RegistryObject<Block> MINT_WOOL = register("mint_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.MINT)));
    public static final RegistryObject<Block> AQUA_WOOL = register("aqua_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.AQUA)));
    public static final RegistryObject<Block> VERDANT_WOOL = register("verdant_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.VERDANT)));
    public static final RegistryObject<Block> FOREST_WOOL = register("forest_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.FOREST)));
    public static final RegistryObject<Block> GINGER_WOOL = register("ginger_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.GINGER)));
    public static final RegistryObject<Block> TAN_WOOL = register("tan_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(DDDyeKeys.TAN)));

    public static final RegistryObject<Block> MAROON_CARPET = register("maroon_carpet", () -> new WoolCarpetBlock(DDDyeKeys.MAROON, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.MAROON)));
    public static final RegistryObject<Block> ROSE_CARPET = register("rose_carpet", () -> new WoolCarpetBlock(DDDyeKeys.ROSE, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.ROSE)));
    public static final RegistryObject<Block> CORAL_CARPET = register("coral_carpet", () -> new WoolCarpetBlock(DDDyeKeys.CORAL, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.CORAL)));
    public static final RegistryObject<Block> INDIGO_CARPET = register("indigo_carpet", () -> new WoolCarpetBlock(DDDyeKeys.INDIGO, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.INDIGO)));
    public static final RegistryObject<Block> NAVY_CARPET = register("navy_carpet", () -> new WoolCarpetBlock(DDDyeKeys.NAVY, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.NAVY)));
    public static final RegistryObject<Block> SLATE_CARPET = register("slate_carpet", () -> new WoolCarpetBlock(DDDyeKeys.SLATE, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.SLATE)));
    public static final RegistryObject<Block> OLIVE_CARPET = register("olive_carpet", () -> new WoolCarpetBlock(DDDyeKeys.OLIVE, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.OLIVE)));
    public static final RegistryObject<Block> AMBER_CARPET = register("amber_carpet", () -> new WoolCarpetBlock(DDDyeKeys.AMBER, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.AMBER)));
    public static final RegistryObject<Block> BEIGE_CARPET = register("beige_carpet", () -> new WoolCarpetBlock(DDDyeKeys.BEIGE, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.BEIGE)));
    public static final RegistryObject<Block> TEAL_CARPET = register("teal_carpet", () -> new WoolCarpetBlock(DDDyeKeys.TEAL, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.TEAL)));
    public static final RegistryObject<Block> MINT_CARPET = register("mint_carpet", () -> new WoolCarpetBlock(DDDyeKeys.MINT, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.MINT)));
    public static final RegistryObject<Block> AQUA_CARPET = register("aqua_carpet", () -> new WoolCarpetBlock(DDDyeKeys.AQUA, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.AQUA)));
    public static final RegistryObject<Block> VERDANT_CARPET = register("verdant_carpet", () -> new WoolCarpetBlock(DDDyeKeys.VERDANT, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.VERDANT)));
    public static final RegistryObject<Block> FOREST_CARPET = register("forest_carpet", () -> new WoolCarpetBlock(DDDyeKeys.FOREST, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.FOREST)));
    public static final RegistryObject<Block> GINGER_CARPET = register("ginger_carpet", () -> new WoolCarpetBlock(DDDyeKeys.GINGER, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.GINGER)));
    public static final RegistryObject<Block> TAN_CARPET = register("tan_carpet", () -> new WoolCarpetBlock(DDDyeKeys.TAN, BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(DDDyeKeys.TAN)));

    public static final RegistryObject<Block> MAROON_TERRACOTTA = register("maroon_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.MAROON)));
    public static final RegistryObject<Block> ROSE_TERRACOTTA = register("rose_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.ROSE)));
    public static final RegistryObject<Block> CORAL_TERRACOTTA = register("coral_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.CORAL)));
    public static final RegistryObject<Block> INDIGO_TERRACOTTA = register("indigo_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.INDIGO)));
    public static final RegistryObject<Block> NAVY_TERRACOTTA = register("navy_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.NAVY)));
    public static final RegistryObject<Block> SLATE_TERRACOTTA = register("slate_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.SLATE)));
    public static final RegistryObject<Block> OLIVE_TERRACOTTA = register("olive_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.OLIVE)));
    public static final RegistryObject<Block> AMBER_TERRACOTTA = register("amber_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.AMBER)));
    public static final RegistryObject<Block> BEIGE_TERRACOTTA = register("beige_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.BEIGE)));
    public static final RegistryObject<Block> TEAL_TERRACOTTA = register("teal_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.TEAL)));
    public static final RegistryObject<Block> MINT_TERRACOTTA = register("mint_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.MINT)));
    public static final RegistryObject<Block> AQUA_TERRACOTTA = register("aqua_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.AQUA)));
    public static final RegistryObject<Block> VERDANT_TERRACOTTA = register("verdant_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.VERDANT)));
    public static final RegistryObject<Block> FOREST_TERRACOTTA = register("forest_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.FOREST)));
    public static final RegistryObject<Block> GINGER_TERRACOTTA = register("ginger_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.GINGER)));
    public static final RegistryObject<Block> TAN_TERRACOTTA = register("tan_terracotta", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA).mapColor(DDDyeKeys.TAN)));

    public static final RegistryObject<Block> MAROON_CONCRETE = register("maroon_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.CRIMSON_HYPHAE)));
    public static final RegistryObject<Block> ROSE_CONCRETE = register("rose_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> CORAL_CONCRETE = register("coral_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.PODZOL)));
    public static final RegistryObject<Block> INDIGO_CONCRETE = register("indigo_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.WARPED_HYPHAE)));
    public static final RegistryObject<Block> NAVY_CONCRETE = register("navy_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistryObject<Block> SLATE_CONCRETE = register("slate_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> OLIVE_CONCRETE = register("olive_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> AMBER_CONCRETE = register("amber_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.WOOD)));
    public static final RegistryObject<Block> BEIGE_CONCRETE = register("beige_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistryObject<Block> TEAL_CONCRETE = register("teal_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> MINT_CONCRETE = register("mint_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.DEEPSLATE)));
    public static final RegistryObject<Block> AQUA_CONCRETE = register("aqua_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.WARPED_WART_BLOCK)));
    public static final RegistryObject<Block> VERDANT_CONCRETE = register("verdant_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final RegistryObject<Block> FOREST_CONCRETE = register("forest_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> GINGER_CONCRETE = register("ginger_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.NETHER)));
    public static final RegistryObject<Block> TAN_CONCRETE = register("tan_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.DIRT)));

    public static final RegistryObject<Block> MAROON_CONCRETE_POWDER = register("maroon_concrete_powder", () -> new ConcretePowderBlock(MAROON_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.MAROON)));
    public static final RegistryObject<Block> ROSE_CONCRETE_POWDER = register("rose_concrete_powder", () -> new ConcretePowderBlock(ROSE_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.ROSE)));
    public static final RegistryObject<Block> CORAL_CONCRETE_POWDER = register("coral_concrete_powder", () -> new ConcretePowderBlock(CORAL_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.CORAL)));
    public static final RegistryObject<Block> INDIGO_CONCRETE_POWDER = register("indigo_concrete_powder", () -> new ConcretePowderBlock(INDIGO_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.INDIGO)));
    public static final RegistryObject<Block> NAVY_CONCRETE_POWDER = register("navy_concrete_powder", () -> new ConcretePowderBlock(NAVY_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.NAVY)));
    public static final RegistryObject<Block> SLATE_CONCRETE_POWDER = register("slate_concrete_powder", () -> new ConcretePowderBlock(SLATE_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.SLATE)));
    public static final RegistryObject<Block> OLIVE_CONCRETE_POWDER = register("olive_concrete_powder", () -> new ConcretePowderBlock(OLIVE_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.OLIVE)));
    public static final RegistryObject<Block> AMBER_CONCRETE_POWDER = register("amber_concrete_powder", () -> new ConcretePowderBlock(AMBER_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.AMBER)));
    public static final RegistryObject<Block> BEIGE_CONCRETE_POWDER = register("beige_concrete_powder", () -> new ConcretePowderBlock(BEIGE_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.BEIGE)));
    public static final RegistryObject<Block> TEAL_CONCRETE_POWDER = register("teal_concrete_powder", () -> new ConcretePowderBlock(TEAL_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.TEAL)));
    public static final RegistryObject<Block> MINT_CONCRETE_POWDER = register("mint_concrete_powder", () -> new ConcretePowderBlock(MINT_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.MINT)));
    public static final RegistryObject<Block> AQUA_CONCRETE_POWDER = register("aqua_concrete_powder", () -> new ConcretePowderBlock(AQUA_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.AQUA)));
    public static final RegistryObject<Block> VERDANT_CONCRETE_POWDER = register("verdant_concrete_powder", () -> new ConcretePowderBlock(VERDANT_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.VERDANT)));
    public static final RegistryObject<Block> FOREST_CONCRETE_POWDER = register("forest_concrete_powder", () -> new ConcretePowderBlock(FOREST_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.FOREST)));
    public static final RegistryObject<Block> GINGER_CONCRETE_POWDER = register("ginger_concrete_powder", () -> new ConcretePowderBlock(GINGER_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.GINGER)));
    public static final RegistryObject<Block> TAN_CONCRETE_POWDER = register("tan_concrete_powder", () -> new ConcretePowderBlock(TAN_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER).mapColor(DDDyeKeys.TAN)));

    public static final RegistryObject<Block> MAROON_GLAZED_TERRACOTTA = register("maroon_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.MAROON)));
    public static final RegistryObject<Block> ROSE_GLAZED_TERRACOTTA = register("rose_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.ROSE)));
    public static final RegistryObject<Block> CORAL_GLAZED_TERRACOTTA = register("coral_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.CORAL)));
    public static final RegistryObject<Block> INDIGO_GLAZED_TERRACOTTA = register("indigo_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.INDIGO)));
    public static final RegistryObject<Block> NAVY_GLAZED_TERRACOTTA = register("navy_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.NAVY)));
    public static final RegistryObject<Block> SLATE_GLAZED_TERRACOTTA = register("slate_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.SLATE)));
    public static final RegistryObject<Block> OLIVE_GLAZED_TERRACOTTA = register("olive_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.OLIVE)));
    public static final RegistryObject<Block> AMBER_GLAZED_TERRACOTTA = register("amber_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.AMBER)));
    public static final RegistryObject<Block> BEIGE_GLAZED_TERRACOTTA = register("beige_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.BEIGE)));
    public static final RegistryObject<Block> TEAL_GLAZED_TERRACOTTA = register("teal_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.TEAL)));
    public static final RegistryObject<Block> MINT_GLAZED_TERRACOTTA = register("mint_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.MINT)));
    public static final RegistryObject<Block> AQUA_GLAZED_TERRACOTTA = register("aqua_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.AQUA)));
    public static final RegistryObject<Block> VERDANT_GLAZED_TERRACOTTA = register("verdant_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.VERDANT)));
    public static final RegistryObject<Block> FOREST_GLAZED_TERRACOTTA = register("forest_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.FOREST)));
    public static final RegistryObject<Block> GINGER_GLAZED_TERRACOTTA = register("ginger_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.GINGER)));
    public static final RegistryObject<Block> TAN_GLAZED_TERRACOTTA = register("tan_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(DDDyeKeys.TAN)));

    public static final RegistryObject<Block> MAROON_STAINED_GLASS = register("maroon_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.MAROON, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> ROSE_STAINED_GLASS = register("rose_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.ROSE, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> CORAL_STAINED_GLASS = register("coral_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.CORAL, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> INDIGO_STAINED_GLASS = register("indigo_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.INDIGO, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> NAVY_STAINED_GLASS = register("navy_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.NAVY, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> SLATE_STAINED_GLASS = register("slate_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.SLATE, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> OLIVE_STAINED_GLASS = register("olive_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.OLIVE, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> AMBER_STAINED_GLASS = register("amber_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.AMBER, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> BEIGE_STAINED_GLASS = register("beige_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.BEIGE, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> TEAL_STAINED_GLASS = register("teal_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.TEAL, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> MINT_STAINED_GLASS = register("mint_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.MINT, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> AQUA_STAINED_GLASS = register("aqua_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.AQUA, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> VERDANT_STAINED_GLASS = register("verdant_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.VERDANT, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> FOREST_STAINED_GLASS = register("forest_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.FOREST, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> GINGER_STAINED_GLASS = register("ginger_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.GINGER, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> TAN_STAINED_GLASS = register("tan_stained_glass", () -> new StainedGlassBlock(DDDyeKeys.TAN, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));

    public static final RegistryObject<Block> MAROON_STAINED_GLASS_PANE = register("maroon_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.MAROON, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> ROSE_STAINED_GLASS_PANE = register("rose_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.ROSE, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> CORAL_STAINED_GLASS_PANE = register("coral_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.CORAL, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> INDIGO_STAINED_GLASS_PANE = register("indigo_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.INDIGO, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> NAVY_STAINED_GLASS_PANE = register("navy_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.NAVY, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> SLATE_STAINED_GLASS_PANE = register("slate_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.SLATE, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> OLIVE_STAINED_GLASS_PANE = register("olive_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.OLIVE, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> AMBER_STAINED_GLASS_PANE = register("amber_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.AMBER, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> BEIGE_STAINED_GLASS_PANE = register("beige_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.BEIGE, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> TEAL_STAINED_GLASS_PANE = register("teal_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.TEAL, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> MINT_STAINED_GLASS_PANE = register("mint_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.MINT, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> AQUA_STAINED_GLASS_PANE = register("aqua_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.AQUA, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> VERDANT_STAINED_GLASS_PANE = register("verdant_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.VERDANT, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> FOREST_STAINED_GLASS_PANE = register("forest_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.FOREST, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> GINGER_STAINED_GLASS_PANE = register("ginger_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.GINGER, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> TAN_STAINED_GLASS_PANE = register("tan_stained_glass_pane", () -> new StainedGlassPaneBlock(DDDyeKeys.TAN, BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));

    public static final RegistryObject<Block> MAROON_SHULKER_BOX = register("maroon_shulker_box", () -> shulkerBox(DDDyeKeys.MAROON, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.MAROON)));
    public static final RegistryObject<Block> ROSE_SHULKER_BOX = register("rose_shulker_box", () -> shulkerBox(DDDyeKeys.ROSE, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.ROSE)));
    public static final RegistryObject<Block> CORAL_SHULKER_BOX = register("coral_shulker_box", () -> shulkerBox(DDDyeKeys.CORAL, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.CORAL)));
    public static final RegistryObject<Block> INDIGO_SHULKER_BOX = register("indigo_shulker_box", () -> shulkerBox(DDDyeKeys.INDIGO, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.INDIGO)));
    public static final RegistryObject<Block> NAVY_SHULKER_BOX = register("navy_shulker_box", () -> shulkerBox(DDDyeKeys.NAVY, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.NAVY)));
    public static final RegistryObject<Block> SLATE_SHULKER_BOX = register("slate_shulker_box", () -> shulkerBox(DDDyeKeys.SLATE, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.SLATE)));
    public static final RegistryObject<Block> OLIVE_SHULKER_BOX = register("olive_shulker_box", () -> shulkerBox(DDDyeKeys.OLIVE, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.OLIVE)));
    public static final RegistryObject<Block> AMBER_SHULKER_BOX = register("amber_shulker_box", () -> shulkerBox(DDDyeKeys.AMBER, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.AMBER)));
    public static final RegistryObject<Block> BEIGE_SHULKER_BOX = register("beige_shulker_box", () -> shulkerBox(DDDyeKeys.BEIGE, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.BEIGE)));
    public static final RegistryObject<Block> TEAL_SHULKER_BOX = register("teal_shulker_box", () -> shulkerBox(DDDyeKeys.TEAL, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.TEAL)));
    public static final RegistryObject<Block> MINT_SHULKER_BOX = register("mint_shulker_box", () -> shulkerBox(DDDyeKeys.MINT, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.MINT)));
    public static final RegistryObject<Block> AQUA_SHULKER_BOX = register("aqua_shulker_box", () -> shulkerBox(DDDyeKeys.AQUA, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.AQUA)));
    public static final RegistryObject<Block> VERDANT_SHULKER_BOX = register("verdant_shulker_box", () -> shulkerBox(DDDyeKeys.VERDANT, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.VERDANT)));
    public static final RegistryObject<Block> FOREST_SHULKER_BOX = register("forest_shulker_box", () -> shulkerBox(DDDyeKeys.FOREST, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.FOREST)));
    public static final RegistryObject<Block> GINGER_SHULKER_BOX = register("ginger_shulker_box", () -> shulkerBox(DDDyeKeys.GINGER, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.GINGER)));
    public static final RegistryObject<Block> TAN_SHULKER_BOX = register("tan_shulker_box", () -> shulkerBox(DDDyeKeys.TAN, BlockBehaviour.Properties.of().mapColor(DDDyeKeys.TAN)));

    public static final RegistryObject<Block> MAROON_CANDLE = register("maroon_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.MAROON)));
    public static final RegistryObject<Block> ROSE_CANDLE = register("rose_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.ROSE)));
    public static final RegistryObject<Block> CORAL_CANDLE = register("coral_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.CORAL)));
    public static final RegistryObject<Block> INDIGO_CANDLE = register("indigo_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.INDIGO)));
    public static final RegistryObject<Block> NAVY_CANDLE = register("navy_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.NAVY)));
    public static final RegistryObject<Block> SLATE_CANDLE = register("slate_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.SLATE)));
    public static final RegistryObject<Block> OLIVE_CANDLE = register("olive_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.OLIVE)));
    public static final RegistryObject<Block> AMBER_CANDLE = register("amber_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.AMBER)));
    public static final RegistryObject<Block> BEIGE_CANDLE = register("beige_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.BEIGE)));
    public static final RegistryObject<Block> TEAL_CANDLE = register("teal_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.TEAL)));
    public static final RegistryObject<Block> MINT_CANDLE = register("mint_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.MINT)));
    public static final RegistryObject<Block> AQUA_CANDLE = register("aqua_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.AQUA)));
    public static final RegistryObject<Block> VERDANT_CANDLE = register("verdant_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.VERDANT)));
    public static final RegistryObject<Block> FOREST_CANDLE = register("forest_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.FOREST)));
    public static final RegistryObject<Block> GINGER_CANDLE = register("ginger_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.GINGER)));
    public static final RegistryObject<Block> TAN_CANDLE = register("tan_candle", () -> new CandleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE).mapColor(DDDyeKeys.TAN)));

    public static final RegistryObject<Block> MAROON_CANDLE_CAKE = register("maroon_candle_cake", () -> new CandleCakeBlock(MAROON_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> ROSE_CANDLE_CAKE = register("rose_candle_cake", () -> new CandleCakeBlock(ROSE_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> CORAL_CANDLE_CAKE = register("coral_candle_cake", () -> new CandleCakeBlock(CORAL_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> INDIGO_CANDLE_CAKE = register("indigo_candle_cake", () -> new CandleCakeBlock(INDIGO_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> NAVY_CANDLE_CAKE = register("navy_candle_cake", () -> new CandleCakeBlock(NAVY_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> SLATE_CANDLE_CAKE = register("slate_candle_cake", () -> new CandleCakeBlock(SLATE_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> OLIVE_CANDLE_CAKE = register("olive_candle_cake", () -> new CandleCakeBlock(OLIVE_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> AMBER_CANDLE_CAKE = register("amber_candle_cake", () -> new CandleCakeBlock(AMBER_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> BEIGE_CANDLE_CAKE = register("beige_candle_cake", () -> new CandleCakeBlock(BEIGE_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> TEAL_CANDLE_CAKE = register("teal_candle_cake", () -> new CandleCakeBlock(TEAL_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> MINT_CANDLE_CAKE = register("mint_candle_cake", () -> new CandleCakeBlock(MINT_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> AQUA_CANDLE_CAKE = register("aqua_candle_cake", () -> new CandleCakeBlock(AQUA_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> VERDANT_CANDLE_CAKE = register("verdant_candle_cake", () -> new CandleCakeBlock(VERDANT_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> FOREST_CANDLE_CAKE = register("forest_candle_cake", () -> new CandleCakeBlock(FOREST_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> GINGER_CANDLE_CAKE = register("ginger_candle_cake", () -> new CandleCakeBlock(GINGER_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));
    public static final RegistryObject<Block> TAN_CANDLE_CAKE = register("tan_candle_cake", () -> new CandleCakeBlock(TAN_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CANDLE_CAKE)));

    public static final RegistryObject<Block> MAROON_BANNER = register("maroon_banner", () -> new BannerBlock(DDDyeKeys.MAROON, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> ROSE_BANNER = register("rose_banner", () -> new BannerBlock(DDDyeKeys.ROSE, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> CORAL_BANNER = register("coral_banner", () -> new BannerBlock(DDDyeKeys.CORAL, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> INDIGO_BANNER = register("indigo_banner", () -> new BannerBlock(DDDyeKeys.INDIGO, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> NAVY_BANNER = register("navy_banner", () -> new BannerBlock(DDDyeKeys.NAVY, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> SLATE_BANNER = register("slate_banner", () -> new BannerBlock(DDDyeKeys.SLATE, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> OLIVE_BANNER = register("olive_banner", () -> new BannerBlock(DDDyeKeys.OLIVE, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> AMBER_BANNER = register("amber_banner", () -> new BannerBlock(DDDyeKeys.AMBER, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> BEIGE_BANNER = register("beige_banner", () -> new BannerBlock(DDDyeKeys.BEIGE, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> TEAL_BANNER = register("teal_banner", () -> new BannerBlock(DDDyeKeys.TEAL, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> MINT_BANNER = register("mint_banner", () -> new BannerBlock(DDDyeKeys.MINT, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> AQUA_BANNER = register("aqua_banner", () -> new BannerBlock(DDDyeKeys.AQUA, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> VERDANT_BANNER = register("verdant_banner", () -> new BannerBlock(DDDyeKeys.VERDANT, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> FOREST_BANNER = register("forest_banner", () -> new BannerBlock(DDDyeKeys.FOREST, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> GINGER_BANNER = register("ginger_banner", () -> new BannerBlock(DDDyeKeys.GINGER, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> TAN_BANNER = register("tan_banner", () -> new BannerBlock(DDDyeKeys.TAN, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> MAROON_WALL_BANNER = register("maroon_wall_banner", () -> new WallBannerBlock(DDDyeKeys.MAROON, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(MAROON_BANNER.get())));
    public static final RegistryObject<Block> ROSE_WALL_BANNER = register("rose_wall_banner", () -> new WallBannerBlock(DDDyeKeys.ROSE, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(ROSE_BANNER.get())));
    public static final RegistryObject<Block> CORAL_WALL_BANNER = register("coral_wall_banner", () -> new WallBannerBlock(DDDyeKeys.CORAL, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(CORAL_BANNER.get())));
    public static final RegistryObject<Block> INDIGO_WALL_BANNER = register("indigo_wall_banner", () -> new WallBannerBlock(DDDyeKeys.INDIGO, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(INDIGO_BANNER.get())));
    public static final RegistryObject<Block> NAVY_WALL_BANNER = register("navy_wall_banner", () -> new WallBannerBlock(DDDyeKeys.NAVY, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(NAVY_BANNER.get())));
    public static final RegistryObject<Block> SLATE_WALL_BANNER = register("slate_wall_banner", () -> new WallBannerBlock(DDDyeKeys.SLATE, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(SLATE_BANNER.get())));
    public static final RegistryObject<Block> OLIVE_WALL_BANNER = register("olive_wall_banner", () -> new WallBannerBlock(DDDyeKeys.OLIVE, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(OLIVE_BANNER.get())));
    public static final RegistryObject<Block> AMBER_WALL_BANNER = register("amber_wall_banner", () -> new WallBannerBlock(DDDyeKeys.AMBER, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(AMBER_BANNER.get())));
    public static final RegistryObject<Block> BEIGE_WALL_BANNER = register("beige_wall_banner", () -> new WallBannerBlock(DDDyeKeys.BEIGE, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(BEIGE_BANNER.get())));
    public static final RegistryObject<Block> TEAL_WALL_BANNER = register("teal_wall_banner", () -> new WallBannerBlock(DDDyeKeys.TEAL, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(TEAL_BANNER.get())));
    public static final RegistryObject<Block> MINT_WALL_BANNER = register("mint_wall_banner", () -> new WallBannerBlock(DDDyeKeys.MINT, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(MINT_BANNER.get())));
    public static final RegistryObject<Block> AQUA_WALL_BANNER = register("aqua_wall_banner", () -> new WallBannerBlock(DDDyeKeys.AQUA, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(AQUA_BANNER.get())));
    public static final RegistryObject<Block> VERDANT_WALL_BANNER = register("verdant_wall_banner", () -> new WallBannerBlock(DDDyeKeys.VERDANT, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(VERDANT_BANNER.get())));
    public static final RegistryObject<Block> FOREST_WALL_BANNER = register("forest_wall_banner", () -> new WallBannerBlock(DDDyeKeys.FOREST, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(FOREST_BANNER.get())));
    public static final RegistryObject<Block> GINGER_WALL_BANNER = register("ginger_wall_banner", () -> new WallBannerBlock(DDDyeKeys.GINGER, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(GINGER_BANNER.get())));
    public static final RegistryObject<Block> TAN_WALL_BANNER = register("tan_wall_banner", () -> new WallBannerBlock(DDDyeKeys.TAN, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER).dropsLike(TAN_BANNER.get())));

    public static final RegistryObject<Block> MAROON_BED = register("maroon_bed", () -> bed(DDDyeKeys.MAROON));
    public static final RegistryObject<Block> ROSE_BED = register("rose_bed", () -> bed(DDDyeKeys.ROSE));
    public static final RegistryObject<Block> CORAL_BED = register("coral_bed", () -> bed(DDDyeKeys.CORAL));
    public static final RegistryObject<Block> INDIGO_BED = register("indigo_bed", () -> bed(DDDyeKeys.INDIGO));
    public static final RegistryObject<Block> NAVY_BED = register("navy_bed", () -> bed(DDDyeKeys.NAVY));
    public static final RegistryObject<Block> SLATE_BED = register("slate_bed", () -> bed(DDDyeKeys.SLATE));
    public static final RegistryObject<Block> OLIVE_BED = register("olive_bed", () -> bed(DDDyeKeys.OLIVE));
    public static final RegistryObject<Block> AMBER_BED = register("amber_bed", () -> bed(DDDyeKeys.AMBER));
    public static final RegistryObject<Block> BEIGE_BED = register("beige_bed", () -> bed(DDDyeKeys.BEIGE));
    public static final RegistryObject<Block> TEAL_BED = register("teal_bed", () -> bed(DDDyeKeys.TEAL));
    public static final RegistryObject<Block> MINT_BED = register("mint_bed", () -> bed(DDDyeKeys.MINT));
    public static final RegistryObject<Block> AQUA_BED = register("aqua_bed", () -> bed(DDDyeKeys.AQUA));
    public static final RegistryObject<Block> VERDANT_BED = register("verdant_bed", () -> bed(DDDyeKeys.VERDANT));
    public static final RegistryObject<Block> FOREST_BED = register("forest_bed", () -> bed(DDDyeKeys.FOREST));
    public static final RegistryObject<Block> GINGER_BED = register("ginger_bed", () -> bed(DDDyeKeys.GINGER));
    public static final RegistryObject<Block> TAN_BED = register("tan_bed", () -> bed(DDDyeKeys.TAN));

    private static DDBedBlock bed(DyeColor dyeColor) {
        return new DDBedBlock(dyeColor, BlockBehaviour.Properties.of().mapColor((blockState) -> blockState.getValue(DDBedBlock.PART) == BedPart.FOOT ? dyeColor.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }

    private static DDShulkerBoxBlock shulkerBox(DyeColor dyeColor, BlockBehaviour.Properties properties) {
        BlockBehaviour.StatePredicate statePredicate = (blockState, blockGetter, blockPos) -> {
            BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
            if (blockEntity instanceof DDShulkerBoxBlockEntity shulkerBoxBlockEntity) return shulkerBoxBlockEntity.isClosed();
            else return true;
        };
        return new DDShulkerBoxBlock(dyeColor, properties.forceSolidOn().strength(2.0F).dynamicShape().noOcclusion().isSuffocating(statePredicate).isViewBlocking(statePredicate).pushReaction(PushReaction.DESTROY).isRedstoneConductor((blockState, blockGetter, blockPos) -> true));
    }
    
    private static <B extends Block> RegistryObject<B> register(String id, Supplier<B> block) {
        return BLOCKS.register(id, block);
    }
}
