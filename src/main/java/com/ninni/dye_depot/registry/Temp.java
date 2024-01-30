package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.CandleCakeBlock;

public class Temp {


    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(DyeDepot.MOD_ID, id), item);
    }
    
    private static Block register(String id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(DyeDepot.MOD_ID, id), block);
    }
}
