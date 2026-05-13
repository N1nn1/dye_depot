package com.ninni.dye_depot.data.server;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.loot.ReplaceDropsModifier;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDItems;
import net.minecraft.data.PackOutput;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class DDLootModifiersProvider extends GlobalLootModifierProvider {

    public DDLootModifiersProvider(PackOutput output) {
        super(output, DyeDepot.MOD_ID);
    }

    @Override
    protected void start() {
        add("modify_shepherd_gift", ReplaceDropsModifier.forTable(
                BuiltInLootTables.SHEPHERD_GIFT,
                0.1F,
                createWoolList()
        ));

        add("modify_desert_pyramid", ReplaceDropsModifier.forTable(
                BuiltInLootTables.DESERT_PYRAMID_ARCHAEOLOGY,
                0.1F,
                SimpleWeightedRandomList.single(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.BEIGE.get())))
        ));

        add("modify_ocean_ruin_cold", ReplaceDropsModifier.forTable(
                BuiltInLootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY,
                0.1F,
                SimpleWeightedRandomList.single(new ItemStack(DDItems.DYES.getOrThrow(DDDyes.VERDANT.get())))
        ));
    }

    private SimpleWeightedRandomList<ItemStack> createWoolList() {
        var builder = SimpleWeightedRandomList.<ItemStack>builder();
        DDBlocks.WOOL.values()
                .map(ItemStack::new)
                .forEach(it -> builder.add(it, 1));
        return builder.build();
    }

}
