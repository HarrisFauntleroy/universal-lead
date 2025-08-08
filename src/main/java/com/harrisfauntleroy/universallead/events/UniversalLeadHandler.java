package com.harrisfauntleroy.universallead.events;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Leashable;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = "universallead")
public class UniversalLeadHandler {

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        Entity target = event.getTarget();

        // Only handle lead interactions with hostile mobs
        if (!player.getItemInHand(event.getHand()).is(Items.LEAD)) {
            return;
        }

        // Check if it's a hostile mob
        if (!(target instanceof Enemy) || !(target instanceof Leashable)) {
            return;
        }

        // Server-side only
        if (event.getLevel().isClientSide()) {
            return;
        }

        // Let vanilla handle it now that canBeLeashed returns true
        // The mixin makes hostile mobs leashable, so vanilla code will work
    }
}
