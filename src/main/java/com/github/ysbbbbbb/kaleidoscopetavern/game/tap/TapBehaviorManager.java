package com.github.ysbbbbbb.kaleidoscopetavern.game.tap;

import com.github.ysbbbbbb.kaleidoscopetavern.api.blockentity.ITapBehavior;
import com.github.ysbbbbbb.kaleidoscopetavern.game.tap.impl.WaterloggedBehavior;
import com.google.common.collect.Maps;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class TapBehaviorManager {
    private static final Map<Block, ITapBehavior> BEHAVIOR_MAP = Maps.newHashMap();
    /**
     * 含水方块按方块状态匹配，不能放进仅以方块类型为键的常规注册表。
     */
    private static final WaterloggedBehavior WATERLOGGED_BEHAVIOR = new WaterloggedBehavior();

    public static void register(Block block, ITapBehavior behavior) {
        BEHAVIOR_MAP.put(block, behavior);
    }

    public static boolean contains(BlockState sourceState) {
        return BEHAVIOR_MAP.containsKey(sourceState.getBlock()) || isWaterlogged(sourceState);
    }

    @Nullable
    public static ITapBehavior get(BlockState sourceState) {
        ITapBehavior behavior = BEHAVIOR_MAP.get(sourceState.getBlock());
        return behavior != null ? behavior : isWaterlogged(sourceState) ? WATERLOGGED_BEHAVIOR : null;
    }

    private static boolean isWaterlogged(BlockState sourceState) {
        return sourceState.hasProperty(BlockStateProperties.WATERLOGGED)
                && sourceState.getValue(BlockStateProperties.WATERLOGGED);
    }
}
