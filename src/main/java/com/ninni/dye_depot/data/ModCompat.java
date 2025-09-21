package com.ninni.dye_depot.data;

import com.google.gson.JsonObject;
import com.ninni.dye_depot.registry.DyedHolders;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class ModCompat {

    public static final String SUPPLEMENTARIES = "supplementaries";

    public static <T> DyedHolders<T> supplementariesHolders(Registry<T> registry, String name) {
        return DyedHolders.fromRegistry(registry, DyedHolders.modColors(), color -> new ResourceLocation(SUPPLEMENTARIES, name + "_" + color));
    }

    public static ConditionJsonProvider supplementariesFlag(String flag) {
        return DefaultResourceConditions.and(
                DefaultResourceConditions.allModsLoaded(SUPPLEMENTARIES),
                new ConditionJsonProvider() {
                    @Override
                    public ResourceLocation getConditionId() {
                        return new ResourceLocation(SUPPLEMENTARIES, "flag");
                    }

                    @Override
                    public void writeParameters(JsonObject json) {
                        json.addProperty("flag", flag);
                    }
                }
        );
    }

}
