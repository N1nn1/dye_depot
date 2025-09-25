package com.ninni.dye_depot.registry;

import com.mojang.serialization.MapCodec;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.loot.ReplaceDropsModifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class DDLootModifiers {

    private static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> REGISTRY = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, DyeDepot.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<? extends IGlobalLootModifier>> REPLACE_DROPS = REGISTRY.register("replace_drop", () -> ReplaceDropsModifier.CODEC);

    public static void register(IEventBus modBus) {
        REGISTRY.register(modBus);
    }

}
