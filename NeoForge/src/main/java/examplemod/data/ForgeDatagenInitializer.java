package examplemod.data;

import net.minecraft.data.DataGenerator;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import examplemod.data.recipe.ForgeRecipeProvider;
import examplemod.ExampleMod;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeDatagenInitializer {

    @SubscribeEvent
    public static void configureForgeDatagen(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();

        gen.addProvider(event.includeServer(), new ForgeRecipeProvider(gen.getPackOutput()));
    }

}
