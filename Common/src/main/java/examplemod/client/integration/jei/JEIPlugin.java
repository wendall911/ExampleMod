package examplemod.client.integration.jei;

import java.util.Collections;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;


import examplemod.common.item.ExampleModItems;
import examplemod.config.ConfigHandler;

import static examplemod.util.ResourceLocationHelper.prefix;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return prefix("jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {

        if (ConfigHandler.Common.disableExampleItem()) {
            registration.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK,
                    Collections.singleton(new ItemStack(ExampleModItems.exampleItem)));
        }
    }

}
