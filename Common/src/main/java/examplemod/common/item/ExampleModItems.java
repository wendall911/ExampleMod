package examplemod.common.item;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import examplemod.config.ConfigHandler;

import static examplemod.util.ResourceLocationHelper.prefix;

public final class ExampleModItems {

    private static final Map<ResourceLocation, Item> ALL = new LinkedHashMap<>();

    public static final String exampleItemId = "example_item";
    
    public static final Item exampleItem = make(
        exampleItemId,
        new ExampleItemBase(getProps().stacksTo(1).durability(ConfigHandler.Common.exampleItemDurability()))
    );

    private static <T extends Item> T make(String id, T item) {
        ResourceLocation loc = prefix(id);

        if (ALL.put(loc, item) != null) {
            throw new IllegalArgumentException("Duplicate Item: " + loc);
        }

        return item;
    }

    public static Item.Properties getProps() {
        return new Item.Properties();
    }

    public static void registerItems(BiConsumer<Item, ResourceLocation> consumer) {
        for (Map.Entry<ResourceLocation, Item> entry : ALL.entrySet()) {
            consumer.accept(entry.getValue(), entry.getKey());
        }
    }

    public static Map<ResourceLocation, Item> getAll() {
        return ALL;
    }

}
