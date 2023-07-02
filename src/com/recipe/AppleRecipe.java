package com.recipe;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class AppleRecipe extends JavaPlugin implements Listener {

    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
    @Override
    public void onEnable() {
        AddGappleRecipe();
        AddWitherStarRecipe();
        //register onPlayerInteract for portable crafting table funcionality
        this.getServer().getPluginManager().registerEvents(new AppleRecipe(), this);
    }

    public void AddGappleRecipe() {
        NamespacedKey key = new NamespacedKey(this, "enchanted_golden_apple");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 2));
        recipe.shape(new String[]{"GGG", "GAG", "GGG"});
        recipe.setIngredient('G', Material.GOLD_BLOCK);
        recipe.setIngredient('A', Material.ENCHANTED_GOLDEN_APPLE); //make it work like armour trims where it takes one to make two
        this.getServer().addRecipe(recipe);
    }

    public void AddWitherStarRecipe() { //add the wither star recipe to detur wither spam
        NamespacedKey key = new NamespacedKey(this, "nether_star");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.NETHER_STAR));
        recipe.shape(new String[]{"WWW", "SSS", " S "});
        recipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);
        recipe.setIngredient('S', Material.SOUL_SAND);
        this.getServer().addRecipe(recipe);
    }

    //####### crafting table funcionality #######
    //TODO: tell wether or not the player is using the item while not pointing at anything
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        //if the player is sneaking while holding a crafting table
        if (p.isSneaking() && p.getInventory().getItemInMainHand().getType().equals(Material.CRAFTING_TABLE)) {
            p.openWorkbench(p.getLocation(), true); //open the crafting UI
        }
    }
}
