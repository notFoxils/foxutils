package me.foxils.foxutils.utility;

import java.util.Objects;
import java.util.UUID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import me.foxils.foxutils.FoxutilsItems.PDCLocationKey;

public final class ItemUtils {

    public static <Primitive, Complex> boolean storeDataOfType(final @Nonnull PersistentDataType<Primitive, Complex> type,
                                                               final @Nonnull Complex data,
                                                               final @Nonnull NamespacedKey key,
                                                               final @Nonnull ItemMeta itemMeta) {
        itemMeta.getPersistentDataContainer().set(key, type, data);
        return true;
    }

    public static boolean storeBooleanData(final boolean booleanData,
                                           final @Nonnull NamespacedKey key,
                                           final @Nonnull ItemMeta itemMeta) {
        return storeDataOfType(PersistentDataType.BOOLEAN, booleanData, key, itemMeta);
    }

    public static boolean storeIntegerData(final int integerData,
                                           final @Nonnull NamespacedKey key,
                                           final @Nonnull ItemMeta itemMeta) {
        return storeDataOfType(PersistentDataType.INTEGER, integerData, key, itemMeta);
    }

    public static boolean storeStringData(final @Nonnull String stringData,
                                          final @Nonnull NamespacedKey key,
                                          final @Nonnull ItemMeta itemMeta) {
        return storeDataOfType(PersistentDataType.STRING, stringData, key, itemMeta);
    }

    public static <Primitive, Complex> boolean storeDataOfType(final @Nonnull PersistentDataType<Primitive, Complex> type,
                                                               final @Nonnull Complex data,
                                                               final @Nonnull NamespacedKey key,
                                                               final @Nonnull ItemStack itemStack) {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return false;
        }

        if (!storeDataOfType(type, data, key, itemMeta)) {
            return false;
        }

