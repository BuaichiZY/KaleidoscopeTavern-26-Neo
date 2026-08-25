package com.github.ysbbbbbb.kaleidoscopetavern.client.animation;

import net.minecraft.client.model.geom.ModelPart;
import org.joml.Matrix4f;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Punchy stores an additional matrix on ModelPart and applies it after the
 * normal xRot/yRot/zRot values. Use reflection so Punchy remains optional.
 */
public final class PunchyModelPartCompat {
    private static boolean resolved;
    private static Method setExplicitTransform;
    private static Method clearDirectPoseBase;

    private PunchyModelPartCompat() {
    }

    public static void clearOptionalTransforms(ModelPart part) {
        resolveMethods();
        try {
            if (setExplicitTransform != null) {
                setExplicitTransform.invoke(part, new Object[]{null});
            }
            if (clearDirectPoseBase != null) {
                clearDirectPoseBase.invoke(part);
            }
        } catch (IllegalAccessException | InvocationTargetException ignored) {
            // Optional compatibility must never make ModelPart rendering fail.
        }
    }

    private static synchronized void resolveMethods() {
        if (resolved) {
            return;
        }
        resolved = true;
        try {
            setExplicitTransform = ModelPart.class.getMethod("punchy$setExplicitTransform", Matrix4f.class);
            clearDirectPoseBase = ModelPart.class.getMethod("punchy$clearDirectPoseBase");
        } catch (NoSuchMethodException ignored) {
            setExplicitTransform = null;
            clearDirectPoseBase = null;
        }
    }
}
