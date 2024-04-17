package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class DDSoundEvents {

    public static final SoundEvent DYE_BASKET_POOF = register("block.dye_basket.poof");

    private static SoundEvent register(String name) {
        ResourceLocation id = new ResourceLocation(DyeDepot.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }
}
