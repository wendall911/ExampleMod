package examplemod;

import java.util.Map;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import examplemod.common.item.ExampleModItems;

public class ExampleModClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        for (Map.Entry<Identifier, Item> entry : ExampleModItems.getAll().entrySet()) {
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register(entries -> entries.accept(entry.getValue()));
        }
    }

}
