package com.ninni.dye_depot.compat;

import com.ninni.dye_depot.DyeDepot;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.*;

@JeiPlugin
public class DyeDepotJei implements IModPlugin {

    private static final Identifier ID = DyeDepot.modLoc("jei");

    @Override
    public Identifier getPluginUid() {
        return ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        //var shulkerColoring = Stream.concat(DyedHolders.modColors(), DyedHolders.vanillaColors())
        //    .map(this::createShulkerColoring)
        //    .toList();

        //registration.addRecipes(RecipeTypes.CRAFTING, shulkerColoring);
    }

    /*
    TODO 26.1.2 check if necessary
    private RecipeHolder<CraftingRecipe> createShulkerColoring(DyeColor color) {
         var baseShulkerIngredient = Ingredient.of(Blocks.SHULKER_BOX);
         var colorIngredient = Ingredient.of(BuiltInRegistries.ITEM.getOrThrow(color.getTag()));
         var inputs = NonNullList.of(baseShulkerIngredient, colorIngredient);
         var output = ShulkerBoxBlock.getColoredItemStack(color);
         var id = Identifier.withDefaultNamespace("jei.shulker.color" + "." + output.getDescriptionId());
         return new RecipeHolder<>(id, new ShapelessRecipe(
             new Recipe.CommonInfo(false),
             new CraftingRecipe.CraftingBookInfo(CraftingBookCategory.MISC, "jei.shulker.color"),
             new ItemStackTemplate(output), inputs
         ));
    }
     */

}
