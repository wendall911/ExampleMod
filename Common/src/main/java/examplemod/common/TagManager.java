package examplemod.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagManager {

    public static class Items {

        private static TagKey<Item> itemTag (Identifier loc) {
            return TagKey.create(Registries.ITEM, loc);
        }
    }

    public static final class Blocks {

    }

}
