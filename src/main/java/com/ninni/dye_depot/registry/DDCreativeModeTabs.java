package com.ninni.dye_depot.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class DDCreativeModeTabs {
    static {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.RED_DYE, DDItems.MAROON_DYE);
            entries.addAfter(Items.CYAN_DYE, DDItems.TEAL_DYE);
            entries.addAfter(Items.BLUE_DYE, DDItems.NAVY_DYE);
            entries.addAfter(Items.PURPLE_DYE, DDItems.INDIGO_DYE);
        });
    }
}
