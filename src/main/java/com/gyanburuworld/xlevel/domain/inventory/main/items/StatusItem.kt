package com.gyanburuworld.xlevel.domain.inventory.main.items

import com.gyanburuworld.xlevel.commands.PlayerCommand
import com.gyanburuworld.xlevel.domain.items.ItemBase
import com.gyanburuworld.xlevel.domain.utils.InventoryUtils
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player

object StatusItem : ItemBase() {
    override val name = "Status"
    override val item =
        InventoryUtils.createGuiItem(
            Material.WRITABLE_BOOK,
            name,
            "${ChatColor.GREEN} Click to view your status"
        )

    override fun action(player: Player) {
        PlayerCommand.showStatus(player)
        player.inventory.close()
    }
}