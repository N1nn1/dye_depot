package com.ninni.dye_depot.registry;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;

public class DDVanillaIntegration {

    public static void commonInit() {
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
}
