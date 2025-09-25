package com.ninni.dye_depot.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

public class ReplaceDropsModifier extends LootModifier {


    public static MapCodec<ReplaceDropsModifier> CODEC = RecordCodecBuilder.mapCodec(builder ->
            codecStart(builder)
                    .and(SimpleWeightedRandomList.wrappedCodec(ItemStack.CODEC).fieldOf("items").forGetter(it -> it.items))
                    .apply(builder, ReplaceDropsModifier::new)
    );

    private final SimpleWeightedRandomList<ItemStack> items;

    protected ReplaceDropsModifier(LootItemCondition[] conditions, SimpleWeightedRandomList<ItemStack> items) {
        super(conditions);
        this.items = items;
    }

    public static ReplaceDropsModifier forTable(ResourceKey<LootTable> id, float chance, SimpleWeightedRandomList<ItemStack> items) {
        return new ReplaceDropsModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(chance).build(),
                LootTableIdCondition.builder(id.location()).build()
        }, items);
    }

    @Override
    public ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> stacks, LootContext context) {
        var item = items.getRandomValue(context.getRandom());
        return item.map(it -> {
            var list = new ObjectArrayList<ItemStack>(1);
            list.add(it);
            return list;
        }).orElse(stacks);
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
