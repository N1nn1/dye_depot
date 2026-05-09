package com.ninni.dye_depot.data.client;

import com.ninni.dye_depot.DyeDepot;
import java.util.concurrent.CompletableFuture;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

public class DDModels extends ModelProvider {

    private final CompletableFuture<HolderLookup.Provider> lookup;

    public DDModels(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, DyeDepot.MOD_ID);
        this.lookup = lookup;
    }

    @Override
    protected void registerModels(BlockModelGenerators blocks, ItemModelGenerators items) {
        var lookup = this.lookup.join();

        var blockModels = new DDBlockModels(blocks);
        blockModels.registerStatesAndModels(lookup);

        var itemModels = new DDItemModels(items);
        itemModels.registerModels(lookup);
    }

}
