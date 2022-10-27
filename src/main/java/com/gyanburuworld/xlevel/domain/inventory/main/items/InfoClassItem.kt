package com.gyanburuworld.xlevel.domain.inventory.main.items

import com.gyanburuworld.xlevel.domain.inventory.info_classes.InfoClassesInventory
import com.gyanburuworld.xlevel.domain.items.ItemBase
import com.gyanburuworld.xlevel.domain.utils.InventoryUtils
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player

object InfoClassItem : ItemBase() {
    override val name = "Info Classes"
    override val item =
        InventoryUtils.createGuiItem(
            Material.TORCH,
            name,
            "${ChatColor.GREEN} Click to view info about classes"
        )

    override fun action(player: Player) {
        InfoClassesInventory.openInventory(player)
    }
}