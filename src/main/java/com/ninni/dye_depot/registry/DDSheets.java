package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.sprite.SpriteId;

// TODO 26.1.2 remove?
public class DDSheets {

    public static final List<SpriteId> SHULKER_TEXTURE_LOCATION = Arrays.stream(DDDyes.values())
            .map(DDDyes::getSerializedName)
            .map(name -> new SpriteId(Sheets.SHULKER_SHEET, DyeDepot.modLoc("entity/shulker/shulker_" + name)))
            .toList();

    public static final List<SpriteId> BED_TEXTURE_LOCATION = Arrays.stream(DDDyes.values())
            .map(DDDyes::getSerializedName)
            .map(name -> new SpriteId(Sheets.BED_SHEET, DyeDepot.modLoc("entity/bed/" + name)))
            .toList();

}
