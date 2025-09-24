package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DDSoundEvents {

    private static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, DyeDepot.MOD_ID);

    public static final RegistryObject<SoundEvent> DYE_BASKET_POOF = register("block.dye_basket.poof");

    private static RegistryObject<SoundEvent> register(String name) {
        ResourceLocation id = DyeDepot.modLoc(name);
        return REGISTRY.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus modBus) {
        REGISTRY.register(modBus);
    }

}
