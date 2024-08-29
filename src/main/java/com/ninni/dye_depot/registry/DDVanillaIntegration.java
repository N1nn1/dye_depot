package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
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
        // Cartographer additions
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 4, factories -> {
            registerMultiple(() -> factories.add(new EmeraldsForItemTag(DDTags.TRADE_BANNERS, DDItems.MAROON_BANNER, 1, 3, 12, 15)), 16);
        });

        // Mason additions
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> {
            registerMultiple(() -> factories.add(new EmeraldsForItemTag(DDTags.TRADE_TERRACOTTAS, DDItems.MAROON_TERRACOTTA, 1, 1, 12, 15)), 32);
        });

        // Shepherd additions
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> {
            registerMultiple(() -> factories.add(new ItemTagForEmeralds(DDTags.TRADE_DYES_2, DDItems.CORAL_DYE, 1, 12, 16, 30)), 5);
            registerMultiple(() -> factories.add(new EmeraldsForItemTag(DDTags.TRADE_WOOL_AND_CARPETS, DDItems.MAROON_WOOL, 1, 1, 16, 5)), 32);
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> {
            registerMultiple(() -> factories.add(new ItemTagForEmeralds(DDTags.TRADE_DYES_3, DDItems.CORAL_DYE, 1, 12, 16, 30)), 5);
            registerMultiple(() -> factories.add(new EmeraldsForItemTag(DDTags.TRADE_BEDS, DDItems.MAROON_BED, 1, 3, 12, 10)), 16);
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 4, factories -> {
            registerMultiple(() -> factories.add(new ItemTagForEmeralds(DDTags.TRADE_DYES_4, DDItems.CORAL_DYE, 1, 12, 16, 30)), 6);
            registerMultiple(() -> factories.add(new EmeraldsForItemTag(DDTags.TRADE_BANNERS, DDItems.MAROON_BANNER, 1, 3, 12, 15)), 16);
        });

        // Wandering Trader additions
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            registerMultiple(() -> factories.add(new EmeraldsForItemTag(DDTags.DYES, DDItems.MAROON_DYE, 3, 1, 12, 1)), 16);
        });
    }

    private static void registerMultiple(Runnable register, int count) {
        for (int i = 0; i < count; i++) {
            register.run();
        }
    }

    public static class EmeraldsForItemTag implements VillagerTrades.ItemListing {
        private final TagKey<Item> itemTag;
        private final Item fallback;
        private final int count;
        private final int cost;
        private final int maxUses;
        private final int xp;

        public EmeraldsForItemTag(TagKey<Item> itemTag, Item fallback, int count, int cost, int maxUses, int xp) {
            this.itemTag = itemTag;
            this.fallback = fallback;
            this.count = count;
            this.cost = cost;
            this.maxUses = maxUses;
            this.xp = xp;
        }

        @Override
        public MerchantOffer getOffer(Entity entity, RandomSource randomSource) {
            Optional<Holder<Item>> item = entity.level().registryAccess().registryOrThrow(Registries.ITEM).getRandomElementOf(this.itemTag, randomSource);

            ItemStack itemStack = item.map(itemHolder -> new ItemStack(itemHolder.value())).orElseGet(() -> new ItemStack(this.fallback));
            itemStack.setCount(this.count);

            return new MerchantOffer(new ItemCost(Items.EMERALD, this.cost), itemStack, this.maxUses, this.xp, 0.05f);
        }
    }

    public static class ItemTagForEmeralds implements VillagerTrades.ItemListing {
        private final TagKey<Item> itemTag;
        private final Item fallback;
        private final int count;
        private final int cost;
        private final int maxUses;
        private final int xp;

        public ItemTagForEmeralds(TagKey<Item> itemTag, Item fallback, int count, int cost, int maxUses, int xp) {
            this.itemTag = itemTag;
            this.fallback = fallback;
            this.count = count;
            this.cost = cost;
            this.maxUses = maxUses;
            this.xp = xp;
        }

        @Override
        public MerchantOffer getOffer(Entity entity, RandomSource randomSource) {
            Optional<Holder<Item>> holder = entity.level().registryAccess().registryOrThrow(Registries.ITEM).getRandomElementOf(this.itemTag, randomSource);

            Item item = holder.map(Holder::value).orElse(this.fallback);

            return new MerchantOffer(new ItemCost(item, this.cost), new ItemStack(Items.EMERALD, this.count), this.maxUses, this.xp, 0.05f);
        }
    }
}
