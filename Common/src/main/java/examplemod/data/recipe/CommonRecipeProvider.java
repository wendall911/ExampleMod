package examplemod.data.recipe;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;

import examplemod.ExampleMod;

public class CommonRecipeProvider extends RecipeProviderBase {

    public CommonRecipeProvider(@NotNull final PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public String getName() {
        return ExampleMod.MOD_NAME + " - Recipes";
    }

    @Override
    protected void registerRecipes(Consumer<FinishedRecipe> consumer) {
        /*
         * Disabling in favor of config condition.
         * Example of an item if just wanting a generic registration.
         */
        //exampleItem().save(consumer);
    }

}

