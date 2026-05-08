package com.ninni.dye_depot.registry;

import java.util.List;
import java.util.function.Consumer;

import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.trading.VillagerTrades;
import net.neoforged.neoforge.common.NeoForge;

public class TradeOfferHelper {

    public static void registerVillagerOffers(VillagerProfession profession, int level, Consumer<List<VillagerTrades.ItemListing>> consumer) {
        NeoForge.EVENT_BUS.addListener((VillagerTradesEvent event) -> {
            if (event.getType() != profession) return;
            var factories = event.getTrades().get(level);
            consumer.accept(factories);
        });
    }

    public static void registerWanderingTraderOffers(int level, Consumer<List<VillagerTrades.ItemListing>> consumer) {
        NeoForge.EVENT_BUS.addListener((WandererTradesEvent event) -> {
            var factories = level > 1 ? event.getRareTrades() : event.getGenericTrades();
            consumer.accept(factories);
        });
    }

}
