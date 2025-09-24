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
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.resource.PathPackResources;

@EventBusSubscriber(modid = DyeDepot.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class DyeDepotClient {

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        registerModelLayers();
    }

    @SubscribeEvent
    public static void addResourcePacks(AddPackFindersEvent event) {
        if (event.getPackType() != PackType.CLIENT_RESOURCES) return;
        var modFile = ModList.get().getModFileById(DyeDepot.MOD_ID).getFile();
        var path = modFile.findResource("resourcepacks/dye_override");
        try (var pack = new PathPackResources(modFile.getFileName() + ":" + path, true, path)) {
            event.addRepositorySource(consumer -> consumer.accept(Pack.readMetaAndCreate(
                    "builtin/" + DyeDepot.MOD_ID,
                    Component.literal("Dye Overrides"),
                    false,
                    ignored -> pack,
                    PackType.CLIENT_RESOURCES,
                    Pack.Position.BOTTOM,
                    PackSource.BUILT_IN))
            );
        }
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
