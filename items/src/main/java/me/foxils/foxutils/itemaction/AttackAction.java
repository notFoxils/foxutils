package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public interface AttackAction extends ActionInterface {

    default void onAttackWithThisItem(final @Nonnull EntityDamageByEntityEvent entityDamageByEntityEvent,
                                      final @Nonnull ItemStack thisItemStack,
                                      final @Nonnull LivingEntity attackedEntity,
                                      final @Nonnull Player attackingPlayer) {
    }

    default void onAttackWithOtherItem(final @Nonnull EntityDamageByEntityEvent entityDamageByEntityEvent,
                                       final @Nonnull ItemStack thisItemStack,
                                       final @Nullable ItemStack itemStackUsedToAttack,
                                       final @Nonnull LivingEntity attackedEntity,
                                       final @Nonnull Player attackingPlayer) {
    }
}
