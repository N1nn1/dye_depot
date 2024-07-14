package com.ninni.dye_depot.registry;

import com.google.common.collect.ImmutableMap;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.client.particles.PoofParticle;
import com.ninni.dye_depot.client.renderer.DDBannerRenderer;
import com.ninni.dye_depot.client.renderer.DDBedRenderer;
import com.ninni.dye_depot.client.renderer.DDShulkerBoxRenderer;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import java.util.Optional;

public class DDVanillaIntegration {

    public static void serverInit() {
        addResourcePacks();
        registerLootTableAdditions();
        registerVillagerTrades();
    }

    //server methods
    public static void addResourcePacks() {
        ModContainer modContainer = FabricLoader.getInstance().getModContainer(DyeDepot.MOD_ID).orElseThrow(() -> new IllegalStateException("Dye Depot's ModContainer couldn't be found!"));
        ResourceManagerHelper.registerBuiltinResourcePack(DyeDepot.id("dye_override"), modContainer, Component.literal("Dye Override"), ResourcePackActivationType.DEFAULT_ENABLED);
    }

    private static void registerLootTableAdditions() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key.equals(BuiltInLootTables.SHEPHERD_GIFT)) tableBuilder.modifyPools(builder -> builder.add(LootItem.lootTableItem(DDItems.MAROON_WOOL)).add(LootItem.lootTableItem(DDItems.ROSE_WOOL)).add(LootItem.lootTableItem(DDItems.CORAL_WOOL)).add(LootItem.lootTableItem(DDItems.INDIGO_WOOL)).add(LootItem.lootTableItem(DDItems.NAVY_WOOL)).add(LootItem.lootTableItem(DDItems.SLATE_WOOL)).add(LootItem.lootTableItem(DDItems.OLIVE_WOOL)).add(LootItem.lootTableItem(DDItems.AMBER_WOOL)).add(LootItem.lootTableItem(DDItems.BEIGE_WOOL)).add(LootItem.lootTableItem(DDItems.TEAL_WOOL)).add(LootItem.lootTableItem(DDItems.MINT_WOOL)).add(LootItem.lootTableItem(DDItems.AQUA_WOOL)).add(LootItem.lootTableItem(DDItems.VERDANT_WOOL)).add(LootItem.lootTableItem(DDItems.FOREST_WOOL)).add(LootItem.lootTableItem(DDItems.GINGER_WOOL)).add(LootItem.lootTableItem(DDItems.TAN_WOOL)));
            if (key.equals(BuiltInLootTables.DESERT_PYRAMID_ARCHAEOLOGY)) tableBuilder.modifyPools(builder -> builder.add(LootItem.lootTableItem(DDItems.BEIGE_DYE).setWeight(2)));
            if (key.equals(BuiltInLootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY)) tableBuilder.modifyPools(builder -> builder.add(LootItem.lootTableItem(DDItems.VERDANT_DYE).setWeight(3)));
        });
    }

    private static void registerVillagerTrades() {

        //Cartographer additions
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.MAROON_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.ROSE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.CORAL_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.INDIGO_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.NAVY_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.SLATE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.OLIVE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.AMBER_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.BEIGE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.TEAL_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.MINT_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.AQUA_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.VERDANT_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.FOREST_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.GINGER_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.TAN_BANNER), 12, 15, 0.05f)));

        //Mason additions
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.MAROON_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.ROSE_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.CORAL_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.INDIGO_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.NAVY_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.SLATE_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.OLIVE_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.AMBER_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.BEIGE_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.TEAL_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.MINT_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.AQUA_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.VERDANT_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.FOREST_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.GINGER_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.TAN_TERRACOTTA), 12, 15, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.MAROON_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.ROSE_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.CORAL_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.INDIGO_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.NAVY_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.SLATE_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.OLIVE_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.AMBER_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.BEIGE_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.TEAL_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.MINT_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.AQUA_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.VERDANT_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.FOREST_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.GINGER_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.TAN_GLAZED_TERRACOTTA), 12, 15, 0.05f)));

        //Shepherd additions
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.TAN_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.AQUA_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.CORAL_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD),16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.BEIGE_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.AMBER_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.MAROON_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.ROSE_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.CORAL_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.INDIGO_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.NAVY_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.SLATE_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.OLIVE_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.AMBER_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.BEIGE_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.TEAL_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.MINT_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.AQUA_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.VERDANT_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.FOREST_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.GINGER_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.TAN_WOOL), 16, 5, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.MAROON_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.ROSE_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.CORAL_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.INDIGO_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.NAVY_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.SLATE_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.OLIVE_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.AMBER_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.BEIGE_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.TEAL_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.MINT_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.AQUA_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.VERDANT_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.FOREST_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.GINGER_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.TAN_CARPET, 4), 16, 5, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.ROSE_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.SLATE_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.MINT_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD),16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.FOREST_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.GINGER_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.MAROON_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.ROSE_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.CORAL_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.INDIGO_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.NAVY_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.SLATE_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.OLIVE_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.AMBER_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.BEIGE_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.TEAL_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.MINT_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.AQUA_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.VERDANT_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.FOREST_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.GINGER_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.TAN_BED), 12, 10, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.MAROON_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.INDIGO_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.TEAL_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD),16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.VERDANT_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.NAVY_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(DDItems.OLIVE_DYE, 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.MAROON_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.ROSE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.CORAL_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.INDIGO_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.NAVY_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.SLATE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.OLIVE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.AMBER_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.BEIGE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.TEAL_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.MINT_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.AQUA_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.VERDANT_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.FOREST_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.GINGER_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(DDItems.TAN_BANNER), 12, 15, 0.05f)));

        //Wandering Trader additions
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.MAROON_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.ROSE_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.CORAL_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.INDIGO_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.NAVY_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.SLATE_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.OLIVE_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.AMBER_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.BEIGE_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.TEAL_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.MINT_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.AQUA_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.VERDANT_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.FOREST_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.GINGER_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(DDItems.TAN_DYE, 3), 12, 1, 0.05f)));
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> immutableMap) {
        return new Int2ObjectOpenHashMap<>(immutableMap);
    }

    @Environment(EnvType.CLIENT)
    public static class Client {

        public static void clientInit() {
            registerModelLayers();
            registerBlockRenderLayers();
            registerParticles();
        }

        //client methods
        private static void registerModelLayers() {
            BlockEntityRenderers.register(DDBlockEntityTypes.SHULKER_BOX, DDShulkerBoxRenderer::new);
            BlockEntityRenderers.register(DDBlockEntityTypes.BED, DDBedRenderer::new);
            BlockEntityRenderers.register(DDBlockEntityTypes.BANNER, DDBannerRenderer::new);
        }

        private static void registerParticles() {
            ParticleFactoryRegistry.getInstance().register(DDParticles.DYE_POOF, PoofParticle.Provider::new);
        }

        private static void registerBlockRenderLayers() {
            BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(),
                    DDBlocks.MAROON_STAINED_GLASS,
                    DDBlocks.ROSE_STAINED_GLASS,
                    DDBlocks.CORAL_STAINED_GLASS,
                    DDBlocks.INDIGO_STAINED_GLASS,
                    DDBlocks.NAVY_STAINED_GLASS,
                    DDBlocks.SLATE_STAINED_GLASS,
                    DDBlocks.OLIVE_STAINED_GLASS,
                    DDBlocks.AMBER_STAINED_GLASS,
                    DDBlocks.BEIGE_STAINED_GLASS,
                    DDBlocks.TEAL_STAINED_GLASS,
                    DDBlocks.MINT_STAINED_GLASS,
                    DDBlocks.AQUA_STAINED_GLASS,
                    DDBlocks.VERDANT_STAINED_GLASS,
                    DDBlocks.FOREST_STAINED_GLASS,
                    DDBlocks.GINGER_STAINED_GLASS,
                    DDBlocks.TAN_STAINED_GLASS,
                    DDBlocks.MAROON_STAINED_GLASS_PANE,
                    DDBlocks.ROSE_STAINED_GLASS_PANE,
                    DDBlocks.CORAL_STAINED_GLASS_PANE,
                    DDBlocks.INDIGO_STAINED_GLASS_PANE,
                    DDBlocks.NAVY_STAINED_GLASS_PANE,
                    DDBlocks.SLATE_STAINED_GLASS_PANE,
                    DDBlocks.OLIVE_STAINED_GLASS_PANE,
                    DDBlocks.AMBER_STAINED_GLASS_PANE,
                    DDBlocks.BEIGE_STAINED_GLASS_PANE,
                    DDBlocks.TEAL_STAINED_GLASS_PANE,
                    DDBlocks.MINT_STAINED_GLASS_PANE,
                    DDBlocks.AQUA_STAINED_GLASS_PANE,
                    DDBlocks.VERDANT_STAINED_GLASS_PANE,
                    DDBlocks.FOREST_STAINED_GLASS_PANE,
                    DDBlocks.GINGER_STAINED_GLASS_PANE,
                    DDBlocks.TAN_STAINED_GLASS_PANE
            );
        }
    }
}
