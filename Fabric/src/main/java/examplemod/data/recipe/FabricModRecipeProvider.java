package examplemod.data.recipe;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;

import examplemod.ExampleMod;

public class FabricModRecipeProvider extends FabricRecipeProvider {

    public FabricModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryFuture) {
        super(output, registryFuture);
    }

    @Override
    public @NotNull String getName() {
        return ExampleMod.MOD_NAME + " - Fabric Recipes";
    }

    @Override
    public void buildRecipes(RecipeOutput recipeOutput) {
        RecipeProviderBase.exampleItem().save(withConditions(
            recipeOutput,
            new ConfigResourceCondition("disableExampleItem")
        ));
    }

}
