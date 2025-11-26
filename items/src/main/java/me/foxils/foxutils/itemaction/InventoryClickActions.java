package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public interface InventoryClickActions extends ActionInterface {

    /**
     *
     * @param inventoryClickEvent The InventoryClickEvent that called this method.
     * @param thisItemStack Item of this class that was clicked on during any InventoryClickEvent.
     */
    default void onInventoryClick(final @Nonnull InventoryClickEvent inventoryClickEvent,
                                  final @Nonnull ItemStack thisItemStack,
                                  final @Nullable ItemStack itemStackInCursor) {
    }

    /**
     *
     * @param inventoryClickEvent The InventoryClickEvent that called this method.
     * @param thisItemStack Item of this class that was in the player's cursor during any InventoryClickEvent
     */
    default void onInventoryInteract(final @Nonnull InventoryClickEvent inventoryClickEvent,
                                     final @Nonnull ItemStack thisItemStack,
                                     final @Nullable ItemStack itemStackClickedOn) {
    }
}
