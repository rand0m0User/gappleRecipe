package com.recipe;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class recipes extends JavaPlugin implements Listener {

    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
    @Override
    public void onEnable() {
        AddGappleRecipe();
        AddWitherStarRecipe();
        AddSandRecipe();
        AddSandFromSandstoneRecipe();
        //register onPlayerInteract for portable crafting table funcionality
        this.getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }

    public void AddGappleRecipe() {
        NamespacedKey key = new NamespacedKey(this, "enchanted_golden_apple");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 2));
        recipe.shape(new String[]{"GGG", "GAG", "GGG"});
        recipe.setIngredient('G', Material.GOLD_BLOCK);
        recipe.setIngredient('A', Material.ENCHANTED_GOLDEN_APPLE); //make it work like armour trims where it takes one to make two
        this.getServer().addRecipe(recipe);
    }

    public void AddWitherStarRecipe() { //add the ender star recipe to detur wither spam
        NamespacedKey key = new NamespacedKey(this, "nether_star");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.NETHER_STAR));
        recipe.shape(new String[]{"WWW", "SSS", " S "});
        recipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);
        recipe.setIngredient('S', Material.SOUL_SAND);
        this.getServer().addRecipe(recipe);
    }
    
    public void AddSandRecipe() { //add a sand recipe for automation of concete 
        NamespacedKey key = new NamespacedKey(this, "sand");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.SAND, 4));
        recipe.shape(new String[]{"SG ", "GS ", "   "});
        recipe.setIngredient('G', Material.GRAVEL);
        recipe.setIngredient('S', Material.SOUL_SAND);
        this.getServer().addRecipe(recipe);
    }
    
    public void AddSandFromSandstoneRecipe() { //add a sand recipe for automation of concete 
        NamespacedKey key = new NamespacedKey(this, "sand");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.SAND, 4));
        recipe.shape(new String[]{"S  ", "   ", "   "});
        recipe.setIngredient('S', Material.SANDSTONE);
        this.getServer().addRecipe(recipe);
    }
}
