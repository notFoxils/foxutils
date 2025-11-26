package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public interface ClickActions extends ActionInterface {

    default void onLeftClickAir(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                final @Nonnull ItemStack thisItemStack) {
    }

    default void onShiftLeftClickAir(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                     final @Nonnull ItemStack thisItemStack) {
    }

    default void onLeftClickBlock(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                  final @Nonnull ItemStack thisItemStack) {
    }

    default void onShiftLeftClickBlock(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                       final @Nonnull ItemStack thisItemStack) {
    }

    default void onRightClickAir(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                 final @Nonnull ItemStack thisItemStack) {
    }

    default void onShiftRightClickAir(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                      final @Nonnull ItemStack thisItemStack) {
    }

    default void onRightClickBlock(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                   final @Nonnull ItemStack thisItemStack) {
    }

    default void onShiftRightClickBlock(final @Nonnull PlayerInteractEvent playerInteractEvent,
                                        final @Nonnull ItemStack thisItemStack) {
    }
}
