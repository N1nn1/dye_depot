package com.ninni.dye_depot.client.items;

import com.mojang.blaze3d.vertex.PoseStack;
import com.ninni.dye_depot.block.DDShulkerBoxBlock;
import com.ninni.dye_depot.block.DDShulkerBoxBlockEntity;
import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;
import java.util.Comparator;

@OnlyIn(Dist.CLIENT)
public class DDShulkerBoxItemRenderer extends BlockEntityWithoutLevelRenderer {
    private static final DDShulkerBoxBlockEntity DEFAULT_SHULKER_BOX = new DDShulkerBoxBlockEntity(BlockPos.ZERO, Blocks.SHULKER_BOX.defaultBlockState());
    private static final DDShulkerBoxBlockEntity[] SHULKER_BOXES = Arrays.stream(DDDyes.values()).sorted(Comparator.comparingInt(DDDyes::getId)).map((dye) -> {
        return new DDShulkerBoxBlockEntity(dye.get(), BlockPos.ZERO, Blocks.SHULKER_BOX.defaultBlockState());
    }).toArray(DDShulkerBoxBlockEntity[]::new);
    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    public DDShulkerBoxItemRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
        super(p_172550_, p_172551_);
        this.blockEntityRenderDispatcher = p_172550_;
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext p_270899_, PoseStack p_108832_, MultiBufferSource p_108833_, int p_108834_, int p_108835_) {
        if (!(stack.getItem() instanceof BlockItem blockItem)) return;
        BlockEntity blockentity;
        DyeColor dyecolor = DDShulkerBoxBlock.getColorFromItem(blockItem);
        if (dyecolor == null) {
            blockentity = DEFAULT_SHULKER_BOX;
        } else {
            blockentity = SHULKER_BOXES[dyecolor.getId() - 16];
        }
        this.blockEntityRenderDispatcher.renderItem(blockentity, p_108832_, p_108833_, p_108834_, p_108835_);
    }
}
