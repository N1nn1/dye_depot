package com.ninni.dye_depot;

import com.google.common.collect.ImmutableSet;
import com.ninni.dye_depot.events.MiscEvents;
import com.ninni.dye_depot.registry.DDBlockEntityType;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyeKeys;
import com.ninni.dye_depot.registry.DDItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mod(DyeDepot.MOD_ID)
public class DyeDepot {
	public static final String MOD_ID = "dye_depot";

	public DyeDepot() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus eventBus = MinecraftForge.EVENT_BUS;

		modEventBus.addListener(this::commonSetup);

		DDItems.ITEMS.register(modEventBus);
		DDBlocks.BLOCKS.register(modEventBus);
		DDBlockEntityType.BLOCK_ENTITIES.register(modEventBus);

		DDDyeKeys.init();

		eventBus.register(this);
		eventBus.register(new MiscEvents());
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			Set<Block> shulkerSet = BlockEntityType.SHULKER_BOX.validBlocks;
            List<Block> shulkerList = new ArrayList<>(shulkerSet);
			shulkerList.add(DDBlocks.MAROON_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.ROSE_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.CORAL_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.INDIGO_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.NAVY_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.SLATE_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.OLIVE_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.AMBER_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.BEIGE_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.TEAL_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.MINT_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.AQUA_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.VERDANT_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.FOREST_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.GINGER_SHULKER_BOX.get());
			shulkerList.add(DDBlocks.TAN_SHULKER_BOX.get());

			BlockEntityType.SHULKER_BOX.validBlocks = ImmutableSet.copyOf(shulkerList);

			Set<Block> bedSet = BlockEntityType.BED.validBlocks;
			List<Block> bedList = new ArrayList<>();
			for (Block bed : bedSet) {
				bedList.add(bed);
			}
			bedList.add(DDBlocks.MAROON_BED.get());
			bedList.add(DDBlocks.ROSE_BED.get());
			bedList.add(DDBlocks.CORAL_BED.get());
			bedList.add(DDBlocks.INDIGO_BED.get());
			bedList.add(DDBlocks.NAVY_BED.get());
			bedList.add(DDBlocks.SLATE_BED.get());
			bedList.add(DDBlocks.OLIVE_BED.get());
			bedList.add(DDBlocks.AMBER_BED.get());
			bedList.add(DDBlocks.BEIGE_BED.get());
			bedList.add(DDBlocks.TEAL_BED.get());
			bedList.add(DDBlocks.MINT_BED.get());
			bedList.add(DDBlocks.AQUA_BED.get());
			bedList.add(DDBlocks.VERDANT_BED.get());
			bedList.add(DDBlocks.FOREST_BED.get());
			bedList.add(DDBlocks.GINGER_BED.get());
			bedList.add(DDBlocks.TAN_BED.get());

			BlockEntityType.BED.validBlocks = ImmutableSet.copyOf(bedList);

			Set<Block> bannerSet = BlockEntityType.BANNER.validBlocks;
            List<Block> bannerList = new ArrayList<>(bannerSet);
			bannerList.add(DDBlocks.MAROON_BANNER.get());
			bannerList.add(DDBlocks.ROSE_BANNER.get());
			bannerList.add(DDBlocks.CORAL_BANNER.get());
			bannerList.add(DDBlocks.INDIGO_BANNER.get());
			bannerList.add(DDBlocks.NAVY_BANNER.get());
			bannerList.add(DDBlocks.SLATE_BANNER.get());
			bannerList.add(DDBlocks.OLIVE_BANNER.get());
			bannerList.add(DDBlocks.AMBER_BANNER.get());
			bannerList.add(DDBlocks.BEIGE_BANNER.get());
			bannerList.add(DDBlocks.TEAL_BANNER.get());
			bannerList.add(DDBlocks.MINT_BANNER.get());
			bannerList.add(DDBlocks.AQUA_BANNER.get());
			bannerList.add(DDBlocks.VERDANT_BANNER.get());
			bannerList.add(DDBlocks.FOREST_BANNER.get());
			bannerList.add(DDBlocks.GINGER_BANNER.get());
			bannerList.add(DDBlocks.TAN_BANNER.get());
			bannerList.add(DDBlocks.MAROON_WALL_BANNER.get());
			bannerList.add(DDBlocks.ROSE_WALL_BANNER.get());
			bannerList.add(DDBlocks.CORAL_WALL_BANNER.get());
			bannerList.add(DDBlocks.INDIGO_WALL_BANNER.get());
			bannerList.add(DDBlocks.NAVY_WALL_BANNER.get());
			bannerList.add(DDBlocks.SLATE_WALL_BANNER.get());
			bannerList.add(DDBlocks.OLIVE_WALL_BANNER.get());
			bannerList.add(DDBlocks.AMBER_WALL_BANNER.get());
			bannerList.add(DDBlocks.BEIGE_WALL_BANNER.get());
			bannerList.add(DDBlocks.TEAL_WALL_BANNER.get());
			bannerList.add(DDBlocks.MINT_WALL_BANNER.get());
			bannerList.add(DDBlocks.AQUA_WALL_BANNER.get());
			bannerList.add(DDBlocks.VERDANT_WALL_BANNER.get());
			bannerList.add(DDBlocks.FOREST_WALL_BANNER.get());
			bannerList.add(DDBlocks.GINGER_WALL_BANNER.get());
			bannerList.add(DDBlocks.TAN_WALL_BANNER.get());

			BlockEntityType.BANNER.validBlocks = ImmutableSet.copyOf(bannerList);
		});
	}

}