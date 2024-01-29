package com.ninni.dye_depot.registry;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.MapColor;

public enum DDDyes implements StringRepresentable {
    INDIGO(16, "indigo", 0x331E57, MapColor.TERRACOTTA_PURPLE, 0x331E57, 0x331E57),
    MAROON(17, "maroon", 0x7B2713, MapColor.TERRACOTTA_RED, 0x7B2713, 0x7B2713),
    NAVY(18, "navy", 0x153D64, MapColor.TERRACOTTA_BLUE, 0x153D64, 0x153D64),
    TEAL(19, "teal", 0x2F7B67, MapColor.TERRACOTTA_CYAN, 0x2F7B67, 0x2F7B67);

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
