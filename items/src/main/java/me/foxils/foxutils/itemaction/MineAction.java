package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public interface MineAction extends ActionInterface {

    default void onMineWithThisItem(final @Nonnull BlockBreakEvent blockBreakEvent,
                                    final @Nonnull ItemStack thisItemStack) {
    }

    default void onMineWithOtherItem(final @Nonnull BlockBreakEvent blockBreakEvent,
                                     final @Nonnull ItemStack thisItemStack,
                                     final @Nullable ItemStack itemStackUsedToMine) {
    }
}
