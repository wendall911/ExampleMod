package examplemod.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class CommonItemTagProvider extends ItemTagsProvider {

    public CommonItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagsProvider) {
        super(packOutput, lookupProvider, blockTagsProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    }

}
