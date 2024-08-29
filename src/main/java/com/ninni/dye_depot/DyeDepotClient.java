package com.ninni.dye_depot;

import com.ninni.dye_depot.client.particles.PoofParticle;
import com.ninni.dye_depot.client.renderer.DDBannerRenderer;
import com.ninni.dye_depot.registry.DDBlockEntityTypes;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDParticles;
import com.ninni.dye_depot.registry.DDVanillaIntegration;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;


public class DyeDepotClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		registerModelLayers();
		registerBlockRenderLayers();
		registerParticles();
	}

	private static void registerModelLayers() {
		BlockEntityRenderers.register(DDBlockEntityTypes.BANNER, DDBannerRenderer::new);
	}

	private static void registerParticles() {
		ParticleFactoryRegistry.getInstance().register(DDParticles.DYE_POOF, PoofParticle.Provider::new);
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
				DDBlocks.MINT_STAINED_GLASS,
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
				DDBlocks.MINT_STAINED_GLASS_PANE,
				DDBlocks.AQUA_STAINED_GLASS_PANE,
				DDBlocks.VERDANT_STAINED_GLASS_PANE,
				DDBlocks.FOREST_STAINED_GLASS_PANE,
				DDBlocks.GINGER_STAINED_GLASS_PANE,
				DDBlocks.TAN_STAINED_GLASS_PANE
		);
	}
}