package examplemod.data;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;

public class FabricItemTagProvider extends ItemTagsProvider {

    public FabricItemTagProvider(FabricDataOutput dataGenerator, CompletableFuture<HolderLookup.Provider> registriesFuture, CompletableFuture<TagLookup<Block>> blockTagsProvider) {
        super(dataGenerator, registriesFuture, blockTagsProvider);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
    }

}
