package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public interface DDTags {
    //Item tags
    TagKey<Item> SMELTS_INTO_CORAL_DYE = TagKey.create(Registries.ITEM, DyeDepot.modLoc("smelts_into_coral_dye"));
}
