package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.mixin.BannerBlockAccessor;
import net.minecraft.world.level.block.AbstractBannerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class DDBlockEntityTypes {

    public static void init() {
        registerBanner(DDBlocks.MAROON_BANNER);
        registerBanner(DDBlocks.ROSE_BANNER);
        registerBanner(DDBlocks.CORAL_BANNER);
        registerBanner(DDBlocks.INDIGO_BANNER);
        registerBanner(DDBlocks.NAVY_BANNER);
        registerBanner(DDBlocks.SLATE_BANNER);
        registerBanner(DDBlocks.OLIVE_BANNER);
        registerBanner(DDBlocks.AMBER_BANNER);
        registerBanner(DDBlocks.BEIGE_BANNER);
        registerBanner(DDBlocks.TEAL_BANNER);
        registerBanner(DDBlocks.MINT_BANNER);
        registerBanner(DDBlocks.AQUA_BANNER);
        registerBanner(DDBlocks.VERDANT_BANNER);
        registerBanner(DDBlocks.FOREST_BANNER);
        registerBanner(DDBlocks.GINGER_BANNER);
        registerBanner(DDBlocks.TAN_BANNER);
        registerBanner(DDBlocks.MAROON_WALL_BANNER);
        registerBanner(DDBlocks.ROSE_WALL_BANNER);
        registerBanner(DDBlocks.CORAL_WALL_BANNER);
        registerBanner(DDBlocks.INDIGO_WALL_BANNER);
        registerBanner(DDBlocks.NAVY_WALL_BANNER);
        registerBanner(DDBlocks.SLATE_WALL_BANNER);
        registerBanner(DDBlocks.OLIVE_WALL_BANNER);
        registerBanner(DDBlocks.AMBER_WALL_BANNER);
        registerBanner(DDBlocks.BEIGE_WALL_BANNER);
        registerBanner(DDBlocks.TEAL_WALL_BANNER);
        registerBanner(DDBlocks.MINT_WALL_BANNER);
        registerBanner(DDBlocks.AQUA_WALL_BANNER);
        registerBanner(DDBlocks.VERDANT_WALL_BANNER);
        registerBanner(DDBlocks.FOREST_WALL_BANNER);
        registerBanner(DDBlocks.GINGER_WALL_BANNER);
        registerBanner(DDBlocks.TAN_WALL_BANNER);

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

    private static void registerBanner(Block block) {
        BlockEntityType.BANNER.addSupportedBlock(block);
        BannerBlockAccessor.getByColor().put(((AbstractBannerBlock)block).getColor(), block);
    }

    private static void registerShulkerBox(Block block) {
        BlockEntityType.SHULKER_BOX.addSupportedBlock(block);
    }

    private static void registerBed(Block block) {
        BlockEntityType.BED.addSupportedBlock(block);
    }
}
