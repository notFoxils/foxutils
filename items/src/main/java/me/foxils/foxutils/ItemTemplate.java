package me.foxils.foxutils;

import java.util.UUID;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.foxils.foxutils.FoxutilsItems.PDCLocationKey;
import me.foxils.foxutils.utility.ItemUtils;

public abstract class ItemTemplate {

    private final NamespacedKey itemKey;

    private final Material itemMaterial;

    public ItemTemplate(
        final @Nonnull NamespacedKey itemKey,
        final @Nonnull Material itemMaterial
    ) {
        this.itemKey = itemKey;

        this.itemMaterial = itemMaterial;
    }

    public final @Nonnull ItemStack createItemStack(final int amount) {
        final ItemStack newItem = new ItemStack(itemMaterial, amount);
        final ItemMeta itemMeta = specializeItemMeta(newItem.getItemMeta());

        // Stores the ItemTemplate's itemKey inside the ItemStack's ItemMeta.
        // This key is used to identify the ItemStack as being from the ItemTemplate.
        ItemUtils.storeStringData(
            itemKey.toString(),
            PDCLocationKey.ITEMSTACK_ITEMKEY_STORAGE,
            itemMeta
        );
        ItemUtils.storeStringData(
            UUID.randomUUID().toString(),
            PDCLocationKey.ITEMSTACK_UID_STORAGE,
            itemMeta
        );

        newItem.setItemMeta(itemMeta);
        return newItem;
    }

    public final @Nonnull NamespacedKey getItemKey() {
        return this.itemKey;
    }

    public final @Nonnull Material getItemMaterial() {
        return this.itemMaterial;
    }

    protected @Nonnull ItemMeta specializeItemMeta(final @Nonnull ItemMeta itemMeta) {
        return itemMeta;
    }
}
