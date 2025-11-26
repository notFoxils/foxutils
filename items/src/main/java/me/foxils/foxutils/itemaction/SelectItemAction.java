package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public interface SelectItemAction extends ActionInterface {

    default void onSelectThisItem(final @Nonnull PlayerItemHeldEvent playerItemHeldEvent,
                                  final @Nonnull ItemStack thisItemStack,
                                  final @Nullable ItemStack itemStackUnselected) {
    }

    default void onUnselectThisItem(final @Nonnull PlayerItemHeldEvent playerItemHeldEvent,
                                    final @Nonnull ItemStack thisItemStack,
                                    final @Nullable ItemStack itemStackSelected) {
    }

    default void onSelectOtherItem(final @Nonnull PlayerItemHeldEvent playerItemHeldEvent,
                                   final @Nonnull ItemStack thisItemStack,
                                   final @Nullable ItemStack itemStackSelected,
                                   final @Nullable ItemStack itemStackUnselected) {
    }

    default void onUnselectOtherItem(final @Nonnull PlayerItemHeldEvent playerItemHeldEvent,
                                     final @Nonnull ItemStack thisItemStack,
                                     final @Nullable ItemStack itemStackUnselected,
                                     final @Nullable ItemStack itemStackSelected) {
    }
}
