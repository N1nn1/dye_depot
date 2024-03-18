package com.ninni.dye_depot.registry;

import com.google.common.collect.ImmutableMap;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.client.DDBannerRenderer;
import com.ninni.dye_depot.client.DDBedRenderer;
import com.ninni.dye_depot.client.DDShulkerBoxRenderer;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

public class DDVanillaIntegration {

    public static void serverInit() {
        addResourcePacks();
        registerVillagerTrades();
    }

    //server methods
    public static void addResourcePacks() {
        ModContainer modContainer = FabricLoader.getInstance().getModContainer(DyeDepot.MOD_ID).orElseThrow(() -> new IllegalStateException("Dye Depot's ModContainer couldn't be found!"));
        ResourceManagerHelper.registerBuiltinResourcePack(new ResourceLocation(DyeDepot.MOD_ID, "dye_override"), modContainer, "Dye Override", ResourcePackActivationType.DEFAULT_ENABLED);
    }

    private static void registerVillagerTrades() {

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MINT_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TAN_BANNER), 12, 15, 0.05f)));


        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MINT_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TAN_TERRACOTTA), 12, 15, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MINT_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_GLAZED_TERRACOTTA), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TAN_GLAZED_TERRACOTTA), 12, 15, 0.05f)));



        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.TAN_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.AQUA_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.CORAL_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD),16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.BEIGE_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.AMBER_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MINT_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_WOOL),16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_WOOL), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TAN_WOOL), 16, 5, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MINT_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_CARPET, 4), 16, 5, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TAN_CARPET, 4), 16, 5, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.ROSE_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.SLATE_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.MINT_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD),16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.FOREST_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.GINGER_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MINT_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_BED), 12, 10, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TAN_BED), 12, 10, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.MAROON_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.INDIGO_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.TEAL_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD),16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.VERDANT_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.NAVY_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(DDItems.OLIVE_DYE, 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MINT_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_BANNER), 12, 15, 0.05f)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TAN_BANNER), 12, 15, 0.05f)));


        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MINT_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_DYE, 3), 12, 1, 0.05f)));
        TradeOfferHelper.registerWanderingTraderOffers( 1, factories -> factories.add((entity, randomSource) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TAN_DYE, 3), 12, 1, 0.05f)));
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> immutableMap) {
        return new Int2ObjectOpenHashMap<>(immutableMap);
    }

    @Environment(EnvType.CLIENT)
    public static class Client {

        public static void clientInit() {
            registerModelLayers();
            registerBlockRenderLayers();
        }

        //client methods
        private static void registerModelLayers() {
            BlockEntityRendererRegistry.INSTANCE.register(DDBlockEntityType.SHULKER_BOX, DDShulkerBoxRenderer::new);
            BlockEntityRendererRegistry.INSTANCE.register(DDBlockEntityType.BED, DDBedRenderer::new);
            BlockEntityRendererRegistry.INSTANCE.register(DDBlockEntityType.BANNER, DDBannerRenderer::new);
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
