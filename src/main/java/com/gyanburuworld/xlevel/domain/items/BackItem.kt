package com.gyanburuworld.xlevel.domain.items

import com.gyanburuworld.xlevel.domain.inventory.main.MainInventory
import com.gyanburuworld.xlevel.domain.utils.InventoryUtils
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player

object BackItem : ItemBase() {
    override val name = "Back"
    override val item =
        InventoryUtils.createGuiItem(
            Material.POTATO,
            name,
            "${ChatColor.GREEN} Click to back"
        )

    override fun action(player: Player) {
        MainInventory.openInventory(player)
    }
}