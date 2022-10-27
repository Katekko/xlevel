package com.gyanburuworld.xlevel.domain.inventory

import net.kyori.adventure.text.TextComponent
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

abstract class InventoryBase : InventoryHolder {
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