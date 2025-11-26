package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public interface SwapItemHandAction extends ActionInterface {

    default void onSwapThisItemToOffHand(final @Nonnull PlayerSwapHandItemsEvent playerSwapHandItemsEvent,
                                         final @Nonnull ItemStack thisItemStack,
                                         final @Nullable ItemStack itemStackSwappedToMainHand) {
    }

    default void onSwapThisItemToMainHand(final @Nonnull PlayerSwapHandItemsEvent playerSwapHandItemsEvent,
                                          final @Nonnull ItemStack thisItemStack,
                                          final @Nullable ItemStack itemStackSwappedToOffHand) {
    }

    default void onSwapOtherItemToMainHand(final @Nonnull PlayerSwapHandItemsEvent playerSwapHandItemsEvent,
                                           final @Nonnull ItemStack thisItemStack,
                                           final @Nonnull ItemStack itemStackSwappedToMainHand,
                                           final @Nullable ItemStack itemStackSwappedToOffHand) {
    }

    default void onSwapOtherItemToOffHand(final @Nonnull PlayerSwapHandItemsEvent playerSwapHandItemsEvent,
                                          final @Nonnull ItemStack thisItemSTack,
                                          final @Nonnull ItemStack itemStackSwappedToOffHand,
                                          final @Nullable ItemStack itemStackSwappedToMainHand) {
    }
}
