package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import java.util.function.Supplier;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;

public class DDItems {

    public static final DyedHolders<Item, Item> DYES = DyedHolders.createModded(dye ->
            register(dye + "_dye", () -> new DyeItem(dye, new Item.Properties()))
    );

    public static final DyedHolders<Item, Item> SHULKER_BOXES = DyedHolders.createModded(dye ->
            register(dye + "_shulker_box", () -> new BlockItem(DDBlocks.SHULKER_BOXES.getOrThrow(dye), new Item.Properties().stacksTo(1)))
    );

    public static final DyedHolders<Item, Item> BANNERS = DyedHolders.createModded(dye ->
            register(dye + "_banner", () -> new BannerItem(DDBlocks.BANNERS.getOrThrow(dye), DDBlocks.WALL_BANNERS.getOrThrow(dye), new Item.Properties()))
    );

    public static final DyedHolders<Item, Item> BEDS = DyedHolders.createModded(dye ->
            register(dye + "_bed", () -> new BedItem(DDBlocks.BEDS.getOrThrow(dye), new Item.Properties().stacksTo(1)))
    );

    @SuppressWarnings("unchecked")
    private static <T extends Item> Holder<T> register(String id, Supplier<T> item) {
        return (Holder<T>) Registry.registerForHolder(BuiltInRegistries.ITEM, DyeDepot.modLoc(id), item.get());
    }
}
