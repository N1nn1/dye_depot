package com.ninni.dye_depot.registry;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ninni.dye_depot.DyeDepot;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.Util;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = DyeDepot.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DDLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, DyeDepot.MOD_ID);

    public static final RegistryObject<Codec<VillagerGiftLootModifier>> VILLAGER_GIFT_LOOT_MODIFIER = LOOT_MODIFIERS.register("villager_gift_loot_modifier", () -> VillagerGiftLootModifier.CODEC);
    public static final RegistryObject<Codec<ArcheologyLootModifier>> ARCHEOLOGY_LOOT_MODIFIER = LOOT_MODIFIERS.register("archeology_loot_modifier", () -> ArcheologyLootModifier.CODEC);

    public static class VillagerGiftLootModifier extends LootModifier {
        private static final Codec<VillagerGiftLootModifier> CODEC = RecordCodecBuilder.create(instance -> codecStart(instance).apply(instance, VillagerGiftLootModifier::new));
        private static final List<Supplier<Item>> LIST = Util.make(Lists.newArrayList(), list -> {
            list.add(DDItems.MAROON_WOOL);
            list.add(DDItems.ROSE_WOOL);
            list.add(DDItems.CORAL_WOOL);
            list.add(DDItems.INDIGO_WOOL);
            list.add(DDItems.NAVY_WOOL);
            list.add(DDItems.SLATE_WOOL);
            list.add(DDItems.OLIVE_WOOL);
            list.add(DDItems.AMBER_WOOL);
            list.add(DDItems.BEIGE_WOOL);
            list.add(DDItems.TEAL_WOOL);
            list.add(DDItems.MINT_WOOL);
            list.add(DDItems.AQUA_WOOL);
            list.add(DDItems.VERDANT_WOOL);
            list.add(DDItems.FOREST_WOOL);
            list.add(DDItems.GINGER_WOOL);
            list.add(DDItems.TAN_WOOL);
        });

        protected VillagerGiftLootModifier(LootItemCondition[] conditionsIn) {
            super(new LootItemCondition[]{LootTableIdCondition.builder(BuiltInLootTables.SHEPHERD_GIFT).build()});
        }

        @Override
        protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
            if (context.getRandom().nextBoolean()) {
                return generatedLoot;
            }
            generatedLoot.clear();
            generatedLoot.add(new ItemStack(LIST.get(context.getRandom().nextInt(LIST.size())).get()));
            return generatedLoot;
        }

        @Override
        public Codec<? extends IGlobalLootModifier> codec() {
            return CODEC;
        }
    }

    public static class ArcheologyLootModifier extends LootModifier {
        private static final Codec<ArcheologyLootModifier> CODEC = RecordCodecBuilder.create(instance -> codecStart(instance).and(
                instance.group(
                        Codec.intRange(0, 256).fieldOf("weight").forGetter(lm -> lm.weight),
                        ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(lm -> lm.item)
                )).apply(instance, ArcheologyLootModifier::new));
        private final Item item;
        private final int weight;

        protected ArcheologyLootModifier(LootItemCondition[] conditionsIn, int weight, Item item) {
            super(conditionsIn);
            this.weight = weight;
            this.item = item;
        }

        @Override
        protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
            RandomSource random = context.getRandom();
            int weight = random.nextInt(this.weight) - this.weight;
            if (weight < 0 && random.nextFloat() < 0.1F) {
                generatedLoot.clear();
                generatedLoot.add(new ItemStack(this.item));
                return generatedLoot;
            }
            return generatedLoot;
        }

        @Override
        public Codec<? extends IGlobalLootModifier> codec() {
            return CODEC;
        }
    }

}
