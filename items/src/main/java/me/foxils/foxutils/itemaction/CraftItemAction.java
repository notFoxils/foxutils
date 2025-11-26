package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public interface CraftItemAction extends ActionInterface {

    default void onCraftThisItem(final @Nonnull CraftItemEvent craftItemEvent,
                                 final @Nonnull ItemStack thisItemStack,
                                 final @Nonnull Player crafterPlayer) {
    }

    default void onCraftOtherItem(final @Nonnull CraftItemEvent craftItemEvent,
                                  final @Nonnull ItemStack thisItemStack,
                                  final @Nonnull ItemStack craftedItemStack,
                                  final @Nonnull Player crafterPlayer) {
    }
}
