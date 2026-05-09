package com.ninni.dye_depot.data.server;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDBlocks;
import java.util.function.BiConsumer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class DDEntityLoot implements LootTableSubProvider {

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> consumer) {
        DDBlocks.WOOL.forEach((color, wool) -> {
                consumer.accept(
                    ResourceKey.create(Registries.LOOT_TABLE, DyeDepot.modLoc("entities/sheep/" + color)),
                    LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(wool.value())))
                );

                consumer.accept(
                    ResourceKey.create(Registries.LOOT_TABLE, DyeDepot.modLoc("shearing/sheep/" + color)),
                    LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).add(LootItem.lootTableItem(wool.value())))
                );
            }
        );
    }

}
