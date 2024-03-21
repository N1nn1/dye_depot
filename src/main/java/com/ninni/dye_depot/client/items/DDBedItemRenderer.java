package com.ninni.dye_depot.client.items;

import com.mojang.blaze3d.vertex.PoseStack;
import com.ninni.dye_depot.block.DDBedBlockEntity;
import com.ninni.dye_depot.registry.DDBlocks;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DDBedItemRenderer extends BlockEntityWithoutLevelRenderer {
    private final DDBedBlockEntity bed = new DDBedBlockEntity(BlockPos.ZERO, DDBlocks.MAROON_BED.get().defaultBlockState());
    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    public DDBedItemRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
        super(p_172550_, p_172551_);
        this.blockEntityRenderDispatcher = p_172550_;
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext p_270899_, PoseStack p_108832_, MultiBufferSource p_108833_, int p_108834_, int p_108835_) {
        if (!(stack.getItem() instanceof BlockItem blockItem)) return;
        if (!(blockItem.getBlock() instanceof BedBlock bedBlock)) return;
        BlockEntity blockentity = this.bed;
        this.bed.setColor(bedBlock.getColor());
        this.blockEntityRenderDispatcher.renderItem(blockentity, p_108832_, p_108833_, p_108834_, p_108835_);
    }

}
