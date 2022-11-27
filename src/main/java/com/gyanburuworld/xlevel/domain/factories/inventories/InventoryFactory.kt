package com.gyanburuworld.xlevel.domain.factories.inventories

import com.gyanburuworld.xlevel.domain.inventory.InventoryBase
import com.gyanburuworld.xlevel.domain.inventory.info_classes.InfoClassesInventory
import com.gyanburuworld.xlevel.domain.inventory.main.MainInventory
import org.bukkit.entity.Player

object InventoryFactory {
    var currentInventory : InventoryBase? = null

    fun makeMainInventory(player: Player): MainInventory {
        val inv = MainInventory(player)
        currentInventory = inv
        return inv
    }

    fun makeInfoClassesInventory(player: Player): MainInventory {
        val inv = InfoClassesInventory(player)
        currentInventory = inv
        return inv
    }

    fun closeInventory(player: Player) {
        currentInventory = null
        player.inventory.close()
    }
}