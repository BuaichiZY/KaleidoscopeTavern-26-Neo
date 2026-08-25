package com.github.ysbbbbbb.kaleidoscopetavern.datagen.builder;

import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import com.github.ysbbbbbb.kaleidoscopetavern.crafting.recipe.ShakerRecipe;
import com.github.ysbbbbbb.kaleidoscopetavern.crafting.serializer.ShakerRecipeSerializer;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.NonNullList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class ShakerBuilder implements RecipeBuilder {
    private static final String NAME = "shaker";

    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final HolderLookup.Provider registries;
    private ItemStackTemplate result;

    private ShakerBuilder(HolderLookup.Provider registries) {
        this.registries = registries;
    }

    public static ShakerBuilder builder(HolderLookup.Provider registries) {
        return new ShakerBuilder(registries);
    }

    public ShakerBuilder addIngredient(ItemLike itemLike) {
        this.ingredients.add(Ingredient.of(itemLike));
        return this;
    }

    public ShakerBuilder addIngredient(TagKey<Item> tag) {
        var itemLookup = this.registries.lookupOrThrow(Registries.ITEM);
        this.ingredients.add(Ingredient.of(itemLookup.getOrThrow(tag)));
        return this;
    }

    public ShakerBuilder addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public ShakerBuilder setResult(ItemLike itemLike) {
        this.result = new ItemStackTemplate(itemLike.asItem());
        return this;
    }

    @Override
    public @NonNull RecipeBuilder unlockedBy(@NonNull String s, @NonNull Criterion<?> criterion) {
        return this;
    }

    @Override
    public @NonNull RecipeBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public @NonNull ResourceKey<Recipe<?>> defaultId() {
        String path = RecipeBuilder.getDefaultRecipeId(this.result).identifier().getPath();
        return ResourceKey.create(Registries.RECIPE, KaleidoscopeTavern.modLoc(NAME + "/" + path));
    }

    @Override
    public void save(@NonNull RecipeOutput output, @NonNull ResourceKey<Recipe<?>> location) {
        NonNullList<Ingredient> normalized = NonNullList.create();
        normalized.addAll(this.ingredients.stream().limit(ShakerRecipeSerializer.MAX_INGREDIENTS).toList());
        ShakerRecipe recipe = new ShakerRecipe(normalized, this.result, Int2ObjectMaps.emptyMap());
        output.accept(location, recipe, null);
    }
}
