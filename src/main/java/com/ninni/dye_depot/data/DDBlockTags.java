package com.ninni.dye_depot.data;

import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class DDBlockTags extends FabricTagProvider.BlockTagProvider {

    public DDBlockTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for (DDDyes dye : DDDyes.values()) {
            DDBlocks.SHULKER_BOXES.values().forEach(block -> {
                var key = id(block);
                tag(key("c", "dyed")).add(key);
                tag(key("c", "dyed/" + dye)).add(key);
            });
        }

        DDBlocks.SHULKER_BOXES.values()
                .map(this::id)
                .forEach(id -> tag(BlockTags.SHULKER_BOXES).add(id));
    }

    private ResourceKey<Block> id(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow();
    }

    private TagKey<Block> key(String namespace, String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(namespace, path));
    }

}
