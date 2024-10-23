package com.ninni.dye_depot.mixin;

import com.ninni.dye_depot.block.DDBannerBlockEntity;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDMapDecorationTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.saveddata.maps.MapBanner;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(MapBanner.class)
public class MapBannerMixin {
    @Shadow @Final private DyeColor color;

    @Inject(method = "fromWorld", at = @At(value = "HEAD"), cancellable = true)
    private static void DD$fromWorld(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<MapBanner> cir) {
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
        if (blockEntity instanceof DDBannerBlockEntity bannerBlockEntity) {
            DyeColor color = bannerBlockEntity.getBaseColor();
            Optional<Component> optional = Optional.ofNullable(bannerBlockEntity.getCustomName());
            cir.setReturnValue(new MapBanner(blockPos, color, optional));
        }
    }

    @Inject(method = "getDecoration", at = @At(value = "HEAD"), cancellable = true)
    private void DD$addCustomDecoration(CallbackInfoReturnable<Holder<MapDecorationType>> cir) {
        if (color == DDDyes.MAROON.get()) cir.setReturnValue(DDMapDecorationTypes.MAROON_BANNER);
        else if (color == DDDyes.ROSE.get()) cir.setReturnValue(DDMapDecorationTypes.ROSE_BANNER);
        else if (color == DDDyes.CORAL.get()) cir.setReturnValue(DDMapDecorationTypes.CORAL_BANNER);
        else if (color == DDDyes.INDIGO.get()) cir.setReturnValue(DDMapDecorationTypes.INDIGO_BANNER);
        else if (color == DDDyes.NAVY.get()) cir.setReturnValue(DDMapDecorationTypes.NAVY_BANNER);
        else if (color == DDDyes.SLATE.get()) cir.setReturnValue(DDMapDecorationTypes.SLATE_BANNER);
        else if (color == DDDyes.OLIVE.get()) cir.setReturnValue(DDMapDecorationTypes.OLIVE_BANNER);
        else if (color == DDDyes.AMBER.get()) cir.setReturnValue(DDMapDecorationTypes.AMBER_BANNER);
        else if (color == DDDyes.BEIGE.get()) cir.setReturnValue(DDMapDecorationTypes.BEIGE_BANNER);
        else if (color == DDDyes.TEAL.get()) cir.setReturnValue(DDMapDecorationTypes.TEAL_BANNER);
        else if (color == DDDyes.MINT.get()) cir.setReturnValue(DDMapDecorationTypes.MINT_BANNER);
        else if (color == DDDyes.AQUA.get()) cir.setReturnValue(DDMapDecorationTypes.AQUA_BANNER);
        else if (color == DDDyes.VERDANT.get()) cir.setReturnValue(DDMapDecorationTypes.VERDANT_BANNER);
        else if (color == DDDyes.FOREST.get()) cir.setReturnValue(DDMapDecorationTypes.FOREST_BANNER);
        else if (color == DDDyes.GINGER.get()) cir.setReturnValue(DDMapDecorationTypes.GINGER_BANNER);
        else if (color == DDDyes.TAN.get()) cir.setReturnValue(DDMapDecorationTypes.TAN_BANNER);

    }
}
