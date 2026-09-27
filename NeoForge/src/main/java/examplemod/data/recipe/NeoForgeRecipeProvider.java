package examplemod.data.recipe;

import net.minecraft.advancements.Advancement;

import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.crafting.Recipe;

public class NeoForgeRecipeProvider extends RecipeProvider {

    public NeoForgeRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    @Override
    protected void buildRecipes() {
        RecipeProviderBase.exampleItem(this.items).save(
            this.output.withConditions(new ConfigResourceCondition(("disableExampleItem"))));
    }

}
