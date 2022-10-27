package com.gyanburuworld.xlevel.domain.inventory.main

import com.gyanburuworld.xlevel.domain.inventory.InventoryBase
import com.gyanburuworld.xlevel.domain.inventory.main.items.ChooseClassItem
import com.gyanburuworld.xlevel.domain.inventory.main.items.InfoClassItem
import com.gyanburuworld.xlevel.domain.inventory.main.items.MenuItem
import com.gyanburuworld.xlevel.domain.inventory.main.items.StatusItem
import com.gyanburuworld.xlevel.domain.utils.ItemUtils
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.inventory.ItemStack

object MainInventory : InventoryBase() {
    override val title = "${ChatColor.DARK_PURPLE} xLevel Menu ${ChatColor.YELLOW} ~~"
    override val items = arrayOf ( StatusItem, ChooseClassItem, InfoClassItem )

    init {
        inventory = Bukkit.createInventory(this, 9, Component.text(title))
        createInventory()
    }

    fun isMenuItem(item: ItemStack?): Boolean {
        return ItemUtils.getDisplayNameFromItemStack(item) == MenuItem.name
    }

    override fun createInventory() {
        inv.addItem(StatusItem.item)
        inv.setItem(4, ChooseClassItem.item)
        inv.setItem(8, InfoClassItem.item)
    }
}