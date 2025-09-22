package com.ninni.dye_depot.data;

import com.ninni.dye_depot.DyeDepot;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DyeDepotDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        var pack = generator.createPack();

        var blockTags = pack.addProvider(DDBlockTags::new);
        pack.addProvider((output, lookup) -> new DDItemTags(output, lookup, blockTags));
        pack.addProvider(DDBlockLoot::new);
        pack.addProvider(DDEntityLoot::new);
        pack.addProvider(DDRecipes::new);
        pack.addProvider((output, $) -> new DDPackMetadata(output, DyeDepot.MOD_ID + " resources"));
    }

}