        return itemStack.setItemMeta(itemMeta);
    }

    public static boolean storeBooleanData(final @Nonnull Boolean booleanData,
                                           final @Nonnull NamespacedKey key,
                                           final @Nonnull ItemStack itemStack) {
        return storeDataOfType(PersistentDataType.BOOLEAN, booleanData, key, itemStack);
    }

    public static boolean storeIntegerData(final @Nonnull Integer integerData,
                                           final @Nonnull NamespacedKey key,
                                           final @Nonnull ItemStack itemStack) {
        return storeDataOfType(PersistentDataType.INTEGER, integerData, key, itemStack);
    }

    public static boolean storeStringData(final @Nonnull String stringData,
                                          final @Nonnull NamespacedKey key,
                                          final @Nonnull ItemStack itemStack) {
        return storeDataOfType(PersistentDataType.STRING, stringData, key, itemStack);
    }

    public static @Nullable <Complex> Complex getDataOfType(final @Nonnull PersistentDataType<?, Complex> type,
                                                            final @Nonnull NamespacedKey key,
                                                            final @Nonnull ItemMeta itemMeta) {
        return itemMeta.getPersistentDataContainer().get(key, type);
    }

    public static @Nullable Boolean getBooleanData(final @Nonnull NamespacedKey key, final @Nonnull ItemMeta itemMeta) {
        return getDataOfType(PersistentDataType.BOOLEAN, key, itemMeta);
    }

    public static @Nullable Integer getIntegerData(final @Nonnull NamespacedKey key, final @Nonnull ItemMeta itemMeta) {
        return getDataOfType(PersistentDataType.INTEGER, key, itemMeta);
    }

    public static @Nullable String getStringData(final @Nonnull NamespacedKey key, final @Nonnull ItemMeta itemMeta) {
        return getDataOfType(PersistentDataType.STRING, key, itemMeta);
    }

    public static @Nullable <Complex> Complex getDataOfType(final @Nonnull PersistentDataType<?, Complex> type,
                                                            final @Nonnull NamespacedKey key,
                                                            final @Nonnull ItemStack itemStack) {
        if (!itemStack.hasItemMeta()) {
            return null;
        }

        return itemStack.getItemMeta().getPersistentDataContainer().get(key, type);
    }

    public static @Nullable Boolean getBooleanData(final @Nonnull NamespacedKey key, final @Nonnull ItemStack itemStack) {
        return getDataOfType(PersistentDataType.BOOLEAN, key, itemStack);
    }

    public static @Nullable Integer getIntegerData(final @Nonnull NamespacedKey key, final @Nonnull ItemStack itemStack) {
        return getDataOfType(PersistentDataType.INTEGER, key, itemStack);
    }

    public static @Nullable String getStringData(final @Nonnull NamespacedKey key, final @Nonnull ItemStack itemStack) {
        return getDataOfType(PersistentDataType.STRING, key, itemStack);
    }

    public static @Nullable NamespacedKey getFoxItemKey(final @Nonnull ItemMeta itemMeta) {
        final String itemKeyString = itemMeta.getPersistentDataContainer().get(PDCLocationKey.ITEMSTACK_ITEMKEY_STORAGE, PersistentDataType.STRING);

        return (itemKeyString == null) ? null : NamespacedKey.fromString(itemKeyString);
    }

    public static @Nullable NamespacedKey getFoxItemKey(final @Nonnull ItemStack itemStack) {
        return (itemStack.hasItemMeta()) ? getFoxItemKey(itemStack.getItemMeta()) : null;
    }

    public static @Nullable UUID getUid(final @Nonnull ItemMeta itemMeta) {
        final String itemUid = getStringData(PDCLocationKey.ITEMSTACK_UID_STORAGE, itemMeta);

        return (itemUid == null) ? null : UUID.fromString(itemUid);
    }

    public static @Nullable UUID getUid(final @Nonnull ItemStack itemStack) {
        return (itemStack.hasItemMeta()) ? getUid(itemStack.getItemMeta()) : null;
    }

    public static boolean setRelatedItemUid(final @Nonnull Projectile projectile,
                                                      final @Nonnull ItemMeta itemMeta) {
        final UUID itemUid = getUid(itemMeta);
        if (itemUid == null)
            return false;

        storeStringData(itemUid.toString(), PDCLocationKey.DATAHOLDER_RELATED_ITEMSTACK_UID_STORAGE, itemMeta);
        return true;
    }

    public static boolean setRelatedItemUid(final @Nonnull Projectile projectile,
                                                      final @Nonnull ItemStack itemStack) {
        return (itemStack.hasItemMeta()) ? setRelatedItemUid(projectile, itemStack.getItemMeta()) : false;
    }

    public static @Nullable UUID getRelatedItemUid(final @Nonnull Projectile projectile) {
        final String uidInStorage = projectile.getPersistentDataContainer().get(PDCLocationKey.DATAHOLDER_RELATED_ITEMSTACK_UID_STORAGE, PersistentDataType.STRING);

        return (uidInStorage == null) ? null : UUID.fromString(uidInStorage);
    }

    /**
     * @param key               Location to where the cooldown should be and/or is stored.
     * @param itemStack         ItemStack to apply a cooldown to.
     * @param cooldownInSeconds The cooldown in seconds.
     *
     * @return True if there is a cooldown or False if there is not.
     */
    public static boolean getCooldown(final @Nonnull NamespacedKey key,
                                      final @Nonnull ItemStack itemStack,
                                      final double cooldownInSeconds) {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return false;
        }

        if (getCooldown(key, itemMeta, cooldownInSeconds)) {
            return true;
        }

        itemStack.setItemMeta(itemMeta);
        return false;
    }

    /**
     * @param key               Location to where the cooldown should be and/or is stored.
     * @param itemMeta          ItemMeta of an ItemStack to apply a cooldown to.
     * @param cooldownInSeconds The cooldown in seconds.
     *
     * @return True if there is a cooldown or False if there is not.
     */
    public static boolean getCooldown(final @Nonnull NamespacedKey key,
                                      final @Nonnull ItemMeta itemMeta,
                                      final double cooldownInSeconds) {
        final long timestampOfNowInNanoseconds = System.nanoTime();

        // (timestampOfNowInNanoseconds - timestampOfLastCooldownInNanoseconds) > (cooldownInSeconds * 1_000_000_000)
        // timeSinceLastCooldownInNanoseconds > cooldownInNanoseconds
        if ((timestampOfNowInNanoseconds - Objects.requireNonNullElse(getDataOfType(PersistentDataType.LONG, key, itemMeta), 0L)) > cooldownInSeconds * 1_000_000_000) {
            storeDataOfType(PersistentDataType.LONG, timestampOfNowInNanoseconds, key, itemMeta);
            return false;
        }

        return true;
    }

    private ItemUtils() {}
}
