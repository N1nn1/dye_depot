package com.ninni.dye_depot.data.server;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Collection;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import org.jetbrains.annotations.Nullable;

public record ConditionalRecipe(FinishedRecipe delegate, Collection<ICondition> conditions) implements FinishedRecipe {

    private void serializeConditions(JsonObject json) {
        if (conditions().isEmpty()) return;
        var conditions = new JsonArray();
        conditions().stream()
                .map(CraftingHelper::serialize)
                .forEach(conditions::add);
        json.add("conditions", conditions);
    }

    @Override
    public void serializeRecipeData(JsonObject json) {
        delegate.serializeRecipeData(json);
        serializeConditions(json);
    }

    @Override
    public ResourceLocation getId() {
        return delegate.getId();
    }

    @Override
    public RecipeSerializer<?> getType() {
        return delegate.getType();
    }

    @Override
    public @Nullable JsonObject serializeAdvancement() {
        var json = delegate.serializeAdvancement();
        if (json == null) return null;
        serializeConditions(json);
        return json;
    }

    @Override
    public @Nullable ResourceLocation getAdvancementId() {
        return delegate.getAdvancementId();
    }

}
