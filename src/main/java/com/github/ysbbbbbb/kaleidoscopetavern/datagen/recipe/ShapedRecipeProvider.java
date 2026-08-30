package com.github.ysbbbbbb.kaleidoscopetavern.datagen.recipe;

import com.github.ysbbbbbb.kaleidoscopetavern.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

import java.util.function.Supplier;

public class ShapedRecipeProvider extends ModRecipeProvider {
    public ShapedRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        // 沙发
        sofa(ModItems.WHITE_SOFA, wool(DyeColor.WHITE));
        sofa(ModItems.ORANGE_SOFA, wool(DyeColor.ORANGE));
        sofa(ModItems.MAGENTA_SOFA, wool(DyeColor.MAGENTA));
        sofa(ModItems.LIGHT_BLUE_SOFA, wool(DyeColor.LIGHT_BLUE));
        sofa(ModItems.YELLOW_SOFA, wool(DyeColor.YELLOW));
        sofa(ModItems.LIME_SOFA, wool(DyeColor.LIME));
        sofa(ModItems.PINK_SOFA, wool(DyeColor.PINK));
        sofa(ModItems.GRAY_SOFA, wool(DyeColor.GRAY));
        sofa(ModItems.LIGHT_GRAY_SOFA, wool(DyeColor.LIGHT_GRAY));
        sofa(ModItems.CYAN_SOFA, wool(DyeColor.CYAN));
        sofa(ModItems.PURPLE_SOFA, wool(DyeColor.PURPLE));
        sofa(ModItems.BLUE_SOFA, wool(DyeColor.BLUE));
        sofa(ModItems.BROWN_SOFA, wool(DyeColor.BROWN));
        sofa(ModItems.GREEN_SOFA, wool(DyeColor.GREEN));
        sofa(ModItems.BLACK_SOFA, wool(DyeColor.BLACK));
        sofa(ModItems.RED_SOFA, wool(DyeColor.RED));

        // 高脚凳
        barStool(ModItems.WHITE_BAR_STOOL, wool(DyeColor.WHITE));
        barStool(ModItems.ORANGE_BAR_STOOL, wool(DyeColor.ORANGE));
        barStool(ModItems.MAGENTA_BAR_STOOL, wool(DyeColor.MAGENTA));
        barStool(ModItems.LIGHT_BLUE_BAR_STOOL, wool(DyeColor.LIGHT_BLUE));
        barStool(ModItems.YELLOW_BAR_STOOL, wool(DyeColor.YELLOW));
        barStool(ModItems.LIME_BAR_STOOL, wool(DyeColor.LIME));
        barStool(ModItems.PINK_BAR_STOOL, wool(DyeColor.PINK));
        barStool(ModItems.GRAY_BAR_STOOL, wool(DyeColor.GRAY));
        barStool(ModItems.LIGHT_GRAY_BAR_STOOL, wool(DyeColor.LIGHT_GRAY));
        barStool(ModItems.CYAN_BAR_STOOL, wool(DyeColor.CYAN));
        barStool(ModItems.PURPLE_BAR_STOOL, wool(DyeColor.PURPLE));
        barStool(ModItems.BLUE_BAR_STOOL, wool(DyeColor.BLUE));
        barStool(ModItems.BROWN_BAR_STOOL, wool(DyeColor.BROWN));
        barStool(ModItems.GREEN_BAR_STOOL, wool(DyeColor.GREEN));
        barStool(ModItems.BLACK_BAR_STOOL, wool(DyeColor.BLACK));
        barStool(ModItems.RED_BAR_STOOL, wool(DyeColor.RED));

        // 香薰
        incense(ModItems.SAKURA_INCENSE, Items.CHERRY_SAPLING);
        incense(ModItems.PINE_INCENSE, Items.SPRUCE_SAPLING);
        incense(ModItems.GINKGO_INCENSE, dye(DyeColor.YELLOW));
        incense(ModItems.SPORE_INCENSE, Items.SPORE_BLOSSOM);
        incense(ModItems.CATNIP_INCENSE, Items.ALLIUM);
        incense(ModItems.SNOW_INCENSE, Items.SNOWBALL);
        incense(ModItems.BUTTERFLY_INCENSE, Items.PITCHER_PLANT);
        incense(ModItems.FIREFLY_INCENSE, Items.GLOWSTONE_DUST);

