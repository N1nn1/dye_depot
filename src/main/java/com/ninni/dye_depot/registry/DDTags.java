package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.Item;

public interface DDTags {
    TagKey<Item> SMELTS_INTO_CORAL_DYE = TagKey.create(Registries.ITEM, DyeDepot.modLoc("smelts_into_coral_dye"));

    TagKey<PoiType> BEDS = TagKey.create(Registries.POINT_OF_INTEREST_TYPE, DyeDepot.modLoc("beds"));
}
