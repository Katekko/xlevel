package com.gyanburuworld.xlevel.domain.inventory.main

import com.gyanburuworld.xlevel.domain.inventory.InventoryBase
import com.gyanburuworld.xlevel.domain.inventory.main.items.ChooseClassItem
import com.gyanburuworld.xlevel.domain.inventory.main.items.InfoClassItem
import com.gyanburuworld.xlevel.domain.inventory.main.items.StatusItem
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class MainInventory(player: Player) : InventoryBase(player) {
    override  val title = "${ChatColor.DARK_PURPLE} xLevel Menu ${ChatColor.YELLOW} ~~"
    override val items = arrayOf(StatusItem, ChooseClassItem, InfoClassItem)

    init {
        inventory = Bukkit.createInventory(this, 9, Component.text(title))
        createInventory()
    }

    override fun createInventory() {
        inv.addItem(StatusItem.item)
        inv.setItem(4, ChooseClassItem.item)
        inv.setItem(8, InfoClassItem.item)
    }
}