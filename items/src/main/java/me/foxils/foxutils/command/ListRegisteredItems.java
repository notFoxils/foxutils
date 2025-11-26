package me.foxils.foxutils.command;

import java.util.Collection;

import javax.annotation.Nonnull;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.foxils.foxutils.Item;
import me.foxils.foxutils.registry.ItemRegistry;

public class ListRegisteredItems implements CommandExecutor {

    private final ItemRegistry itemRegistry;

    public ListRegisteredItems(final @Nonnull ItemRegistry itemRegistry) {
        this.itemRegistry = itemRegistry;
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender,
                             @Nonnull Command command,
                             @Nonnull String commandName,
                             @Nonnull String[] args) {
        final Collection<Item> registeredItems = itemRegistry.getRegisteredItems();

        if (registeredItems.isEmpty()) {
            commandSender.sendMessage("There are no currently registered items");
            return true;
        }

        for (final Item item : registeredItems) {
            commandSender.sendMessage(ChatColor.RED + "Name: " + ChatColor.RESET + item.getName() + ChatColor.BLUE + " Item-Key: " + ChatColor.RESET + item.getKey());
        }

        return true;
    }
}
