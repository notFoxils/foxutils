package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;

import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public interface ProjectileLaunchAction extends ActionInterface {

    default void onLaunchProjectileWithThisItem(final @Nonnull ProjectileLaunchEvent projectileLaunchEvent,
                                                final @Nonnull ItemStack thisItemStack,
                                                final @Nonnull Projectile launchedProjectile) {
    }

    default void onLaunchProjectleWithOtherItem(final @Nonnull ProjectileLaunchEvent projectileLaunchEvent,
                                                final @Nonnull ItemStack thisItemStack,
                                                final @Nonnull ItemStack itemStackUsedToLaunch,
                                                final Projectile launchedProjectile) {
    }
}
