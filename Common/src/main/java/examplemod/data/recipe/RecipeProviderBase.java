package examplemod.data.recipe;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import examplemod.common.item.ExampleModItems;

import static examplemod.util.ResourceLocationHelper.prefix;

public class RecipeProviderBase {

    private static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderLookup.RegistryLookup<Item> itemRegistry, TagKey<Item> pTag) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(itemRegistry, pTag).build());
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderLookup.RegistryLookup<Item> itemRegistry, ItemLike pItemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(itemRegistry, pItemLike).build());
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(ItemPredicate... predicates) {
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(
            new InventoryChangeTrigger.TriggerInstance(
                Optional.empty(),
                InventoryChangeTrigger.TriggerInstance.Slots.ANY,
                List.of(predicates)
            )
        );
    }

    public static void specialRecipe(RecipeOutput exporter, CustomRecipe.Serializer<?> serializer, Function<CraftingBookCategory, Recipe<?>> recipeFunction) {
        ResourceLocation name = BuiltInRegistries.RECIPE_SERIALIZER.getKey(serializer);

        SpecialRecipeBuilder.special(recipeFunction).save(
            exporter, prefix("dynamic/" + Objects.requireNonNull(name).getPath()).toString());
    }

    /*
     * Example shaped recipe
     */
    protected static ShapedRecipeBuilder exampleItem(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.MISC, ExampleModItems.exampleItem)
            .define('N', Items.IRON_NUGGET)
            .define('K', Items.KELP)
            .pattern("NNN")
            .pattern("NKN")
            .pattern("NNN")
            .unlockedBy("has_item", has(itemRegistry, Items.KELP));
    }

}
