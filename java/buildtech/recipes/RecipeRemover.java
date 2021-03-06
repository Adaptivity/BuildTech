/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
package buildtech.recipes;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import buildcraft.BuildCraftCore;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeRemover{

	public static void removeRecipesWithResult(ItemStack resultItem)
	{
	    ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

	    for (int scan = 0; scan < recipes.size(); scan++)
	    {
	        IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
	        ItemStack recipeResult = tmpRecipe.getRecipeOutput();
	        if (ItemStack.areItemStacksEqual(resultItem, recipeResult)){
	        	if (tmpRecipe instanceof ShapedOreRecipe)
	        	{
	        	                  ShapedOreRecipe recipe = (ShapedOreRecipe)tmpRecipe;
	        	                  recipeResult = recipe.getRecipeOutput();
	        	}
	        	if (tmpRecipe instanceof ShapelessRecipes)
	            {
	                ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
	                recipeResult = recipe.getRecipeOutput();
	            }
	            System.out.println("[BuildTech] Removing Recipe: " + recipes.get(scan) + " -> " + recipeResult);
	            recipes.remove(scan);
	        }
	    }
	}
}