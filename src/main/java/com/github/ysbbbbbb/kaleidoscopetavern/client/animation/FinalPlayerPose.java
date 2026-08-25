package com.github.ysbbbbbb.kaleidoscopetavern.client.animation;

import com.github.ysbbbbbb.kaleidoscopetavern.client.render.state.TavernModelPartAccess;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.HumanoidArm;
import org.jetbrains.annotations.Nullable;

/**
 * Rebuilds Tavern's two required limb poses after optional player animation
 * libraries have finished changing the model.
 */
public final class FinalPlayerPose {
    private FinalPlayerPose() {
    }

    public static void clearProtection(HumanoidModel<?> model) {
        protect(model.rightArm, false);
        protect(model.leftArm, false);
        protect(model.rightLeg, false);
        protect(model.leftLeg, false);
    }

    public static @Nullable HumanoidArm apply(HumanoidModel<?> model, HumanoidRenderState state) {
        HumanoidArm shakerArm = ShakerAnimation.findUsedShakerArm(state);
        if (shakerArm != null) {
            ModelPart armPart = shakerArm == HumanoidArm.RIGHT ? model.rightArm : model.leftArm;
            restoreInitialTransform(armPart);
            ShakerAnimation.applyArmRotation(armPart, shakerArm, state.ageInTicks);
            protect(armPart, true);
        }
        return shakerArm;
    }

    public static void protect(ModelPart part, boolean protectedPose) {
        ((TavernModelPartAccess) (Object) part).kaleidoscopeTavern$setPoseProtected(protectedPose);
    }

    private static void restoreInitialTransform(ModelPart part) {
        PartPose pose = part.getInitialPose();
        part.x = pose.x();
        part.y = pose.y();
        part.z = pose.z();
        part.xRot = pose.xRot();
        part.yRot = pose.yRot();
        part.zRot = pose.zRot();
        part.xScale = pose.xScale();
        part.yScale = pose.yScale();
        part.zScale = pose.zScale();
    }
}
