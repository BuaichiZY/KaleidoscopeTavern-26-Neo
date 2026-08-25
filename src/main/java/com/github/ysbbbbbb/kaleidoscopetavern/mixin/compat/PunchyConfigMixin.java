package com.github.ysbbbbbb.kaleidoscopetavern.mixin.compat;

import com.github.ysbbbbbb.kaleidoscopetavern.init.ModItems;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Punchy replaces the vanilla first-person renderer and cancels
 * ItemInHandRenderer#renderArmWithItem for every item it manages. That also
 * bypasses the NeoForge hand-transform hook used by the original shaker
 * animation. Punchy's own item blacklist is its intended compatibility escape
 * hatch: blacklisted items keep vanilla use properties and vanilla first- and
 * third-person animation handling.
 *
 * <p>Report the shaker as blacklisted without modifying the user's Punchy
 * configuration. The pseudo mixin is ignored when Punchy is not installed.</p>
 */
@Pseudo
@Mixin(targets = "punchy.config.PunchyConfig", remap = false)
public abstract class PunchyConfigMixin {
    @Inject(
            method = "isItemBlacklisted(Lnet/minecraft/world/item/ItemStack;)Z",
            at = @At("HEAD"),
            cancellable = true,
            require = 0,
            remap = false
    )
    private static void kaleidoscopeTavern$letPunchyIgnoreShaker(
            ItemStack stack,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (stack != null && stack.is(ModItems.SHAKER)) {
            cir.setReturnValue(true);
        }
    }
}
