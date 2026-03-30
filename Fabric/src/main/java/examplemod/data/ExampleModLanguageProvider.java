package examplemod.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import net.minecraft.core.HolderLookup;

import examplemod.ExampleMod;
import examplemod.common.item.ExampleModItems;
import examplemod.common.Translations;

public class ExampleModLanguageProvider extends FabricLanguageProvider {

    protected ExampleModLanguageProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryFuture) {
        super(dataOutput, "en_us", registryFuture);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder) {
        builder.add("itemGroup." + ExampleMod.MODID, ExampleMod.MOD_NAME);
        addItem(builder, ExampleModItems.exampleItemId, "Example Item Name");
        addTranslationTitle(builder, "Example Mod");
        addTranslation(builder, "general");
        addTranslationName(builder, "debugenabled", "Enable Debug");
        addTranslationDescription(builder, "debugenabled");
        addTranslationName(builder, "items", "Item Settings");
        addTranslationDescription(builder, "items");
        addTranslationName(builder, "disableexampleitem", "Disable Example Item");
        addTranslationDescription(builder, "disableexampleitem");
        addTranslationName(builder, "exampleitemdurability", "Example Item Durability");
        addTranslationDescription(builder, "exampleitemdurability");
    }

    private void addItem(TranslationBuilder builder, String id, String name) {
        builder.add("item." + ExampleMod.MODID + "." + id, name);
    }

    private void addTranslationTitle(TranslationBuilder builder, String title) {
        builder.add(ExampleMod.MODID + ".configuration.title", title);
    }

    private void addTranslationName(TranslationBuilder builder, String id, String name) {
        builder.add(ExampleMod.MODID + ".configuration." + id + ".name", name);
    }

    private void addTranslationDescription(TranslationBuilder builder, String id) {
        builder.add(ExampleMod.MODID + ".configuration." + id + ".description", Translations.get(id));
    }

    private void addTranslation(TranslationBuilder buildder, String id) {
        addTranslationName(buildder, id, Translations.get(id + ".title"));
        addTranslationDescription(buildder, id);
    }

    private void addTranslationDescription(TranslationBuilder builder, String id, String key) {
        builder.add(ExampleMod.MODID + ".configuration." + id + ".description", Translations.get(key));
    }

}
