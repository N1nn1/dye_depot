package com.ninni.dye_depot.mixin;

import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.MapColor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(DyeColor.class)
public class DyeColorMixin {
    @Shadow
    @Mutable
    @Final
    private static DyeColor[] $VALUES;

    @Invoker("<init>")
    public static DyeColor newColor(String name, int id, int j, String string2, int k, MapColor mapColor, int l, int m) {
        throw new AssertionError();
    }

    @Inject(method = "<clinit>", at = @At(value = "FIELD", target = "Lnet/minecraft/world/item/DyeColor;$VALUES:[Lnet/minecraft/world/item/DyeColor;", shift = At.Shift.AFTER))
    private static void US$addCustomColor(CallbackInfo ci) {
        List<DyeColor> dyeColors = new ArrayList<>(Arrays.asList($VALUES));
        DyeColor last = dyeColors.get(dyeColors.size() - 1);
        int i = 1;
        for (DDDyes color : DDDyes.values()) {
            dyeColors.add(newColor(color.name(), last.ordinal() + i, color.getId(), color.getName(), color.getColor(), color.getMapColor(), color.getFireworkColor(), color.getTextColor()));
            i++;
        }
        $VALUES = dyeColors.toArray(new DyeColor[0]);
    }
}