        // 黑板
        this.shaped(RecipeCategory.DECORATIONS, ModItems.CHALKBOARD.get())
                .pattern("III")
                .pattern("ISI")
                .pattern("III")
                .define('I', Items.INK_SAC)
                .define('S', ItemTags.SIGNS)
                .unlockedBy("has_ink_sac", has(Items.INK_SAC))
                .save(this.output);

        // 展板
        this.shaped(RecipeCategory.DECORATIONS, ModItems.BASE_SANDWICH_BOARD.get())
                .pattern("I")
                .pattern("S")
                .define('I', Items.INK_SAC)
                .define('S', ItemTags.WOODEN_SLABS)
                .unlockedBy("has_ink_sac", has(Items.INK_SAC))
                .save(this.output);

        // 灯串
        // 无色的
        this.shaped(RecipeCategory.DECORATIONS, ModItems.STRING_LIGHTS_COLORLESS.get(), 8)
                .pattern("CCC")
                .pattern("LLL")
                .define('C', Items.IRON_CHAIN)
                .define('L', Items.LANTERN)
                .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                .save(this.output);

        // 有色灯串
        stringLights(ModItems.STRING_LIGHTS_WHITE, dye(DyeColor.WHITE));
        stringLights(ModItems.STRING_LIGHTS_ORANGE, dye(DyeColor.ORANGE));
        stringLights(ModItems.STRING_LIGHTS_MAGENTA, dye(DyeColor.MAGENTA));
        stringLights(ModItems.STRING_LIGHTS_LIGHT_BLUE, dye(DyeColor.LIGHT_BLUE));
        stringLights(ModItems.STRING_LIGHTS_YELLOW, dye(DyeColor.YELLOW));
        stringLights(ModItems.STRING_LIGHTS_LIME, dye(DyeColor.LIME));
        stringLights(ModItems.STRING_LIGHTS_PINK, dye(DyeColor.PINK));
        stringLights(ModItems.STRING_LIGHTS_GRAY, dye(DyeColor.GRAY));
        stringLights(ModItems.STRING_LIGHTS_LIGHT_GRAY, dye(DyeColor.LIGHT_GRAY));
        stringLights(ModItems.STRING_LIGHTS_CYAN, dye(DyeColor.CYAN));
        stringLights(ModItems.STRING_LIGHTS_PURPLE, dye(DyeColor.PURPLE));
        stringLights(ModItems.STRING_LIGHTS_BLUE, dye(DyeColor.BLUE));
        stringLights(ModItems.STRING_LIGHTS_BROWN, dye(DyeColor.BROWN));
        stringLights(ModItems.STRING_LIGHTS_GREEN, dye(DyeColor.GREEN));
        stringLights(ModItems.STRING_LIGHTS_BLACK, dye(DyeColor.BLACK));
        stringLights(ModItems.STRING_LIGHTS_RED, dye(DyeColor.RED));

        // 蒙德里安挂画是有序合成
        this.shaped(RecipeCategory.DECORATIONS, ModItems.MONDRIAN_PAINTING.get())
                .pattern(" B ")
                .pattern("WFY")
                .pattern(" R ")
                .define('F', Items.ITEM_FRAME)
                .define('B', Tags.Items.DYES_BLUE)
                .define('W', Tags.Items.DYES_WHITE)
                .define('Y', Tags.Items.DYES_YELLOW)
                .define('R', Tags.Items.DYES_RED)
                .unlockedBy("has_item_frame", has(Items.ITEM_FRAME))
                .save(this.output);

        // 吧台
        this.shaped(RecipeCategory.DECORATIONS, ModItems.BAR_COUNTER.get())
                .pattern("NNN")
                .pattern("WWW")
                .pattern("WWW")
                .define('N', Tags.Items.NUGGETS_GOLD)
                .define('W', ItemTags.PLANKS)
                .unlockedBy("has_nugget", has(Tags.Items.NUGGETS_GOLD))
                .save(this.output);

