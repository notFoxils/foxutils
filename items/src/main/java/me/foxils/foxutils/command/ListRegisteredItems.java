package me.foxils.foxutils.command;

import java.util.Collection;

import javax.annotation.Nonnull;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.foxils.foxutils.ItemTemplate;
import me.foxils.foxutils.registry.ItemTemplateRegistry;

public class ListRegisteredItems implements CommandExecutor {

    private final ItemTemplateRegistry itemRegistry;

    public ListRegisteredItems(final @Nonnull ItemTemplateRegistry itemRegistry) {
        this.itemRegistry = itemRegistry;
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender,
                             @Nonnull Command command,
                             @Nonnull String commandName,
                             @Nonnull String[] args) {
        final Collection<ItemTemplate> registeredItems = itemRegistry.getRegisteredItems();

        if (registeredItems.isEmpty()) {
            commandSender.sendMessage("There are no currently registered items");
            return true;
        }

        for (final ItemTemplate item : registeredItems) {
            //commandSender.sendMessage(ChatColor.RED + "Name: " + ChatColor.RESET + item.getName() + ChatColor.BLUE + " Item-Key: " + ChatColor.RESET + item.getItemKey());
        }

        return true;
    }
}
