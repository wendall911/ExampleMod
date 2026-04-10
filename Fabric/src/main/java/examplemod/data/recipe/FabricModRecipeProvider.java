package examplemod.data.recipe;

import java.util.concurrent.CompletableFuture;

import org.jspecify.annotations.NonNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import examplemod.ExampleMod;

public class FabricModRecipeProvider extends FabricRecipeProvider {

    public FabricModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryFuture) {
        super(output, registryFuture);
    }

    @Override
    public @NonNull String getName() {
        return ExampleMod.MOD_NAME + " - Fabric Recipes";
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.Provider registries, @NonNull RecipeOutput recipeOutput) {
        HolderLookup.RegistryLookup<Item> itemRegistry = registries.lookupOrThrow(Registries.ITEM);

        RecipeProviderBase.exampleItem(itemRegistry).save(withConditions(
            recipeOutput,
            new ConfigResourceCondition("disableExampleItem")
        ));

        return new CommonRecipeProvider(registries, recipeOutput);
    }

}
