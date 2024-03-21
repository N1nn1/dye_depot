package com.ninni.dye_depot.events;

import com.google.common.collect.Lists;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.client.DDBannerRenderer;
import com.ninni.dye_depot.client.DDBedRenderer;
import com.ninni.dye_depot.client.DDShulkerBoxRenderer;
import com.ninni.dye_depot.registry.DDBlockEntityType;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = DyeDepot.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    private static final Function<ItemLike, ItemStack> FUNCTION = ItemStack::new;

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        IEventBus eventBus = MinecraftForge.EVENT_BUS;
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.MAROON_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.ROSE_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.CORAL_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.INDIGO_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.NAVY_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.SLATE_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.OLIVE_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.AMBER_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.BEIGE_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.TEAL_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.MINT_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.AQUA_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.VERDANT_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.FOREST_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.GINGER_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.TAN_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.MAROON_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.ROSE_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.CORAL_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.INDIGO_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.NAVY_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.SLATE_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.OLIVE_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.AMBER_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.BEIGE_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.TEAL_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.MINT_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.AQUA_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.VERDANT_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.FOREST_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.GINGER_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DDBlocks.TAN_STAINED_GLASS_PANE.get(), RenderType.translucent());
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(DDBlockEntityType.BED.get(), DDBedRenderer::new);
        event.registerBlockEntityRenderer(DDBlockEntityType.SHULKER_BOX.get(), DDShulkerBoxRenderer::new);
        event.registerBlockEntityRenderer(DDBlockEntityType.BANNER.get(), DDBannerRenderer::new);
    }

    private static void addAfter(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike after, ItemLike... block) {
        List<ItemLike> stream = Lists.newArrayList(Arrays.stream(block).toList());
        Collections.reverse(stream);
        stream.forEach(blk -> addAfter(map, after, blk));
    }

    private static void addBefore(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike before, ItemLike... block) {
        List<ItemLike> stream = Lists.newArrayList(Arrays.stream(block).toList());
        Collections.reverse(stream);
        stream.forEach(blk -> addBefore(map, before, blk));
    }

    private static void addAfter(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike after, ItemLike block) {
        map.putAfter(FUNCTION.apply(after), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    private static void addBefore(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike before, ItemLike block) {
        map.putBefore(FUNCTION.apply(before), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    private static void accept(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike block) {
        map.put(new ItemStack(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @SubscribeEvent
    public static void buildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries = event.getEntries();
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
        if (tabKey.equals(CreativeModeTabs.INGREDIENTS)) {
            addBefore(entries, Items.RED_DYE, DDItems.MAROON_DYE.get(), DDItems.ROSE_DYE.get());
            addAfter(entries, Items.RED_DYE, DDItems.CORAL_DYE.get());
            addBefore(entries, Items.ORANGE_DYE, DDItems.GINGER_DYE.get());
            addAfter(entries, Items.ORANGE_DYE, DDItems.TAN_DYE.get());
            addBefore(entries, Items.YELLOW_DYE, DDItems.BEIGE_DYE.get());
            addAfter(entries, Items.YELLOW_DYE, DDItems.AMBER_DYE.get(), DDItems.OLIVE_DYE.get());
            addBefore(entries, Items.GREEN_DYE, DDItems.FOREST_DYE.get());
            addAfter(entries, Items.GREEN_DYE, DDItems.VERDANT_DYE.get());
            addBefore(entries, Items.RED_DYE, DDItems.MAROON_DYE.get(), DDItems.ROSE_DYE.get());
            addAfter(entries, Items.RED_DYE, DDItems.CORAL_DYE.get());
            addBefore(entries, Items.CYAN_DYE, DDItems.TEAL_DYE.get());
            addAfter(entries, Items.CYAN_DYE, DDItems.MINT_DYE.get(), DDItems.AQUA_DYE.get());
            addAfter(entries, Items.BLUE_DYE, DDItems.SLATE_DYE.get(), DDItems.NAVY_DYE.get());
            addBefore(entries, Items.PURPLE_DYE, DDItems.INDIGO_DYE.get());
        }
        if (tabKey.equals(CreativeModeTabs.COLORED_BLOCKS)) {
            addBefore(entries, Items.RED_WOOL, DDItems.MAROON_WOOL.get(), DDItems.ROSE_WOOL.get());
            addAfter(entries, Items.RED_WOOL, DDItems.CORAL_WOOL.get());
            addBefore(entries, Items.ORANGE_WOOL, DDItems.GINGER_WOOL.get());
            addAfter(entries, Items.ORANGE_WOOL, DDItems.TAN_WOOL.get());
            addBefore(entries, Items.YELLOW_WOOL, DDItems.BEIGE_WOOL.get());
            addAfter(entries, Items.YELLOW_WOOL, DDItems.AMBER_WOOL.get(), DDItems.OLIVE_WOOL.get());
            addBefore(entries, Items.GREEN_WOOL, DDItems.FOREST_WOOL.get());
            addAfter(entries, Items.GREEN_WOOL, DDItems.VERDANT_WOOL.get());
            addBefore(entries, Items.RED_WOOL, DDItems.MAROON_WOOL.get(), DDItems.ROSE_WOOL.get());
            addAfter(entries, Items.RED_WOOL, DDItems.CORAL_WOOL.get());
            addBefore(entries, Items.CYAN_WOOL, DDItems.TEAL_WOOL.get());
            addAfter(entries, Items.CYAN_WOOL, DDItems.MINT_WOOL.get(), DDItems.AQUA_WOOL.get());
            addAfter(entries, Items.BLUE_WOOL, DDItems.SLATE_WOOL.get(), DDItems.NAVY_WOOL.get());
            addBefore(entries, Items.PURPLE_WOOL, DDItems.INDIGO_WOOL.get());

            addBefore(entries, Items.RED_CARPET, DDItems.MAROON_CARPET.get(), DDItems.ROSE_CARPET.get());
            addAfter(entries, Items.RED_CARPET, DDItems.CORAL_CARPET.get());
            addBefore(entries, Items.ORANGE_CARPET, DDItems.GINGER_CARPET.get());
            addAfter(entries, Items.ORANGE_CARPET, DDItems.TAN_CARPET.get());
            addBefore(entries, Items.YELLOW_CARPET, DDItems.BEIGE_CARPET.get());
            addAfter(entries, Items.YELLOW_CARPET, DDItems.AMBER_CARPET.get(), DDItems.OLIVE_CARPET.get());
            addBefore(entries, Items.GREEN_CARPET, DDItems.FOREST_CARPET.get());
            addAfter(entries, Items.GREEN_CARPET, DDItems.VERDANT_CARPET.get());
            addBefore(entries, Items.RED_CARPET, DDItems.MAROON_CARPET.get(), DDItems.ROSE_CARPET.get());
            addAfter(entries, Items.RED_CARPET, DDItems.CORAL_CARPET.get());
            addBefore(entries, Items.CYAN_CARPET, DDItems.TEAL_CARPET.get());
            addAfter(entries, Items.CYAN_CARPET, DDItems.MINT_CARPET.get(), DDItems.AQUA_CARPET.get());
            addAfter(entries, Items.BLUE_CARPET, DDItems.SLATE_CARPET.get(), DDItems.NAVY_CARPET.get());
            addBefore(entries, Items.PURPLE_CARPET, DDItems.INDIGO_CARPET.get());

            addBefore(entries, Items.RED_TERRACOTTA, DDItems.MAROON_TERRACOTTA.get(), DDItems.ROSE_TERRACOTTA.get());
            addAfter(entries, Items.RED_TERRACOTTA, DDItems.CORAL_TERRACOTTA.get());
            addBefore(entries, Items.ORANGE_TERRACOTTA, DDItems.GINGER_TERRACOTTA.get());
            addAfter(entries, Items.ORANGE_TERRACOTTA, DDItems.TAN_TERRACOTTA.get());
            addBefore(entries, Items.YELLOW_TERRACOTTA, DDItems.BEIGE_TERRACOTTA.get());
            addAfter(entries, Items.YELLOW_TERRACOTTA, DDItems.AMBER_TERRACOTTA.get(), DDItems.OLIVE_TERRACOTTA.get());
            addBefore(entries, Items.GREEN_TERRACOTTA, DDItems.FOREST_TERRACOTTA.get());
            addAfter(entries, Items.GREEN_TERRACOTTA, DDItems.VERDANT_TERRACOTTA.get());
            addBefore(entries, Items.RED_TERRACOTTA, DDItems.MAROON_TERRACOTTA.get(), DDItems.ROSE_TERRACOTTA.get());
            addAfter(entries, Items.RED_TERRACOTTA, DDItems.CORAL_TERRACOTTA.get());
            addBefore(entries, Items.CYAN_TERRACOTTA, DDItems.TEAL_TERRACOTTA.get());
            addAfter(entries, Items.CYAN_TERRACOTTA, DDItems.MINT_TERRACOTTA.get(), DDItems.AQUA_TERRACOTTA.get());
            addAfter(entries, Items.BLUE_TERRACOTTA, DDItems.SLATE_TERRACOTTA.get(), DDItems.NAVY_TERRACOTTA.get());
            addBefore(entries, Items.PURPLE_TERRACOTTA, DDItems.INDIGO_TERRACOTTA.get());

            addBefore(entries, Items.RED_CONCRETE, DDItems.MAROON_CONCRETE.get(), DDItems.ROSE_CONCRETE.get());
            addAfter(entries, Items.RED_CONCRETE, DDItems.CORAL_CONCRETE.get());
            addBefore(entries, Items.ORANGE_CONCRETE, DDItems.GINGER_CONCRETE.get());
            addAfter(entries, Items.ORANGE_CONCRETE, DDItems.TAN_CONCRETE.get());
            addBefore(entries, Items.YELLOW_CONCRETE, DDItems.BEIGE_CONCRETE.get());
            addAfter(entries, Items.YELLOW_CONCRETE, DDItems.AMBER_CONCRETE.get(), DDItems.OLIVE_CONCRETE.get());
            addBefore(entries, Items.GREEN_CONCRETE, DDItems.FOREST_CONCRETE.get());
            addAfter(entries, Items.GREEN_CONCRETE, DDItems.VERDANT_CONCRETE.get());
            addBefore(entries, Items.RED_CONCRETE, DDItems.MAROON_CONCRETE.get(), DDItems.ROSE_CONCRETE.get());
            addAfter(entries, Items.RED_CONCRETE, DDItems.CORAL_CONCRETE.get());
            addBefore(entries, Items.CYAN_CONCRETE, DDItems.TEAL_CONCRETE.get());
            addAfter(entries, Items.CYAN_CONCRETE, DDItems.MINT_CONCRETE.get(), DDItems.AQUA_CONCRETE.get());
            addAfter(entries, Items.BLUE_CONCRETE, DDItems.SLATE_CONCRETE.get(), DDItems.NAVY_CONCRETE.get());
            addBefore(entries, Items.PURPLE_CONCRETE, DDItems.INDIGO_CONCRETE.get());

            addBefore(entries, Items.RED_CONCRETE_POWDER, DDItems.MAROON_CONCRETE_POWDER.get(), DDItems.ROSE_CONCRETE_POWDER.get());
            addAfter(entries, Items.RED_CONCRETE_POWDER, DDItems.CORAL_CONCRETE_POWDER.get());
            addBefore(entries, Items.ORANGE_CONCRETE_POWDER, DDItems.GINGER_CONCRETE_POWDER.get());
            addAfter(entries, Items.ORANGE_CONCRETE_POWDER, DDItems.TAN_CONCRETE_POWDER.get());
            addBefore(entries, Items.YELLOW_CONCRETE_POWDER, DDItems.BEIGE_CONCRETE_POWDER.get());
            addAfter(entries, Items.YELLOW_CONCRETE_POWDER, DDItems.AMBER_CONCRETE_POWDER.get(), DDItems.OLIVE_CONCRETE_POWDER.get());
            addBefore(entries, Items.GREEN_CONCRETE_POWDER, DDItems.FOREST_CONCRETE_POWDER.get());
            addAfter(entries, Items.GREEN_CONCRETE_POWDER, DDItems.VERDANT_CONCRETE_POWDER.get());
            addBefore(entries, Items.RED_CONCRETE_POWDER, DDItems.MAROON_CONCRETE_POWDER.get(), DDItems.ROSE_CONCRETE_POWDER.get());
            addAfter(entries, Items.RED_CONCRETE_POWDER, DDItems.CORAL_CONCRETE_POWDER.get());
            addBefore(entries, Items.CYAN_CONCRETE_POWDER, DDItems.TEAL_CONCRETE_POWDER.get());
            addAfter(entries, Items.CYAN_CONCRETE_POWDER, DDItems.MINT_CONCRETE_POWDER.get(), DDItems.AQUA_CONCRETE_POWDER.get());
            addAfter(entries, Items.BLUE_CONCRETE_POWDER, DDItems.SLATE_CONCRETE_POWDER.get(), DDItems.NAVY_CONCRETE_POWDER.get());
            addBefore(entries, Items.PURPLE_CONCRETE_POWDER, DDItems.INDIGO_CONCRETE_POWDER.get());

            addBefore(entries, Items.RED_GLAZED_TERRACOTTA, DDItems.MAROON_GLAZED_TERRACOTTA.get(), DDItems.ROSE_GLAZED_TERRACOTTA.get());
            addAfter(entries, Items.RED_GLAZED_TERRACOTTA, DDItems.CORAL_GLAZED_TERRACOTTA.get());
            addBefore(entries, Items.ORANGE_GLAZED_TERRACOTTA, DDItems.GINGER_GLAZED_TERRACOTTA.get());
            addAfter(entries, Items.ORANGE_GLAZED_TERRACOTTA, DDItems.TAN_GLAZED_TERRACOTTA.get());
            addBefore(entries, Items.YELLOW_GLAZED_TERRACOTTA, DDItems.BEIGE_GLAZED_TERRACOTTA.get());
            addAfter(entries, Items.YELLOW_GLAZED_TERRACOTTA, DDItems.AMBER_GLAZED_TERRACOTTA.get(), DDItems.OLIVE_GLAZED_TERRACOTTA.get());
            addBefore(entries, Items.GREEN_GLAZED_TERRACOTTA, DDItems.FOREST_GLAZED_TERRACOTTA.get());
            addAfter(entries, Items.GREEN_GLAZED_TERRACOTTA, DDItems.VERDANT_GLAZED_TERRACOTTA.get());
            addBefore(entries, Items.RED_GLAZED_TERRACOTTA, DDItems.MAROON_GLAZED_TERRACOTTA.get(), DDItems.ROSE_GLAZED_TERRACOTTA.get());
            addAfter(entries, Items.RED_GLAZED_TERRACOTTA, DDItems.CORAL_GLAZED_TERRACOTTA.get());
            addBefore(entries, Items.CYAN_GLAZED_TERRACOTTA, DDItems.TEAL_GLAZED_TERRACOTTA.get());
            addAfter(entries, Items.CYAN_GLAZED_TERRACOTTA, DDItems.MINT_GLAZED_TERRACOTTA.get(), DDItems.AQUA_GLAZED_TERRACOTTA.get());
            addAfter(entries, Items.BLUE_GLAZED_TERRACOTTA, DDItems.SLATE_GLAZED_TERRACOTTA.get(), DDItems.NAVY_GLAZED_TERRACOTTA.get());
            addBefore(entries, Items.PURPLE_GLAZED_TERRACOTTA, DDItems.INDIGO_GLAZED_TERRACOTTA.get());

            addBefore(entries, Items.RED_STAINED_GLASS, DDItems.MAROON_STAINED_GLASS.get(), DDItems.ROSE_STAINED_GLASS.get());
            addAfter(entries, Items.RED_STAINED_GLASS, DDItems.CORAL_STAINED_GLASS.get());
            addBefore(entries, Items.ORANGE_STAINED_GLASS, DDItems.GINGER_STAINED_GLASS.get());
            addAfter(entries, Items.ORANGE_STAINED_GLASS, DDItems.TAN_STAINED_GLASS.get());
            addBefore(entries, Items.YELLOW_STAINED_GLASS, DDItems.BEIGE_STAINED_GLASS.get());
            addAfter(entries, Items.YELLOW_STAINED_GLASS, DDItems.AMBER_STAINED_GLASS.get(), DDItems.OLIVE_STAINED_GLASS.get());
            addBefore(entries, Items.GREEN_STAINED_GLASS, DDItems.FOREST_STAINED_GLASS.get());
            addAfter(entries, Items.GREEN_STAINED_GLASS, DDItems.VERDANT_STAINED_GLASS.get());
            addBefore(entries, Items.RED_STAINED_GLASS, DDItems.MAROON_STAINED_GLASS.get(), DDItems.ROSE_STAINED_GLASS.get());
            addAfter(entries, Items.RED_STAINED_GLASS, DDItems.CORAL_STAINED_GLASS.get());
            addBefore(entries, Items.CYAN_STAINED_GLASS, DDItems.TEAL_STAINED_GLASS.get());
            addAfter(entries, Items.CYAN_STAINED_GLASS, DDItems.MINT_STAINED_GLASS.get(), DDItems.AQUA_STAINED_GLASS.get());
            addAfter(entries, Items.BLUE_STAINED_GLASS, DDItems.SLATE_STAINED_GLASS.get(), DDItems.NAVY_STAINED_GLASS.get());
            addBefore(entries, Items.PURPLE_STAINED_GLASS, DDItems.INDIGO_STAINED_GLASS.get());

            addBefore(entries, Items.RED_STAINED_GLASS_PANE, DDItems.MAROON_STAINED_GLASS_PANE.get(), DDItems.ROSE_STAINED_GLASS_PANE.get());
            addAfter(entries, Items.RED_STAINED_GLASS_PANE, DDItems.CORAL_STAINED_GLASS_PANE.get());
            addBefore(entries, Items.ORANGE_STAINED_GLASS_PANE, DDItems.GINGER_STAINED_GLASS_PANE.get());
            addAfter(entries, Items.ORANGE_STAINED_GLASS_PANE, DDItems.TAN_STAINED_GLASS_PANE.get());
            addBefore(entries, Items.YELLOW_STAINED_GLASS_PANE, DDItems.BEIGE_STAINED_GLASS_PANE.get());
            addAfter(entries, Items.YELLOW_STAINED_GLASS_PANE, DDItems.AMBER_STAINED_GLASS_PANE.get(), DDItems.OLIVE_STAINED_GLASS_PANE.get());
            addBefore(entries, Items.GREEN_STAINED_GLASS_PANE, DDItems.FOREST_STAINED_GLASS_PANE.get());
            addAfter(entries, Items.GREEN_STAINED_GLASS_PANE, DDItems.VERDANT_STAINED_GLASS_PANE.get());
            addBefore(entries, Items.RED_STAINED_GLASS_PANE, DDItems.MAROON_STAINED_GLASS_PANE.get(), DDItems.ROSE_STAINED_GLASS_PANE.get());
            addAfter(entries, Items.RED_STAINED_GLASS_PANE, DDItems.CORAL_STAINED_GLASS_PANE.get());
            addBefore(entries, Items.CYAN_STAINED_GLASS_PANE, DDItems.TEAL_STAINED_GLASS_PANE.get());
            addAfter(entries, Items.CYAN_STAINED_GLASS_PANE, DDItems.MINT_STAINED_GLASS_PANE.get(), DDItems.AQUA_STAINED_GLASS_PANE.get());
            addAfter(entries, Items.BLUE_STAINED_GLASS_PANE, DDItems.SLATE_STAINED_GLASS_PANE.get(), DDItems.NAVY_STAINED_GLASS_PANE.get());
            addBefore(entries, Items.PURPLE_STAINED_GLASS_PANE, DDItems.INDIGO_STAINED_GLASS_PANE.get());

            addBefore(entries, Items.RED_SHULKER_BOX, DDItems.MAROON_SHULKER_BOX.get(), DDItems.ROSE_SHULKER_BOX.get());
            addAfter(entries, Items.RED_SHULKER_BOX, DDItems.CORAL_SHULKER_BOX.get());
            addBefore(entries, Items.ORANGE_SHULKER_BOX, DDItems.GINGER_SHULKER_BOX.get());
            addAfter(entries, Items.ORANGE_SHULKER_BOX, DDItems.TAN_SHULKER_BOX.get());
            addBefore(entries, Items.YELLOW_SHULKER_BOX, DDItems.BEIGE_SHULKER_BOX.get());
            addAfter(entries, Items.YELLOW_SHULKER_BOX, DDItems.AMBER_SHULKER_BOX.get(), DDItems.OLIVE_SHULKER_BOX.get());
            addBefore(entries, Items.GREEN_SHULKER_BOX, DDItems.FOREST_SHULKER_BOX.get());
            addAfter(entries, Items.GREEN_SHULKER_BOX, DDItems.VERDANT_SHULKER_BOX.get());
            addBefore(entries, Items.RED_SHULKER_BOX, DDItems.MAROON_SHULKER_BOX.get(), DDItems.ROSE_SHULKER_BOX.get());
            addAfter(entries, Items.RED_SHULKER_BOX, DDItems.CORAL_SHULKER_BOX.get());
            addBefore(entries, Items.CYAN_SHULKER_BOX, DDItems.TEAL_SHULKER_BOX.get());
            addAfter(entries, Items.CYAN_SHULKER_BOX, DDItems.MINT_SHULKER_BOX.get(), DDItems.AQUA_SHULKER_BOX.get());
            addAfter(entries, Items.BLUE_SHULKER_BOX, DDItems.SLATE_SHULKER_BOX.get(), DDItems.NAVY_SHULKER_BOX.get());
            addBefore(entries, Items.PURPLE_SHULKER_BOX, DDItems.INDIGO_SHULKER_BOX.get());

            addBefore(entries, Items.RED_BED, DDItems.MAROON_BED.get(), DDItems.ROSE_BED.get());
            addAfter(entries, Items.RED_BED, DDItems.CORAL_BED.get());
            addBefore(entries, Items.ORANGE_BED, DDItems.GINGER_BED.get());
            addAfter(entries, Items.ORANGE_BED, DDItems.TAN_BED.get());
            addBefore(entries, Items.YELLOW_BED, DDItems.BEIGE_BED.get());
            addAfter(entries, Items.YELLOW_BED, DDItems.AMBER_BED.get(), DDItems.OLIVE_BED.get());
            addBefore(entries, Items.GREEN_BED, DDItems.FOREST_BED.get());
            addAfter(entries, Items.GREEN_BED, DDItems.VERDANT_BED.get());
            addBefore(entries, Items.RED_BED, DDItems.MAROON_BED.get(), DDItems.ROSE_BED.get());
            addAfter(entries, Items.RED_BED, DDItems.CORAL_BED.get());
            addBefore(entries, Items.CYAN_BED, DDItems.TEAL_BED.get());
            addAfter(entries, Items.CYAN_BED, DDItems.MINT_BED.get(), DDItems.AQUA_BED.get());
            addAfter(entries, Items.BLUE_BED, DDItems.SLATE_BED.get(), DDItems.NAVY_BED.get());
            addBefore(entries, Items.PURPLE_BED, DDItems.INDIGO_BED.get());

            addBefore(entries, Items.RED_CANDLE, DDItems.MAROON_CANDLE.get(), DDItems.ROSE_CANDLE.get());
            addAfter(entries, Items.RED_CANDLE, DDItems.CORAL_CANDLE.get());
            addBefore(entries, Items.ORANGE_CANDLE, DDItems.GINGER_CANDLE.get());
            addAfter(entries, Items.ORANGE_CANDLE, DDItems.TAN_CANDLE.get());
            addBefore(entries, Items.YELLOW_CANDLE, DDItems.BEIGE_CANDLE.get());
            addAfter(entries, Items.YELLOW_CANDLE, DDItems.AMBER_CANDLE.get(), DDItems.OLIVE_CANDLE.get());
            addBefore(entries, Items.GREEN_CANDLE, DDItems.FOREST_CANDLE.get());
            addAfter(entries, Items.GREEN_CANDLE, DDItems.VERDANT_CANDLE.get());
            addBefore(entries, Items.RED_CANDLE, DDItems.MAROON_CANDLE.get(), DDItems.ROSE_CANDLE.get());
            addAfter(entries, Items.RED_CANDLE, DDItems.CORAL_CANDLE.get());
            addBefore(entries, Items.CYAN_CANDLE, DDItems.TEAL_CANDLE.get());
            addAfter(entries, Items.CYAN_CANDLE, DDItems.MINT_CANDLE.get(), DDItems.AQUA_CANDLE.get());
            addAfter(entries, Items.BLUE_CANDLE, DDItems.SLATE_CANDLE.get(), DDItems.NAVY_CANDLE.get());
            addBefore(entries, Items.PURPLE_CANDLE, DDItems.INDIGO_CANDLE.get());

            addBefore(entries, Items.RED_BANNER, DDItems.MAROON_BANNER.get(), DDItems.ROSE_BANNER.get());
            addAfter(entries, Items.RED_BANNER, DDItems.CORAL_BANNER.get());
            addBefore(entries, Items.ORANGE_BANNER, DDItems.GINGER_BANNER.get());
            addAfter(entries, Items.ORANGE_BANNER, DDItems.TAN_BANNER.get());
            addBefore(entries, Items.YELLOW_BANNER, DDItems.BEIGE_BANNER.get());
            addAfter(entries, Items.YELLOW_BANNER, DDItems.AMBER_BANNER.get(), DDItems.OLIVE_BANNER.get());
            addBefore(entries, Items.GREEN_BANNER, DDItems.FOREST_BANNER.get());
            addAfter(entries, Items.GREEN_BANNER, DDItems.VERDANT_BANNER.get());
            addBefore(entries, Items.RED_BANNER, DDItems.MAROON_BANNER.get(), DDItems.ROSE_BANNER.get());
            addAfter(entries, Items.RED_BANNER, DDItems.CORAL_BANNER.get());
            addBefore(entries, Items.CYAN_BANNER, DDItems.TEAL_BANNER.get());
            addAfter(entries, Items.CYAN_BANNER, DDItems.MINT_BANNER.get(), DDItems.AQUA_BANNER.get());
            addAfter(entries, Items.BLUE_BANNER, DDItems.SLATE_BANNER.get(), DDItems.NAVY_BANNER.get());
            addBefore(entries, Items.PURPLE_BANNER, DDItems.INDIGO_BANNER.get());
        }
        if (tabKey.equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            addBefore(entries, Items.RED_SHULKER_BOX, DDItems.MAROON_SHULKER_BOX.get(), DDItems.ROSE_SHULKER_BOX.get());
            addAfter(entries, Items.RED_SHULKER_BOX, DDItems.CORAL_SHULKER_BOX.get());
            addBefore(entries, Items.ORANGE_SHULKER_BOX, DDItems.GINGER_SHULKER_BOX.get());
            addAfter(entries, Items.ORANGE_SHULKER_BOX, DDItems.TAN_SHULKER_BOX.get());
            addBefore(entries, Items.YELLOW_SHULKER_BOX, DDItems.BEIGE_SHULKER_BOX.get());
            addAfter(entries, Items.YELLOW_SHULKER_BOX, DDItems.AMBER_SHULKER_BOX.get(), DDItems.OLIVE_SHULKER_BOX.get());
            addBefore(entries, Items.GREEN_SHULKER_BOX, DDItems.FOREST_SHULKER_BOX.get());
            addAfter(entries, Items.GREEN_SHULKER_BOX, DDItems.VERDANT_SHULKER_BOX.get());
            addBefore(entries, Items.RED_SHULKER_BOX, DDItems.MAROON_SHULKER_BOX.get(), DDItems.ROSE_SHULKER_BOX.get());
            addAfter(entries, Items.RED_SHULKER_BOX, DDItems.CORAL_SHULKER_BOX.get());
            addBefore(entries, Items.CYAN_SHULKER_BOX, DDItems.TEAL_SHULKER_BOX.get());
            addAfter(entries, Items.CYAN_SHULKER_BOX, DDItems.MINT_SHULKER_BOX.get(), DDItems.AQUA_SHULKER_BOX.get());
            addAfter(entries, Items.BLUE_SHULKER_BOX, DDItems.SLATE_SHULKER_BOX.get(), DDItems.NAVY_SHULKER_BOX.get());
            addBefore(entries, Items.PURPLE_SHULKER_BOX, DDItems.INDIGO_SHULKER_BOX.get());

            addBefore(entries, Items.RED_BED, DDItems.MAROON_BED.get(), DDItems.ROSE_BED.get());
            addAfter(entries, Items.RED_BED, DDItems.CORAL_BED.get());
            addBefore(entries, Items.ORANGE_BED, DDItems.GINGER_BED.get());
            addAfter(entries, Items.ORANGE_BED, DDItems.TAN_BED.get());
            addBefore(entries, Items.YELLOW_BED, DDItems.BEIGE_BED.get());
            addAfter(entries, Items.YELLOW_BED, DDItems.AMBER_BED.get(), DDItems.OLIVE_BED.get());
            addBefore(entries, Items.GREEN_BED, DDItems.FOREST_BED.get());
            addAfter(entries, Items.GREEN_BED, DDItems.VERDANT_BED.get());
            addBefore(entries, Items.RED_BED, DDItems.MAROON_BED.get(), DDItems.ROSE_BED.get());
            addAfter(entries, Items.RED_BED, DDItems.CORAL_BED.get());
            addBefore(entries, Items.CYAN_BED, DDItems.TEAL_BED.get());
            addAfter(entries, Items.CYAN_BED, DDItems.MINT_BED.get(), DDItems.AQUA_BED.get());
            addAfter(entries, Items.BLUE_BED, DDItems.SLATE_BED.get(), DDItems.NAVY_BED.get());
            addBefore(entries, Items.PURPLE_BED, DDItems.INDIGO_BED.get());

            addBefore(entries, Items.RED_CANDLE, DDItems.MAROON_CANDLE.get(), DDItems.ROSE_CANDLE.get());
            addAfter(entries, Items.RED_CANDLE, DDItems.CORAL_CANDLE.get());
            addBefore(entries, Items.ORANGE_CANDLE, DDItems.GINGER_CANDLE.get());
            addAfter(entries, Items.ORANGE_CANDLE, DDItems.TAN_CANDLE.get());
            addBefore(entries, Items.YELLOW_CANDLE, DDItems.BEIGE_CANDLE.get());
            addAfter(entries, Items.YELLOW_CANDLE, DDItems.AMBER_CANDLE.get(), DDItems.OLIVE_CANDLE.get());
            addBefore(entries, Items.GREEN_CANDLE, DDItems.FOREST_CANDLE.get());
            addAfter(entries, Items.GREEN_CANDLE, DDItems.VERDANT_CANDLE.get());
            addBefore(entries, Items.RED_CANDLE, DDItems.MAROON_CANDLE.get(), DDItems.ROSE_CANDLE.get());
            addAfter(entries, Items.RED_CANDLE, DDItems.CORAL_CANDLE.get());
            addBefore(entries, Items.CYAN_CANDLE, DDItems.TEAL_CANDLE.get());
            addAfter(entries, Items.CYAN_CANDLE, DDItems.MINT_CANDLE.get(), DDItems.AQUA_CANDLE.get());
            addAfter(entries, Items.BLUE_CANDLE, DDItems.SLATE_CANDLE.get(), DDItems.NAVY_CANDLE.get());
            addBefore(entries, Items.PURPLE_CANDLE, DDItems.INDIGO_CANDLE.get());

            addBefore(entries, Items.RED_BANNER, DDItems.MAROON_BANNER.get(), DDItems.ROSE_BANNER.get());
            addAfter(entries, Items.RED_BANNER, DDItems.CORAL_BANNER.get());
            addBefore(entries, Items.ORANGE_BANNER, DDItems.GINGER_BANNER.get());
            addAfter(entries, Items.ORANGE_BANNER, DDItems.TAN_BANNER.get());
            addBefore(entries, Items.YELLOW_BANNER, DDItems.BEIGE_BANNER.get());
            addAfter(entries, Items.YELLOW_BANNER, DDItems.AMBER_BANNER.get(), DDItems.OLIVE_BANNER.get());
            addBefore(entries, Items.GREEN_BANNER, DDItems.FOREST_BANNER.get());
            addAfter(entries, Items.GREEN_BANNER, DDItems.VERDANT_BANNER.get());
            addBefore(entries, Items.RED_BANNER, DDItems.MAROON_BANNER.get(), DDItems.ROSE_BANNER.get());
            addAfter(entries, Items.RED_BANNER, DDItems.CORAL_BANNER.get());
            addBefore(entries, Items.CYAN_BANNER, DDItems.TEAL_BANNER.get());
            addAfter(entries, Items.CYAN_BANNER, DDItems.MINT_BANNER.get(), DDItems.AQUA_BANNER.get());
            addAfter(entries, Items.BLUE_BANNER, DDItems.SLATE_BANNER.get(), DDItems.NAVY_BANNER.get());
            addBefore(entries, Items.PURPLE_BANNER, DDItems.INDIGO_BANNER.get());
        }
    }

}
