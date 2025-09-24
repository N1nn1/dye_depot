package com.ninni.dye_depot.client;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.client.particles.PoofParticleProvider;
import com.ninni.dye_depot.registry.DDBlockEntityType;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDParticles;
import java.util.stream.Stream;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.blockentity.BedRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ShulkerBoxRenderer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class DyeDepotClient implements ClientModInitializer {

	@Override
    public void onInitializeClient() {
        addResourcePacks();
        registerModelLayers();
        registerBlockRenderLayers();
        registerParticles();
    }

    public static void addResourcePacks() {
        ModContainer modContainer = FabricLoader.getInstance().getModContainer(DyeDepot.MOD_ID).orElseThrow(() -> new IllegalStateException("Dye Depot's ModContainer couldn't be found!"));
        ResourceManagerHelper.registerBuiltinResourcePack(DyeDepot.modLoc("dye_override"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
    }

    @SuppressWarnings("unchecked")
    private static <E extends BlockEntity> void registerRenderer(BlockEntityType<? extends E> type, BlockEntityRendererProvider<E> renderer) {
        BlockEntityRendererRegistry.register((BlockEntityType<E>) type, renderer);
    }

    private static void registerModelLayers() {
        registerRenderer(DDBlockEntityType.SHULKER_BOX, ShulkerBoxRenderer::new);
        registerRenderer(DDBlockEntityType.BED, BedRenderer::new);
        registerRenderer(DDBlockEntityType.BANNER, BannerRenderer::new);
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