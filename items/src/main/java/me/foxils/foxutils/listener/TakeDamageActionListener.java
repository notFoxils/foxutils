package me.foxils.foxutils.listener;

import javax.annotation.Nonnull;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import me.foxils.foxutils.itemaction.TakeDamageAction;
import me.foxils.foxutils.registry.ItemTemplateRegistry;

@SuppressWarnings("UnstableApiUsage")
public final class TakeDamageActionListener implements Listener {

    private final ItemTemplateRegistry itemRegistry;

    public TakeDamageActionListener(final @Nonnull ItemTemplateRegistry itemRegistry) {
        this.itemRegistry = itemRegistry;
    }

    @EventHandler
    public void onEntityDamage(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof final Player damagedPlayer))
            return;

        for (final ItemStack itemStack : damagedPlayer.getInventory().getContents()) {
            if (!(itemRegistry.getItemTemplateFromItemStack(itemStack) instanceof final TakeDamageAction damageActionItem))
                continue;

            damageActionItem.onTakeDamage(event, itemStack, damagedPlayer);
        }
    }
}
