package com.ninni.dye_depot.data.server;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class DDLoot extends LootTableProvider {

    public DDLoot(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, Set.of(), List.of(
                new SubProviderEntry(() -> new DDBlockLoot(lookup), LootContextParamSets.BLOCK),
                new SubProviderEntry(DDEntityLoot::new, LootContextParamSets.ENTITY)
        ));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext context) {
        // No validation
    }
}
