package necode.angelitex.tiplur.angelitemsapi.tools;


import com.google.common.collect.Multimap;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

/**
 * Authors TIplur, omashune, Green_Panda.
 *
 * The code is based on the work of Green_Panda,
 * although we implemented a similar version,
 * this structure seemed to us more correct.
 *
 */

public class ItemBuilder {
    public ItemStack itemStack;
    public ItemMeta  itemMeta;


    /**
     * @param type Type item.
     */
    public ItemBuilder(Material type) {
        new ItemBuilder(type, 1, (short) 0);
    }

    /**
     * @param type Type Item.
     * @param amount Amount Item.
     */
    public ItemBuilder(Material type, int amount) {
        new ItemBuilder(type, amount, (short) 0);
    }

    /**
     * @param type Type Item.
     * @param amount Amount Item.
     * @param damage Damage Item.
     */
    public ItemBuilder(Material type, int amount, short damage) {
        this.itemStack = new ItemStack(type, amount, damage);
        this.itemMeta  = this.itemStack.getItemMeta();
    }

    /**
     * @param item Item.
     */
    public ItemBuilder(ItemStack item) {
        this.itemStack = item;
        this.itemMeta  = item.getItemMeta();
    }

    /**
     * @param type Type Item, for create item.
     */
    public static ItemBuilder from(Material type) {
        return new ItemBuilder(type, 1, (short) 0);
    }

    /**
     * @param type Type Item, for create item.
     * @param amount Amount Item.
     */
    public static ItemBuilder from(Material type, int amount) {
        return new ItemBuilder(type, amount, (short) 0);
    }

    /**
     *
     * @param type Type Item, for create item.
     * @param amount Amount Item.
     * @param damage Damage Item.
     */
    public static ItemBuilder from(Material type, int amount, short damage) {
        return  new ItemBuilder(type, amount, damage);
    }

    /**
     * @param item Type Item, for create item.
     */
    public static ItemBuilder from(ItemStack item) {
        return new ItemBuilder(item);
    }

    // ==================================================[ Add settings item. ] ==================================================

    /**
     * Add an Attribute and it's Modifier.
     * @param attribute specify the attribute to modify
     * @param modifier specify the modifier
     */
    public ItemBuilder addAttribute(Attribute attribute, AttributeModifier modifier) {
        this.itemMeta.addAttributeModifier(attribute, modifier);
        return this;
    }

    /**
     * Adds the specified enchantment to this item meta.
     * @param enchantment specify the enchantment
     * @param level specify the level
     * @param ignoreLevelRestriction specify whether the enchantment level restriction should be ignored
     */
    public ItemBuilder addEnchantment(Enchantment enchantment, int level, boolean ignoreLevelRestriction) {
        this.itemMeta.addEnchant(enchantment, level, ignoreLevelRestriction);
        return this;
    }

    /**
     * Set item flags which should be ignored when rendering a ItemStack in the Client.
     * @param itemFlags specify the item flags
     */
    public ItemBuilder addItemFlag(ItemFlag... itemFlags) {
        this.itemMeta.addItemFlags(itemFlags);
        return this;
    }

    // ==================================================[ Get settings item. ] ==================================================

    /**
     * Return an immutable copy of all Attributes and their modifiers in this ItemMeta.
     * Returns null if none exist.
     */
    public Multimap<Attribute, AttributeModifier> getAttribute() {
        return this.itemMeta.getAttributeModifiers();
    }

    /**
     * Return an immutable copy of all AttributeModifiers for a given Attribute
     * @param attribute specify the desired attribute
     */
    public Collection<AttributeModifier> getAttribute(Attribute attribute) {
        return this.itemMeta.getAttributeModifiers(attribute);
    }

    /**
     * Return an immutable copy of all Attributes and their AttributeModifiers for a given EquipmentSlot.
     * Any AttributeModifier that does have have a given EquipmentSlot will be returned.
     * @param slot specify the target slot
     */
    public Multimap<Attribute, AttributeModifier> getAttribute(EquipmentSlot slot) {
        return this.itemMeta.getAttributeModifiers(slot);
    }

    /**
     * Gets the custom model data that is set.
     */
    public int getCustomModelData() {
        return this.itemMeta.getCustomModelData();
    }

    /**
     * Gets the display name that is set.
     */
    public String getName() {
        return this.itemMeta.getDisplayName();
    }

    /**
     * Checks for the level of the specified enchantment.
     * @param ench specify the desired enchantment
     */
    public int getEnchantmentLevel(Enchantment ench) {
        return this.itemMeta.getEnchantLevel(ench);
    }

    /**
     * Returns a copy the enchantments in this ItemMeta.
     */
    public Map<Enchantment, Integer> getEnchantments() {
        return this.itemMeta.getEnchants();
    }

    /**
     * Get current set itemFlags.
     */
    public Set<ItemFlag> getItemFlags() {
        return this.itemMeta.getItemFlags();
    }

    /**
     * Gets the localized display name that is set.
     */
    public String getLocalizedName() {
        return this.itemMeta.getLocalizedName();
    }

    /**
     * Gets the lore that is set.
     */
    public List<String> getLore() {
        return this.itemMeta.getLore();
    }

    // ==================================================[ Check settings item. ] ==================================================

    /**
     * Checks for the existence of any AttributeModifiers.
     */
    public boolean hasAttribute() {
        return this.itemMeta.hasAttributeModifiers();
    }