        // 人字梯
        this.shaped(RecipeCategory.DECORATIONS, ModItems.STEPLADDER.get())
                .pattern("L  ")
                .pattern("LL ")
                .pattern("LLL")
                .define('L', Items.LADDER)
                .unlockedBy("has_ladder", has(Items.LADDER))
                .save(this.output);

        // 藤架
        this.shaped(RecipeCategory.DECORATIONS, ModItems.TRELLIS.get(), 8)
                .pattern("G")
                .pattern("G")
                .pattern("G")
                .define('G', ModItems.GRAPEVINE.get())
                .unlockedBy("has_grapevine", has(ModItems.GRAPEVINE.get()))
                .save(this.output);

        // 龙头
        this.shaped(RecipeCategory.DECORATIONS, ModItems.TAP.get())
                .pattern("L")
                .pattern("H")
                .define('L', Items.LEVER)
                .define('H', Items.HOPPER)
                .unlockedBy("has_lever", has(Items.LEVER))
                .save(this.output);

        // 酒桶
        this.shaped(RecipeCategory.DECORATIONS, ModItems.BARREL.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', Items.BARREL)
                .unlockedBy("has_barrel", has(Items.BARREL))
                .save(this.output);

        // 酒柜
        this.shaped(RecipeCategory.DECORATIONS, ModItems.BAR_CABINET.get())
                .pattern("GGG")
                .pattern("G G")
                .pattern("GGG")
                .define('G', ModItems.GRAPEVINE.get())
                .unlockedBy("has_grapevine", has(ModItems.GRAPEVINE.get()))
                .save(this.output);

        // 玻璃酒柜
        this.shaped(RecipeCategory.DECORATIONS, ModItems.GLASS_BAR_CABINET.get())
                .pattern("GGG")
                .pattern("GPG")
                .pattern("GGG")
                .define('G', ModItems.GRAPEVINE.get())
                .define('P', Tags.Items.GLASS_PANES)
                .unlockedBy("has_grapevine", has(ModItems.GRAPEVINE.get()))
                .save(this.output);

        // 窖藏酒柜
        this.shaped(RecipeCategory.DECORATIONS, ModItems.CELLAR_CABINET.get())
                .pattern("GGG")
                .pattern("GTG")
                .pattern("GGG")
                .define('G', ModItems.GRAPEVINE.get())
                .define('T', ItemTags.WOODEN_TRAPDOORS)
                .unlockedBy("has_grapevine", has(ModItems.GRAPEVINE.get()))
                .save(this.output);

        // 倾斜酒架
        this.shaped(RecipeCategory.DECORATIONS, ModItems.TILTED_RACK.get(), 3)
                .pattern("I  ")
                .pattern("CI ")
                .pattern("C I")
                .define('I', Tags.Items.INGOTS_IRON)
                .define('C', Items.IRON_CHAIN)
                .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                .save(this.output);

        // 圆周酒架
        this.shaped(RecipeCategory.DECORATIONS, ModItems.CIRCULAR_RACK.get(), 2)
                .pattern("IRI")
                .pattern("IRI")
                .pattern("IRI")
                .define('I', Tags.Items.INGOTS_IRON)
                .define('R', Items.END_ROD)
                .unlockedBy("has_end_rod", has(Items.END_ROD))
                .save(this.output);

        // 单体酒架
        this.shaped(RecipeCategory.DECORATIONS, ModItems.HOLDER.get())
                .pattern(" C ")
                .pattern(" C ")
                .pattern("I I")
                .define('I', Tags.Items.INGOTS_IRON)
                .define('C', Items.IRON_CHAIN)
                .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                .save(this.output);

        // 桌子
        this.shaped(RecipeCategory.DECORATIONS, ModItems.TABLE.get())
                .pattern("WWW")
                .pattern(" F ")
                .pattern(" I ")
                .define('W', ItemTags.PLANKS)
                .define('F', ItemTags.WOODEN_FENCES)
                .define('I', Tags.Items.INGOTS_IRON)
                .unlockedBy("has_fence", has(ItemTags.WOODEN_FENCES))
                .save(this.output);

        // 雪克杯
        this.shaped(RecipeCategory.DECORATIONS, ModItems.SHAKER.get())
                .pattern("I")
                .pattern("B")
                .define('I', Tags.Items.INGOTS_IRON)
                .define('B', Items.BUCKET)
                .unlockedBy("has_bucket", has(Items.BUCKET))
                .save(this.output);

        // 酒杯
        this.shaped(RecipeCategory.DECORATIONS, ModItems.EMPTY_GLASSWARE.get())
                .pattern("G G")
                .pattern(" G ")
                .define('G', Tags.Items.GLASS_PANES)
                .unlockedBy("has_glass_pane", has(Tags.Items.GLASS_PANES))
                .save(this.output);

        // 酒杯架
        this.shaped(RecipeCategory.DECORATIONS, ModItems.GLASSWARE_HOLDER.get())
                .pattern("NNN")
                .pattern("CCC")
                .pattern("NNN")
                .define('N', Tags.Items.NUGGETS_IRON)
                .define('C', Items.IRON_CHAIN)
                .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                .save(this.output);

        // 垂灯
        this.shaped(RecipeCategory.DECORATIONS, ModItems.BELL_PENDANT_LAMP.get(), 8)
                .pattern("C")
                .pattern("C")
                .pattern("B")
                .define('C', Items.IRON_CHAIN)
                .define('B', Items.BELL)
                .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                .save(this.output);

        this.shaped(RecipeCategory.DECORATIONS, ModItems.YELLOW_PENDANT_LAMP.get(), 4)
                .pattern("C")
                .pattern("C")
                .pattern("B")
                .define('C', Items.IRON_CHAIN)
                .define('B', Items.LANTERN)
                .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                .save(this.output);

        this.shaped(RecipeCategory.DECORATIONS, ModItems.BLUE_PENDANT_LAMP.get(), 4)
                .pattern("C")
                .pattern("C")
                .pattern("B")
                .define('C', Items.IRON_CHAIN)
                .define('B', Items.SOUL_LANTERN)
                .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                .save(this.output);
    }

