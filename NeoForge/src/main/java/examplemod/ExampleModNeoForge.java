package examplemod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import examplemod.event.ServerEventListener;

@Mod(ExampleMod.MODID)
public class ExampleModNeoForge {

    @SuppressWarnings("removal")
    public ExampleModNeoForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        ExampleMod.init();
        ExampleMod.initConfig();
    }

    private void setup(final FMLCommonSetupEvent evt) {
        MinecraftForge.EVENT_BUS.register(ServerEventListener.class);
    }

}

