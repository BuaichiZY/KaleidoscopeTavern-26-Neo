package com.github.ysbbbbbb.kaleidoscopetavern.mixin;

import com.github.ysbbbbbb.kaleidoscopetavern.client.animation.ShakerAnimation;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.HumanoidArm;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Keep the shaker on the same vanilla BOW pose path as Cookery's raw dough,
 * then replace only the final arm transform with Tavern's original motion.
 * Animation libraries copy this vanilla pose as their base bone state, so the
 * motion is available before their own layers run instead of being patched in
 * after rendering has already taken ownership of the model.
 */
@Mixin(HumanoidModel.ArmPose.class)
public abstract class ArmPoseMixin {
    @Inject(
            method = "applyTransform(Lnet/minecraft/client/model/HumanoidModel;Lnet/minecraft/client/renderer/entity/state/HumanoidRenderState;Lnet/minecraft/world/entity/HumanoidArm;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void kaleidoscopeTavern$replaceShakerBowPose(
            HumanoidModel<?> model, HumanoidRenderState state, HumanoidArm arm, CallbackInfo ci
    ) {
        HumanoidModel.ArmPose self = (HumanoidModel.ArmPose) (Object) this;
        if (self != HumanoidModel.ArmPose.BOW_AND_ARROW || !ShakerAnimation.isUsingShaker(state, arm)) {
            return;
        }

        ModelPart armPart = arm == HumanoidArm.RIGHT ? model.rightArm : model.leftArm;
        ShakerAnimation.applyArmRotation(armPart, arm, state.ageInTicks);
        ci.cancel();
    }
}
