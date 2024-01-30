package com.ninni.dye_depot.registry;

import net.minecraft.world.level.saveddata.maps.MapDecoration;

public enum DDMapDecorationType {
    BANNER_MAROON(true, true),
    BANNER_ROSE(true, true),
    BANNER_CORAL(true, true),
    BANNER_INDIGO(true, true),
    BANNER_NAVY(true, true),
    BANNER_SLATE(true, true),
    BANNER_OLIVE(true, true),
    BANNER_AMBER(true, true),
    BANNER_BEIGE(true, true),
    BANNER_TEAL(true, true),
    BANNER_MINT(true, true),
    BANNER_AQUA(true, true),
    BANNER_VERDANT(true, true),
    BANNER_FOREST(true, true),
    BANNER_GINGER(true, true),
    BANNER_TAN(true, true);

    private final byte icon;
    private final boolean renderedOnFrame;
    private final boolean trackCount;

    DDMapDecorationType(boolean bl, boolean bl2) {
        this.trackCount = bl2;
        this.icon = (byte)this.ordinal();
        this.renderedOnFrame = bl;
    }

    public MapDecoration.Type get() {
        return MapDecoration.Type.valueOf(this.name());
    }

    public boolean isRenderedOnFrame() {
        return this.renderedOnFrame;
    }

    public boolean shouldTrackCount() {
        return this.trackCount;
    }
}
