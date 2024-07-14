package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

public class DDLootTables {
    public static final ResourceKey<LootTable> SHEEP_MAROON = create("entities/sheep/maroon");
    public static final ResourceKey<LootTable> SHEEP_ROSE = create("entities/sheep/rose");
    public static final ResourceKey<LootTable> SHEEP_CORAL = create("entities/sheep/coral");
    public static final ResourceKey<LootTable> SHEEP_INDIGO = create("entities/sheep/indigo");
    public static final ResourceKey<LootTable> SHEEP_NAVY = create("entities/sheep/navy");
    public static final ResourceKey<LootTable> SHEEP_OLIVE = create("entities/sheep/olive");
    public static final ResourceKey<LootTable> SHEEP_AMBER = create("entities/sheep/amber");
    public static final ResourceKey<LootTable> SHEEP_BEIGE = create("entities/sheep/beige");
    public static final ResourceKey<LootTable> SHEEP_MINT = create("entities/sheep/mint");
    public static final ResourceKey<LootTable> SHEEP_AQUA = create("entities/sheep/aqua");
    public static final ResourceKey<LootTable> SHEEP_TEAL = create("entities/sheep/teal");
    public static final ResourceKey<LootTable> SHEEP_VERDANT = create("entities/sheep/verdant");
    public static final ResourceKey<LootTable> SHEEP_FOREST = create("entities/sheep/forest");
    public static final ResourceKey<LootTable> SHEEP_SLATE = create("entities/sheep/slate");
    public static final ResourceKey<LootTable> SHEEP_GINGER = create("entities/sheep/ginger");
    public static final ResourceKey<LootTable> SHEEP_TAN = create("entities/sheep/tan");

    private static ResourceKey<LootTable> create(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, DyeDepot.id(name));
    }
}
