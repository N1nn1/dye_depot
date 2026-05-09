package com.ninni.dye_depot.data.server;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDItems;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.RegistryPatchGenerator;
import net.minecraft.data.tags.KeyTagProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.*;
import net.minecraft.world.item.trading.*;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

public class DDTrades extends DatapackBuiltinEntriesProvider {

    private final DataProvider tags;

    public DDTrades(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        var tags = HashMultimap.<TagKey<VillagerTrade>, ResourceKey<VillagerTrade>>create();
        var builder = new RegistrySetBuilder()
            .add(Registries.VILLAGER_TRADE, ctx -> bootstrap(new Helper(ctx, tags::put)));
        var patches = RegistryPatchGenerator.createLookup(registries, builder);
        var patched = patches.thenApply(RegistrySetBuilder.PatchedRegistries::patches);
        super(output, patches, Set.of(DyeDepot.MOD_ID));
        this.tags = new Tags(output, patched, tags);
    }

    private static void bootstrap(Helper helper) {
        //Cartographer additions
        DDBlocks.BANNERS.forEach((dye, block) ->
            helper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories ->
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
            helper.registerVillagerOffers(VillagerProfession.MASON, 4, factories ->
                factories.add("sell_terracotta_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 1),
                    new ItemStackTemplate(block.value().asItem()),
                    12, 15, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        DDBlocks.GLAZED_TERRACOTTA.forEach((dye, block) ->
            helper.registerVillagerOffers(VillagerProfession.MASON, 4, factories ->
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
            helper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                factories.add("buy_dye_" + dye, new VillagerTrade(
                    new TradeCost(DDItems.DYES.getOrThrow(dye.get()), 12),
                    new ItemStackTemplate(Items.EMERALD),
                    16, 30, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        DDBlocks.WOOL.forEach((dye, block) ->
            helper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                factories.add("sell_wool_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 1),
                    new ItemStackTemplate(block.value().asItem()),
                    16, 5, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        DDBlocks.CARPETS.forEach((dye, block) ->
            helper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                factories.add("sell_carpet_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 1),
                    new ItemStackTemplate(block.value().asItem(), 4),
                    16, 5, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        Stream.of(DDDyes.ROSE, DDDyes.SLATE, DDDyes.MINT, DDDyes.FOREST, DDDyes.GINGER).forEach(dye ->
            helper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories ->
                factories.add("buy_dye_" + dye, new VillagerTrade(
                    new TradeCost(DDItems.DYES.getOrThrow(dye.get()), 12),
                    new ItemStackTemplate(Items.EMERALD),
                    16, 30, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        DDBlocks.BEDS.forEach((dye, block) ->
            helper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories ->
                factories.add("sell_bed_" + dye, new VillagerTrade(
                    new TradeCost(Items.EMERALD, 3),
                    new ItemStackTemplate(block.value().asItem(), 4),
                    12, 10, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        Stream.of(DDDyes.MAROON, DDDyes.INDIGO, DDDyes.TEAL, DDDyes.VERDANT, DDDyes.NAVY, DDDyes.OLIVE).forEach(dye ->
            helper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories ->
                factories.add("buy_dye_" + dye, new VillagerTrade(
                    new TradeCost(DDItems.DYES.getOrThrow(dye.get()), 12),
                    new ItemStackTemplate(Items.EMERALD),
                    16, 30, 0.05f,
                    Optional.empty(), Collections.emptyList()
                ))
            )
        );

        DDBlocks.BANNERS.forEach((dye, block) ->
            helper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories ->
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
            helper.registerWanderingTraderOffers(factories ->
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
        private final BiConsumer<TagKey<VillagerTrade>, ResourceKey<VillagerTrade>> tags;

        public Helper(BootstrapContext<VillagerTrade> context, BiConsumer<TagKey<VillagerTrade>, ResourceKey<VillagerTrade>> tags) {
            this.context = context;
            this.tags = tags;
        }

        public void registerVillagerOffers(ResourceKey<VillagerProfession> profession, int level, Consumer<Factory> consumer) {
            var traderId = DyeDepot.modLoc(profession.identifier().getPath());
            var tag = TagKey.create(Registries.VILLAGER_TRADE, profession.identifier().withSuffix("/level_" + level));
            consumer.accept((name, trade) -> {
                var id = traderId.withPath(path -> String.join("/", path, Integer.toString(level), name));
                var key = ResourceKey.create(Registries.VILLAGER_TRADE, id);
                context.register(key, trade);
                tags.accept(tag, key);
            });
        }

        public void registerWanderingTraderOffers(Consumer<Factory> consumer) {
            var traderId = DyeDepot.modLoc("wandering_trader");
            var tag = VillagerTradeTags.WANDERING_TRADER_COMMON;
            consumer.accept((name, trade) -> {
                var id = traderId.withPath(path -> String.join("/", path, name));
                var key = ResourceKey.create(Registries.VILLAGER_TRADE, id);
                context.register(key, trade);
                tags.accept(tag, key);
            });
        }
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        return super.run(cache).thenCompose(_ -> tags.run(cache));
    }

    public interface Factory {
        void add(String name, VillagerTrade trade);
    }

    public static class Tags extends KeyTagProvider<VillagerTrade> {

        private final Multimap<TagKey<VillagerTrade>, ResourceKey<VillagerTrade>> supplier;

        private Tags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, Multimap<TagKey<VillagerTrade>, ResourceKey<VillagerTrade>> supplier) {
            super(output, Registries.VILLAGER_TRADE, lookupProvider, DyeDepot.MOD_ID);
            this.supplier = supplier;
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            supplier.forEach((tag, key) -> tag(tag).add(key));
        }

    }

}
