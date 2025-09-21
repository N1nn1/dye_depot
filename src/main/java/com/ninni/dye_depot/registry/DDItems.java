package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.function.Function;

public class DDItems {

    public static final DyedHolders<Item> DYES = DyedHolders.create(dye ->
            register(dye + "_dye", new DyeItem(dye, new Item.Properties()))
    );

    public static final DyedHolders<Item> SHULKER_BOXES = DyedHolders.create(dye ->
        register(dye + "_shulker_box", new BlockItem(DDBlocks.SHULKER_BOXES.getOrThrow(dye), new Item.Properties().stacksTo(1)))
    );

    public static final DyedHolders<Item> BANNERS = DyedHolders.create(dye ->
            register(dye + "_banner", new BannerItem(DDBlocks.BANNERS.getOrThrow(dye), DDBlocks.WALL_BANNERS.getOrThrow(dye), new Item.Properties()))
    );

    public static final DyedHolders<Item> BEDS = DyedHolders.create(dye ->
            register(dye + "_bed", new BedItem(DDBlocks.BEDS.getOrThrow(dye), new Item.Properties().stacksTo(1)))
    );

    static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, DyeDepot.modLoc(id), item);
    }
}
