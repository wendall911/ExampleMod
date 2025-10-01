package examplemod.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;

public class CommonRecipeProvider extends RecipeProvider {

    RecipeOutput recipeOutput;
    HolderLookup.Provider registries;

    public CommonRecipeProvider(HolderLookup.Provider registries, RecipeOutput recipeOutput) {
        super(registries, recipeOutput);

        this.recipeOutput = recipeOutput;
        this.registries = registries;
    }

    @Override
    public void buildRecipes() {
        HolderLookup.RegistryLookup<Item> itemRegistry = registries.lookupOrThrow(Registries.ITEM);

        /*
         * Disabling in favor of config condition.
         * Example of an item if just wanting a generic registration.
         */
        //RecipeProviderBase.exampleItem(itemRegistry).save(recipeOutput);
    }

}
