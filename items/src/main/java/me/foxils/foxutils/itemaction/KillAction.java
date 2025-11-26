package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public interface KillAction extends ActionInterface {

    default void onKillWithThisItem(final @Nonnull EntityDeathEvent playerDeathEvent,
                                    final @Nonnull ItemStack thisItemStack,
                                    final @Nonnull LivingEntity killedEntity,
                                    final @Nonnull Player killerPlayer) {
    }

    default void onKillWithOtherItem(final @Nonnull EntityDeathEvent playerDeathEvent,
                                     final @Nonnull ItemStack thisItemStack,
                                     final @Nullable ItemStack itemStackUsedToKill,
                                     final @Nonnull LivingEntity killedEntity,
                                     final @Nonnull Player killerPlayer) {
    }
}
