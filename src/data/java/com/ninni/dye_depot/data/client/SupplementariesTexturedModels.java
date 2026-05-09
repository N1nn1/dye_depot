package com.ninni.dye_depot.data.client;

import com.mojang.datafixers.util.Pair;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class SupplementariesTexturedModels {

    public static TexturedModel.Provider candleHolderWall(int count, boolean lit) {
        return TexturedModel.createDefault(
            TextureMapping::cube,
            ModelTemplates.create("candle_holders", TextureSlot.ALL)
        );
    }

    public static TexturedModel.Provider present(boolean packed) {
        return TexturedModel.createDefault(
            TextureMapping::cube,
            ModelTemplates.create("candle_holders", TextureSlot.ALL)
        );
    }

    public static PropertyDispatch<MultiVariant> candleDispatch(BiFunction<Integer, Boolean, MultiVariant> factory) {
        return Stream.of(false, true).flatMap(lit ->
            IntStream.rangeClosed(1, 4).mapToObj(count ->
                Pair.of(lit, count)
            )
        ).reduce(
            PropertyDispatch.initial(BlockStateProperties.CANDLES, BlockStateProperties.LIT),
            (dispatch, values) -> {
                var count = values.getSecond();
                var lit = values.getFirst();
                return dispatch.select(count, lit, factory.apply(count, lit));
            },
            (a, b) -> a
        );
    }

}
