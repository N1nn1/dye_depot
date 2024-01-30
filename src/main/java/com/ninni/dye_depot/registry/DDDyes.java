package com.ninni.dye_depot.registry;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.MapColor;

//TODO MapColors and Hex codes
public enum DDDyes implements StringRepresentable {
    MAROON(16, "maroon", 0x7B2713, MapColor.NONE, 0x7B2713, 0x7B2713),
    ROSE(17, "rose", 0xE05894, MapColor.NONE, 0xE05894, 0xE05894),
    CORAL(18, "coral", 0xDF7758, MapColor.NONE, 0xDF7758, 0xDF7758),

    INDIGO(19, "indigo", 0x331E57, MapColor.NONE, 0x331E57, 0x331E57),

    NAVY(20, "navy", 0x153D64, MapColor.NONE, 0x153D64, 0x153D64),
    SLATE(21, "slate", 0x4C5E86, MapColor.NONE, 0x4C5E86, 0x4C5E86),

    OLIVE(22, "olive", 0x969421, MapColor.NONE, 0x969421, 0x969421),
    AMBER(23, "amber", 0xD7AF00, MapColor.NONE, 0xD7AF00, 0xD7AF00),
    BEIGE(24, "beige", 0xFFE3AE, MapColor.NONE, 0xFFE3AE, 0xFFE3AE),

    TEAL(25, "teal", 0x2F7B67, MapColor.NONE, 0x2F7B67, 0x2F7B67),
    TURQUOISE(26, "turquoise", 0x38CE7D, MapColor.NONE, 0x38CE7D, 0x38CE7D),
    AQUA(27, "aqua", 0x79E8EB, MapColor.NONE, 0x79E8EB, 0x79E8EB),

    VERDANT(28, "verdant", 0x234d15, MapColor.NONE, 0x234d15, 0x234d15),
    FOREST(29, "forest", 0x339A34, MapColor.NONE, 0x339A34, 0x339A34),

    GINGER(30, "ginger", 0xE15D00, MapColor.NONE, 0xE15D00, 0xE15D00),
    TAN(31, "tan", 0xDDA562, MapColor.NONE, 0xDDA562, 0xDDA562);

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
