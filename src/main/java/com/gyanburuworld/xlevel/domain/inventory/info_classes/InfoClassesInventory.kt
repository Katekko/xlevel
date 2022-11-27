package com.gyanburuworld.xlevel.domain.inventory.info_classes

import com.gyanburuworld.xlevel.domain.inventory.InventoryBase
import com.gyanburuworld.xlevel.domain.inventory.info_classes.items.ArcherItem
import com.gyanburuworld.xlevel.domain.inventory.info_classes.items.MageItem
import com.gyanburuworld.xlevel.domain.inventory.info_classes.items.PriestItem
import com.gyanburuworld.xlevel.domain.inventory.info_classes.items.WarriorItem
import com.gyanburuworld.xlevel.domain.items.BackItem
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class InfoClassesInventory(player: Player) : InventoryBase(player) {
    override val title: String = "${ChatColor.DARK_PURPLE} Info Classes ${ChatColor.YELLOW} ~~"
    override val items = arrayOf(WarriorItem, MageItem, ArcherItem, PriestItem, BackItem)

    init {
        inventory = Bukkit.createInventory(this, 27, Component.text(title))
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