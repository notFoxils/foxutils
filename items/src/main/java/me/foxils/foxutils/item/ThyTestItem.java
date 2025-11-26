package me.foxils.foxutils.item;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.foxils.foxutils.Item;
import me.foxils.foxutils.itemaction.AttackAction;
import me.foxils.foxutils.itemaction.ClickActions;
import me.foxils.foxutils.itemaction.CraftItemAction;
import me.foxils.foxutils.itemaction.ProjectileHitAction;
import me.foxils.foxutils.itemaction.ProjectileLaunchAction;
import me.foxils.foxutils.utility.ItemAbility;

public class ThyTestItem extends Item implements AttackAction, ClickActions, CraftItemAction, ProjectileHitAction, ProjectileLaunchAction {

    public ThyTestItem(final @Nonnull NamespacedKey key,
                       final @Nonnull Plugin plugin,
                       final @Nonnull Material itemMaterial,
                       final @Nonnull String name,
                       final @Nullable Integer customModelData,
                       final @Nullable List<ItemAbility> abilityList,
                       final @Nullable List<ItemStack> itemsForRecipe,
                       final boolean areRecipeItemsExact,
                       final boolean isRecipeShaped) {
        super(key, plugin, itemMaterial, name, customModelData, abilityList, itemsForRecipe, areRecipeItemsExact, isRecipeShaped);
    }

    // AttackAction
    @Override
    public void onAttackWithThisItem(final @Nonnull EntityDamageByEntityEvent entityDamageByEntityEvent,
                                     final @Nonnull ItemStack thisItemStack,
                                     final @Nonnull LivingEntity attackedEntity,
                                     final @Nonnull Player attackingPlayer) {
        attackingPlayer.sendMessage("You have attacked with the " + thisItemStack.getItemMeta().getDisplayName());
    }

    @Override
    public void onAttackWithOtherItem(final @Nonnull EntityDamageByEntityEvent entityDamageByEntityEvent,
                                      final @Nonnull ItemStack thisItemStack,
                                      final @Nullable ItemStack itemStackUsedToAttack,
                                      final @Nonnull LivingEntity attackedEntity,
                                      final @Nonnull Player attackingPlayer) {
        final String itemStackName;
        if (itemStackUsedToAttack == null) {
            itemStackName = "Fist";
        } else {
            itemStackName = itemStackUsedToAttack.getType().name();
        }

        attackingPlayer.sendMessage("The " + thisItemStack.getItemMeta().getDisplayName() + " has detected an attack from a " + itemStackName);
    }
    // AttackAction End

    // ClickActions
    @Override
    public void onLeftClickAir(final @Nonnull PlayerInteractEvent playerInteractEvent,
                               final @Nonnull ItemStack thisItemStack) {
        playerInteractEvent.getPlayer().sendMessage("You left clicked air using the " + thisItemStack.getItemMeta().getDisplayName());
    }

    @Override
    public void onLeftClickBlock(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                 final @Nonnull ItemStack thisItemStack) {
        playerInteractEvent.getPlayer().sendMessage("You left clicked a block using the " + thisItemStack.getItemMeta().getDisplayName());
    }

    @Override
    public void onShiftLeftClickAir(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                    final @Nonnull ItemStack thisItemStack) {
        playerInteractEvent.getPlayer().sendMessage("You shift left clicked air using the " + thisItemStack.getItemMeta().getDisplayName());
    }

    @Override
    public void onShiftLeftClickBlock(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                      final @Nonnull ItemStack thisItemStack) {
        playerInteractEvent.getPlayer().sendMessage("You shift left clicked a block using the " + thisItemStack.getItemMeta().getDisplayName());
    }

    @Override
    public void onRightClickAir(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                final @Nonnull ItemStack thisItemStack) {
        playerInteractEvent.getPlayer().sendMessage("You right clicked air using the " + thisItemStack.getItemMeta().getDisplayName());
    }

    @Override
    public void onRightClickBlock(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                  final @Nonnull ItemStack thisItemStack) {
        playerInteractEvent.getPlayer().sendMessage("You right clicked a block using the " + thisItemStack.getItemMeta().getDisplayName());
    }

    @Override
    public void onShiftRightClickAir(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                     final @Nonnull ItemStack thisItemStack) {
        playerInteractEvent.getPlayer().sendMessage("You shift right clicked air using the " + thisItemStack.getItemMeta().getDisplayName());
    }

    @Override
    public void onShiftRightClickBlock(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                       final @Nonnull ItemStack thisItemStack) {
        playerInteractEvent.getPlayer().sendMessage("You shift right clicked a block using the " + thisItemStack.getItemMeta().getDisplayName());
    }
    // ClickActions End

    // CraftItemAction
    @Override
    public void onCraftThisItem(final @Nonnull CraftItemEvent craftItemEvent,
                                final @Nonnull ItemStack thisItemStack,
                                final @Nonnull Player crafterPlayer) {
        crafterPlayer.sendMessage("You've crafted " + getName());
    }

    @Override
    public void onCraftOtherItem(final @Nonnull CraftItemEvent craftItemEvent,
                                 final @Nonnull ItemStack thisItemStack,
                                 final @Nonnull ItemStack craftedItemStack,
                                 final @Nonnull Player crafterPlayer) {
        crafterPlayer.sendMessage("You've crafted " + craftedItemStack.getType().name() + " and " + getName() + " has detected it");
    }
    // CraftItemAction End


    @Override
    public void onProjectileFromThisItemHit(final @Nonnull ProjectileHitEvent projectileHitEvent,
                                            final @Nonnull ItemStack thisItemStack,
                                            final @Nonnull Projectile hittingProjectile,
                                            final @Nonnull Player shooterPlayer) {
        shooterPlayer.sendMessage("You have hit with a projectile using " + thisItemStack.getItemMeta().getDisplayName());
    }

    @Override
    public void onProjectileFromOtherItemHit(final @Nonnull ProjectileHitEvent projectileHitEvent,
                                             final @Nonnull ItemStack thisItemStack,
                                             final @Nonnull ItemStack itemStackUsedToLaunch,
                                             final @Nonnull Projectile hittingProjectile,
                                             final @Nonnull Player shooterPlayer) {
        shooterPlayer.sendMessage("You have shot a projectile using " + itemStackUsedToLaunch + " and " + thisItemStack.getItemMeta().getDisplayName() + " has detected it hit");
    }
}
