package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;

import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

import me.foxils.foxutils.ItemTemplate;
import me.foxils.foxutils.utility.ItemUtils;

/**
 * This interface defines an {@link ItemTemplate} implementation that can detect when an associated
 * projectile hits an entity, block, etc.
 *
 * <p>
 * <strong>Detection happens by default with bows and tridents <em>exclusively</em>.</strong>
 * </p>
 *
 * <p>
 * Any summoned projectiles you want to detect will need to be tagged using:
 * </p>
 * <ol>
 *     <li>{@link ItemUtils#setRelatedItemUid(Projectile, org.bukkit.inventory.meta.ItemMeta)}</li>
 *     <li>{@link ItemUtils#setRelatedItemUid(Projectile, ItemStack)} (convenience method of #1)</li>
 *     <li>{@link AbstractArrow#setWeapon(ItemStack)} (where applicable, e.g. bows or tridents)</li>
 * </ol>
 *
 * <p>
 * Tagging with {@link ItemUtils#setRelatedItemUid} takes priority in detection.
 * </p>
 */
public interface ProjectileHitAction extends ActionInterface {

    /**
     *
     * @param projectileHitEvent {@link ProjectileHitEvent} that was used to call this method.
     * @param thisItemStack      {@link ItemStack} of the implementing {@link ItemTemplate} used to fire this method.
     * @param hittingProjectile  {@link Projectile} used to fire the {@code projectileHitEvent}.
     * @param launchingPlayer    {@link Player} who had launched the {@code hittingProjectile}.
     */
    default void onProjectileFromThisItemHit(final @Nonnull ProjectileHitEvent projectileHitEvent,
                                             final @Nonnull ItemStack thisItemStack,
                                             final @Nonnull Projectile hittingProjectile,
                                             final @Nonnull Player launchingPlayer) {
    }

    /**
     *
     * @param projectileHitEvent    {@link ProjectileHitEvent} that was used to call this method.
     * @param thisItemStack         {@link ItemStack} of the implementing {@link ItemTemplate} used to fire this method.
     * @param itemStackUsedToLaunch {@link ItemStack} that was used to launch the {@code hittingProjectile}.
     * @param hittingProjectile     {@link Projectile} used to fire the {@code projectileHitEvent}.
     * @param launchingPlayer       {@link Player} who had launched the {@code hittingProjectile}.
     */
    default void onProjectileFromOtherItemHit(final @Nonnull ProjectileHitEvent projectileHitEvent,
                                              final @Nonnull ItemStack thisItemStack,
                                              final @Nonnull ItemStack itemStackUsedToLaunch,
                                              final @Nonnull Projectile hittingProjectile,
                                              final @Nonnull Player launchingPlayer) {
    }
}
