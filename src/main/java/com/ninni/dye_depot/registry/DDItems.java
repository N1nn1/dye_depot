package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import java.util.function.Supplier;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDItems {

    static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(Registries.ITEM, DyeDepot.MOD_ID);

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
        return (Holder<T>) REGISTRY.register(id, item);
    }

    public static void register(IEventBus modBus) {
        REGISTRY.register(modBus);
    }

}
