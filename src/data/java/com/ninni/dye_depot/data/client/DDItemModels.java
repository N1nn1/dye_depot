package com.ninni.dye_depot.data.client;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDItems;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DDItemModels extends ItemModelProvider {

    private final CompletableFuture<HolderLookup.Provider> lookup;

    public DDItemModels(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, ExistingFileHelper fileHelper) {
        super(output, DyeDepot.MOD_ID, fileHelper);
        this.lookup = lookup;
    }

    @Override
    protected void registerModels() {
        // No longer needed, will be kept here for potential future purposes
        var lookup = this.lookup.join();

        DDItems.DYES.values().forEach(this::basicItem);
    }

}
