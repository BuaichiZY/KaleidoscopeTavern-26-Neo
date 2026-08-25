package com.github.ysbbbbbb.kaleidoscopetavern.mixin;

import com.github.ysbbbbbb.kaleidoscopetavern.client.animation.ShakerAnimation;
import com.github.ysbbbbbb.kaleidoscopetavern.client.render.state.ShakerRenderStateAccess;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModItems;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.HumanoidArm;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Mark the used arm after the final avatar state has been extracted so every
 * downstream player model sees the shaker pose, including Vivecraft and
 * Player Animation Library render passes.
 */
@Mixin(value = AvatarRenderer.class, priority = 100)
public abstract class AvatarRendererMixin {
    @Inject(
            method = "extractRenderState(Lnet/minecraft/world/entity/Avatar;Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;F)V",
            at = @At("RETURN"),
            order = 10000
    )
    private void kaleidoscopeTavern$markShakerPose(
            Avatar avatar, AvatarRenderState state, float partialTick, CallbackInfo ci
    ) {
        ShakerRenderStateAccess access = (ShakerRenderStateAccess) state;
        access.kaleidoscopeTavern$setShakerArm(null);
        if (!avatar.isUsingItem() || !avatar.getUseItem().is(ModItems.SHAKER)) {
            return;
        }

        HumanoidArm usedArm = avatar.getUsedItemHand() == InteractionHand.MAIN_HAND
                ? avatar.getMainArm()
                : avatar.getMainArm().getOpposite();
        access.kaleidoscopeTavern$setShakerArm(usedArm);
        if (usedArm == HumanoidArm.RIGHT) {
            state.rightArmPose = ShakerAnimation.shakingPose();
        } else {
            state.leftArmPose = ShakerAnimation.shakingPose();
        }
    }
}
