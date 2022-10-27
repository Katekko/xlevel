package com.gyanburuworld.xlevel.domain.inventory.main.items

import com.gyanburuworld.xlevel.domain.items.ItemBase
import com.gyanburuworld.xlevel.domain.utils.InventoryUtils
import org.bukkit.ChatColor
import org.bukkit.Material

object StatusItem : ItemBase() {
    override val name = "Status"
    override val item =
        InventoryUtils.createGuiItem(
            Material.WRITABLE_BOOK,
            name,
            "${ChatColor.GREEN} Click to view your status"
        )
}