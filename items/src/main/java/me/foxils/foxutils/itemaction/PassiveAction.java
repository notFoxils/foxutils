package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface PassiveAction extends ActionInterface {

    public void onPassiveAction(final @Nonnull Player player,
                                final @Nonnull ItemStack thisItemStack);
}
