package com.ninni.dye_depot.data.client;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface TranslationBuilder {

    void add(Item item, String translation);

    void add(Block block, String translation);

    void add(String key, String translation);

}
