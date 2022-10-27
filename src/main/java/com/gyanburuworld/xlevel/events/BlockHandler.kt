package com.gyanburuworld.xlevel.events

import com.gyanburuworld.xlevel.domain.inventory.main.MainInventory
import org.bukkit.event.Listener
import org.bukkit.event.EventHandler
import org.bukkit.event.block.BlockPlaceEvent

class BlockHandler: Listener {
    @EventHandler
    fun onBlockPlaced(event: BlockPlaceEvent) {
        if (MainInventory.isMenuItem(event.itemInHand)) {
            event.isCancelled = true
            MainInventory.openInventory(event.player)
        }
    }
}