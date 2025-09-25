package com.ninni.dye_depot.registry;

import java.util.Optional;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

public class DDVanillaIntegration {

    public static void commonInit() {
        registerVillagerTrades();
    }

    private static void registerVillagerTrades() {
        //Cartographer additions
        DDBlocks.BANNERS.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(block.value()), 12, 15, 0.05f))
                )
        );

        //Mason additions
        DDBlocks.TERRACOTTA.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(block.value()), 12, 15, 0.05f))
                )
        );

        DDBlocks.GLAZED_TERRACOTTA.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(block.value()), 12, 15, 0.05f))
                )
        );

        //Shepherd additions
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> {
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.TAN.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.AQUA.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.CORAL.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.BEIGE.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.AMBER.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
        });

        DDBlocks.WOOL.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(block.value()), 16, 5, 0.05f))
                )
        );

        DDBlocks.CARPETS.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(block.value(), 4), 16, 5, 0.05f))
                )
        );

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> {
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.ROSE.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.SLATE.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.MINT.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.FOREST.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.GINGER.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
        });


        DDBlocks.BEDS.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(block.value()), 12, 10, 0.05f))
                )
        );

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> {
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.MAROON.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.INDIGO.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.TEAL.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.VERDANT.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.NAVY.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            factories.add((entity, random) -> new MerchantOffer(new ItemCost(DDItems.DYES.getOrThrow(DDDyes.OLIVE.get()), 12), Optional.empty(), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
        });

        DDBlocks.BANNERS.forEach((dye, block) ->
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Optional.empty(), new ItemStack(block.value()), 12, 15, 0.05f))
                )
        );

        //Wandering Trader additions
        DDItems.DYES.forEach((dye, item) ->
                TradeOfferHelper.registerWanderingTraderOffers(1, factories ->
                        factories.add((entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), Optional.empty(), new ItemStack(item, 3), 12, 1, 0.05f))
                )
        );
    }
}
