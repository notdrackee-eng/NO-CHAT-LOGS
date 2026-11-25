package dev.nochatlogs.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Cancels Cartcore's own sendLog method before it can send a chat message.
 * This is a source-level block, not a visual chat filter.
 */
@Pseudo
@Mixin(targets = "thetruetrident.cartcore.CartcoreCore", remap = false)
public abstract class CartcoreCoreMixin {
    @Inject(method = "sendLog", at = @At("HEAD"), cancellable = true, remap = false)
    private static void nochatlogs$cancelCartcoreLogs(CallbackInfo ci) {
        ci.cancel();
    }
}
