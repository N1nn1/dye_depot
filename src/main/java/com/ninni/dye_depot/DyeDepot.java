package com.ninni.dye_depot;

import com.google.common.reflect.Reflection;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDCreativeModeTabs;
import com.ninni.dye_depot.registry.DDItems;
import com.ninni.dye_depot.registry.DDVanillaIntegration;
import net.fabricmc.api.ModInitializer;


public class DyeDepot implements ModInitializer {
	public static final String MOD_ID = "dye_depot";

	@Override
	public void onInitialize() {
		Reflection.initialize(
				DDItems.class,
				DDBlocks.class,
				DDCreativeModeTabs.class
		);
		DDVanillaIntegration.serverInit();
	}
}