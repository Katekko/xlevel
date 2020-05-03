package com.gyanburu.inventory

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import java.util.*


object InventoryUtil {
    fun createGuiItem(material: Material, name: String, vararg lore: String, enchantment: Enchantment? = null): ItemStack {
        val item = ItemStack(material, 1)
        val meta = item.itemMeta
        meta!!.setDisplayName(name)
        if(enchantment != null) {
            meta.addEnchant(enchantment, 5, true)
        }
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
        val metaLore = ArrayList<String>()
        for (loreComments in lore) {
            metaLore.add(loreComments)
        }
        meta.lore = metaLore
        item.itemMeta = meta
        return item
    }
}