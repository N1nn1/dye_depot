package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.DDBannerBlockEntity;
import com.ninni.dye_depot.block.DDBedBlockEntity;
import com.ninni.dye_depot.block.DDShulkerBoxBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = DyeDepot.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DDBlockEntityType {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DyeDepot.MOD_ID);

    public static final RegistryObject<BlockEntityType<DDShulkerBoxBlockEntity>> SHULKER_BOX = BLOCK_ENTITIES.register(
            "shulker_box",
            () -> BlockEntityType.Builder.of(DDShulkerBoxBlockEntity::new,
                    DDBlocks.MAROON_SHULKER_BOX.get(),
                    DDBlocks.ROSE_SHULKER_BOX.get(),
                    DDBlocks.CORAL_SHULKER_BOX.get(),
                    DDBlocks.INDIGO_SHULKER_BOX.get(),
                    DDBlocks.NAVY_SHULKER_BOX.get(),
                    DDBlocks.SLATE_SHULKER_BOX.get(),
                    DDBlocks.OLIVE_SHULKER_BOX.get(),
                    DDBlocks.AMBER_SHULKER_BOX.get(),
                    DDBlocks.BEIGE_SHULKER_BOX.get(),
                    DDBlocks.TEAL_SHULKER_BOX.get(),
                    DDBlocks.MINT_SHULKER_BOX.get(),
                    DDBlocks.AQUA_SHULKER_BOX.get(),
                    DDBlocks.VERDANT_SHULKER_BOX.get(),
                    DDBlocks.FOREST_SHULKER_BOX.get(),
                    DDBlocks.GINGER_SHULKER_BOX.get(),
                    DDBlocks.TAN_SHULKER_BOX.get()
            ).build(null)
    );

    public static final RegistryObject<BlockEntityType<DDBedBlockEntity>> BED = BLOCK_ENTITIES.register(
            "bed",
            () -> BlockEntityType.Builder.of(DDBedBlockEntity::new,
                    DDBlocks.MAROON_BED.get(),
                    DDBlocks.ROSE_BED.get(),
                    DDBlocks.CORAL_BED.get(),
                    DDBlocks.INDIGO_BED.get(),
                    DDBlocks.NAVY_BED.get(),
                    DDBlocks.SLATE_BED.get(),
                    DDBlocks.OLIVE_BED.get(),
                    DDBlocks.AMBER_BED.get(),
                    DDBlocks.BEIGE_BED.get(),
                    DDBlocks.TEAL_BED.get(),
                    DDBlocks.MINT_BED.get(),
                    DDBlocks.AQUA_BED.get(),
                    DDBlocks.VERDANT_BED.get(),
                    DDBlocks.FOREST_BED.get(),
                    DDBlocks.GINGER_BED.get(),
                    DDBlocks.TAN_BED.get()
            ).build(null)
    );

    public static final RegistryObject<BlockEntityType<DDBannerBlockEntity>> BANNER = BLOCK_ENTITIES.register(
            "banner",
            () -> BlockEntityType.Builder.of(DDBannerBlockEntity::new,
                    DDBlocks.MAROON_BANNER.get(),
                    DDBlocks.ROSE_BANNER.get(),
                    DDBlocks.CORAL_BANNER.get(),
                    DDBlocks.INDIGO_BANNER.get(),
                    DDBlocks.NAVY_BANNER.get(),
                    DDBlocks.SLATE_BANNER.get(),
                    DDBlocks.OLIVE_BANNER.get(),
                    DDBlocks.AMBER_BANNER.get(),
                    DDBlocks.BEIGE_BANNER.get(),
                    DDBlocks.TEAL_BANNER.get(),
                    DDBlocks.MINT_BANNER.get(),
                    DDBlocks.AQUA_BANNER.get(),
                    DDBlocks.VERDANT_BANNER.get(),
                    DDBlocks.FOREST_BANNER.get(),
                    DDBlocks.GINGER_BANNER.get(),
                    DDBlocks.TAN_BANNER.get(),
                    DDBlocks.MAROON_WALL_BANNER.get(),
                    DDBlocks.ROSE_WALL_BANNER.get(),
                    DDBlocks.CORAL_WALL_BANNER.get(),
                    DDBlocks.INDIGO_WALL_BANNER.get(),
                    DDBlocks.NAVY_WALL_BANNER.get(),
                    DDBlocks.SLATE_WALL_BANNER.get(),
                    DDBlocks.OLIVE_WALL_BANNER.get(),
                    DDBlocks.AMBER_WALL_BANNER.get(),
                    DDBlocks.BEIGE_WALL_BANNER.get(),
                    DDBlocks.TEAL_WALL_BANNER.get(),
                    DDBlocks.MINT_WALL_BANNER.get(),
                    DDBlocks.AQUA_WALL_BANNER.get(),
                    DDBlocks.VERDANT_WALL_BANNER.get(),
                    DDBlocks.FOREST_WALL_BANNER.get(),
                    DDBlocks.GINGER_WALL_BANNER.get(),
                    DDBlocks.TAN_WALL_BANNER.get()
            ).build(null)
    );
}
