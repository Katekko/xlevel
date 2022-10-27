package com.gyanburuworld.xlevel.domain.items

import com.gyanburuworld.xlevel.domain.inventory.InventoryUtil
import org.bukkit.ChatColor
import org.bukkit.Material

object MenuItem : ItemBase() {
    override val name = "xLevel Menu"
    override val item =
        InventoryUtil.createGuiItem(
            Material.BOOKSHELF,
            name,
            "${ChatColor.LIGHT_PURPLE} Right click to open menu"
        )
}