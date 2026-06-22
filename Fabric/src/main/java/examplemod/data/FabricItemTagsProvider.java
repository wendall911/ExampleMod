package examplemod.data;

import java.util.concurrent.CompletableFuture;

import org.jspecify.annotations.NonNull;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class FabricItemTagsProvider extends FabricTagsProvider<Item> {

    private final CommonItemTagProvider commonItemTagProvider;

    public FabricItemTagsProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, Registries.ITEM, lookupProvider);

        this.commonItemTagProvider = new CommonItemTagProvider(packOutput, lookupProvider);
    }

    @Override
    protected void addTags(@NonNull Provider registries) {
        commonItemTagProvider.addTags(registries);
    }

}
