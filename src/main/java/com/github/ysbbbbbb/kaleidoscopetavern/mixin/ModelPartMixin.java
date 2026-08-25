package com.github.ysbbbbbb.kaleidoscopetavern.mixin;

import com.github.ysbbbbbb.kaleidoscopetavern.client.animation.PunchyModelPartCompat;
import com.github.ysbbbbbb.kaleidoscopetavern.client.render.state.TavernModelPartAccess;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ModelPart.class, priority = 50)
public abstract class ModelPartMixin implements TavernModelPartAccess {
    @Unique
    private boolean kaleidoscopeTavern$poseProtected;

    @Override
    public boolean kaleidoscopeTavern$isPoseProtected() {
        return this.kaleidoscopeTavern$poseProtected;
    }

    @Override
    public void kaleidoscopeTavern$setPoseProtected(boolean poseProtected) {
        this.kaleidoscopeTavern$poseProtected = poseProtected;
    }

    @Inject(method = "translateAndRotate", at = @At("HEAD"))
    private void kaleidoscopeTavern$preserveFinalLimbPose(PoseStack poseStack, CallbackInfo ci) {
        if (this.kaleidoscopeTavern$poseProtected) {
            PunchyModelPartCompat.clearOptionalTransforms((ModelPart) (Object) this);
        }
    }
}
