package com.ninni.dye_depot;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class DDMixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) { } // NO-OP

    @Override
    public String getRefMapperConfig() { return null; } // DEFAULT

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.startsWith("com.ninni.dye_depot.mixin.compat.create"))
            return FabricLoader.getInstance().isModLoaded("create");
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) { } // NO-OP

    @Override
    public List<String> getMixins() { return null; } // DEFAULT

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) { } // NO-OP

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) { } // NO-OP
}
