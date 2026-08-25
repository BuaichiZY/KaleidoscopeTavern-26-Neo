package com.github.ysbbbbbb.kaleidoscopetavern.client.render.misc;

import com.github.ysbbbbbb.kaleidoscopetavern.blockentity.brew.PotionBottleBlockEntity;
import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.List;

@EventBusSubscriber(modid = KaleidoscopeTavern.MOD_ID, value = Dist.CLIENT)
public class PotionBottleColor implements BlockTintSource {
    @SubscribeEvent
    public static void register(RegisterColorHandlersEvent.BlockTintSources event) {
        event.register(List.of(new PotionBottleColor()), ModBlocks.POTION_BOTTLE.get());
    }

    @Override
    public int color(@NotNull BlockState state) {
        return 0xFFFFFFFF;
    }

    @Override
    public int colorInWorld(@NotNull BlockState state, @NotNull BlockAndTintGetter level, @NotNull BlockPos pos) {
        if (level.getBlockEntity(pos) instanceof PotionBottleBlockEntity blockEntity && !blockEntity.getPotionStack().isEmpty()) {
            PotionContents contents = blockEntity.getPotionStack().get(DataComponents.POTION_CONTENTS);
            if (contents != null) {
                return 0xFF000000 | contents.getColor();
            }
        }
        return 0xFFFFFFFF;
    }
}
