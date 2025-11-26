package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;

import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public interface DropItemAction extends ActionInterface {

    default void onDropThisItem(final @Nonnull PlayerDropItemEvent playerDropItemEvent,
                                final @Nonnull ItemStack thisItemStack) {
    }

    default void onDropOtherItem(final @Nonnull PlayerDropItemEvent playerDropItemEvent,
                                 final @Nonnull ItemStack thisItemStack,
                                 final @Nonnull ItemStack itemStackDropped) {
    }
}
