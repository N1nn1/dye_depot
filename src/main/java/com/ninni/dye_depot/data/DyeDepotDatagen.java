package com.ninni.dye_depot.data;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.data.client.DDBlockModels;
import com.ninni.dye_depot.data.client.DDItemModels;
import com.ninni.dye_depot.data.client.DDLang;
import com.ninni.dye_depot.data.client.DDLangOverrides;
import com.ninni.dye_depot.data.server.DDBlockTags;
import com.ninni.dye_depot.data.server.DDItemTags;
import com.ninni.dye_depot.data.server.DDLoot;
import com.ninni.dye_depot.data.server.DDLootModifiersProvider;
import com.ninni.dye_depot.data.server.DDRecipes;
import net.minecraft.ChatFormatting;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = DyeDepot.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DyeDepotDatagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var lookup = event.getLookupProvider();
        var fileHelper = event.getExistingFileHelper();

        var client = event.includeClient();
        var server = event.includeServer();

        generator.addProvider(true, new DDPackMetadata(output, Component.literal(DyeDepot.MOD_ID + " resources")));

        var blockTags = generator.addProvider(server, new DDBlockTags(output, lookup, fileHelper));
        generator.addProvider(server, new DDItemTags(output, lookup, blockTags.contentsGetter()));
        generator.addProvider(server, new DDLoot(output, lookup));
        generator.addProvider(server, new DDRecipes(output, lookup));
        generator.addProvider(server, new DDLootModifiersProvider(output));

        generator.addProvider(client, new DDBlockModels(output, lookup, fileHelper));
        generator.addProvider(client, new DDItemModels(output, lookup, fileHelper));
        generator.addProvider(client, new DDLang(output, lookup));

        var supplementariesPack = generator.getBuiltinDatapack(client, "dye_override");
        var supplementariesOutput = new PackOutput(output.getOutputFolder().resolve("resourcepacks/dye_override"));
        supplementariesPack.addProvider($ -> new DDPackMetadata(supplementariesOutput, Component.literal("Slight dye adjustments").withStyle(ChatFormatting.GRAY)));
        supplementariesPack.addProvider($ -> new DDLangOverrides(supplementariesOutput, lookup));
    }

}
