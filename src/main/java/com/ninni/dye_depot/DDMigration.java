package com.ninni.dye_depot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class DDMigration {

    public static void migrateBlockEntities() {
        migrateBlockEntity("bed");
        migrateBlockEntity("shulker_box");
        migrateBlockEntity("banner");
    }

    private static void migrateBlockEntity(String id) {
        var registry = (ForgeRegistry<BlockEntityType<?>>) ForgeRegistries.BLOCK_ENTITY_TYPES;
        registry.addAlias(DyeDepot.modLoc(id), new ResourceLocation(id));
    }

}
