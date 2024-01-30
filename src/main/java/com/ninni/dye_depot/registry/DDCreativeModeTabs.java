package com.ninni.dye_depot.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;

import static com.ninni.dye_depot.registry.DDItems.*;
import static net.minecraft.world.item.Items.*;

public class DDCreativeModeTabs {
    static {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {

            entries.addBefore(RED_DYE, MAROON_DYE, ROSE_DYE);
            entries.addAfter(RED_DYE, CORAL_DYE);
            entries.addBefore(ORANGE_DYE, GINGER_DYE);
            entries.addAfter(ORANGE_DYE, TAN_DYE);
            entries.addBefore(YELLOW_DYE, BEIGE_DYE);
            entries.addAfter(YELLOW_DYE, AMBER_DYE, OLIVE_DYE);
            entries.addBefore(GREEN_DYE, FOREST_DYE);
            entries.addAfter(GREEN_DYE, VERDANT_DYE);
            entries.addBefore(RED_DYE, MAROON_DYE, ROSE_DYE);
            entries.addAfter(RED_DYE, CORAL_DYE);
            entries.addBefore(CYAN_DYE, TEAL_DYE);
            entries.addAfter(CYAN_DYE, TURQUOISE_DYE, AQUA_DYE);
            entries.addAfter(BLUE_DYE, SLATE_DYE, NAVY_DYE);
            entries.addBefore(PURPLE_DYE, INDIGO_DYE);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(entries -> {

            entries.addBefore(RED_WOOL, MAROON_WOOL, ROSE_WOOL);
            entries.addAfter(RED_WOOL, CORAL_WOOL);
            entries.addBefore(ORANGE_WOOL, GINGER_WOOL);
            entries.addAfter(ORANGE_WOOL, TAN_WOOL);
            entries.addBefore(YELLOW_WOOL, BEIGE_WOOL);
            entries.addAfter(YELLOW_WOOL, AMBER_WOOL, OLIVE_WOOL);
            entries.addBefore(GREEN_WOOL, FOREST_WOOL);
            entries.addAfter(GREEN_WOOL, VERDANT_WOOL);
            entries.addBefore(RED_WOOL, MAROON_WOOL, ROSE_WOOL);
            entries.addAfter(RED_WOOL, CORAL_WOOL);
            entries.addBefore(CYAN_WOOL, TEAL_WOOL);
            entries.addAfter(CYAN_WOOL, TURQUOISE_WOOL, AQUA_WOOL);
            entries.addAfter(BLUE_WOOL, SLATE_WOOL, NAVY_WOOL);
            entries.addBefore(PURPLE_WOOL, INDIGO_WOOL);

            entries.addBefore(RED_CARPET, MAROON_CARPET, ROSE_CARPET);
            entries.addAfter(RED_CARPET, CORAL_CARPET);
            entries.addBefore(ORANGE_CARPET, GINGER_CARPET);
            entries.addAfter(ORANGE_CARPET, TAN_CARPET);
            entries.addBefore(YELLOW_CARPET, BEIGE_CARPET);
            entries.addAfter(YELLOW_CARPET, AMBER_CARPET, OLIVE_CARPET);
            entries.addBefore(GREEN_CARPET, FOREST_CARPET);
            entries.addAfter(GREEN_CARPET, VERDANT_CARPET);
            entries.addBefore(RED_CARPET, MAROON_CARPET, ROSE_CARPET);
            entries.addAfter(RED_CARPET, CORAL_CARPET);
            entries.addBefore(CYAN_CARPET, TEAL_CARPET);
            entries.addAfter(CYAN_CARPET, TURQUOISE_CARPET, AQUA_CARPET);
            entries.addAfter(BLUE_CARPET, SLATE_CARPET, NAVY_CARPET);
            entries.addBefore(PURPLE_CARPET, INDIGO_CARPET);

            entries.addBefore(RED_TERRACOTTA, MAROON_TERRACOTTA, ROSE_TERRACOTTA);
            entries.addAfter(RED_TERRACOTTA, CORAL_TERRACOTTA);
            entries.addBefore(ORANGE_TERRACOTTA, GINGER_TERRACOTTA);
            entries.addAfter(ORANGE_TERRACOTTA, TAN_TERRACOTTA);
            entries.addBefore(YELLOW_TERRACOTTA, BEIGE_TERRACOTTA);
            entries.addAfter(YELLOW_TERRACOTTA, AMBER_TERRACOTTA, OLIVE_TERRACOTTA);
            entries.addBefore(GREEN_TERRACOTTA, FOREST_TERRACOTTA);
            entries.addAfter(GREEN_TERRACOTTA, VERDANT_TERRACOTTA);
            entries.addBefore(RED_TERRACOTTA, MAROON_TERRACOTTA, ROSE_TERRACOTTA);
            entries.addAfter(RED_TERRACOTTA, CORAL_TERRACOTTA);
            entries.addBefore(CYAN_TERRACOTTA, TEAL_TERRACOTTA);
            entries.addAfter(CYAN_TERRACOTTA, TURQUOISE_TERRACOTTA, AQUA_TERRACOTTA);
            entries.addAfter(BLUE_TERRACOTTA, SLATE_TERRACOTTA, NAVY_TERRACOTTA);
            entries.addBefore(PURPLE_TERRACOTTA, INDIGO_TERRACOTTA);

            entries.addBefore(RED_CONCRETE, MAROON_CONCRETE, ROSE_CONCRETE);
            entries.addAfter(RED_CONCRETE, CORAL_CONCRETE);
            entries.addBefore(ORANGE_CONCRETE, GINGER_CONCRETE);
            entries.addAfter(ORANGE_CONCRETE, TAN_CONCRETE);
            entries.addBefore(YELLOW_CONCRETE, BEIGE_CONCRETE);
            entries.addAfter(YELLOW_CONCRETE, AMBER_CONCRETE, OLIVE_CONCRETE);
            entries.addBefore(GREEN_CONCRETE, FOREST_CONCRETE);
            entries.addAfter(GREEN_CONCRETE, VERDANT_CONCRETE);
            entries.addBefore(RED_CONCRETE, MAROON_CONCRETE, ROSE_CONCRETE);
            entries.addAfter(RED_CONCRETE, CORAL_CONCRETE);
            entries.addBefore(CYAN_CONCRETE, TEAL_CONCRETE);
            entries.addAfter(CYAN_CONCRETE, TURQUOISE_CONCRETE, AQUA_CONCRETE);
            entries.addAfter(BLUE_CONCRETE, SLATE_CONCRETE, NAVY_CONCRETE);
            entries.addBefore(PURPLE_CONCRETE, INDIGO_CONCRETE);

            entries.addBefore(RED_CONCRETE_POWDER, MAROON_CONCRETE_POWDER, ROSE_CONCRETE_POWDER);
            entries.addAfter(RED_CONCRETE_POWDER, CORAL_CONCRETE_POWDER);
            entries.addBefore(ORANGE_CONCRETE_POWDER, GINGER_CONCRETE_POWDER);
            entries.addAfter(ORANGE_CONCRETE_POWDER, TAN_CONCRETE_POWDER);
            entries.addBefore(YELLOW_CONCRETE_POWDER, BEIGE_CONCRETE_POWDER);
            entries.addAfter(YELLOW_CONCRETE_POWDER, AMBER_CONCRETE_POWDER, OLIVE_CONCRETE_POWDER);
            entries.addBefore(GREEN_CONCRETE_POWDER, FOREST_CONCRETE_POWDER);
            entries.addAfter(GREEN_CONCRETE_POWDER, VERDANT_CONCRETE_POWDER);
            entries.addBefore(RED_CONCRETE_POWDER, MAROON_CONCRETE_POWDER, ROSE_CONCRETE_POWDER);
            entries.addAfter(RED_CONCRETE_POWDER, CORAL_CONCRETE_POWDER);
            entries.addBefore(CYAN_CONCRETE_POWDER, TEAL_CONCRETE_POWDER);
            entries.addAfter(CYAN_CONCRETE_POWDER, TURQUOISE_CONCRETE_POWDER, AQUA_CONCRETE_POWDER);
            entries.addAfter(BLUE_CONCRETE_POWDER, SLATE_CONCRETE_POWDER, NAVY_CONCRETE_POWDER);
            entries.addBefore(PURPLE_CONCRETE_POWDER, INDIGO_CONCRETE_POWDER);

            entries.addBefore(RED_GLAZED_TERRACOTTA, MAROON_GLAZED_TERRACOTTA, ROSE_GLAZED_TERRACOTTA);
            entries.addAfter(RED_GLAZED_TERRACOTTA, CORAL_GLAZED_TERRACOTTA);
            entries.addBefore(ORANGE_GLAZED_TERRACOTTA, GINGER_GLAZED_TERRACOTTA);
            entries.addAfter(ORANGE_GLAZED_TERRACOTTA, TAN_GLAZED_TERRACOTTA);
            entries.addBefore(YELLOW_GLAZED_TERRACOTTA, BEIGE_GLAZED_TERRACOTTA);
            entries.addAfter(YELLOW_GLAZED_TERRACOTTA, AMBER_GLAZED_TERRACOTTA, OLIVE_GLAZED_TERRACOTTA);
            entries.addBefore(GREEN_GLAZED_TERRACOTTA, FOREST_GLAZED_TERRACOTTA);
            entries.addAfter(GREEN_GLAZED_TERRACOTTA, VERDANT_GLAZED_TERRACOTTA);
            entries.addBefore(RED_GLAZED_TERRACOTTA, MAROON_GLAZED_TERRACOTTA, ROSE_GLAZED_TERRACOTTA);
            entries.addAfter(RED_GLAZED_TERRACOTTA, CORAL_GLAZED_TERRACOTTA);
            entries.addBefore(CYAN_GLAZED_TERRACOTTA, TEAL_GLAZED_TERRACOTTA);
            entries.addAfter(CYAN_GLAZED_TERRACOTTA, TURQUOISE_GLAZED_TERRACOTTA, AQUA_GLAZED_TERRACOTTA);
            entries.addAfter(BLUE_GLAZED_TERRACOTTA, SLATE_GLAZED_TERRACOTTA, NAVY_GLAZED_TERRACOTTA);
            entries.addBefore(PURPLE_GLAZED_TERRACOTTA, INDIGO_GLAZED_TERRACOTTA);

            entries.addBefore(RED_STAINED_GLASS, MAROON_STAINED_GLASS, ROSE_STAINED_GLASS);
            entries.addAfter(RED_STAINED_GLASS, CORAL_STAINED_GLASS);
            entries.addBefore(ORANGE_STAINED_GLASS, GINGER_STAINED_GLASS);
            entries.addAfter(ORANGE_STAINED_GLASS, TAN_STAINED_GLASS);
            entries.addBefore(YELLOW_STAINED_GLASS, BEIGE_STAINED_GLASS);
            entries.addAfter(YELLOW_STAINED_GLASS, AMBER_STAINED_GLASS, OLIVE_STAINED_GLASS);
            entries.addBefore(GREEN_STAINED_GLASS, FOREST_STAINED_GLASS);
            entries.addAfter(GREEN_STAINED_GLASS, VERDANT_STAINED_GLASS);
            entries.addBefore(RED_STAINED_GLASS, MAROON_STAINED_GLASS, ROSE_STAINED_GLASS);
            entries.addAfter(RED_STAINED_GLASS, CORAL_STAINED_GLASS);
            entries.addBefore(CYAN_STAINED_GLASS, TEAL_STAINED_GLASS);
            entries.addAfter(CYAN_STAINED_GLASS, TURQUOISE_STAINED_GLASS, AQUA_STAINED_GLASS);
            entries.addAfter(BLUE_STAINED_GLASS, SLATE_STAINED_GLASS, NAVY_STAINED_GLASS);
            entries.addBefore(PURPLE_STAINED_GLASS, INDIGO_STAINED_GLASS);

            entries.addBefore(RED_STAINED_GLASS_PANE, MAROON_STAINED_GLASS_PANE, ROSE_STAINED_GLASS_PANE);
            entries.addAfter(RED_STAINED_GLASS_PANE, CORAL_STAINED_GLASS_PANE);
            entries.addBefore(ORANGE_STAINED_GLASS_PANE, GINGER_STAINED_GLASS_PANE);
            entries.addAfter(ORANGE_STAINED_GLASS_PANE, TAN_STAINED_GLASS_PANE);
            entries.addBefore(YELLOW_STAINED_GLASS_PANE, BEIGE_STAINED_GLASS_PANE);
            entries.addAfter(YELLOW_STAINED_GLASS_PANE, AMBER_STAINED_GLASS_PANE, OLIVE_STAINED_GLASS_PANE);
            entries.addBefore(GREEN_STAINED_GLASS_PANE, FOREST_STAINED_GLASS_PANE);
            entries.addAfter(GREEN_STAINED_GLASS_PANE, VERDANT_STAINED_GLASS_PANE);
            entries.addBefore(RED_STAINED_GLASS_PANE, MAROON_STAINED_GLASS_PANE, ROSE_STAINED_GLASS_PANE);
            entries.addAfter(RED_STAINED_GLASS_PANE, CORAL_STAINED_GLASS_PANE);
            entries.addBefore(CYAN_STAINED_GLASS_PANE, TEAL_STAINED_GLASS_PANE);
            entries.addAfter(CYAN_STAINED_GLASS_PANE, TURQUOISE_STAINED_GLASS_PANE, AQUA_STAINED_GLASS_PANE);
            entries.addAfter(BLUE_STAINED_GLASS_PANE, SLATE_STAINED_GLASS_PANE, NAVY_STAINED_GLASS_PANE);
            entries.addBefore(PURPLE_STAINED_GLASS_PANE, INDIGO_STAINED_GLASS_PANE);

            entries.addBefore(RED_SHULKER_BOX, MAROON_SHULKER_BOX, ROSE_SHULKER_BOX);
            entries.addAfter(RED_SHULKER_BOX, CORAL_SHULKER_BOX);
            entries.addBefore(ORANGE_SHULKER_BOX, GINGER_SHULKER_BOX);
            entries.addAfter(ORANGE_SHULKER_BOX, TAN_SHULKER_BOX);
            entries.addBefore(YELLOW_SHULKER_BOX, BEIGE_SHULKER_BOX);
            entries.addAfter(YELLOW_SHULKER_BOX, AMBER_SHULKER_BOX, OLIVE_SHULKER_BOX);
            entries.addBefore(GREEN_SHULKER_BOX, FOREST_SHULKER_BOX);
            entries.addAfter(GREEN_SHULKER_BOX, VERDANT_SHULKER_BOX);
            entries.addBefore(RED_SHULKER_BOX, MAROON_SHULKER_BOX, ROSE_SHULKER_BOX);
            entries.addAfter(RED_SHULKER_BOX, CORAL_SHULKER_BOX);
            entries.addBefore(CYAN_SHULKER_BOX, TEAL_SHULKER_BOX);
            entries.addAfter(CYAN_SHULKER_BOX, TURQUOISE_SHULKER_BOX, AQUA_SHULKER_BOX);
            entries.addAfter(BLUE_SHULKER_BOX, SLATE_SHULKER_BOX, NAVY_SHULKER_BOX);
            entries.addBefore(PURPLE_SHULKER_BOX, INDIGO_SHULKER_BOX);
        });
    }
}
