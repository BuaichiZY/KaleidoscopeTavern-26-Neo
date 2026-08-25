package com.github.ysbbbbbb.kaleidoscopetavern.mixin;

import com.github.ysbbbbbb.kaleidoscopetavern.client.animation.ShakerAnimation;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Apply the original 1.20.1 first-person shaker transform at NeoForge's exact
 * extension call site. This survives renderer mixins which replace or cache
 * the registered item extension before the hand is submitted.
 */
@Mixin(value = ItemInHandRenderer.class, priority = 2000)
public abstract class ItemInHandRendererMixin {
    @Redirect(
            method = "renderArmWithItem(Lnet/minecraft/client/player/AbstractClientPlayer;FFLnet/minecraft/world/InteractionHand;FLnet/minecraft/world/item/ItemStack;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;I)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/neoforged/neoforge/client/extensions/common/IClientItemExtensions;applyForgeHandTransform(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/player/LocalPlayer;Lnet/minecraft/world/entity/HumanoidArm;Lnet/minecraft/world/item/ItemStack;FFF)Z"
            )
    )
    private boolean kaleidoscopeTavern$forceShakerHandTransform(
            IClientItemExtensions extensions,
            PoseStack poseStack,
            LocalPlayer player,
            HumanoidArm arm,
            ItemStack stack,
            float partialTick,
            float equipProcess,
            float swingProcess
    ) {
        if (stack.is(ModItems.SHAKER)
                && player.isUsingItem()
                && player.getUseItem().is(ModItems.SHAKER)
                && player.getUseItemRemainingTicks() > 0) {
            return ShakerAnimation.applyHandTransform(poseStack, player, arm, partialTick);
        }
        return extensions.applyForgeHandTransform(
                poseStack, player, arm, stack, partialTick, equipProcess, swingProcess
        );
    }
}
