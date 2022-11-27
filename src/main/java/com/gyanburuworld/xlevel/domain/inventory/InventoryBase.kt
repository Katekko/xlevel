package com.gyanburuworld.xlevel.domain.inventory

import com.gyanburuworld.xlevel.domain.items.ItemBase
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

abstract class InventoryBase(private val player: Player) : InventoryHolder {
    abstract val title: String
    abstract val items: Array<ItemBase>
    var inv: Inventory = inventory

    protected abstract fun createInventory()

    override fun getInventory(): Inventory {
        return inv
    }

    fun setInventory(inventory: Inventory){
        this.inv = inventory
    }

    fun openInventory() {
        player.openInventory(this.inv)
    }
}