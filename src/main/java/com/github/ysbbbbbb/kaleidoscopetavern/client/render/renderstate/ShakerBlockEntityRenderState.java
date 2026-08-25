package com.github.ysbbbbbb.kaleidoscopetavern.client.render.renderstate;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.world.entity.AnimationState;
public class ShakerBlockEntityRenderState extends BlockEntityRenderState {
    public float animationAge;
    public AnimationState put = new AnimationState();
}
