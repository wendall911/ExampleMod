package examplemod.data.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;

public class CommonRecipeProvider extends RecipeProvider {

    BootstrapContext<Recipe<?>> recipeOutput;
    BootstrapContext<Advancement> advancementOutput;
    Provider registries;

    public CommonRecipeProvider(Provider registries, BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);

        this.registries = registries;
        this.recipeOutput = recipeOutput;
        this.advancementOutput = advancementOutput;
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
