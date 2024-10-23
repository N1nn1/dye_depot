package com.ninni.dye_depot.registry;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.List;

public enum DDDyes implements StringRepresentable {
    MAROON(16, "maroon", 0x7B2713, MapColor.CRIMSON_HYPHAE, 0x7B2713, 0x7B2713),
    ROSE(17, "rose", 0xFF5E64, MapColor.TERRACOTTA_MAGENTA, 0xFF5E64, 0xFF5E64),
    CORAL(18, "coral", 0xDF7758, MapColor.RAW_IRON, 0xDF7758, 0xDF7758),

    INDIGO(19, "indigo", 0x331E57, MapColor.TERRACOTTA_BLUE, 0x331E57, 0x331E57),

    NAVY(20, "navy", 0x153D64, MapColor.COLOR_CYAN, 0x153D64, 0x153D64),
    SLATE(21, "slate", 0x4C5E86, MapColor.WARPED_NYLIUM, 0x4C5E86, 0x4C5E86),

    OLIVE(22, "olive", 0x8C8F2A, MapColor.TERRACOTTA_LIGHT_GREEN, 0x8C8F2A, 0x8C8F2A),
    AMBER(23, "amber", 0xD7AF00, MapColor.WOOD, 0xD7AF00, 0xD7AF00),
    BEIGE(24, "beige", 0xE1D5A3, MapColor.SAND, 0xE1D5A3, 0xE1D5A3),

    TEAL(25, "teal", 0x2F7B67, MapColor.TERRACOTTA_CYAN, 0x2F7B67, 0x2F7B67),
    MINT(26, "mint", 0x38CE7D, MapColor.WARPED_WART_BLOCK, 0x38CE7D, 0x38CE7D),
    AQUA(27, "aqua", 0x5EF0CC, MapColor.DIAMOND, 0x5EF0CC, 0x5EF0CC),

    VERDANT(28, "verdant", 0x255714, MapColor.TERRACOTTA_GREEN, 0x255714, 0x255714),
    FOREST(29, "forest", 0x32A326, MapColor.EMERALD, 0x32A326, 0x32A326),

    GINGER(30, "ginger", 0xCF6121, MapColor.TERRACOTTA_ORANGE, 0xCF6121, 0xCF6121),
    TAN(31, "tan", 0xF49C5D, MapColor.DIRT, 0xF49C5D, 0xF49C5D);

    private final int id;
    private final String name;
    private final MapColor mapColor;
    private final float[] textureDiffuseColors;
    private final int color;
    private final int fireworkColor;
    private final int textColor;

    DDDyes(int j, String string2, int k, MapColor mapColor, int l, int m) {
        this.id = j;
        this.name = string2;
        this.mapColor = mapColor;
        this.textColor = m;
        this.color = k;
        int n = (k & 0xFF0000) >> 16;
        int o = (k & 0xFF00) >> 8;
        int p = (k & 0xFF) >> 0;
        this.textureDiffuseColors = new float[]{(float)n / 255.0f, (float)o / 255.0f, (float)p / 255.0f};
        this.fireworkColor = l;
    }

    public static List<DyeColor> getAll() {
        List<DyeColor> colors = new ArrayList<>();
        for (DDDyes dye : DDDyes.values()) {
            colors.add(dye.get());
        }
        return colors;
    }


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float[] getTextureDiffuseColors() {
        return this.textureDiffuseColors;
    }

    public MapColor getMapColor() {
        return this.mapColor;
    }

    public int getFireworkColor() {
        return this.fireworkColor;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public int getColor() {
        return color;
    }

    public DyeColor get() {
        return DyeColor.valueOf(this.name());
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
