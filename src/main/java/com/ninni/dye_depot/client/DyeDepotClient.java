package com.ninni.dye_depot.client;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.client.particles.PoofParticleProvider;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDParticles;
import java.util.stream.Stream;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

public class DyeDepotClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        addResourcePacks();
        registerBlockRenderLayers();
        registerParticles();
    }

    public static void addResourcePacks() {
        ModContainer modContainer = FabricLoader.getInstance().getModContainer(DyeDepot.MOD_ID).orElseThrow(() -> new IllegalStateException("Dye Depot's ModContainer couldn't be found!"));
        ResourceManagerHelper.registerBuiltinResourcePack(DyeDepot.modLoc("dye_override"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
    }

    private static void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(DDParticles.DYE_POOF, PoofParticleProvider::new);
    }

    private static void registerBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(),
                Stream.concat(
                        DDBlocks.STAINED_GLASS.values(),
                        DDBlocks.STAINED_GLASS_PANES.values()
                ).toArray(Block[]::new)
        );
    }

}