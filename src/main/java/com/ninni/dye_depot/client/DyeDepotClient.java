package com.ninni.dye_depot.client;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.client.particles.PoofParticleProvider;
import com.ninni.dye_depot.registry.DDBlockEntityType;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDParticles;
import java.util.stream.Stream;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.blockentity.BedRenderer;
import net.minecraft.client.renderer.blockentity.ShulkerBoxRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@EventBusSubscriber(modid = DyeDepot.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class DyeDepotClient {

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        registerModelLayers();
    }

    @SubscribeEvent
    public static void addResourcePacks(AddPackFindersEvent event) {
        event.addPackFinders(
                ResourceLocation.fromNamespaceAndPath(DyeDepot.MOD_ID, "resourcepacks/dye_override"),
                PackType.CLIENT_RESOURCES,
                Component.literal("Dye Overrides"),
                PackSource.BUILT_IN,
                false,
                Pack.Position.BOTTOM
        );
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(DDBlockEntityType.SHULKER_BOX.get(), ShulkerBoxRenderer::new);
        event.registerBlockEntityRenderer(DDBlockEntityType.BED.get(), BedRenderer::new);
        event.registerBlockEntityRenderer(DDBlockEntityType.BANNER.get(), BannerRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(DDParticles.DYE_POOF.get(), PoofParticleProvider::new);
    }

    @SubscribeEvent
    public static void registerBlockRenderLayers(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(DDParticles.DYE_POOF.get(), PoofParticleProvider::new);
    }

    private static void registerModelLayers() {
        Stream.concat(
                DDBlocks.STAINED_GLASS.values(),
                DDBlocks.STAINED_GLASS_PANES.values()
        ).forEach(it ->
                ItemBlockRenderTypes.setRenderLayer(it, RenderType.translucent())
        );
    }

}
