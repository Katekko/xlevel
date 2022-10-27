package com.gyanburuworld.xlevel.events

import com.gyanburuworld.xlevel.domain.inventory.info_classes.InfoClassesInventory
import com.gyanburuworld.xlevel.domain.inventory.main.MainInventory
import com.gyanburuworld.xlevel.domain.utils.InventoryUtils
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.event.inventory.InventoryInteractEvent
import org.bukkit.inventory.ItemStack

class InventoryHandler : Listener {
    private val inventories = arrayOf ( MainInventory, InfoClassesInventory )

    private fun isCustomInventory(event: InventoryInteractEvent) : Boolean {
        val title = InventoryUtils.getTitleFromEventComponent(event)
        return inventories.any { it.title ==  title}
    }

    private fun executeCommand(inventoryTitle: String, player: Player, itemClicked: ItemStack) {
        val inventory = inventories.find { it.title == inventoryTitle }
        val item = inventory?.items?.find { it.item == itemClicked }
        item?.action(player)
    }

    @EventHandler
    fun onInventoryDrag(event: InventoryDragEvent) {
        val dragged = event.oldCursor
        if (isCustomInventory(event)) {
            if (dragged.type != Material.AIR) {
                val inventorySize = event.inventory.size
                for (i in event.rawSlots) {
                    if (i < inventorySize) {
                        event.isCancelled = true
                        break
                    }
                }
            }
        }
    }

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        val clickedInventory = event.clickedInventory
        val player = event.whoClicked as Player
        val clickedOn = event.currentItem

        if (clickedInventory != null) {
            if (clickedInventory == player.inventory) {
                if (MainInventory.isMenuItem(clickedOn)) {
                    event.isCancelled = true
                    return
                }

                if (event.isShiftClick) {
                    if (isCustomInventory(event)) {
                        event.isCancelled = true
                    }
                }
            } else {
                verifyCustomInventoryClick(event)
            }
        }
    }

    private fun verifyCustomInventoryClick(event: InventoryClickEvent) {
        val player = event.whoClicked as Player
        val itemLeft = event.cursor
        val itemClicked = event.currentItem

        if (isCustomInventory(event)) {
            if (event.click == ClickType.NUMBER_KEY
                || event.click.isShiftClick
                || (itemLeft != null && itemLeft.type != Material.AIR)
                || itemClicked != null
            ) {
                event.isCancelled = true
                player.updateInventory()
                if (itemClicked != null) {
                    val title = InventoryUtils.getTitleFromEventComponent(event)
                    executeCommand(title, player, itemClicked)
                }
            }
        }
    }
}