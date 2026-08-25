package com.github.ysbbbbbb.kaleidoscopetavern.mixin;

import com.github.ysbbbbbb.kaleidoscopetavern.client.animation.FinalPlayerPose;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.HumanoidArm;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Player Animation Library (used by Better Combat and several animation mods)
 * writes its bone transforms at the end of PlayerModel#setupAnim. Apply the
 * original Tavern shaker arm pose after that final animation pass so both the
 * normal third-person renderer and PAL's first-person full-player renderer use it.
 */
@Mixin(value = PlayerModel.class, priority = 100)
public abstract class PlayerModelMixin {
    @Inject(
            method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;)V",
            at = @At("HEAD"),
            order = 10000
    )
    private void kaleidoscopeTavern$clearProtectedPlayerLayers(AvatarRenderState state, CallbackInfo ci) {
        PlayerModel model = (PlayerModel) (Object) this;
        FinalPlayerPose.protect(model.rightSleeve, false);
        FinalPlayerPose.protect(model.leftSleeve, false);
        FinalPlayerPose.protect(model.rightPants, false);
        FinalPlayerPose.protect(model.leftPants, false);
    }

    @Inject(
            method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;)V",
            at = @At("RETURN"),
            order = 10000
    )
    private void kaleidoscopeTavern$applyShakerPoseLast(AvatarRenderState state, CallbackInfo ci) {
        PlayerModel model = (PlayerModel) (Object) this;
        HumanoidArm usedArm = FinalPlayerPose.apply(model, state);

        if (usedArm == HumanoidArm.RIGHT) {
            FinalPlayerPose.protect(model.rightSleeve, true);
        } else if (usedArm == HumanoidArm.LEFT) {
            FinalPlayerPose.protect(model.leftSleeve, true);
        }
    }
}
