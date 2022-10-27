package com.gyanburuworld.xlevel.domain.inventory

import com.gyanburuworld.xlevel.commands.PlayerCommand
import com.gyanburuworld.xlevel.domain.items.ChooseClassItem
import com.gyanburuworld.xlevel.domain.items.InfoClassItem
import com.gyanburuworld.xlevel.domain.items.MenuItem
import com.gyanburuworld.xlevel.domain.items.StatusItem
import com.gyanburuworld.xlevel.domain.utils.ItemUtils
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object MainInventory : InventoryBase() {
    override val title = "${ChatColor.DARK_PURPLE} xLevel Menu ${ChatColor.YELLOW} ~~"

    init {
        inventory = Bukkit.createInventory(this, 9, Component.text(title))
        createInventory()
    }

    fun isMenuItem(item: ItemStack?): Boolean {
        return ItemUtils.getDisplayNameFromComponent(item) == MenuItem.name
    }

    override fun executeCommand(item: ItemStack?, player: Player): ItemStack? {
        return when (ItemUtils.getDisplayNameFromComponent(item)) {
            StatusItem.name -> {
                player.closeInventory()
                PlayerCommand.showStatus(player)
                null
            }

            else -> null
        }
    }

    override fun createInventory() {
        inv.addItem(StatusItem.item)
        inv.setItem(4, ChooseClassItem.item)
        inv.setItem(8, InfoClassItem.item)
    }
}