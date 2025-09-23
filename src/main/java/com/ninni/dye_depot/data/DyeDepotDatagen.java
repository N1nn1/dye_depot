package com.ninni.dye_depot.data;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.data.client.DDBlockModels;
import com.ninni.dye_depot.data.client.DDItemModels;
import com.ninni.dye_depot.data.client.DDLang;
import com.ninni.dye_depot.data.client.DDLangOverrides;
import com.ninni.dye_depot.data.server.DDBlockLoot;
import com.ninni.dye_depot.data.server.DDBlockTags;
import com.ninni.dye_depot.data.server.DDEntityLoot;
import com.ninni.dye_depot.data.server.DDItemTags;
import com.ninni.dye_depot.data.server.DDRecipes;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class DyeDepotDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        var pack = generator.createPack();

        pack.addProvider((output, $) -> new DDPackMetadata(output, Component.literal(DyeDepot.MOD_ID + " resources")));

        var blockTags = pack.addProvider(DDBlockTags::new);
        pack.addProvider((output, lookup) -> new DDItemTags(output, lookup, blockTags));
        pack.addProvider(DDBlockLoot::new);
        pack.addProvider(DDEntityLoot::new);
        pack.addProvider(DDRecipes::new);

        var fileHelper = ExistingFileHelper.withResourcesFromArg();
        pack.addProvider((output, lookup) -> new DDBlockModels(output, lookup, fileHelper));
        pack.addProvider((output, lookup) -> new DDItemModels(output, lookup, fileHelper));
        pack.addProvider(DDLang::new);

        var overrides = generator.createBuiltinResourcePack(DyeDepot.modLoc("dye_override"));
        overrides.addProvider((output, $) -> new DDPackMetadata(output, Component.literal("Slight dye adjustments").withStyle(ChatFormatting.GRAY)));
        overrides.addProvider(DDLangOverrides::new);
    }

}
