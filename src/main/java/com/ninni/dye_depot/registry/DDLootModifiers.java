package com.ninni.dye_depot.registry;

import com.mojang.serialization.Codec;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.loot.ReplaceDropsModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDLootModifiers {

    private static final DeferredRegister<Codec<? extends IGlobalLootModifier>> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, DyeDepot.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> REPLACE_DROPS = REGISTRY.register("replace_drop", () -> ReplaceDropsModifier.CODEC);

    public static void register(IEventBus modBus) {
        REGISTRY.register(modBus);
    }

}
