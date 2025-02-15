package com.ninni.dye_depot.mixin;

import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(BannerBlock.class)
public class BannerBlockMixin {
    @Redirect(
        method = "<init>",
        at = @At(
            value = "INVOKE",
            target = "Ljava/util/Map;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"
        )
    )
    private <K, V> V removeEarlyDDDyedBannerReferences(Map<K, V> instance, K k, V v) {
        if (k instanceof DyeColor color && !DDDyes.contains(color)) {
            instance.put(k, v);
        }
        return v;
    }
}
