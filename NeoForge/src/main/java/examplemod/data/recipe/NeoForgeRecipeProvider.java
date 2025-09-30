package examplemod.data.recipe;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;

public class NeoForgeRecipeProvider extends RecipeProvider {

    public NeoForgeRecipeProvider(@NotNull final PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeOutput) {
        RecipeProviderBase.exampleItem().save(
            recipeOutput.withConditions(new ConfigResourceCondition(("disableExampleItem"))));
    }

}
