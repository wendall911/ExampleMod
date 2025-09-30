package examplemod.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import examplemod.data.recipe.NeoForgeRecipeProvider;
import examplemod.ExampleMod;

@EventBusSubscriber(modid = ExampleMod.MODID)
public class NeoForgeDatagenInitializer {

    @SubscribeEvent
    public static void configureNeoForgeDatagen(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new NeoForgeRecipeProvider(packOutput, lookupProvider));
    }

}
