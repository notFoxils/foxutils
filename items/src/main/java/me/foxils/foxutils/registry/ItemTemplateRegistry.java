package me.foxils.foxutils.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.foxils.foxutils.FoxutilsItems;
import me.foxils.foxutils.ItemTemplate;
import me.foxils.foxutils.utility.ItemUtils;

public final class ItemTemplateRegistry {

    private final FoxutilsItems plugin;

    private final Map<NamespacedKey, ItemTemplate> keyToItemTemplate = new HashMap<>();

    public ItemTemplateRegistry(final FoxutilsItems plugin) {
        this.plugin = plugin;
    }

    public void registerItemTemplate(final @Nonnull ItemTemplate itemTemplate) {
        final NamespacedKey itemKey = itemTemplate.getItemKey();

        keyToItemTemplate.put(itemKey, itemTemplate);

        plugin.getLogger().info("Registered: " + itemKey.getKey());
    }

    public void unregisterItemTemplate(final @Nonnull NamespacedKey itemKey) {
        keyToItemTemplate.remove(itemKey);

        plugin.getLogger().info("Unregistered: " + itemKey.getKey());
    }

    public void unregisterItemTemplate(final @Nonnull ItemTemplate itemTemplate) {
        unregisterItemTemplate(itemTemplate.getItemKey());
    }

    public void unregisterPluginItemTemplates(final @Nonnull Plugin plugin) {
        final String pluginNamespace = plugin.getName().toLowerCase(Locale.ROOT);

        for (final NamespacedKey itemKey : keyToItemTemplate.keySet()) {
            if (!itemKey.getNamespace().equals(pluginNamespace)) {
                continue;
            }

            unregisterItemTemplate(itemKey);
        }
    }

    public @Nullable ItemTemplate getItemTemplateFromKey(final @Nonnull NamespacedKey itemKey) {
        return keyToItemTemplate.get(itemKey);
    }

    public @Nullable ItemTemplate getItemTemplateFromItemMeta(final @Nonnull ItemMeta itemMeta) {
        final NamespacedKey itemKey = ItemUtils.getFoxItemKey(itemMeta);
        if (itemKey == null) {
            return null;
        }

        return getItemTemplateFromKey(itemKey);
    }

    public @Nullable ItemTemplate getItemTemplateFromItemStack(final @Nonnull ItemStack itemStack) {
        return getItemTemplateFromItemMeta(itemStack.getItemMeta());
    }

    public @Nonnull List<ItemTemplate> getRegisteredItems() {
        return new ArrayList<>(keyToItemTemplate.values());
    }
}
