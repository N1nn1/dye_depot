package com.ninni.dye_depot;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class DDMigration {

    public static void addAliases() {
        // TODO 26.1.2 can probably remove this
        migrateBlockEntity("bed");
        migrateBlockEntity("shulker_box");
        migrateBlockEntity("banner");
    }

    private static void migrateBlockEntity(String id) {
        BuiltInRegistries.BLOCK_ENTITY_TYPE.addAlias(DyeDepot.modLoc(id), Identifier.withDefaultNamespace(id));
    }

}
