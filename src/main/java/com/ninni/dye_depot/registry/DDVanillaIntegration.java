package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.client.DDBannerRenderer;
import com.ninni.dye_depot.client.DDShulkerBoxRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class DDVanillaIntegration {

    public static void serverInit() {
        addResourcePacks();
    }

    //server methods
    public static void addResourcePacks() {
        ModContainer modContainer = FabricLoader.getInstance().getModContainer(DyeDepot.MOD_ID).orElseThrow(() -> new IllegalStateException("Dye Depot's ModContainer couldn't be found!"));
        ResourceManagerHelper.registerBuiltinResourcePack(new ResourceLocation(DyeDepot.MOD_ID, "dye_override"), modContainer, "Dye Override", ResourcePackActivationType.DEFAULT_ENABLED);
    }

    @Environment(EnvType.CLIENT)
    public static class Client {

        public static void clientInit() {
            registerModelLayers();
            registerBlockRenderLayers();
        }

        //client methods
        private static void registerModelLayers() {
            BlockEntityRendererRegistry.INSTANCE.register(DDBlockEntityType.BANNER, DDBannerRenderer::new);
            BlockEntityRendererRegistry.INSTANCE.register(DDBlockEntityType.SHULKER_BOX, DDShulkerBoxRenderer::new);
        }

        private static void registerBlockRenderLayers() {
            BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(),
                    DDBlocks.MAROON_STAINED_GLASS,
                    DDBlocks.ROSE_STAINED_GLASS,
                    DDBlocks.CORAL_STAINED_GLASS,
                    DDBlocks.INDIGO_STAINED_GLASS,
                    DDBlocks.NAVY_STAINED_GLASS,
                    DDBlocks.SLATE_STAINED_GLASS,
                    DDBlocks.OLIVE_STAINED_GLASS,
                    DDBlocks.AMBER_STAINED_GLASS,
                    DDBlocks.BEIGE_STAINED_GLASS,
                    DDBlocks.TEAL_STAINED_GLASS,
                    DDBlocks.TURQUOISE_STAINED_GLASS,
                    DDBlocks.AQUA_STAINED_GLASS,
                    DDBlocks.VERDANT_STAINED_GLASS,
                    DDBlocks.FOREST_STAINED_GLASS,
                    DDBlocks.GINGER_STAINED_GLASS,
                    DDBlocks.TAN_STAINED_GLASS,
                    DDBlocks.MAROON_STAINED_GLASS_PANE,
                    DDBlocks.ROSE_STAINED_GLASS_PANE,
                    DDBlocks.CORAL_STAINED_GLASS_PANE,
                    DDBlocks.INDIGO_STAINED_GLASS_PANE,
                    DDBlocks.NAVY_STAINED_GLASS_PANE,
                    DDBlocks.SLATE_STAINED_GLASS_PANE,
                    DDBlocks.OLIVE_STAINED_GLASS_PANE,
                    DDBlocks.AMBER_STAINED_GLASS_PANE,
                    DDBlocks.BEIGE_STAINED_GLASS_PANE,
                    DDBlocks.TEAL_STAINED_GLASS_PANE,
                    DDBlocks.TURQUOISE_STAINED_GLASS_PANE,
                    DDBlocks.AQUA_STAINED_GLASS_PANE,
                    DDBlocks.VERDANT_STAINED_GLASS_PANE,
                    DDBlocks.FOREST_STAINED_GLASS_PANE,
                    DDBlocks.GINGER_STAINED_GLASS_PANE,
                    DDBlocks.TAN_STAINED_GLASS_PANE
            );
        }
    }
}
