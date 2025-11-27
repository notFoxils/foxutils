package me.foxils.foxutils;

import java.util.Objects;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import me.foxils.foxutils.command.GetRegisteredItem;
import me.foxils.foxutils.command.ListRegisteredItems;
import me.foxils.foxutils.item.ThyTestItem;
import me.foxils.foxutils.itemaction.ActiveItemAction;
import me.foxils.foxutils.itemaction.PassiveAction;
import me.foxils.foxutils.listener.AttackActionListener;
import me.foxils.foxutils.listener.ClickActionsListener;
import me.foxils.foxutils.listener.CraftItemActionListener;
import me.foxils.foxutils.listener.DropActionListener;
import me.foxils.foxutils.listener.InventoryClickActionListener;
import me.foxils.foxutils.listener.KillActionListener;
import me.foxils.foxutils.listener.MineBlockActionListener;
import me.foxils.foxutils.listener.ProjectileHitActionListener;
import me.foxils.foxutils.listener.ProjectileLaunchActionListener;
import me.foxils.foxutils.listener.SelectItemActionListener;
import me.foxils.foxutils.listener.SwapOffHandActionListener;
import me.foxils.foxutils.listener.TakeDamageActionListener;
import me.foxils.foxutils.registry.ItemTemplateRegistry;

public final class FoxutilsItems extends JavaPlugin {

    private static final long PASSIVE_TASK_INTERVAL_TICKS = 5;

    private static void registerEvents(final FoxutilsItems plugin, final PluginManager pluginManager, final @Nonnull ItemTemplateRegistry itemTemplateRegistry) {
        pluginManager.registerEvents(new AttackActionListener(itemTemplateRegistry), plugin);
        pluginManager.registerEvents(new ClickActionsListener(itemTemplateRegistry), plugin);
        pluginManager.registerEvents(new CraftItemActionListener(itemTemplateRegistry), plugin);
        pluginManager.registerEvents(new DropActionListener(itemTemplateRegistry), plugin);
        pluginManager.registerEvents(new InventoryClickActionListener(itemTemplateRegistry), plugin);
        pluginManager.registerEvents(new SelectItemActionListener(itemTemplateRegistry), plugin);
        pluginManager.registerEvents(new KillActionListener(itemTemplateRegistry), plugin);
        pluginManager.registerEvents(new MineBlockActionListener(itemTemplateRegistry), plugin);
        pluginManager.registerEvents(new ProjectileHitActionListener(itemTemplateRegistry), plugin);
        pluginManager.registerEvents(new ProjectileLaunchActionListener(itemTemplateRegistry), plugin);
        pluginManager.registerEvents(new SwapOffHandActionListener(itemTemplateRegistry), plugin);
        pluginManager.registerEvents(new TakeDamageActionListener(itemTemplateRegistry), plugin);
    }

    private static void registerCommands(final FoxutilsItems plugin, final ItemTemplateRegistry itemTemplateRegistry) {
        Objects.requireNonNull(plugin.getCommand("getitem")).setExecutor(new GetRegisteredItem(itemTemplateRegistry));
        Objects.requireNonNull(plugin.getCommand("listitems")).setExecutor(new ListRegisteredItems(itemTemplateRegistry));
    }

    private static void registerItems(final FoxutilsItems plugin, final ItemTemplateRegistry itemTemplateRegistry) {
        itemTemplateRegistry.registerItemTemplate(new ThyTestItem(plugin));
    }

    private ItemTemplateRegistry itemTemplateRegistry;

    @Override
    public void onEnable() {
        itemTemplateRegistry = new ItemTemplateRegistry(this);
        getServer().getServicesManager().register(ItemTemplateRegistry.class, itemTemplateRegistry, this, ServicePriority.Highest);

        PDCLocationKey.initializeKeys(this);

        registerEvents(this, getServer().getPluginManager(), itemTemplateRegistry);
        scheduleTasks();
        registerCommands(this, itemTemplateRegistry);
        registerItems(this, itemTemplateRegistry);
    }

    @Override
    public void onDisable() {
        getServer().getServicesManager().unregister(itemTemplateRegistry);
        itemTemplateRegistry = null;
    }

    private void scheduleTasks() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                final PlayerInventory playerInventory = player.getInventory();

                for (final ItemStack itemStack : playerInventory.getContents()) {
                    if (!(itemTemplateRegistry.getItemTemplateFromItemStack(itemStack) instanceof final PassiveAction passiveActionItem)) {
                        continue;
                    }

                    passiveActionItem.onPassiveAction(player, itemStack);
                }

                for (final ItemStack itemStack : new ItemStack[]{playerInventory.getHelmet(), playerInventory.getChestplate(), playerInventory.getLeggings(), playerInventory.getBoots(), playerInventory.getItemInMainHand(), playerInventory.getItemInOffHand()}) {
                    if (!(itemTemplateRegistry.getItemTemplateFromItemStack(itemStack) instanceof final ActiveItemAction activeItemActionItem)) {
                        continue;
                    }

                    activeItemActionItem.onActiveAction(player, itemStack);
                }
            }
        }, 0L, PASSIVE_TASK_INTERVAL_TICKS);
    }

    public final class PDCLocationKey {
        private static boolean keysInitialized = false;

        public static NamespacedKey ITEMSTACK_ITEMKEY_STORAGE;
        public static NamespacedKey ITEMSTACK_UID_STORAGE;
        public static NamespacedKey DATAHOLDER_RELATED_ITEMSTACK_UID_STORAGE;

        static final void initializeKeys(final @Nonnull FoxutilsItems plugin) {
            if (keysInitialized) {
                return;
            }

            ITEMSTACK_ITEMKEY_STORAGE = new NamespacedKey(plugin, "fox_item");
            ITEMSTACK_UID_STORAGE = new NamespacedKey(plugin, "item_uid_storage");
            DATAHOLDER_RELATED_ITEMSTACK_UID_STORAGE = new NamespacedKey(plugin, "related_itemstack_uids_storage");

            keysInitialized = true;
        }

        private PDCLocationKey() {}
    }
}
