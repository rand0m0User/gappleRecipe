package com.recipe;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class AppleRecipe extends JavaPlugin {

    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
    @Override
    public void onEnable() {
        AddGappleRecipe();
        AddWitherStarRecipe();
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
}
