package examplemod.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;

import examplemod.data.recipe.FabricModRecipeProvider;
import examplemod.ExampleMod;

public class FabricDatagenInitializer implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        FabricDataGenerator.Pack pack = gen.createPack();

        if (System.getProperty(ExampleMod.MODID + ".common_datagen") != null) {
            configureCommonDatagen(pack);
        }
        else {
            configureFabricDatagen(pack);
        }
    }

    /*
     * Datagen common across all modloaders.
     */
    public static void configureCommonDatagen(FabricDataGenerator.Pack pack) {
        pack.addProvider(FabricItemTagsProvider::new);
        pack.addProvider((dataOutput, registryFuture) -> new ExampleModItemModelProvider(dataOutput));
        pack.addProvider(ExampleModLanguageProvider::new);
    }

    /*
     * Fabric only datagen.
     */
    public static void configureFabricDatagen(FabricDataGenerator.Pack pack) {
        pack.addProvider(FabricModRecipeProvider::new);
    }

}
