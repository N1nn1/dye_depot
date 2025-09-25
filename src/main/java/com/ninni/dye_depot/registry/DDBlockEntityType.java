package com.ninni.dye_depot.registry;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.block.DDBannerBlockEntity;
import com.ninni.dye_depot.block.DDBedBlockEntity;
import com.ninni.dye_depot.block.DDShulkerBoxBlockEntity;
import java.util.stream.Stream;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDBlockEntityType {

    private static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, DyeDepot.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DDShulkerBoxBlockEntity>> SHULKER_BOX = REGISTRY.register(
            "shulker_box",
            () -> BlockEntityType.Builder.of(DDShulkerBoxBlockEntity::new,
                    DDBlocks.SHULKER_BOXES.values().toArray(Block[]::new)
            ).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DDBedBlockEntity>> BED = REGISTRY.register(
            "bed",
            () -> BlockEntityType.Builder.of(DDBedBlockEntity::new,
                    DDBlocks.BEDS.values().toArray(Block[]::new)
            ).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DDBannerBlockEntity>> BANNER = REGISTRY.register(
            "banner",
            () -> BlockEntityType.Builder.of(DDBannerBlockEntity::new,
                    Stream.concat(
                            DDBlocks.BANNERS.values(),
                            DDBlocks.WALL_BANNERS.values()
                    ).toArray(Block[]::new)
            ).build(null)
    );

    public static void register(IEventBus modBus) {
        REGISTRY.register(modBus);
    }

}
