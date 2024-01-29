package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;

public class DDItems {

    public static final Item INDIGO_DYE = register("indigo_dye", new DyeItem(DDDyes.INDIGO.get(), new Item.Properties()));
    public static final Item MAROON_DYE = register("maroon_dye", new DyeItem(DDDyes.MAROON.get(), new Item.Properties()));
    public static final Item NAVY_DYE = register("navy_dye", new DyeItem(DDDyes.NAVY.get(), new Item.Properties()));
    public static final Item TEAL_DYE = register("teal_dye", new DyeItem(DDDyes.TEAL.get(), new Item.Properties()));

    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(DyeDepot.MOD_ID, id), item);
    }
}
