package examplemod.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import examplemod.ExampleMod;
import examplemod.common.item.ExampleModItems;

public class ExampleModLanguageProvider extends FabricLanguageProvider {

    protected ExampleModLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryFuture) {
        super(dataOutput, "en_us", registryFuture);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup." + ExampleMod.MODID, ExampleMod.MOD_NAME);
        addItem(translationBuilder, ExampleModItems.exampleItemId, "Example Item Name");
    }

    private void addItem(TranslationBuilder builder, String id, String name) {
        builder.add("item." + ExampleMod.MODID + "." + id, name);
    }

}
