package com.github.ysbbbbbb.kaleidoscopetavern.mixin;

import com.github.ysbbbbbb.kaleidoscopetavern.client.render.state.ShakerRenderStateAccess;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.HumanoidArm;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(AvatarRenderState.class)
public abstract class AvatarRenderStateMixin implements ShakerRenderStateAccess {
    @Unique
    private @Nullable HumanoidArm kaleidoscopeTavern$shakerArm;

    @Override
    public @Nullable HumanoidArm kaleidoscopeTavern$getShakerArm() {
        return this.kaleidoscopeTavern$shakerArm;
    }

    @Override
    public void kaleidoscopeTavern$setShakerArm(@Nullable HumanoidArm arm) {
        this.kaleidoscopeTavern$shakerArm = arm;
    }

}
