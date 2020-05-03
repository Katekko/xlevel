package com.gyanburu.inventory

import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

abstract class InventoryBase : InventoryHolder {
    // TODO: Ajustar esse atributo nessa classe abstrata
    var inv: Inventory = inventory

    abstract fun createInventory()
    abstract fun executeCommand(item: ItemStack?, player: Player): ItemStack?

    override fun getInventory(): Inventory {
        return inv
    }

    fun setInventory(inventory: Inventory){
        this.inv = inventory
    }

    fun openInventory(player: Player) {
        player.openInventory(this.inv)
    }
}