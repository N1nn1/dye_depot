package com.ninni.dye_depot.data.server;

import com.ninni.dye_depot.registry.DDPoiTypes;
import com.ninni.dye_depot.registry.DDTags;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;

public class DDPoiTags extends IntrinsicHolderTagsProvider<PoiType> {

    private static Function<PoiType, ResourceKey<PoiType>> keyProvider() {
        return it -> BuiltInRegistries.POINT_OF_INTEREST_TYPE.getResourceKey(it).orElseThrow();
    }

    public DDPoiTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, Registries.POINT_OF_INTEREST_TYPE, lookup, keyProvider());
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(DDTags.BEDS)
                .add(DDPoiTypes.HOME)
                .add(PoiTypes.HOME);

        tag(TagKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation("village")))
                .addTag(DDTags.BEDS);
    }

}