    private void sofa(Supplier<? extends Item> item, Item wool) {
        this.shaped(RecipeCategory.DECORATIONS, item.get())
                .pattern("W W")
                .pattern("WWW")
                .pattern("L L")
                .define('W', wool)
                .define('L', Tags.Items.INGOTS_IRON)
                .unlockedBy("has_wool", has(wool))
                .save(this.output);
    }

    private void barStool(Supplier<? extends Item> item, Item wool) {
        this.shaped(RecipeCategory.DECORATIONS, item.get())
                .pattern("W")
                .pattern("C")
                .pattern("L")
                .define('W', wool)
                .define('C', Items.IRON_CHAIN)
                .define('L', Tags.Items.INGOTS_IRON)
                .unlockedBy("has_wool", has(wool))
                .save(this.output);
    }

    private void stringLights(Supplier<? extends Item> item, Item dye) {
        this.shaped(RecipeCategory.DECORATIONS, item.get(), 8)
                .pattern("CCC")
                .pattern("LLL")
                .pattern("DDD")
                .define('C', Items.IRON_CHAIN)
                .define('L', Items.LANTERN)
                .define('D', dye)
                .unlockedBy("has_dye", has(dye))
                .save(this.output);
    }

    private void incense(Supplier<? extends Item> item, Item ingredient) {
        this.shaped(RecipeCategory.DECORATIONS, item.get())
                .pattern("F")
                .pattern("C")
                .pattern("B")
                .define('F', Items.FEATHER)
                .define('C', ingredient)
                .define('B', Items.GLASS_BOTTLE)
                .unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE))
                .save(this.output);
    }

    private static Item wool(DyeColor color) {
        return Items.WOOL.pick(color);
    }

    private static Item dye(DyeColor color) {
        return Items.DYE.pick(color);
    }
}

