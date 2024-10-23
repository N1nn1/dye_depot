package com.ninni.dye_depot.registry;

import com.google.common.collect.ImmutableList;
import com.ninni.dye_depot.DyeDepot;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.stream.Stream;

@Environment(EnvType.CLIENT)
public class DDSheets {

    public static final List<Material> SHULKER_TEXTURE_LOCATION = Stream.of(
            "maroon",
            "rose",
            "coral",
            "indigo",
            "navy",
            "slate",
            "olive",
            "amber",
            "beige",
            "teal",
            "mint",
            "aqua",
            "verdant",
            "forest",
            "ginger",
            "tan"
    ).map((string) -> new Material(Sheets.SHULKER_SHEET,  DyeDepot.id("entity/shulker/shulker_" + string))).collect(ImmutableList.toImmutableList());

    public static final List<Material> BED_TEXTURE_LOCATION = Stream.of(
            "maroon",
            "rose",
            "coral",
            "indigo",
            "navy",
            "slate",
            "olive",
            "amber",
            "beige",
            "teal",
            "mint",
            "aqua",
            "verdant",
            "forest",
            "ginger",
            "tan"
    ).map((string) -> new Material(Sheets.BED_SHEET, DyeDepot.id("entity/bed/" + string))).collect(ImmutableList.toImmutableList());

}
