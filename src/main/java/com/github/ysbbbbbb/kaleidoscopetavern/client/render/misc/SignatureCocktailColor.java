package com.github.ysbbbbbb.kaleidoscopetavern.client.render.misc;

import com.github.ysbbbbbb.kaleidoscopetavern.blockentity.mixology.SignatureCocktailBlockEntity;
import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.List;

@EventBusSubscriber(modid = KaleidoscopeTavern.MOD_ID, value = Dist.CLIENT)
public final class SignatureCocktailColor {
    private static final int OPAQUE_MASK = 0xFE000000;

    private SignatureCocktailColor() {
    }

    private static int opaque(int color) {
        return OPAQUE_MASK | (color & 0xFFFFFF);
    }

    @SubscribeEvent
    public static void register(RegisterColorHandlersEvent.BlockTintSources event) {
        event.register(List.of(new Block()), ModBlocks.SIGNATURE_COCKTAIL.get());
    }

    public static class Block implements BlockTintSource {
        @Override
        public int color(@NotNull BlockState state) {
            return opaque(0xFFFFFF);
        }

        @Override
        public int colorInWorld(@NotNull BlockState state, @NotNull BlockAndTintGetter level, @NotNull BlockPos pos) {
            if (level.getBlockEntity(pos) instanceof SignatureCocktailBlockEntity blockEntity) {
                return opaque(blockEntity.getColor());
            }
            return opaque(0xFFFFFF);
        }
    }
}
