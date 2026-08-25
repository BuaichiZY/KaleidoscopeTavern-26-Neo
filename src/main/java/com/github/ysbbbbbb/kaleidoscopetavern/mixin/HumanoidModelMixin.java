package com.github.ysbbbbbb.kaleidoscopetavern.mixin;

import com.github.ysbbbbbb.kaleidoscopetavern.client.animation.FinalPlayerPose;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Reapply the shaker pose to secondary humanoid models such as armor after
 * their vanilla pose pass. PlayerModel receives one additional final pass
 * after Player Animation Library has updated its bones.
 */
@Mixin(value = HumanoidModel.class, priority = 100)
public abstract class HumanoidModelMixin {
    @Inject(
            method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/HumanoidRenderState;)V",
            at = @At("HEAD"),
            order = 10000
    )
    private void kaleidoscopeTavern$clearProtectedLimbs(HumanoidRenderState state, CallbackInfo ci) {
        FinalPlayerPose.clearProtection((HumanoidModel<?>) (Object) this);
    }

    @Inject(
            method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/HumanoidRenderState;)V",
            at = @At("RETURN"),
            order = 10000
    )
    private void kaleidoscopeTavern$applyShakerToHumanoidLayers(HumanoidRenderState state, CallbackInfo ci) {
        FinalPlayerPose.apply((HumanoidModel<?>) (Object) this, state);
    }
}
