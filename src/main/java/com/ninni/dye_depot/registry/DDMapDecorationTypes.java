package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;

public class DDMapDecorationTypes {
    public static final Holder<MapDecorationType> MAROON_BANNER = register("banner_maroon", "maroon_banner");
    public static final Holder<MapDecorationType> ROSE_BANNER = register("banner_rose", "rose_banner");
    public static final Holder<MapDecorationType> CORAL_BANNER = register("banner_coral", "coral_banner");
    public static final Holder<MapDecorationType> INDIGO_BANNER = register("banner_indigo", "indigo_banner");
    public static final Holder<MapDecorationType> NAVY_BANNER = register("banner_navy", "navy_banner");
    public static final Holder<MapDecorationType> SLATE_BANNER = register("banner_slate", "slate_banner");
    public static final Holder<MapDecorationType> OLIVE_BANNER = register("banner_olive", "olive_banner");
    public static final Holder<MapDecorationType> AMBER_BANNER = register("banner_amber", "amber_banner");
    public static final Holder<MapDecorationType> BEIGE_BANNER = register("banner_beige", "beige_banner");
    public static final Holder<MapDecorationType> TEAL_BANNER = register("banner_teal", "teal_banner");
    public static final Holder<MapDecorationType> MINT_BANNER = register("banner_mint", "mint_banner");
    public static final Holder<MapDecorationType> AQUA_BANNER = register("banner_aqua", "aqua_banner");
    public static final Holder<MapDecorationType> VERDANT_BANNER = register("banner_verdant", "verdant_banner");
    public static final Holder<MapDecorationType> FOREST_BANNER = register("banner_forest", "forest_banner");
    public static final Holder<MapDecorationType> GINGER_BANNER = register("banner_ginger", "ginger_banner");
    public static final Holder<MapDecorationType> TAN_BANNER = register("banner_tan", "tan_banner");

    private static Holder<MapDecorationType> register(String id, String assetId) {
        ResourceKey<MapDecorationType> resourceKey = ResourceKey.create(Registries.MAP_DECORATION_TYPE, DyeDepot.id(id));
        MapDecorationType mapDecorationType = new MapDecorationType(DyeDepot.id(assetId), true, -1, false, true);
        return Registry.registerForHolder(BuiltInRegistries.MAP_DECORATION_TYPE, resourceKey, mapDecorationType);
    }

    public static void init() {

    }
}
