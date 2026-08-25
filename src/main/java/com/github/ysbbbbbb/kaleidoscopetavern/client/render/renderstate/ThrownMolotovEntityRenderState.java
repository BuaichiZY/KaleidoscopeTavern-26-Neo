package com.github.ysbbbbbb.kaleidoscopetavern.client.render.renderstate;

import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
public class ThrownMolotovEntityRenderState extends EntityRenderState {
    public float partialTicks;
    public float tickCount;
    public BlockModelRenderState bottleModel = new BlockModelRenderState();
}
