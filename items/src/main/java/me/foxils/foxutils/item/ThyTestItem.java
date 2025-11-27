package me.foxils.foxutils.item;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;

import me.foxils.foxutils.FoxutilsItems;
import me.foxils.foxutils.ItemTemplate;

public final class ThyTestItem extends ItemTemplate {

    private static final String KEY = "dsa";

    private static final Material ITEM_MATERIAL = Material.TRIDENT;

    public ThyTestItem(final @Nonnull FoxutilsItems plugin) {
        super(new NamespacedKey(plugin, KEY), ITEM_MATERIAL);
    }

    @Override
    protected ItemMeta specializeItemMeta(final @Nonnull ItemMeta itemMeta) {
        itemMeta.setItemName("The Inator");

        return itemMeta;
    }
}
