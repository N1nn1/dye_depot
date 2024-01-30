package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.DDShulkerBoxBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;

public class DDBlockEntityType {

    public static final BlockEntityType<DDShulkerBoxBlockEntity> SHULKER_BOX = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            new ResourceLocation(DyeDepot.MOD_ID, "shulker_box"),
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
                    DDBlocks.TURQUOISE_SHULKER_BOX,
                    DDBlocks.AQUA_SHULKER_BOX,
                    DDBlocks.VERDANT_SHULKER_BOX,
                    DDBlocks.FOREST_SHULKER_BOX,
                    DDBlocks.GINGER_SHULKER_BOX,
                    DDBlocks.TAN_SHULKER_BOX
            ).build(null)
    );
}
