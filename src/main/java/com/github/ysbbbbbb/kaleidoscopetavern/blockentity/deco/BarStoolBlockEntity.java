package com.github.ysbbbbbb.kaleidoscopetavern.blockentity.deco;

import com.github.ysbbbbbb.kaleidoscopetavern.blockentity.BaseBlockEntity;
import com.github.ysbbbbbb.kaleidoscopetavern.entity.SitEntity;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;

public class BarStoolBlockEntity extends BaseBlockEntity {
    /**
     * 颜色，默认为白色，决定客户端渲染的材质
     */
    private final DyeColor color;
    /**
     * 缓存的 sit 实体，避免频繁查找实体导致的性能问题
     */
    private @Nullable SitEntity sitEntity = null;
    /**
     * 客户端收到方块实体更新时，座位实体的生成包可能尚未处理。
     * 保留实体 ID，渲染时再延迟解析，恢复原版凳面随乘客转动的效果。
     */
    private int sitEntityId = -1;

    public BarStoolBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.BAR_STOOL_BE.get(), pos, state);
        this.color = DyeColor.WHITE;
    }

    public BarStoolBlockEntity(BlockPos pos, BlockState state, DyeColor color) {
        super(ModBlocks.BAR_STOOL_BE.get(), pos, state);
        this.color = color;
    }

    public void tick() {
        if (this.sitEntity == null) {
            return;
        }

        if (this.sitEntity.isRemoved()) {
            this.setSitEntity(null);
            return;
        }

        Entity entity = this.sitEntity.getFirstPassenger();
        if (!(entity instanceof LivingEntity)) {
            this.setSitEntity(null);
        }
    }

    @Override
    public void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.sitEntityId = input.getIntOr("SitEntityId", -1);
        this.sitEntity = null;
        this.resolveSitEntity();
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if (this.sitEntity != null && this.sitEntity.isAlive()
            && this.sitEntity.blockPosition().equals(this.worldPosition)
        ) {
            output.putInt("SitEntityId", this.sitEntity.getId());
        }
    }

    @Nullable
    public SitEntity getSitEntity() {
        this.resolveSitEntity();
        return sitEntity;
    }

    public void setSitEntity(@Nullable SitEntity sitEntity) {
        this.sitEntity = sitEntity;
        this.sitEntityId = sitEntity == null ? -1 : sitEntity.getId();
        this.refresh();
    }

    private void resolveSitEntity() {
        if (this.sitEntity != null || this.sitEntityId <= 0 || this.level == null) {
            return;
        }
        if (this.level.getEntity(this.sitEntityId) instanceof SitEntity sit
                && sit.blockPosition().equals(this.worldPosition)) {
            this.sitEntity = sit;
        }
    }

    public DyeColor getColor() {
        return color;
    }
}
