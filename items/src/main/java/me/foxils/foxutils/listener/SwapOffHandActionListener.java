package me.foxils.foxutils.listener;

import javax.annotation.Nonnull;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

import me.foxils.foxutils.itemaction.SwapItemHandAction;
import me.foxils.foxutils.registry.ItemTemplateRegistry;

public final class SwapOffHandActionListener implements Listener {

    private final ItemTemplateRegistry itemRegistry;

    public SwapOffHandActionListener(final @Nonnull ItemTemplateRegistry itemRegistry) {
        this.itemRegistry = itemRegistry;
    }

    @EventHandler
    public void onPlayerSwapHands(final PlayerSwapHandItemsEvent playerSwapHandItemsEvent) {
        final ItemStack itemStackSwappedToMainHand = playerSwapHandItemsEvent.getMainHandItem();
        final ItemStack itemStackSwappedToOffHand = playerSwapHandItemsEvent.getOffHandItem();
        for (final ItemStack itemStack : playerSwapHandItemsEvent.getPlayer().getInventory().getContents()) {
            if (!(itemRegistry.getItemTemplateFromItemStack(itemStack) instanceof final SwapItemHandAction swapItemHandsActionItem))
                continue;

            if (itemStackSwappedToMainHand != null && itemStackSwappedToOffHand.equals(itemStack)) {
                swapItemHandsActionItem.onSwapThisItemToOffHand(playerSwapHandItemsEvent, itemStack, itemStackSwappedToMainHand);
                swapItemHandsActionItem.onSwapOtherItemToMainHand(playerSwapHandItemsEvent, itemStack, itemStackSwappedToMainHand, itemStackSwappedToOffHand);
            } else if (itemStackSwappedToOffHand != null && itemStackSwappedToMainHand.equals(itemStack)) {
                swapItemHandsActionItem.onSwapThisItemToMainHand(playerSwapHandItemsEvent, itemStack, itemStackSwappedToOffHand);
                swapItemHandsActionItem.onSwapOtherItemToOffHand(playerSwapHandItemsEvent, itemStack, itemStackSwappedToOffHand, itemStackSwappedToMainHand);
            } else {
                swapItemHandsActionItem.onSwapOtherItemToOffHand(playerSwapHandItemsEvent, itemStack, itemStackSwappedToOffHand, itemStackSwappedToMainHand);
                swapItemHandsActionItem.onSwapOtherItemToMainHand(playerSwapHandItemsEvent, itemStack, itemStackSwappedToMainHand, itemStackSwappedToOffHand);
            }
        }
    }
}
