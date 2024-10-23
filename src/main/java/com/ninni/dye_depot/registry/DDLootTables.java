package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

public class DDLootTables {
    public static final ResourceKey<LootTable> SHEEP_ENTITY = create("entities/sheep");
    public static final ResourceKey<LootTable> SHEEP_SHEARING = create("shearing/sheep");

    private static ResourceKey<LootTable> create(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, DyeDepot.id(name));
    }
}
