package com.ninni.dye_depot.data.server;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDItems;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.stream.Stream;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.*;
import net.minecraft.world.item.trading.*;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

public class DDTrades extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.VILLAGER_TRADE, DDTrades::bootstrap);

    public DDTrades(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DyeDepot.MOD_ID));
    }

    private static void bootstrap(BootstrapContext<VillagerTrade> context) {
        var TradeOfferHelper = new Helper(context);

        //Cartographer additions
        DDBlocks.BANNERS.forEach((dye, block) ->
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories ->
                factories.add("sell_emerald_banner_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 3),
                    new ItemStackTemplate(block.value().asItem()),
                    12, 15, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        //Mason additions
        DDBlocks.TERRACOTTA.forEach((dye, block) ->
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories ->
                factories.add("sell_terracotta_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 1),
                    new ItemStackTemplate(block.value().asItem()),
                    12, 15, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        DDBlocks.GLAZED_TERRACOTTA.forEach((dye, block) ->
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories ->
                factories.add("sell_glazed_terracotta_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 1),
                    new ItemStackTemplate(block.value().asItem()),
                    12, 15, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        //Shepherd additions
        Stream.of(DDDyes.TAN, DDDyes.AQUA, DDDyes.CORAL, DDDyes.BEIGE, DDDyes.AMBER).forEach(dye ->
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                factories.add("buy_dye_" + dye, new VillagerTrade(
                    new TradeCost(DDItems.DYES.getOrThrow(dye.get()), 12),
                    new ItemStackTemplate(Items.EMERALD),
                    16, 30, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        DDBlocks.WOOL.forEach((dye, block) ->
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                factories.add("sell_wool_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 1),
                    new ItemStackTemplate(block.value().asItem()),
                    16, 5, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        DDBlocks.CARPETS.forEach((dye, block) ->
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                factories.add("sell_carpet_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 1),
                    new ItemStackTemplate(block.value().asItem(), 4),
                    16, 5, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        Stream.of(DDDyes.ROSE, DDDyes.SLATE, DDDyes.MINT, DDDyes.FOREST, DDDyes.GINGER).forEach(dye ->
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                factories.add("buy_dye_" + dye, new VillagerTrade(
                    new TradeCost(DDItems.DYES.getOrThrow(dye.get()), 12),
                    new ItemStackTemplate(Items.EMERALD),
                    16, 30, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        DDBlocks.BEDS.forEach((dye, block) ->
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories ->
                factories.add("sell_bed_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 3),
                    new ItemStackTemplate(block.value().asItem(), 4),
                    12, 10, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        Stream.of(DDDyes.MAROON, DDDyes.INDIGO, DDDyes.TEAL, DDDyes.VERDANT, DDDyes.NAVY, DDDyes.OLIVE).forEach(dye ->
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories ->
                factories.add("buy_dye_" + dye, new VillagerTrade(
                    new TradeCost(DDItems.DYES.getOrThrow(dye.get()), 12),
                    new ItemStackTemplate(Items.EMERALD),
                    16, 30, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        DDBlocks.BANNERS.forEach((dye, block) ->
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories ->
                factories.add("sell_banner_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 3),
                    new ItemStackTemplate(block.value().asItem(), 4),
                    16, 15, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        //Wandering Trader additions
        DDItems.DYES.forEach((dye, item) ->
            TradeOfferHelper.registerWanderingTraderOffers(factories ->
                factories.add("sell_dye_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 1),
                    new ItemStackTemplate(item.value(), 4),
                    16, 15, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );
    }

    public static class Helper {
        private final BootstrapContext<VillagerTrade> context;

        public Helper(BootstrapContext<VillagerTrade> context) {
            this.context = context;
        }

        public void registerVillagerOffers(ResourceKey<VillagerProfession> profession, int level, Consumer<Factory> consumer) {
            consumer.accept((name, trade) -> {
                var id = profession.identifier().withPath(path -> String.join("/", path, Integer.toString(level), DyeDepot.MOD_ID, name));
                context.register(ResourceKey.create(Registries.VILLAGER_TRADE, id), trade);
            });
        }

        public void registerWanderingTraderOffers(Consumer<Factory> consumer) {
            var traderId = Identifier.withDefaultNamespace("wandering_trader");
            consumer.accept((name, trade) -> {
                var id = traderId.withPath(path -> String.join("/", path, DyeDepot.MOD_ID, name));
                context.register(ResourceKey.create(Registries.VILLAGER_TRADE, id), trade);
            });
        }
    }

    public interface Factory {
        void add(String name, VillagerTrade trade);
    }

}
