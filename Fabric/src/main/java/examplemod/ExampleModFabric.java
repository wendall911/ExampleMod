package examplemod;

import java.util.function.BiConsumer;

import net.fabricmc.api.ModInitializer;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import examplemod.common.item.ExampleModItems;

public class ExampleModFabric implements ModInitializer {

	@Override
    public void onInitialize() {
        registryInit();

        ExampleMod.init();
    }

    private void registryInit() {
        ExampleModItems.registerItems(bind(BuiltInRegistries.ITEM));
    }

    private static <T> BiConsumer<T, Identifier> bind(Registry<? super T> registry) {
        return (t, id) -> Registry.register(registry, id, t);
    }

}
