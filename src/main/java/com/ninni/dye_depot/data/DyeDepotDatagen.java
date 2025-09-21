package com.ninni.dye_depot.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DyeDepotDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        var pack = generator.createPack();

        var blockTags = pack.addProvider(DDBlockTags::new);
        pack.addProvider((output, lookup) -> new DDItemTags(output, lookup, blockTags));
    }

}
