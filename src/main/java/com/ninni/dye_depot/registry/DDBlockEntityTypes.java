package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.DDBannerBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class DDBlockEntityTypes {

    public static final BlockEntityType<DDBannerBlockEntity> BANNER = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            DyeDepot.id("banner"),
            BlockEntityType.Builder.of(DDBannerBlockEntity::new,
                    DDBlocks.MAROON_BANNER,
                    DDBlocks.ROSE_BANNER,
                    DDBlocks.CORAL_BANNER,
                    DDBlocks.INDIGO_BANNER,
                    DDBlocks.NAVY_BANNER,
                    DDBlocks.SLATE_BANNER,
                    DDBlocks.OLIVE_BANNER,
                    DDBlocks.AMBER_BANNER,
                    DDBlocks.BEIGE_BANNER,
                    DDBlocks.TEAL_BANNER,
                    DDBlocks.MINT_BANNER,
                    DDBlocks.AQUA_BANNER,
                    DDBlocks.VERDANT_BANNER,
                    DDBlocks.FOREST_BANNER,
                    DDBlocks.GINGER_BANNER,
                    DDBlocks.TAN_BANNER,
                    DDBlocks.MAROON_WALL_BANNER,
                    DDBlocks.ROSE_WALL_BANNER,
                    DDBlocks.CORAL_WALL_BANNER,
                    DDBlocks.INDIGO_WALL_BANNER,
                    DDBlocks.NAVY_WALL_BANNER,
                    DDBlocks.SLATE_WALL_BANNER,
                    DDBlocks.OLIVE_WALL_BANNER,
                    DDBlocks.AMBER_WALL_BANNER,
                    DDBlocks.BEIGE_WALL_BANNER,
                    DDBlocks.TEAL_WALL_BANNER,
                    DDBlocks.MINT_WALL_BANNER,
                    DDBlocks.AQUA_WALL_BANNER,
                    DDBlocks.VERDANT_WALL_BANNER,
                    DDBlocks.FOREST_WALL_BANNER,
                    DDBlocks.GINGER_WALL_BANNER,
                    DDBlocks.TAN_WALL_BANNER
            ).build(null)
    );

    public static void init() {
        registerShulkerBox(DDBlocks.MAROON_SHULKER_BOX);
        registerShulkerBox(DDBlocks.ROSE_SHULKER_BOX);
        registerShulkerBox(DDBlocks.CORAL_SHULKER_BOX);
        registerShulkerBox(DDBlocks.INDIGO_SHULKER_BOX);
        registerShulkerBox(DDBlocks.NAVY_SHULKER_BOX);
        registerShulkerBox(DDBlocks.SLATE_SHULKER_BOX);
        registerShulkerBox(DDBlocks.OLIVE_SHULKER_BOX);
        registerShulkerBox(DDBlocks.AMBER_SHULKER_BOX);
        registerShulkerBox(DDBlocks.BEIGE_SHULKER_BOX);
        registerShulkerBox(DDBlocks.TEAL_SHULKER_BOX);
        registerShulkerBox(DDBlocks.MINT_SHULKER_BOX);
        registerShulkerBox(DDBlocks.AQUA_SHULKER_BOX);
        registerShulkerBox(DDBlocks.VERDANT_SHULKER_BOX);
        registerShulkerBox(DDBlocks.FOREST_SHULKER_BOX);
        registerShulkerBox(DDBlocks.GINGER_SHULKER_BOX);
        registerShulkerBox(DDBlocks.TAN_SHULKER_BOX);

        registerBed(DDBlocks.MAROON_BED);
        registerBed(DDBlocks.ROSE_BED);
        registerBed(DDBlocks.CORAL_BED);
        registerBed(DDBlocks.INDIGO_BED);
        registerBed(DDBlocks.NAVY_BED);
        registerBed(DDBlocks.SLATE_BED);
        registerBed(DDBlocks.OLIVE_BED);
        registerBed(DDBlocks.AMBER_BED);
        registerBed(DDBlocks.BEIGE_BED);
        registerBed(DDBlocks.TEAL_BED);
        registerBed(DDBlocks.MINT_BED);
        registerBed(DDBlocks.AQUA_BED);
        registerBed(DDBlocks.VERDANT_BED);
        registerBed(DDBlocks.FOREST_BED);
        registerBed(DDBlocks.GINGER_BED);
        registerBed(DDBlocks.TAN_BED);
    }

    private static void registerShulkerBox(Block block) {
        BlockEntityType.SHULKER_BOX.addSupportedBlock(block);
    }

    private static void registerBed(Block block) {
        BlockEntityType.BED.addSupportedBlock(block);
    }
}
