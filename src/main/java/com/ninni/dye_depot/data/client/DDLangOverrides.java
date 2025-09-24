package com.ninni.dye_depot.data.client;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;

public class DDLangOverrides extends DDLangProvider {

    private static final Map<DyeColor, String> CUSTOM_NAMES = Map.of(
            DyeColor.LIGHT_BLUE, "Sky",
            DyeColor.LIGHT_GRAY, "Ash"
    );

    public DDLangOverrides(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
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
