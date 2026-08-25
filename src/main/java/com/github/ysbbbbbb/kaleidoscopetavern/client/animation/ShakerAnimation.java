package com.github.ysbbbbbb.kaleidoscopetavern.client.animation;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModItems;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.neoforged.neoforge.client.IArmPoseTransformer;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

public final class ShakerAnimation {
    private ShakerAnimation() {
    }

    public static final AnimationDefinition PUT = AnimationDefinition.Builder.withLength(0.375F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.0F, -4.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bone2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2083F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bone2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 1.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            )).build();

    public static final EnumProxy<HumanoidModel.ArmPose> SHAKING = new EnumProxy<>(
            HumanoidModel.ArmPose.class,
            false,
            false,
            (IArmPoseTransformer) ShakerAnimation::applyThirdPersonTransform
    );

    /**
     * 原版 1.20.1 的第三人称手臂角度。26.1 将实体数据提取为渲染状态，
     * 因此从使用中的手、物品快照和 ageInTicks 读取等价信息。
     */
    public static void applyThirdPersonTransform(HumanoidModel<?> model, HumanoidRenderState state, HumanoidArm arm) {
        ModelPart armPart = arm == HumanoidArm.RIGHT ? model.rightArm : model.leftArm;
        applyArmRotation(armPart, arm, state.ageInTicks);
    }

    public static HumanoidModel.ArmPose shakingPose() {
        return SHAKING.getValue();
    }

    public static void applyArmRotation(ModelPart armPart, HumanoidArm arm, float totalTicks) {
        float rot = Mth.sin(totalTicks * 1.5F) * 0.25F;
        armPart.xRot = 1.375F * Mth.PI + (arm == HumanoidArm.RIGHT ? -Mth.PI * rot : Mth.PI * rot);
        armPart.zRot = (arm == HumanoidArm.RIGHT ? -1.0F : 1.0F) * Mth.PI * 0.05F;
    }

    public static boolean isUsingShaker(HumanoidRenderState state, HumanoidArm arm) {
        if (!state.isUsingItem) {
            return false;
        }
        HumanoidArm usedArm = state.useItemHand == InteractionHand.MAIN_HAND
                ? state.mainArm
                : state.mainArm.getOpposite();
        return arm == usedArm && state.getUseItemStackForArm(arm).is(ModItems.SHAKER);
    }

    public static @Nullable HumanoidArm findUsedShakerArm(HumanoidRenderState state) {
        if (!state.isUsingItem) {
            return null;
        }
        HumanoidArm usedArm = state.useItemHand == InteractionHand.MAIN_HAND
                ? state.mainArm
                : state.mainArm.getOpposite();
        return state.getUseItemStackForArm(usedArm).is(ModItems.SHAKER) ? usedArm : null;
    }


    public static boolean applyHandTransform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm, float partialTick) {
        int remainingTicks = player.getUseItemRemainingTicks();
        if (remainingTicks == 0) {
            return false;
        }

        float totalTicks = player.tickCount + partialTick;
        float offset = Mth.sin(totalTicks * 1.5F) * 0.25F;
        double xOffset = arm == HumanoidArm.RIGHT ? 0.56 : -0.56;
        poseStack.translate(xOffset, -0.52 - offset * 0.6, -0.72);
        poseStack.mulPose(Axis.XN.rotationDegrees(-15));
        return true;
    }

    public static final class ShakerExtensions implements IClientItemExtensions {
        @Override
        public HumanoidModel.ArmPose getArmPose(LivingEntity entity, InteractionHand hand, ItemStack stack) {
            // 必须交回 null，让 AvatarRenderer 继续读取 ShakerItem 的 BOW
            // 使用动画。上一版在这里提前返回专用 ArmPose，实际上完全截断了
            // 参考 Cookery 拉面团所补充的原生使用动画通道。
            return null;
        }

        @Override
        public boolean applyForgeHandTransform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm,
                                               ItemStack stack, float partialTick, float equipProcess,
                                               float swingProcess) {
            return applyHandTransform(poseStack, player, arm, partialTick);
        }
    }

    public static void loadOptionalPlayerAnimationCompatibility() {
        try {
            Class.forName(
                    "com.zigythebird.playeranim.animation.AvatarAnimManager",
                    false,
                    ShakerAnimation.class.getClassLoader()
            );
        } catch (ClassNotFoundException ignored) {
            // Player Animation Library is optional.
        }
    }

    public static void trigger() {
    }
}
