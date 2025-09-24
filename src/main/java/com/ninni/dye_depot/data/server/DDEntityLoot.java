package com.ninni.dye_depot.data.server;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDBlocks;
import java.util.function.BiConsumer;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

public class DDEntityLoot implements LootTableSubProvider {

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        DDBlocks.WOOL.forEach((color, wool) ->
                consumer.accept(DyeDepot.modLoc("entities/sheep/" + color), EntityLootSubProvider.createSheepTable(wool.value()))
        );
    }

}
