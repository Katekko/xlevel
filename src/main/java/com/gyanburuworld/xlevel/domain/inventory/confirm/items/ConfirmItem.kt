package com.gyanburuworld.xlevel.domain.inventory.confirm.items

import com.gyanburuworld.xlevel.domain.items.ItemBase
import com.gyanburuworld.xlevel.domain.utils.InventoryUtils
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player

class ConfirmItem(val callback: (player: Player) -> Unit): ItemBase() {
    override val name = "Confirm"
    override val item =
        InventoryUtils.createGuiItem(
            Material.GREEN_WOOL,
            name,
            "${ChatColor.GREEN} Click to confirm"
        )

    override fun action(player: Player) {
        callback(player)
    }
}
