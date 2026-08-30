package com.github.ysbbbbbb.kaleidoscopetavern.datagen.tag;

import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModItems;
import com.github.ysbbbbbb.kaleidoscopetavern.init.tag.TagCommon;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class TagItem extends ItemTagsProvider {
    public TagItem(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup,
                   CompletableFuture<TagsProvider.TagLookup<Block>> contentsGetter
    ) {
        super(output, lookup, KaleidoscopeTavern.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(TagCommon.FRUITS_GRAPES).add(
                ModItems.GRAPE.getKey()
        );

        tag(TagCommon.FRUITS).add(
                ModItems.GRAPE.getKey(),
                ModItems.ICE_GRAPE.getKey(),
                ModItems.GOLD_GRAPE.getKey(),
                ModItems.GREEN_GRAPE.getKey()
        );
    }
}
