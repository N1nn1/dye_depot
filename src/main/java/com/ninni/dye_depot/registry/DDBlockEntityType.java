package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.DDBannerBlockEntity;
import com.ninni.dye_depot.block.DDBedBlockEntity;
import com.ninni.dye_depot.block.DDShulkerBoxBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;

import java.util.function.Function;
import java.util.stream.Stream;

public class DDBlockEntityType {

    public static final BlockEntityType<DDShulkerBoxBlockEntity> SHULKER_BOX = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            DyeDepot.modLoc("shulker_box"),
            BlockEntityType.Builder.of(DDShulkerBoxBlockEntity::new,
                    DDBlocks.SHULKER_BOXES.values().toArray(Block[]::new)
            ).build(null)
    );

    public static final BlockEntityType<DDBedBlockEntity> BED = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            DyeDepot.modLoc("bed"),
            BlockEntityType.Builder.of(DDBedBlockEntity::new,
                    DDBlocks.BEDS.values().toArray(Block[]::new)
            ).build(null)
    );

    public static final BlockEntityType<DDBannerBlockEntity> BANNER = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            DyeDepot.modLoc("banner"),
            BlockEntityType.Builder.of(DDBannerBlockEntity::new,
                    Stream.of(
                            DDBlocks.BANNERS.values(),
                            DDBlocks.WALL_BANNERS.values()
                    ).flatMap(Function.identity()).toArray(Block[]::new)
            ).build(null)
    );
}
