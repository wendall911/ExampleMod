package examplemod.data;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;

import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import examplemod.data.recipe.NeoForgeRecipeProvider;
import examplemod.ExampleMod;

@EventBusSubscriber(modid = ExampleMod.MODID)
public class NeoForgeDatagenInitializer {

    @SubscribeEvent
    public static void configureNeoForgeDatagen(GatherDataEvent.Client event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();

        event.createReloadableRegistryObjects(new RegistrySetBuilder()
            .add(RecipeProvider.asBootstrap(NeoForgeRecipeProvider::new))
        );
    }

}
