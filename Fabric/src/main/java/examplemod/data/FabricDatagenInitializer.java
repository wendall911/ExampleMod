package examplemod.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import examplemod.data.recipe.CommonRecipeProvider;
import examplemod.data.recipe.FabricModRecipeProvider;
import examplemod.ExampleMod;

public class FabricDatagenInitializer implements DataGeneratorEntrypoint {

    private static FabricTagProvider.BlockTagProvider fabricBlockTagProvider;

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        FabricDataGenerator.Pack pack = gen.createPack();
        fabricBlockTagProvider = pack.addProvider(FabricBlockTagProvider::new);

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
        pack.addProvider((dataOutput, registryFuture) -> new CommonItemTagProvider(dataOutput, registryFuture, fabricBlockTagProvider.contentsGetter()));
        pack.addProvider((dataOutput, registryFuture) -> new FabricItemModelProvider(dataOutput));
        pack.addProvider(CommonRecipeProvider::new);
        pack.addProvider(ExampleModLanguageProvider::new);
    }

    /*
     * Fabric only datagen.
     */
    public static void configureFabricDatagen(FabricDataGenerator.Pack pack) {
        pack.addProvider((dataOutput, registryFuture) -> new FabricItemTagProvider(dataOutput, registryFuture, fabricBlockTagProvider.contentsGetter()));
        pack.addProvider(FabricModRecipeProvider::new);
    }

}
