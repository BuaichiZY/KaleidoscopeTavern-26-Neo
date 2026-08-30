package com.github.ysbbbbbb.kaleidoscopetavern.datagen.tag;

import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks;
import com.github.ysbbbbbb.kaleidoscopetavern.init.tag.TagCommon;
import com.github.ysbbbbbb.kaleidoscopetavern.init.tag.TagMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class TagBlock extends BlockTagsProvider {
    public TagBlock(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, KaleidoscopeTavern.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(TagMod.SOFA).add(
                ModBlocks.WHITE_SOFA.getKey(),
                ModBlocks.LIGHT_GRAY_SOFA.getKey(),
                ModBlocks.GRAY_SOFA.getKey(),
                ModBlocks.BLACK_SOFA.getKey(),
                ModBlocks.BROWN_SOFA.getKey(),
                ModBlocks.RED_SOFA.getKey(),
                ModBlocks.ORANGE_SOFA.getKey(),
                ModBlocks.YELLOW_SOFA.getKey(),
                ModBlocks.LIME_SOFA.getKey(),
                ModBlocks.GREEN_SOFA.getKey(),
                ModBlocks.CYAN_SOFA.getKey(),
                ModBlocks.LIGHT_BLUE_SOFA.getKey(),
                ModBlocks.BLUE_SOFA.getKey(),
                ModBlocks.PURPLE_SOFA.getKey(),
                ModBlocks.MAGENTA_SOFA.getKey(),
                ModBlocks.PINK_SOFA.getKey()
        );

        this.tag(TagMod.BAR_STOOL).add(
                ModBlocks.WHITE_BAR_STOOL.getKey(),
                ModBlocks.LIGHT_GRAY_BAR_STOOL.getKey(),
                ModBlocks.GRAY_BAR_STOOL.getKey(),
                ModBlocks.BLACK_BAR_STOOL.getKey(),
                ModBlocks.BROWN_BAR_STOOL.getKey(),
                ModBlocks.RED_BAR_STOOL.getKey(),
                ModBlocks.ORANGE_BAR_STOOL.getKey(),
                ModBlocks.YELLOW_BAR_STOOL.getKey(),
                ModBlocks.LIME_BAR_STOOL.getKey(),
                ModBlocks.GREEN_BAR_STOOL.getKey(),
                ModBlocks.CYAN_BAR_STOOL.getKey(),
                ModBlocks.LIGHT_BLUE_BAR_STOOL.getKey(),
                ModBlocks.BLUE_BAR_STOOL.getKey(),
                ModBlocks.PURPLE_BAR_STOOL.getKey(),
                ModBlocks.MAGENTA_BAR_STOOL.getKey(),
                ModBlocks.PINK_BAR_STOOL.getKey()
        );

        this.tag(TagMod.SANDWICH_BOARD).add(
                ModBlocks.BASE_SANDWICH_BOARD.getKey(),
                ModBlocks.GRASS_SANDWICH_BOARD.getKey(),
                ModBlocks.ALLIUM_SANDWICH_BOARD.getKey(),
                ModBlocks.AZURE_BLUET_SANDWICH_BOARD.getKey(),
                ModBlocks.CORNFLOWER_SANDWICH_BOARD.getKey(),
                ModBlocks.ORCHID_SANDWICH_BOARD.getKey(),
                ModBlocks.PEONY_SANDWICH_BOARD.getKey(),
                ModBlocks.PINK_PETALS_SANDWICH_BOARD.getKey(),
                ModBlocks.PITCHER_PLANT_SANDWICH_BOARD.getKey(),
                ModBlocks.POPPY_SANDWICH_BOARD.getKey(),
                ModBlocks.SUNFLOWER_SANDWICH_BOARD.getKey(),
                ModBlocks.TORCHFLOWER_SANDWICH_BOARD.getKey(),
                ModBlocks.TULIP_SANDWICH_BOARD.getKey(),
                ModBlocks.WITHER_ROSE_SANDWICH_BOARD.getKey()
        );

        this.tag(TagMod.STRING_LIGHTS).add(
                ModBlocks.STRING_LIGHTS_COLORLESS.getKey(),
                ModBlocks.STRING_LIGHTS_WHITE.getKey(),
                ModBlocks.STRING_LIGHTS_LIGHT_GRAY.getKey(),
                ModBlocks.STRING_LIGHTS_GRAY.getKey(),
                ModBlocks.STRING_LIGHTS_BLACK.getKey(),
                ModBlocks.STRING_LIGHTS_BROWN.getKey(),
                ModBlocks.STRING_LIGHTS_RED.getKey(),
                ModBlocks.STRING_LIGHTS_ORANGE.getKey(),
                ModBlocks.STRING_LIGHTS_YELLOW.getKey(),
                ModBlocks.STRING_LIGHTS_LIME.getKey(),
                ModBlocks.STRING_LIGHTS_GREEN.getKey(),
                ModBlocks.STRING_LIGHTS_CYAN.getKey(),
                ModBlocks.STRING_LIGHTS_LIGHT_BLUE.getKey(),
                ModBlocks.STRING_LIGHTS_BLUE.getKey(),
                ModBlocks.STRING_LIGHTS_PURPLE.getKey(),
                ModBlocks.STRING_LIGHTS_MAGENTA.getKey(),
                ModBlocks.STRING_LIGHTS_PINK.getKey()
        );

        this.tag(TagMod.PAINTING).add(
                ModBlocks.YSBB_PAINTING.getKey(),
                ModBlocks.TARTARIC_ACID_PAINTING.getKey(),
                ModBlocks.CR019_PAINTING.getKey(),
                ModBlocks.UNKNOWN_PAINTING.getKey(),
                ModBlocks.MASTER_MARISA_PAINTING.getKey(),
                ModBlocks.SON_OF_MAN_PAINTING.getKey(),
                ModBlocks.DAVID_PAINTING.getKey(),
                ModBlocks.GIRL_WITH_PEARL_EARRING_PAINTING.getKey(),
                ModBlocks.STARRY_NIGHT_PAINTING.getKey(),
                ModBlocks.VAN_GOGH_SELF_PORTRAIT_PAINTING.getKey(),
                ModBlocks.FATHER_PAINTING.getKey(),
                ModBlocks.GREAT_WAVE_PAINTING.getKey(),
                ModBlocks.MONA_LISA_PAINTING.getKey(),
                ModBlocks.MONDRIAN_PAINTING.getKey()
        );

        this.tag(TagMod.SITTABLE)
                .addTag(TagMod.SOFA)
                .addTag(TagMod.BAR_STOOL);

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(TagMod.SANDWICH_BOARD)
                .addTag(TagMod.PAINTING)
                .add(ModBlocks.CHALKBOARD.getKey())
                .add(ModBlocks.TABLE.getKey())
                .add(ModBlocks.BAR_COUNTER.getKey())
                .add(ModBlocks.STEPLADDER.getKey())
                .add(ModBlocks.TRELLIS.getKey())
                .add(ModBlocks.GRAPEVINE_TRELLIS.getKey())
                .add(ModBlocks.PRESSING_TUB.getKey())
                .add(ModBlocks.BARREL.getKey())
                .add(ModBlocks.BAR_CABINET.getKey())
                .add(ModBlocks.GLASS_BAR_CABINET.getKey());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(TagMod.SOFA)
                .addTag(TagMod.BAR_STOOL)
                .addTag(TagMod.STRING_LIGHTS)
                .add(ModBlocks.TAP.getKey());

        this.tag(BlockTags.CLIMBABLE)
                .add(ModBlocks.WILD_GRAPEVINE.getKey())
                .add(ModBlocks.WILD_GRAPEVINE_PLANT.getKey())
                .add(ModBlocks.GRAPEVINE_TRELLIS.getKey());

        this.tag(TagMod.GRAPEVINE_TRELLISES).add(
                ModBlocks.GRAPEVINE_TRELLIS.getKey(),
                ModBlocks.ICE_GRAPEVINE_TRELLIS.getKey(),
                ModBlocks.GOLD_GRAPEVINE_TRELLIS.getKey()
        );

        this.tag(TagMod.GRASS_STEALTH_PLANTS).add(
                Blocks.SHORT_GRASS.builtInRegistryHolder().key(),
                Blocks.SHORT_DRY_GRASS.builtInRegistryHolder().key(),
                Blocks.TALL_GRASS.builtInRegistryHolder().key(),
                Blocks.TALL_DRY_GRASS.builtInRegistryHolder().key(),
                Blocks.FIREFLY_BUSH.builtInRegistryHolder().key(),
                Blocks.FERN.builtInRegistryHolder().key(),
                Blocks.LARGE_FERN.builtInRegistryHolder().key(),
                Blocks.DEAD_BUSH.builtInRegistryHolder().key(),
                Blocks.NETHER_SPROUTS.builtInRegistryHolder().key(),
                Blocks.CRIMSON_ROOTS.builtInRegistryHolder().key(),
                Blocks.WARPED_ROOTS.builtInRegistryHolder().key(),
                Blocks.LILAC.builtInRegistryHolder().key(),
                Blocks.ROSE_BUSH.builtInRegistryHolder().key(),
                Blocks.PEONY.builtInRegistryHolder().key(),
                Blocks.PITCHER_PLANT.builtInRegistryHolder().key(),
                Blocks.SUGAR_CANE.builtInRegistryHolder().key(),
                Blocks.SWEET_BERRY_BUSH.builtInRegistryHolder().key(),
                Blocks.SUNFLOWER.builtInRegistryHolder().key()
        );

        // 兼容静谧四季模组
        this.tag(TagCommon.SPRING_CROPS_BLOCK).add(
                ModBlocks.GRAPEVINE_TRELLIS.getKey()
        );
        this.tag(TagCommon.SUMMER_CROPS_BLOCK).add(
                ModBlocks.GRAPEVINE_TRELLIS.getKey(),
                ModBlocks.GOLD_GRAPEVINE_TRELLIS.getKey(),
                ModBlocks.GRAPE_CROP.getKey(),
                ModBlocks.GOLD_GRAPE_CROP.getKey()
        );
        this.tag(TagCommon.AUTUMN_CROPS_BLOCK).add(
                ModBlocks.GRAPE_CROP.getKey()
        );
        this.tag(TagCommon.WINTER_CROPS_BLOCK).add(
                ModBlocks.ICE_GRAPEVINE_TRELLIS.getKey(),
                ModBlocks.ICE_GRAPE_CROP.getKey()
        );

        // 节气模组：湿度
        this.tag(TagCommon.AVERAGE_MOIST).add(
                ModBlocks.GRAPEVINE_TRELLIS.getKey(),
                ModBlocks.ICE_GRAPEVINE_TRELLIS.getKey(),
                ModBlocks.GOLD_GRAPEVINE_TRELLIS.getKey(),
                ModBlocks.GRAPE_CROP.getKey(),
                ModBlocks.ICE_GRAPE_CROP.getKey(),
                ModBlocks.GOLD_GRAPE_CROP.getKey()
        );

        // Carry On 黑名单
        var blacklist = tag(TagCommon.CARRYON_BLOCK_BLACKLIST);
        BuiltInRegistries.BLOCK.keySet().stream()
                .filter(id -> id.getNamespace().equals(KaleidoscopeTavern.MOD_ID))
                .forEach(id -> blacklist.add(BuiltInRegistries.BLOCK.getValue(id).builtInRegistryHolder().key()));
    }
}
