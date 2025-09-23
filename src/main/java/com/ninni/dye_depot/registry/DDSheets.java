package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import java.util.Arrays;
import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;

@Environment(EnvType.CLIENT)
public class DDSheets {

    public static final List<Material> SHULKER_TEXTURE_LOCATION = Arrays.stream(DDDyes.values())
            .map(DDDyes::getSerializedName)
            .map(name -> new Material(Sheets.SHULKER_SHEET, DyeDepot.modLoc("entity/shulker/shulker_" + name)))
            .toList();

    public static final List<Material> BED_TEXTURE_LOCATION = Arrays.stream(DDDyes.values())
            .map(DDDyes::getSerializedName)
            .map(name -> new Material(Sheets.BED_SHEET, DyeDepot.modLoc("entity/bed/" + name)))
            .toList();

}
