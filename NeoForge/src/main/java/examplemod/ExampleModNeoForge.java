package examplemod;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import examplemod.common.item.ExampleModItems;
import examplemod.data.recipe.ConfigResourceCondition;
import examplemod.event.ServerEventListener;

@Mod(ExampleMod.MODID)
public class ExampleModNeoForge {

    @SuppressWarnings("removal")
    public ExampleModNeoForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ExampleMod.init();
        registryInit(eventBus);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::buildCreativeTabContents);
        ExampleMod.initConfig();
    }

    private void buildCreativeTabContents(BuildCreativeModeTabContentsEvent evt) {
        if (evt.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            for (Map.Entry<ResourceLocation, Item> entry : ExampleModItems.getAll().entrySet()) {
                Item item = entry.getValue();

                if (item != null) {
                    evt.accept(new ItemStack(item));
                }
            }
        }
    }

    private void setup(final FMLCommonSetupEvent evt) {
        MinecraftForge.EVENT_BUS.register(ServerEventListener.class);
    }

    private void registryInit(IEventBus eventBus) {
        bind(ForgeRegistries.ITEMS.getRegistryKey(), ExampleModItems::registerItems, eventBus);

        bind(ForgeRegistries.RECIPE_SERIALIZERS.getRegistryKey(), ConfigResourceCondition::init, eventBus);
    }

    private static <T> void bind(ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, ResourceLocation>> source, IEventBus eventBus) {
        eventBus.addListener((RegisterEvent event) -> {
            if (registry.equals(event.getRegistryKey())) {
                source.accept((t, rl) -> event.register(registry, rl, () -> t));
            }
        });
    }

}
