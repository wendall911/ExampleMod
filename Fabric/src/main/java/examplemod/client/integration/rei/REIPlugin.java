package examplemod.client.integration.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;

import net.minecraft.world.item.ItemStack;

import examplemod.common.item.ExampleModItems;
import examplemod.config.ConfigHandler;

public class REIPlugin implements REIClientPlugin {

    @Override
    public void registerEntries(EntryRegistry registry) {
        registry.removeEntryIf(this::shouldHideEntry);
    }

    private boolean shouldHideEntry(EntryStack<?> entryStack) {
        if (entryStack.getType() != VanillaEntryTypes.ITEM) return false;

        ItemStack stack = entryStack.castValue();

        if (ConfigHandler.Common.disableExampleItem()) {
            return stack.getItem() == ExampleModItems.exampleItem;
        }

        return false;
    }

}
