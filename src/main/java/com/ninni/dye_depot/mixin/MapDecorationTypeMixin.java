package com.ninni.dye_depot.mixin;

import com.ninni.dye_depot.registry.DDMapDecorationType;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
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

@Mixin(MapDecoration.Type.class)
public class MapDecorationTypeMixin {
    @Shadow
    @Mutable
    @Final
    private static MapDecoration.Type[] $VALUES;

    @Invoker("<init>")
    public static MapDecoration.Type newDecorationType(String name, int id, boolean bl, boolean bl2) {
        throw new AssertionError();
    }

    @Inject(method = "<clinit>", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/saveddata/maps/MapDecoration$Type;$VALUES:[Lnet/minecraft/world/level/saveddata/maps/MapDecoration$Type;", shift = At.Shift.AFTER))
    private static void DD$addCustomDecoration(CallbackInfo ci) {
        List<MapDecoration.Type> types = new ArrayList<>(Arrays.asList($VALUES));
        MapDecoration.Type last = types.get(types.size() - 1);
        int i = 1;
        for (DDMapDecorationType type : DDMapDecorationType.values()) {
            types.add(newDecorationType(type.name(), last.ordinal() + i, type.isRenderedOnFrame(), type.shouldTrackCount()));
            i++;
        }
        $VALUES = types.toArray(new MapDecoration.Type[0]);
    }
}
