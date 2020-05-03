package com.gyanburu.events

import com.gyanburu.inventory.InventoryMenuController
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class BlockEvent: Listener {
    @EventHandler
    fun onBlockPlaced(event: BlockPlaceEvent) {
        if (InventoryMenuController.isMenuItem(event.itemInHand)) {
            event.isCancelled = true
            InventoryMenuController.openInventory(event.player)
        }
    }
}