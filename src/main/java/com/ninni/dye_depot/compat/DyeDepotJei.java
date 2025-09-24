package com.ninni.dye_depot.compat;

import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DyedHolders;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ShulkerBoxBlock;

@JeiPlugin
public class DyeDepotJei implements IModPlugin {

    private static final ResourceLocation ID = DyeDepot.modLoc("jei");

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        var shulkerColoring = DyedHolders.modColors()
                .map(this::createShulkerColoring)
                .toList();

        registration.addRecipes(RecipeTypes.CRAFTING, shulkerColoring);
    }

    private CraftingRecipe createShulkerColoring(DyeColor color) {
        var baseShulkerStack = new ItemStack(Blocks.SHULKER_BOX);
        var baseShulkerIngredient = Ingredient.of(baseShulkerStack);
        var colorIngredient = Ingredient.of(DyeItem.byColor(color));
        var inputs = NonNullList.of(Ingredient.EMPTY, baseShulkerIngredient, colorIngredient);
        var output = ShulkerBoxBlock.getColoredItemStack(color);
        var id = new ResourceLocation("jei.shulker.color" + "." + output.getDescriptionId());
        return new ShapelessRecipe(id, "jei.shulker.color", CraftingBookCategory.MISC, output, inputs);
    }

}
