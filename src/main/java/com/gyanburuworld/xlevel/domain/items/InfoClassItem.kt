package com.gyanburuworld.xlevel.domain.items

import com.gyanburuworld.xlevel.domain.inventory.InventoryUtil
import org.bukkit.ChatColor
import org.bukkit.Material

object InfoClassItem : ItemBase(){
    override val name =  "Info Classes"
    override val item =
        InventoryUtil.createGuiItem(
            Material.TORCH,
            name,
            "${ChatColor.GREEN} Click to view info about classes"
        )
}