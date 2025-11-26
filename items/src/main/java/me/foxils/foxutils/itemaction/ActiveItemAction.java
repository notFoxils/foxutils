package me.foxils.foxutils.itemaction;

import javax.annotation.Nonnull;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface ActiveItemAction extends ActionInterface {

    public void onActiveAction(final @Nonnull Player player, final @Nonnull ItemStack itemStack);
}
