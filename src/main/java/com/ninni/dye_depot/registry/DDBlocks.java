package com.ninni.dye_depot.registry;

import com.google.common.collect.ImmutableMap;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.*;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDBlocks {

    private static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(DyeDepot.MOD_ID);

    public static final DyedHolders<Block, Block> WOOL = DyedHolders.createModded(dye ->
        registerWithItem(dye + "_wool", Block::new, () -> Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(dye))
    );

    public static final DyedHolders<Block, Block> CARPETS = DyedHolders.createModded(dye ->
        registerWithItem(dye + "_carpet",
            props -> new WoolCarpetBlock(dye, props),
            () -> Properties.ofFullCopy(Blocks.WHITE_CARPET).mapColor(dye),
            props -> props.component(DataComponents.EQUIPPABLE, Equippable.llamaSwag(dye))
        )
    );

    public static final DyedHolders<Block, Block> TERRACOTTA = DyedHolders.createModded(dye ->
        registerWithItem(dye + "_terracotta", Block::new, () -> Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA).mapColor(dye))
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
        registerWithItem(dye + "_concrete", Block::new, () -> Properties.ofFullCopy(Blocks.WHITE_CONCRETE).mapColor(CONCRETE_COLORS.get(dye)))
    );

    public static final DyedHolders<Block, Block> CONCRETE_POWDER = DyedHolders.createModded(dye ->
        registerWithItem(dye + "_concrete_powder", props -> new ConcretePowderBlock(CONCRETE.getOrThrow(dye), props), () -> Properties.ofFullCopy(Blocks.WHITE_CONCRETE_POWDER).mapColor(dye))
    );

    public static final DyedHolders<Block, Block> GLAZED_TERRACOTTA = DyedHolders.createModded(dye ->
        registerWithItem(dye + "_glazed_terracotta", GlazedTerracottaBlock::new, () -> Properties.ofFullCopy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(dye))
    );

    public static final DyedHolders<Block, Block> STAINED_GLASS = DyedHolders.createModded(dye ->
        registerWithItem(dye + "_stained_glass", props -> new StainedGlassBlock(dye, props), () -> Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS))
    );

    public static final DyedHolders<StainedGlassPaneBlock, Block> STAINED_GLASS_PANES = DyedHolders.createModded(dye ->
        registerWithItem(dye + "_stained_glass_pane", props -> new StainedGlassPaneBlock(dye, props), () -> Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE))
    );

    public static final DyedHolders<ShulkerBoxBlock, Block> SHULKER_BOXES = DyedHolders.createModded(dye ->
        register(dye + "_shulker_box", props -> shulkerBox(dye, props.mapColor(dye)))
    );

    public static final DyedHolders<CandleBlock, Block> CANDLES = DyedHolders.createModded(dye ->
        registerWithItem(dye + "_candle", CandleBlock::new, () -> Properties.ofFullCopy(Blocks.WHITE_CANDLE).mapColor(dye))
    );

    public static final DyedHolders<CandleCakeBlock, Block> CANDLE_CAKES = DyedHolders.createModded(dye ->
        register(dye + "_candle_cake", props -> new CandleCakeBlock(CANDLES.getOrThrow(dye), props), () -> Properties.ofFullCopy(Blocks.WHITE_CANDLE_CAKE))
    );

    public static final DyedHolders<BannerBlock, Block> BANNERS = DyedHolders.createModded(dye ->
        register(dye + "_banner", props -> new BannerBlock(dye, props), DDBlocks::bannerProps)
    );

    public static final DyedHolders<WallBannerBlock, Block> WALL_BANNERS = DyedHolders.createModded(dye ->
        register(dye + "_wall_banner", props -> new WallBannerBlock(dye, props), () -> wallBannerProps(dye))
    );

    public static final DyedHolders<BedBlock, Block> BEDS = DyedHolders.createModded(dye ->
        register(dye + "_bed", props -> bed(dye, props))
    );

    public static final DyedHolders<Block, Block> DYE_BASKETS = DyedHolders.createWithVanilla(dye ->
        registerWithItem(dye + "_dye_basket", props -> new DyeBasketBlock(dye, props.strength(0.8f).sound(SoundType.WOOL).ignitedByLava().mapColor(dye)))
    );

    private static Properties bannerProps() {
        return Properties.ofFullCopy(Blocks.WHITE_BANNER);
    }

    private static Properties wallBannerProps(DyeColor dye) {
        return Properties.ofFullCopy(Blocks.WHITE_WALL_BANNER).overrideLootTable(BANNERS.getOrThrow(dye).getLootTable());
    }

    private static BedBlock bed(DyeColor color, Properties props) {
        return new BedBlock(color, props
            .mapColor(state -> state.getValue(BedBlock.PART) == BedPart.FOOT ? color.getMapColor() : MapColor.WOOL)
            .sound(SoundType.WOOD)
            .strength(0.2F)
            .noOcclusion()
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY)
        );
    }

    private static ShulkerBoxBlock shulkerBox(DyeColor color, Properties properties) {
        BlockBehaviour.StatePredicate statePredicate = (blockState, blockGetter, blockPos) -> {
            BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
            if (blockEntity instanceof ShulkerBoxBlockEntity shulkerBoxBlockEntity)
                return shulkerBoxBlockEntity.isClosed();
            else return true;
        };
        return new ShulkerBoxBlock(color, properties
            .forceSolidOn()
            .strength(2.0F)
            .dynamicShape()
            .noOcclusion()
            .isSuffocating(statePredicate)
            .isViewBlocking(statePredicate)
            .pushReaction(PushReaction.DESTROY)
            .isRedstoneConductor(Blocks::always)
        );
    }

    private static <T extends Block> Holder<T> register(String id, Function<Block.Properties, T> block) {
        return register(id, block, Properties::of);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Block> Holder<T> register(String id, Function<Block.Properties, T> block, Supplier<Properties> properties) {
        return (Holder<T>) REGISTRY.registerBlock(id, block, properties);
    }

    private static <T extends Block> Holder<T> registerWithItem(String id, Function<Block.Properties, T> block) {
        return registerWithItem(id, block, UnaryOperator.identity());
    }

    private static <T extends Block> Holder<T> registerWithItem(String id, Function<Block.Properties, T> block, Supplier<Properties> properties) {
        return registerWithItem(id, block, properties, UnaryOperator.identity());
    }

    private static <T extends Block> Holder<T> registerWithItem(String id, Function<Block.Properties, T> block, UnaryOperator<Item.Properties> itemProperties) {
        return registerWithItem(id, block, Properties::of, itemProperties);
    }

    private static <T extends Block> Holder<T> registerWithItem(String id, Function<Block.Properties, T> block, Supplier<Properties> blockProperties, UnaryOperator<Item.Properties> itemProperties) {
        var supplier = register(id, block, blockProperties);
        DDItems.REGISTRY.registerItem(id, (props) -> new BlockItem(supplier.value(), props), itemProperties);
        return supplier;
    }

    public static void register(IEventBus modBus) {
        REGISTRY.register(modBus);
    }

}
