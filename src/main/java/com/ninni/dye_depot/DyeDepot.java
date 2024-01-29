package com.ninni.dye_depot;

import com.ninni.dye_depot.registry.DDVanillaIntegration;
import net.fabricmc.api.ModInitializer;


public class DyeDepot implements ModInitializer {
	public static final String MOD_ID = "dye_depot";

	@Override
	public void onInitialize() {
		DDVanillaIntegration.serverInit();
	}
}