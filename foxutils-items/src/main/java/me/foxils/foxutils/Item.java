package me.foxils.foxutils;

import me.foxils.foxutils.utilities.FoxCraftingRecipe;
import me.foxils.foxutils.utilities.ItemAbility;
import me.foxils.foxutils.utilities.ItemUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public abstract class Item {

    protected final Plugin plugin;

    private final ItemStack item;
    private final String name;
    private final int customModelData;

    private List<String> actualLore = new ArrayList<>();

    private final List<ItemAbility> abilityList = new ArrayList<>();
    private FoxCraftingRecipe recipe;

    private final NamespacedKey itemKey;

    public static final NamespacedKey itemConfirmationKey = NamespacedKey.fromString("foxutils:fox_item");

    public Item(Material material, int customModelData, String name, Plugin plugin, List<ItemAbility> abilityList, List<ItemStack> itemsForRecipe, boolean shapedRecipe) {
        this.plugin = plugin;

        this.item = new ItemStack(material);
        this.name = name;
        this.customModelData = customModelData;

        this.itemKey = new NamespacedKey(plugin, ChatColor.stripColor(name).replace("[", "").replace("]", "").replace(" ", "_").toLowerCase());

        this.abilityList.addAll(abilityList);
        this.recipe = new FoxCraftingRecipe(itemsForRecipe, itemKey, createItem(1), shapedRecipe);
    }

    public Item(Material material, String name, Plugin plugin, List<ItemAbility> abilityList, List<ItemStack> itemsForRecipe, boolean shapedRecipe) {
        this(material, 0, name, plugin, abilityList, itemsForRecipe, shapedRecipe);
    }

    public Item(Material material, int customModelData, String name, Plugin plugin, List<ItemAbility> abilityList) {
        this(material, customModelData, name, plugin, abilityList, null, false);
    }

    public Item(Material material, String name, Plugin plugin, List<ItemAbility> abilityList) {
        this(material, 0, name, plugin, abilityList);
    }

    public ItemStack createItem(int amount) {
        ItemStack newItem = item.clone();

        ItemUtils.nameItem(newItem, name);
        ItemUtils.addItemLore(newItem, createLore());
        ItemUtils.setCustomModelData(newItem, customModelData);
        // Stores the actual item itemKey (name/internal reference), at the foxutils:fox_item location in NBT
        ItemUtils.storeStringData(itemConfirmationKey, newItem, itemKey.toString());

        newItem.setAmount(amount);

        return newItem;
    }

    public List<String> createLore() {
        if (!actualLore.isEmpty()) {
            return actualLore;
        }

        List<String> lore = new ArrayList<>();

        lore.add(" ");

        abilityList.forEach(itemAbility -> {
            lore.addAll(itemAbility.toLore());
            if (!abilityList.getLast().equals(itemAbility)) lore.add(" ");
        });

        actualLore = lore;

        return lore;
    }

    public Material getItemMaterial() {
        return item.getType();
    }

    public ItemStack getRawItem() {
        return item;
    }

    public String getName() {
        return name;
    }

    public NamespacedKey getKey() {
        return itemKey;
    }

    public String getRawName() {
        return getKey().getKey();
    }

    public FoxCraftingRecipe getRecipe() {
        return recipe;
    }

    public void setRecipe(FoxCraftingRecipe recipe) {
        this.recipe = recipe;
    }
}
