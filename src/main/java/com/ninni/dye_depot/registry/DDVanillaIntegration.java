package com.ninni.dye_depot.registry;

import com.google.common.collect.ImmutableMap;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.client.particles.PoofParticleProvider;
import com.ninni.dye_depot.client.renderer.DDBannerRenderer;
import com.ninni.dye_depot.client.renderer.DDBedRenderer;
import com.ninni.dye_depot.client.renderer.DDShulkerBoxRenderer;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import java.util.stream.Stream;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;

public class DDVanillaIntegration {

    public static void commonInit() {
        addResourcePacks();
        registerLootTableAdditions();
        registerVillagerTrades();
    }

    private static void registerLootTableAdditions() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (id.equals(BuiltInLootTables.SHEPHERD_GIFT))
                tableBuilder.modifyPools(builder ->
                        DDBlocks.WOOL.forEach((dye, block) ->
                                builder.add(LootItem.lootTableItem(block.value()))
                        )
                );
            if (id.equals(BuiltInLootTables.DESERT_PYRAMID_ARCHAEOLOGY))
                tableBuilder.modifyPools(builder -> builder.add(LootItem.lootTableItem(DDItems.DYES.getOrThrow(DDDyes.BEIGE.get())).setWeight(2)));
            if (id.equals(BuiltInLootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY))
                tableBuilder.modifyPools(builder -> builder.add(LootItem.lootTableItem(DDItems.DYES.getOrThrow(DDDyes.VERDANT.get())).setWeight(3)));
        });
    }

    private static void registerVillagerTrades() {

        //Cartographer additions
        DDBlocks.BANNERS.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(block.value()), 12, 15, 0.05f))
                )
        );

        //Mason additions
        DDBlocks.TERRACOTTA.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(block.value()), 12, 15, 0.05f))
                )
        );

        DDBlocks.GLAZED_TERRACOTTA.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(block.value()), 12, 15, 0.05f))
                )
        );

        //Shepherd additions
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> {
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.TAN.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.AQUA.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.CORAL.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.BEIGE.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.AMBER.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
        });

        DDBlocks.WOOL.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(block.value()), 16, 5, 0.05f))
                )
        );

        DDBlocks.CARPETS.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(block.value(), 4), 16, 5, 0.05f))
                )
        );

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> {
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.ROSE.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.SLATE.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.MINT.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.FOREST.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.GINGER.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
        });


        DDBlocks.BEDS.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(block.value()), 12, 10, 0.05f))
                )
        );

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> {
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.MAROON.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.INDIGO.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.TEAL.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.VERDANT.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.NAVY.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.OLIVE.get()), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
        });

        DDBlocks.BANNERS.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(block.value()), 12, 15, 0.05f))
                )
        );

        //Wandering Trader additions
        DDItems.DYES.forEach((dye, item) ->
                TradeOfferHelper.registerWanderingTraderOffers(1, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(item, 3), 12, 1, 0.05f))
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> immutableMap) {
        return new Int2ObjectOpenHashMap<>(immutableMap);
    }

    public static void clientInit() {
        registerModelLayers();
        registerBlockRenderLayers();
        registerParticles();
    }

    public static void addResourcePacks() {
        ModContainer modContainer = FabricLoader.getInstance().getModContainer(DyeDepot.MOD_ID).orElseThrow(() -> new IllegalStateException("Dye Depot's ModContainer couldn't be found!"));
        ResourceManagerHelper.registerBuiltinResourcePack(DyeDepot.modLoc("dye_override"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
    }

    private static void registerModelLayers() {
        BlockEntityRendererRegistry.register(DDBlockEntityType.SHULKER_BOX, DDShulkerBoxRenderer::new);
        BlockEntityRendererRegistry.register(DDBlockEntityType.BED, DDBedRenderer::new);
        BlockEntityRendererRegistry.register(DDBlockEntityType.BANNER, DDBannerRenderer::new);
    }

    private static void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(DDParticles.DYE_POOF, PoofParticleProvider::new);
    }

    private static void registerBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(),
                Stream.concat(
                        DDBlocks.STAINED_GLASS.values(),
                        DDBlocks.STAINED_GLASS_PANES.values()
                ).toArray(Block[]::new)
        );
    }
}
