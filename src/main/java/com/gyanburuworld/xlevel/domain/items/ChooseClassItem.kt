package com.gyanburuworld.xlevel.domain.items

import com.gyanburuworld.xlevel.domain.inventory.InventoryUtil
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment

object ChooseClassItem : ItemBase() {
    override val name =  "Choose Class"
    override val item =
        InventoryUtil.createGuiItem(
            Material.DIAMOND_SWORD,
            name,
            "${ChatColor.GREEN} Click to choose your class",
            enchantment = Enchantment.DAMAGE_ALL
        )
}