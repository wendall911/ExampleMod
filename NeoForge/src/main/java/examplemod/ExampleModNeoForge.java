package examplemod;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import examplemod.common.item.ExampleModItems;
import examplemod.config.ConfigHandler;
import examplemod.data.recipe.ConfigResourceCondition;
import examplemod.event.ServerEventListener;
import examplemod.registries.ExampleModNeoForgeRegistries;

@Mod(ExampleMod.MODID)
@EventBusSubscriber(modid = ExampleMod.MODID)
public class ExampleModNeoForge {

    public ExampleModNeoForge(IEventBus eventBus) {
        ExampleMod.initConfig();
        registryInit(eventBus);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::buildCreativeTabContents);
        ExampleMod.init();
    }

    private void buildCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            for (Map.Entry<Identifier, Item> entry : ExampleModItems.getAll().entrySet()) {
                Item item = entry.getValue();

                if (item != null) {
                    event.accept(new ItemStack(item));
                }
            }
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        NeoForge.EVENT_BUS.register(ServerEventListener.class);
    }

    private static void registryInit(IEventBus eventBus) {
        bind(eventBus, Registries.ITEM, ExampleModItems::registerItems);
        ExampleModNeoForgeRegistries.CONDITION_SERIALIZERS_DEFERRED_REGISTER.register(eventBus);
        ExampleModNeoForgeRegistries.CONDITION_SERIALIZERS_DEFERRED_REGISTER.register(ConfigResourceCondition.ID, () -> ConfigResourceCondition.CODEC);
    }

    @SubscribeEvent
    public static void initConfig(final ServerStartingEvent event) {
        ConfigHandler.init();
    }

    private static <T> void bind(IEventBus eventBus, ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, Identifier>> source) {
        eventBus.addListener((RegisterEvent event) -> {
            if (registry.equals(event.getRegistryKey())) {
                source.accept((t, rl) -> event.register(registry, rl, () -> t));
            }
        });
    }

}
