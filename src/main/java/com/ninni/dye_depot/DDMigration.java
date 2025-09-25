package com.ninni.dye_depot;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class DDMigration {

    public static void addAliases() {
        migrateBlockEntity("bed");
        migrateBlockEntity("shulker_box");
        migrateBlockEntity("banner");
    }

    private static void migrateBlockEntity(String id) {
        BuiltInRegistries.BLOCK_ENTITY_TYPE.addAlias(DyeDepot.modLoc(id), ResourceLocation.withDefaultNamespace(id));
    }

}
