package com.ninni.dye_depot.mixin.compat.create;

import com.google.common.collect.ImmutableMap;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.ninni.dye_depot.registry.DDDyes;
import com.simibubi.create.foundation.utility.Couple;
import com.simibubi.create.foundation.utility.DyeHelper;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DyeHelper.class)
public class DyeHelperMixin {
    /**
     * @author IThundxr
     * @reason Extra entries are needed in the map to make Dye Depot dyes not crash when used on create nixie tubes
     */
    @WrapOperation(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;build()Lcom/google/common/collect/ImmutableMap;"))
    private static ImmutableMap<DyeColor, Couple<Integer>> dye_depot$insertExtraDyeValuesForCreateCompat(ImmutableMap.Builder<DyeColor, Couple<Integer>> instance, Operation<ImmutableMap<DyeColor, Couple<Integer>>> original) {
        ImmutableMap.Builder<DyeColor, Couple<Integer>> builder = instance
                // DyeColor, ( Front RGB, Back RGB )
                .put(DDDyes.MAROON.get(), Couple.create(DDDyes.MAROON.getColor(), 0x662010))
                .put(DDDyes.ROSE.get(), Couple.create(DDDyes.ROSE.getColor(), 0xD56468))
                .put(DDDyes.CORAL.get(), Couple.create(DDDyes.CORAL.getColor(), 0xDEA796))

                .put(DDDyes.INDIGO.get(), Couple.create(DDDyes.INDIGO.getColor(), 0x221439))

                .put(DDDyes.NAVY.get(), Couple.create(DDDyes.NAVY.getColor(), 0x0F2A44))
                .put(DDDyes.SLATE.get(), Couple.create(DDDyes.SLATE.getColor(), 0x384461))

                .put(DDDyes.OLIVE.get(), Couple.create(DDDyes.OLIVE.getColor(), 0x65681D))
                .put(DDDyes.AMBER.get(), Couple.create(DDDyes.AMBER.getColor(), 0x937802))
                .put(DDDyes.BEIGE.get(), Couple.create(DDDyes.BEIGE.getColor(), 0xC5BB90))

                .put(DDDyes.TEAL.get(), Couple.create(DDDyes.TEAL.getColor(), 0x235B4C))
                .put(DDDyes.MINT.get(), Couple.create(DDDyes.MINT.getColor(), 0x2B9E60))
                .put(DDDyes.AQUA.get(), Couple.create(DDDyes.AQUA.getColor(), 0x71DBC1))

                .put(DDDyes.VERDANT.get(), Couple.create(DDDyes.VERDANT.getColor(), 0x235114))
                .put(DDDyes.FOREST.get(), Couple.create(DDDyes.FOREST.getColor(), 0x24751C))

                .put(DDDyes.GINGER.get(), Couple.create(DDDyes.GINGER.getColor(), 0x954618))
                .put(DDDyes.TAN.get(), Couple.create(DDDyes.TAN.getColor(), 0xD39D76));

        return original.call(builder);
    }
}
