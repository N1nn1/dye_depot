package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public interface DDTags {
    TagKey<Item> DYES = item("dyes");
    TagKey<Item> TRADE_BANNERS = item("trade/banners");
    TagKey<Item> TRADE_TERRACOTTAS = item("trade/terracottas");
    TagKey<Item> TRADE_DYES_2 = item("trade/dyes_2");
    TagKey<Item> TRADE_DYES_3 = item("trade/dyes_3");
    TagKey<Item> TRADE_DYES_4 = item("trade/dyes_4");
    TagKey<Item> TRADE_WOOL_AND_CARPETS = item("trade/wool_and_carpets");
    TagKey<Item> TRADE_BEDS = item("trade/beds");

    static TagKey<Item> item(String name) {
        return TagKey.create(Registries.ITEM, DyeDepot.id(name));
    }
}
