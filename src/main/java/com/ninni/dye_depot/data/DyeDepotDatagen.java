package com.ninni.dye_depot.data;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.data.client.DDBlockModels;
import com.ninni.dye_depot.data.client.DDItemModels;
import com.ninni.dye_depot.data.server.DDBlockLoot;
import com.ninni.dye_depot.data.server.DDBlockTags;
import com.ninni.dye_depot.data.server.DDEntityLoot;
import com.ninni.dye_depot.data.server.DDItemTags;
import com.ninni.dye_depot.data.server.DDRecipes;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DyeDepotDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        var pack = generator.createPack();

        pack.addProvider((output, $) -> new DDPackMetadata(output, DyeDepot.MOD_ID + " resources"));

        var blockTags = pack.addProvider(DDBlockTags::new);
        pack.addProvider((output, lookup) -> new DDItemTags(output, lookup, blockTags));
        pack.addProvider(DDBlockLoot::new);
        pack.addProvider(DDEntityLoot::new);
        pack.addProvider(DDRecipes::new);

        var fileHelper = ExistingFileHelper.withResourcesFromArg();
        pack.addProvider((output, $) -> new DDBlockModels(output, fileHelper));
        pack.addProvider((output, $) -> new DDItemModels(output, fileHelper));
    }

}
