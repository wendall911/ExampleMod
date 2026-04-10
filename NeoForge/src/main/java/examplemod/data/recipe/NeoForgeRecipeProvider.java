package examplemod.data.recipe;

import java.util.concurrent.CompletableFuture;

import org.jspecify.annotations.NonNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;

import examplemod.ExampleMod;

public class NeoForgeRecipeProvider extends RecipeProvider.Runner {

    public NeoForgeRecipeProvider(@NonNull final PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    public @NonNull String getName() {
        return ExampleMod.MOD_NAME + " - NeoForge Recipes";
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider provider, @NonNull RecipeOutput recipeOutput) {
        return new VanillaRecipeProvider(provider, recipeOutput) {

            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemRegistry = provider.lookupOrThrow(Registries.ITEM);

                RecipeProviderBase.exampleItem(itemRegistry).save(
                    recipeOutput.withConditions(new ConfigResourceCondition(("disableExampleItem"))));
            }
        };
    }

}
