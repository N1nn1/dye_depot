package com.ninni.dye_depot;

import com.ninni.dye_depot.registry.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class DyeDepot implements ModInitializer {
	public static final String MOD_ID = "dye_depot";
	private static boolean initialized = false;
	@Override
	public void onInitialize() {
		initialized = true;

		DDVanillaIntegration.serverInit();

		DDItems.init();
		DDBlocks.init();
		DDBlockEntityTypes.init();
		DDParticles.init();
		DDSoundEvents.init();
		DDCreativeModeTabs.init();
		DDMapDecorationTypes.init();

	}

	public static boolean isInitialized() {
		return initialized;
	}

	public static ResourceLocation id(String name) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
	}
}