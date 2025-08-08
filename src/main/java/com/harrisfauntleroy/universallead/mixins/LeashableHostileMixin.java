package com.harrisfauntleroy.universallead.mixins;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Enemy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public class LeashableHostileMixin {

    @Inject(method = "canBeLeashed", at = @At("HEAD"), cancellable = true)
    private void allowHostileLeashing(CallbackInfoReturnable<Boolean> cir) {
        // Check if this mob is a hostile mob (implements Enemy interface)
        if ((Object) this instanceof Enemy) {
            // Force return true for hostile mobs
            cir.setReturnValue(true);
        }
    }
}
