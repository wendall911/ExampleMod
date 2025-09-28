package examplemod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

import technology.roughness.whitenoise.config.WhiteNoiseInitializer;

import examplemod.config.ConfigHandler;
import examplemod.data.recipe.ConfigResourceCondition;

public class FabricConfigInitializer implements WhiteNoiseInitializer {

    @Override
    public void onInitializeConfig() {
        ExampleMod.initConfig();

        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            ConfigHandler.init();
        });

        ConfigResourceCondition.init();
    }

}
