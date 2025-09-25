package com.ninni.dye_depot.data.client;

import com.ninni.dye_depot.registry.DDTags;
import com.ninni.dye_depot.registry.DyedHolders;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;

public class DDLang extends DDLangProvider {

    public DDLang(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
    }

    @Override
    protected void translateAdditional(TranslationBuilder builder) {
        builder.add("subtitles.block.dye_depot.dye_basket.poof", "Dye poofs");
        builder.add(DDTags.SMELTS_INTO_CORAL_DYE, "Corals");
    }

    @Override
    protected Stream<DyeColor> colors(String group) {
        if(group.equals("dye_basket")) return Stream.concat(DyedHolders.vanillaColors(), DyedHolders.modColors());
        return DyedHolders.modColors();
    }

    @Override
    protected String translate(DyeColor dye) {
        return Arrays.stream(dye.getSerializedName().split("_"))
                .map(it -> it.substring(0, 1).toUpperCase(Locale.ROOT) + it.substring(1))
                .collect(Collectors.joining(" "));
    }

}