    /**
     * Checks if the specified enchantment conflicts with any enchantments in this ItemMeta.
     * @param ench specify the desired enchantment
     */
    public boolean hasConflictingEnchant(Enchantment ench) {
        return this.itemMeta.hasConflictingEnchant(ench);
    }

    /**
     * Checks for existence of custom model data.
     */
    public boolean hasCustomModelData() {
        return this.itemMeta.hasCustomModelData();
    }

    /**
     * Checks for existence of a display name.
     */
    public boolean hasName() {
        return this.itemMeta.hasDisplayName();
    }

    /**
     * Checks for existence of the specified enchantment.
     * @param ench specify the desired enchantment
     */
    public boolean hasEnchantments(Enchantment ench) {
        return this.itemMeta.hasEnchant(ench);
    }

    /**
     * Checks for the existence of any enchantments.
     */
    public boolean hasEnchantments() {
        return this.itemMeta.hasEnchants();
    }

    /**
     * Check if the specified flag is present on this item.
     * @param flag specify the desired flag
     */
    public boolean hasItemFlag(ItemFlag flag) {
        return this.itemMeta.hasItemFlag(flag);
    }

    /**
     * Checks for existence of a localized name.
     */
    public boolean hasLocalizedName() {
        return this.itemMeta.hasLocalizedName();
    }

    /**
     * Checks for existence of lore.
     */
    public boolean hasLore() {
        return this.itemMeta.hasLore();
    }

    /**
     * Return if the unbreakable tag is true.
     */
    public boolean isUnbreakable() {
        return this.itemMeta.isUnbreakable();
    }

    // ==================================================[ Remove settings item. ] ==================================================
    /**
     * Remove all AttributeModifiers associated with the given Attribute.
     * @param attribute specify the desired attribute
     */
    public ItemBuilder removeAttribute(Attribute attribute) {
        this.itemMeta.removeAttributeModifier(attribute);
        return this;
    }

    /**
     * Remove a specific Attribute and AttributeModifier.
     * @param attribute specify the desired attribute
     * @param modifier specify the desired modifier
     */
    public ItemBuilder removeAttribute(Attribute attribute, AttributeModifier modifier) {
        this.itemMeta.removeAttributeModifier(attribute, modifier);
        return this;
    }

    /**
     * Remove all Attributes and AttributeModifiers for a given EquipmentSlot.
     * If the given EquipmentSlot is null, this will remove all AttributeModifiers that do not have an EquipmentSlot set.
     * @param slot specify the desired slot
     */
    public ItemBuilder removeAttribute(EquipmentSlot slot) {
        this.itemMeta.removeAttributeModifier(slot);
        return this;
    }

    /**
     * Removes the specified enchantment from this item meta.
     * @param ench specify the desired enchantment
     */
    public ItemBuilder removeEnchantment(Enchantment ench) {
        this.itemMeta.removeEnchant(ench);
        return this;
    }

    /**
     * Remove specific set of itemFlags.
     * @param itemFlags specify the desired item flag(s)
     */
    public ItemBuilder removeItemFlags(ItemFlag... itemFlags) {
        this.itemMeta.removeItemFlags(itemFlags);
        return this;
    }

    // ==================================================[ Set settings item. ] ==================================================

    /**
     * Set all Attributes and their AttributeModifiers.
     * @param attributeModifiers specify the desired attribute modifiers
     */
    public ItemBuilder setAttribute(Multimap<Attribute,AttributeModifier> attributeModifiers) {
        this.itemMeta.setAttributeModifiers(attributeModifiers);
        return this;
    }

    /**
     * Sets the custom model data.
     * @param data specify the desired custom model data
     */
    public ItemBuilder setCustomModelData(Integer data) {
        this.itemMeta.setCustomModelData(data);
        return this;
    }

    /**
     * Sets the display name.
     * @param name specify the desired display name
     */
    public ItemBuilder setDisplayName(String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }

    /**
     * Sets the localized name.
     * @param name specify the desired localized name
     */
    public ItemBuilder setLocalizedName(String name) {
        this.itemMeta.setLocalizedName(name);
        return this;
    }

    /**
     * Sets the lore for this item.
     * @param lore specify the desired lore lines
     */
    public ItemBuilder setLore(List<String> lore) {
        this.itemMeta.setLore(lore);
        return this;
    }

    /**
     * Adds lines to the end of the lore.
     * @param lines specify the desired lore line(s) to add
     */
    public ItemBuilder addLoreLines(String...lines) {
        Objects.requireNonNull(this.itemMeta.getLore()).addAll(Arrays.asList(lines));
        return this;
    }

    /**
     * Remove lines by their index.
     * @param lines specify the desired lore indices to remove
     */
    public ItemBuilder removeLoreLines(int...lines) {
        for (int line : lines) Objects.requireNonNull(this.itemMeta.getLore()).remove(line);
        return this;
    }

    /**
     * Sets the unbreakable tag.
     * @param unbreakable specify if the item should be unbreakable
     */
    public ItemBuilder setUnbreakable(boolean unbreakable) {
        this.itemMeta.setUnbreakable(unbreakable);
        return this;
    }

    // ==================================================[ Build item. ] ==================================================

    /**
     * Building item, return a default item Spigot.
     */
    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
