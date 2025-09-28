package examplemod.data.recipe;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.minecraft.data.recipes.FinishedRecipe;

import examplemod.ExampleMod;

public class FabricModRecipeProvider extends FabricRecipeProvider {

    public FabricModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public @NotNull String getName() {
        return ExampleMod.MOD_NAME + " - Fabric Recipes";
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {
        RecipeProviderBase.exampleItem().save(withConditions(consumer, ConfigResourceCondition.configDisabled("disableExampleItem")));
    }

}
