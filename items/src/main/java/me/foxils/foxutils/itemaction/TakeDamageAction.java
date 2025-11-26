package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public interface TakeDamageAction extends ActionInterface {

    public void onTakeDamage(final @Nonnull EntityDamageEvent entityDamageEvent,
                             final @Nonnull ItemStack thisItemStack,
                             final @Nonnull Player damagedPlayer);
}
