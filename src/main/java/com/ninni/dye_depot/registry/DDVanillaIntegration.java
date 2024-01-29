package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.resources.ResourceLocation;

public class DDVanillaIntegration {

    public static void serverInit() {
        addResourcePacks();
    }

    //server methods
    public static void addResourcePacks() {

        ModContainer modContainer = FabricLoader.getInstance().getModContainer(DyeDepot.MOD_ID).orElseThrow(() -> new IllegalStateException("Dye Depot's ModContainer couldn't be found!"));
        ResourceManagerHelper.registerBuiltinResourcePack(new ResourceLocation(DyeDepot.MOD_ID, "new_dyes"), modContainer, "New Dyes", ResourcePackActivationType.DEFAULT_ENABLED);
    }

    @Environment(EnvType.CLIENT)
    public static class Client {

        public static void clientInit() {
        }

        //client methods
    }
}
