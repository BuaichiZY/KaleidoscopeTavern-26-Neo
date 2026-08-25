package com.github.ysbbbbbb.kaleidoscopetavern.client.render.state;

/**
 * Marks a limb whose vanilla/Tavern pose must survive optional animation
 * libraries all the way to ModelPart rendering.
 */
public interface TavernModelPartAccess {
    boolean kaleidoscopeTavern$isPoseProtected();

    void kaleidoscopeTavern$setPoseProtected(boolean poseProtected);
}
