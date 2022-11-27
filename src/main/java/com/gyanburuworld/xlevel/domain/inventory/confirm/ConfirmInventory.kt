package com.gyanburuworld.xlevel.domain.inventory

import com.gyanburuworld.xlevel.domain.inventory.main.MainInventory
import com.gyanburuworld.xlevel.domain.inventory.main.items.ChooseClassItem
import com.gyanburuworld.xlevel.domain.inventory.main.items.InfoClassItem
import com.gyanburuworld.xlevel.domain.inventory.main.items.StatusItem
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor

object ConfirmInventory : InventoryBase(){
    override val title = "${ChatColor.DARK_PURPLE} Confirm the action"
    override val items = arrayOf ( StatusItem, ChooseClassItem, InfoClassItem )

    init {
        inventory = Bukkit.createInventory(this, 20, Component.text(title))
        createInventory()
    }

    override fun createInventory() {
        inv.addItem(StatusItem.item)
        inv.setItem(4, ChooseClassItem.item)
        inv.setItem(8, InfoClassItem.item)
    }
}
