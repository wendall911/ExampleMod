package examplemod.data.recipe;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.PackOutput;

public class CommonRecipeProvider extends RecipeProvider {

    public CommonRecipeProvider(@NotNull final PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryFuture) {
        super(packOutput, registryFuture);
    }

    @Override
    public void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        /*
         * Disabling in favor of config condition.
         * Example of an item if just wanting a generic registration.
         */
        //RecipeProviderBase.exampleItem().save(recipeOutput);
    }

}

