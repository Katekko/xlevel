package com.gyanburuworld.xlevel.domain.items

import com.gyanburuworld.xlevel.domain.inventory.InventoryUtil
import org.bukkit.ChatColor
import org.bukkit.Material

object StatusItem : ItemBase() {
    override val name = "Status"
    override val item =
        InventoryUtil.createGuiItem(
            Material.WRITABLE_BOOK,
            name,
            "${ChatColor.GREEN} Click to view your status"
        )
}