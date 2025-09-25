package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDSoundEvents {

    private static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, DyeDepot.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> DYE_BASKET_POOF = register("block.dye_basket.poof");

    private static DeferredHolder<SoundEvent, SoundEvent> register(String name) {
        ResourceLocation id = DyeDepot.modLoc(name);
        return REGISTRY.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus modBus) {
        REGISTRY.register(modBus);
    }

}
