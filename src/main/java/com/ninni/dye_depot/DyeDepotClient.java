package com.ninni.dye_depot;

import com.ninni.dye_depot.registry.DDVanillaIntegration;
import net.fabricmc.api.ClientModInitializer;


public class DyeDepotClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		DDVanillaIntegration.Client.clientInit();
	}
}