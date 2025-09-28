package examplemod.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import examplemod.ExampleMod;
import examplemod.common.item.ExampleModItems;

public class ExampleModLanguageProvider extends FabricLanguageProvider {

    protected ExampleModLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup." + ExampleMod.MODID, ExampleMod.MOD_NAME);
        addItem(translationBuilder, ExampleModItems.exampleItemId, "Example Item Name");
    }

    private void addItem(TranslationBuilder builder, String id, String name) {
        builder.add("item." + ExampleMod.MODID + "." + id, name);
    }

}
