package examplemod.data.recipe;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;

import net.minecraftforge.common.crafting.conditions.ICondition;

import examplemod.ExampleMod;

public class NeoForgeRecipeProvider extends RecipeProviderBase {

    public NeoForgeRecipeProvider(@NotNull final PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public @NotNull String getName() {
        return ExampleMod.MOD_NAME + " - Forge Recipes";
    }

    @Override
    protected void registerRecipes(Consumer<FinishedRecipe> consumer) {
        exampleItem().save(withConditions(consumer, new ConfigResourceCondition(("disableExampleItem"))));
    }

    private static Consumer<FinishedRecipe> withConditions(Consumer<FinishedRecipe> consumer, ICondition... conditions) {
        ConsumerWrapperBuilder builder = ConsumerWrapperBuilder.wrap();

        for (ICondition condition : conditions) {
            builder.addCondition(condition);
        }

        return builder.build(consumer);
    }

}
