package com.ninni.dye_depot.registry;

import com.google.common.collect.ImmutableMap;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.*;
import java.util.Map;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class DDBlocks {

    public static final DyedHolders<Block, Block> WOOL = DyedHolders.createModded(dye ->
            registerWithItem(dye + "_wool", new Block(Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(dye)))
    );

    public static final DyedHolders<Block, Block> CARPETS = DyedHolders.createModded(dye ->
            registerWithItem(dye + "_carpet", new WoolCarpetBlock(dye, Properties.ofFullCopy(Blocks.WHITE_CARPET).mapColor(dye)))
    );

    public static final DyedHolders<Block, Block> TERRACOTTA = DyedHolders.createModded(dye ->
            registerWithItem(dye + "_terracotta", new Block(Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA).mapColor(dye)))
    );

    private static final Map<DyeColor, MapColor> CONCRETE_COLORS = new ImmutableMap.Builder<DyeColor, MapColor>()
            .put(DDDyes.MAROON.get(), MapColor.CRIMSON_HYPHAE)
            .put(DDDyes.ROSE.get(), MapColor.COLOR_RED)
            .put(DDDyes.CORAL.get(), MapColor.PODZOL)
            .put(DDDyes.INDIGO.get(), MapColor.WARPED_HYPHAE)
            .put(DDDyes.NAVY.get(), MapColor.TERRACOTTA_BLACK)
            .put(DDDyes.SLATE.get(), MapColor.COLOR_GRAY)
            .put(DDDyes.OLIVE.get(), MapColor.COLOR_BROWN)
            .put(DDDyes.AMBER.get(), MapColor.WOOD)
            .put(DDDyes.BEIGE.get(), MapColor.TERRACOTTA_WHITE)
            .put(DDDyes.TEAL.get(), MapColor.COLOR_GRAY)
            .put(DDDyes.MINT.get(), MapColor.DEEPSLATE)
            .put(DDDyes.AQUA.get(), MapColor.WARPED_WART_BLOCK)
            .put(DDDyes.VERDANT.get(), MapColor.TERRACOTTA_BLACK)
            .put(DDDyes.FOREST.get(), MapColor.COLOR_GREEN)
            .put(DDDyes.GINGER.get(), MapColor.NETHER)
            .put(DDDyes.TAN.get(), MapColor.DIRT)
            .build();

    public static final DyedHolders<Block, Block> CONCRETE = DyedHolders.createModded(dye ->
            registerWithItem(dye + "_concrete", new Block(Properties.ofFullCopy(Blocks.WHITE_CONCRETE).mapColor(CONCRETE_COLORS.get(dye))))
    );

    public static final DyedHolders<Block, Block> CONCRETE_POWDER = DyedHolders.createModded(dye ->
            registerWithItem(dye + "_concrete_powder", new ConcretePowderBlock(CONCRETE.getOrThrow(dye), Properties.ofFullCopy(Blocks.WHITE_CONCRETE_POWDER).mapColor(dye)))
    );

    public static final DyedHolders<Block, Block> GLAZED_TERRACOTTA = DyedHolders.createModded(dye ->
            registerWithItem(dye + "_glazed_terracotta", new GlazedTerracottaBlock(Properties.ofFullCopy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(dye)))
    );

    public static final DyedHolders<Block, Block> STAINED_GLASS = DyedHolders.createModded(dye ->
            registerWithItem(dye + "_stained_glass", new StainedGlassBlock(dye, Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)))
    );

    public static final DyedHolders<StainedGlassPaneBlock, Block> STAINED_GLASS_PANES = DyedHolders.createModded(dye ->
            registerWithItem(dye + "_stained_glass_pane", new StainedGlassPaneBlock(dye, Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE)))
    );

    public static final DyedHolders<Block, Block> SHULKER_BOXES = DyedHolders.createModded(dye ->
            register(dye + "_shulker_box", shulkerBox(dye, Properties.of().mapColor(dye)))
    );

    public static final DyedHolders<Block, Block> CANDLES = DyedHolders.createModded(dye ->
            registerWithItem(dye + "_candle", new CandleBlock(Properties.ofFullCopy(Blocks.WHITE_CANDLE).mapColor(dye)))
    );

    public static final DyedHolders<Block, Block> CANDLE_CAKES = DyedHolders.createModded(dye ->
            register(dye + "_candle_cake", new CandleCakeBlock(CANDLES.getOrThrow(dye), Properties.ofFullCopy(Blocks.WHITE_CANDLE_CAKE)))
    );

    public static final DyedHolders<Block, Block> BANNERS = DyedHolders.createModded(dye ->
            register(dye + "_banner", new DDBannerBlock(dye, Properties.ofFullCopy(Blocks.WHITE_BANNER)))
    );

    public static final DyedHolders<Block, Block> WALL_BANNERS = DyedHolders.createModded(dye ->
            register(dye + "_wall_banner", new DDWallBannerBlock(dye, Properties.ofFullCopy(Blocks.WHITE_WALL_BANNER).dropsLike(BANNERS.getOrThrow(dye))))
    );

    public static final DyedHolders<Block, Block> BEDS = DyedHolders.createModded(dye ->
            register(dye + "_bed", bed(dye))
    );

    public static final DyedHolders<Block, Block> DYE_BASKETS = DyedHolders.createWithVanilla(dye ->
            registerWithItem(dye + "_dye_basket", new DyeBasketBlock(dye, Properties.of().strength(0.8f).sound(SoundType.WOOL).ignitedByLava().mapColor(dye)))
    );

    private static DDBedBlock bed(DyeColor dyeColor) {
        return new DDBedBlock(dyeColor, Properties.of().mapColor((blockState) -> blockState.getValue(DDBedBlock.PART) == BedPart.FOOT ? dyeColor.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }

    private static DDShulkerBoxBlock shulkerBox(DyeColor dyeColor, Properties properties) {
        BlockBehaviour.StatePredicate statePredicate = (blockState, blockGetter, blockPos) -> {
            BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
            if (blockEntity instanceof ShulkerBoxBlockEntity shulkerBoxBlockEntity)
                return shulkerBoxBlockEntity.isClosed();
            else return true;
        };
        return new DDShulkerBoxBlock(dyeColor, properties.forceSolidOn().strength(2.0F).dynamicShape().noOcclusion().isSuffocating(statePredicate).isViewBlocking(statePredicate).pushReaction(PushReaction.DESTROY).isRedstoneConductor(Blocks::always));
    }

    @SuppressWarnings("unchecked")
    private static <T extends Block> Holder<T> register(String id, T block) {
        return (Holder<T>) Registry.registerForHolder(BuiltInRegistries.BLOCK, DyeDepot.modLoc(id), block);
    }

    private static <T extends Block> Holder<T> registerWithItem(String id, T block) {
        Registry.register(BuiltInRegistries.ITEM, DyeDepot.modLoc(id), new BlockItem(block, new Item.Properties()));
        return register(id, block);
    }
}
