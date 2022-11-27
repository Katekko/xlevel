package com.gyanburuworld.xlevel.domain.inventory.confirm

import com.gyanburuworld.xlevel.domain.inventory.InventoryBase
import com.gyanburuworld.xlevel.domain.inventory.confirm.items.ConfirmItem
import com.gyanburuworld.xlevel.domain.items.ItemBase
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class ConfirmInventory : InventoryBase() {
    companion object {
        val title = "${ChatColor.DARK_PURPLE} Confirm the action"
    }

    private val confirmItem = ConfirmItem(::confirmSelection)
    override val items: Array<ItemBase> = arrayOf(confirmItem)

    lateinit var itemFocus: ItemStack
    lateinit var confirmCallback: (player: Player) -> Unit
    lateinit var denyCallback: (player: Player) -> Unit

    init {
        inventory = Bukkit.createInventory(this, 27, Component.text(title))
        createInventory()
    }

    private fun confirmSelection(player: Player) {
        confirmCallback(player)
    }

    override fun createInventory() {
        inv.setItem(4, itemFocus)
        inv.setItem(22, confirmItem.item)
    }
}
