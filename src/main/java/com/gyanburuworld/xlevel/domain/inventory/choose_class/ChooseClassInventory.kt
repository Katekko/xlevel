package com.gyanburuworld.xlevel.domain.inventory.choose_class

import com.gyanburuworld.xlevel.domain.inventory.InventoryBase
import com.gyanburuworld.xlevel.domain.inventory.choose_class.items.ArcherItem
import com.gyanburuworld.xlevel.domain.inventory.choose_class.items.MageItem
import com.gyanburuworld.xlevel.domain.inventory.choose_class.items.PriestItem
import com.gyanburuworld.xlevel.domain.inventory.choose_class.items.WarriorItem
import com.gyanburuworld.xlevel.domain.items.BackItem
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor

class ChooseClassInventory : InventoryBase() {
    override val items = arrayOf ( WarriorItem, MageItem, ArcherItem, PriestItem, BackItem )

    companion object{
        val title: String = "${ChatColor.DARK_PURPLE} Choose Class ${ChatColor.YELLOW} ~~"
    }

    init {
        inventory = Bukkit.createInventory(this,  27, Component.text(title))
        createInventory()
    }

    override fun createInventory() {
        inv.addItem(WarriorItem.item)
        inv.setItem(3, MageItem.item)
        inv.setItem(5, ArcherItem.item)
        inv.setItem(8, PriestItem.item)
        inv.setItem(26, BackItem.item)
    }
}