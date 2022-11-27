package com.gyanburuworld.xlevel.domain.inventory.choose_class.items

import com.gyanburuworld.xlevel.commands.PlayerCommand
import com.gyanburuworld.xlevel.domain.items.ItemBase
import com.gyanburuworld.xlevel.domain.utils.InventoryUtils
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player

object MageItem : ItemBase() {
    override val name = "Mage"
    override val item =
        InventoryUtils.createGuiItem(
            Material.BOOK,
            name,
            "${ChatColor.GREEN} Click to choose this class"
        )

    override fun action(player: Player) {
        PlayerCommand.infoMage(player)
        player.inventory.close()
    }
}