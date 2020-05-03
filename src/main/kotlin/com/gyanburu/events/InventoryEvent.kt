package com.gyanburu.events

import com.gyanburu.inventory.InventoryChooseClassesController
import com.gyanburu.inventory.InventoryConfirmClassController
import com.gyanburu.inventory.InventoryInfoClassesController
import com.gyanburu.inventory.InventoryMenuController
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.inventory.ItemStack

class InventoryEvent : Listener {
    // region Methods
    private fun isCustomInventory(inventoryTitle: String): Boolean {
        return when (inventoryTitle) {
            InventoryMenuController.getTitleInventory() -> {
                true
            }
            InventoryInfoClassesController.getTitleInventory() -> {
                true
            }
            InventoryChooseClassesController.getTitleInventory() -> {
                true
            }
            InventoryConfirmClassController.getTitleInventory() -> {
                true
            }
            else -> {
                false
            }
        }
    }

    private fun executeCommand(inventoryTitle: String, player: Player, itemClicked: ItemStack) {
        when (inventoryTitle) {
            InventoryMenuController.getTitleInventory() -> {
                InventoryMenuController.executeCommand(itemClicked, player)
            }
            InventoryInfoClassesController.getTitleInventory() -> {
                InventoryInfoClassesController.executeCommand(itemClicked, player)
            }
            InventoryChooseClassesController.getTitleInventory() -> {
                InventoryChooseClassesController.executeCommand(itemClicked, player)
            }
            InventoryConfirmClassController.getTitleInventory() -> {
                // TODO: Isso ficou muita gambiarra
                val chosenClass = InventoryConfirmClassController(itemClicked).executeCommand(itemClicked, player)
                InventoryChooseClassesController.chooseClass(chosenClass, player)
            }
            else -> {
            }
        }
    }
    //endregion

    // region Events
    @EventHandler
    fun onInventoryDrag(event: InventoryDragEvent) {
        val dragged = event.oldCursor
        val title = event.view.title
        if (isCustomInventory(title)) {
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
                if (InventoryMenuController.isMenuItem(clickedOn)) {
                    event.isCancelled = true
                    return
                }

                if (event.isShiftClick) {
                    val title = event.view.title
                    if (isCustomInventory(title)) {
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
        val inventoryTitle = event.view.title

        if (isCustomInventory(inventoryTitle)) {
            if (event.click == ClickType.NUMBER_KEY
                || event.click.isShiftClick
                || (itemLeft != null && itemLeft.type != Material.AIR)
                || itemClicked != null
            ) {
                event.isCancelled = true
                player.updateInventory()
                if (itemClicked != null) {
                    executeCommand(inventoryTitle, player, itemClicked)
                }
            }
        }
    }
    //endregion
}
