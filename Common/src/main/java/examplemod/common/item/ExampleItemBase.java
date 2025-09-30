package examplemod.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ExampleItemBase extends Item {

    public ExampleItemBase(Properties props) {
        super(props);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

}
