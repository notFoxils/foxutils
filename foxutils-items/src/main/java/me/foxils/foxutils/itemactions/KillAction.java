package me.foxils.foxutils.itemactions;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public interface KillAction {

    void killAction(PlayerDeathEvent playerDeathEvent, ItemStack itemUsedToKill);
}