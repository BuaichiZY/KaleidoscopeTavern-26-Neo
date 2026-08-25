package com.github.ysbbbbbb.kaleidoscopetavern.client.render.state;

import net.minecraft.world.entity.HumanoidArm;
import org.jetbrains.annotations.Nullable;

/**
 * Carries the live shaker-use arm through render-state extraction. Animation
 * mods are free to replace vanilla arm-pose enums, so the Tavern animation
 * must not use that enum as its compatibility signal.
 */
public interface ShakerRenderStateAccess {
    @Nullable
    HumanoidArm kaleidoscopeTavern$getShakerArm();

    void kaleidoscopeTavern$setShakerArm(@Nullable HumanoidArm arm);
}
