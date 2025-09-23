package com.ninni.dye_depot.data.client;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.world.item.DyeColor;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class DDLangOverrides extends DDLangProvider {

    private static final Map<DyeColor, String> CUSTOM_NAMES = Map.of(
            DyeColor.LIGHT_BLUE, "Sky",
            DyeColor.LIGHT_GRAY, "Ash"
    );

    public DDLangOverrides(FabricDataOutput output) {
        super(output);
    }

    @Override
    protected Stream<DyeColor> colors(String group) {
        return CUSTOM_NAMES.keySet().stream();
    }

    @Override
    protected String translate(DyeColor dye) {
        return Objects.requireNonNull(CUSTOM_NAMES.get(dye));
    }
}
