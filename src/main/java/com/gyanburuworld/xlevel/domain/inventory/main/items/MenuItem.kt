package com.gyanburuworld.xlevel.domain.inventory.main.items

import com.gyanburuworld.xlevel.domain.items.ItemBase
import com.gyanburuworld.xlevel.domain.utils.InventoryUtils
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player

object MenuItem : ItemBase() {
    override val name = "xLevel Menu"
    override val item =
        InventoryUtils.createGuiItem(
            Material.BOOKSHELF,
            name,
            "${ChatColor.LIGHT_PURPLE} Right click to open menu"
        )

    override fun action(player: Player) {}
}