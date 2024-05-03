package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.DDBannerBlockEntity;
import com.ninni.dye_depot.block.DDBedBlockEntity;
import com.ninni.dye_depot.block.DDShulkerBoxBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;

public class DDBlockEntityType {

    public static final BlockEntityType<DDShulkerBoxBlockEntity> SHULKER_BOX = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            DyeDepot.asResource("shulker_box"),
            BlockEntityType.Builder.of(DDShulkerBoxBlockEntity::new,
                    DDBlocks.MAROON_SHULKER_BOX,
                    DDBlocks.ROSE_SHULKER_BOX,
                    DDBlocks.CORAL_SHULKER_BOX,
                    DDBlocks.INDIGO_SHULKER_BOX,
                    DDBlocks.NAVY_SHULKER_BOX,
                    DDBlocks.SLATE_SHULKER_BOX,
                    DDBlocks.OLIVE_SHULKER_BOX,
                    DDBlocks.AMBER_SHULKER_BOX,
                    DDBlocks.BEIGE_SHULKER_BOX,
                    DDBlocks.TEAL_SHULKER_BOX,
                    DDBlocks.MINT_SHULKER_BOX,
                    DDBlocks.AQUA_SHULKER_BOX,
                    DDBlocks.VERDANT_SHULKER_BOX,
                    DDBlocks.FOREST_SHULKER_BOX,
                    DDBlocks.GINGER_SHULKER_BOX,
                    DDBlocks.TAN_SHULKER_BOX
            ).build(null)
    );

    public static final BlockEntityType<DDBedBlockEntity> BED = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            DyeDepot.asResource("bed"),
            BlockEntityType.Builder.of(DDBedBlockEntity::new,
                    DDBlocks.MAROON_BED,
                    DDBlocks.ROSE_BED,
                    DDBlocks.CORAL_BED,
                    DDBlocks.INDIGO_BED,
                    DDBlocks.NAVY_BED,
                    DDBlocks.SLATE_BED,
                    DDBlocks.OLIVE_BED,
                    DDBlocks.AMBER_BED,
                    DDBlocks.BEIGE_BED,
                    DDBlocks.TEAL_BED,
                    DDBlocks.MINT_BED,
                    DDBlocks.AQUA_BED,
                    DDBlocks.VERDANT_BED,
                    DDBlocks.FOREST_BED,
                    DDBlocks.GINGER_BED,
                    DDBlocks.TAN_BED
            ).build(null)
    );

    public static final BlockEntityType<DDBannerBlockEntity> BANNER = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            DyeDepot.asResource("banner"),
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
}
