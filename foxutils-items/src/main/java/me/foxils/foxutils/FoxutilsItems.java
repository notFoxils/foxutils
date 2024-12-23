package me.foxils.foxutils;

import me.foxils.foxutils.commands.GetRegisteredItem;
import me.foxils.foxutils.commands.ListRegisteredItems;
import me.foxils.foxutils.itemactions.HoldingItemAction;
import me.foxils.foxutils.itemactions.PassiveAction;
import me.foxils.foxutils.items.ThyTestItem;
import me.foxils.foxutils.listeners.*;
import me.foxils.foxutils.registry.ItemRegistry;
import me.foxils.foxutils.utilities.ActionType;
import me.foxils.foxutils.utilities.ItemAbility;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class FoxutilsItems extends JavaPlugin {

    public static final List<Integer> taskIDs = new ArrayList<>();

    @Override
    public void onEnable() {
        scheduleTasks();
        registerEvents();
        registerCommands();

        ItemRegistry.registerItem(new ThyTestItem(Material.TRIDENT, 43290423, "Thy Test Item", this,
                List.of(
                        new ItemAbility("Test Shit",
                                List.of("They see me testin'",
                                        ChatColor.ITALIC + "They hatin'"
                                ), ActionType.NONE)
                )));

        this.getLogger().info("foxutils-items Started and initialized");
    }

    @Override
    public void onDisable() {
        cancelTasks();
    }

    private void scheduleTasks() {
        taskIDs.addAll(Arrays.asList(
                Bukkit.getScheduler().scheduleSyncRepeatingTask(this, PassiveAction::passiveCall, PassiveAction.passiveTaskInterval, PassiveAction.passiveTaskInterval),
                Bukkit.getScheduler().scheduleSyncRepeatingTask(this, HoldingItemAction::holdActionCall, HoldingItemAction.holdActionInterval, HoldingItemAction.holdActionInterval)));
    }

    private void registerCommands() {
        Objects.requireNonNull(Bukkit.getPluginCommand("getitem")).setExecutor(new GetRegisteredItem(this));
        Objects.requireNonNull(Bukkit.getPluginCommand("listitems")).setExecutor(new ListRegisteredItems());
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new AttackActionListener(), this);
        getServer().getPluginManager().registerEvents(new ClickActionsListener(), this);
        getServer().getPluginManager().registerEvents(new CraftItemActionListener(), this);
        getServer().getPluginManager().registerEvents(new DoubleJumpListener(), this);
        getServer().getPluginManager().registerEvents(new DropActionListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickActionListener(), this);
        getServer().getPluginManager().registerEvents(new ItemSelectionActionListener(), this);
        getServer().getPluginManager().registerEvents(new KillActionListener(), this);
        getServer().getPluginManager().registerEvents(new MineBlockActionListener(), this);
        getServer().getPluginManager().registerEvents(new ProjectileHitActionListener(), this);
        getServer().getPluginManager().registerEvents(new ShootActionListener(), this);
        getServer().getPluginManager().registerEvents(new SwapOffhandActionListener(), this);
        getServer().getPluginManager().registerEvents(new TakeDamageActionListener(), this);
    }

    private void cancelTasks() {
        for (int taskID : taskIDs) {
            Bukkit.getScheduler().cancelTask(taskID);
        }
    }
}
