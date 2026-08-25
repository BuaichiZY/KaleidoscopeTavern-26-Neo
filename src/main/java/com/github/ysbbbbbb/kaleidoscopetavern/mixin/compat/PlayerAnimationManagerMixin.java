package com.github.ysbbbbbb.kaleidoscopetavern.mixin.compat;

import com.github.ysbbbbbb.kaleidoscopetavern.client.animation.ShakerAnimation;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModItems;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.HumanoidArm;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Player Animation Library owns the final player bone update while one of its
 * animation layers is active. Apply the shaker rotation at that exact boundary
 * using the live avatar use state. This optional pseudo mixin is skipped when
 * Player Animation Library is not installed.
 */
@Pseudo
@Mixin(targets = "com.zigythebird.playeranim.animation.AvatarAnimManager", remap = false)
public abstract class PlayerAnimationManagerMixin {
    @Shadow
    @Final
    private Avatar avatar;

    @Shadow
    private float tickDelta;

    @Inject(
            method = "updatePart(Lnet/minecraft/client/model/geom/ModelPart;Lcom/zigythebird/playeranimcore/bones/PlayerAnimBone;)V",
            at = @At("RETURN"),
            require = 0,
            remap = false
    )
    private void kaleidoscopeTavern$applyShakerToPalBone(ModelPart part, @Coerce Object bone, CallbackInfo ci) {
        PartPose initialPose = part.getInitialPose();
        if (!avatar.isUsingItem() || !avatar.getUseItem().is(ModItems.SHAKER)) {
            return;
        }

        HumanoidArm usedArm = avatar.getUsedItemHand() == InteractionHand.MAIN_HAND
                ? avatar.getMainArm()
                : avatar.getMainArm().getOpposite();
        boolean isUsedArmPart = usedArm == HumanoidArm.RIGHT
                ? initialPose.x() <= -4.0F && initialPose.y() <= 4.0F
                : initialPose.x() >= 4.0F && initialPose.y() <= 4.0F;
        if (isUsedArmPart) {
            ShakerAnimation.applyArmRotation(part, usedArm, avatar.tickCount + tickDelta);
        }
    }

}
