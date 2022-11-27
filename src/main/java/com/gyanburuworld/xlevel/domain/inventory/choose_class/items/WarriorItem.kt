package com.gyanburuworld.xlevel.domain.inventory.choose_class.items

import com.gyanburuworld.xlevel.commands.PlayerCommand
import com.gyanburuworld.xlevel.domain.inventory.choose_class.ChooseClassInventory
import com.gyanburuworld.xlevel.domain.inventory.confirm.ConfirmInventory
import com.gyanburuworld.xlevel.domain.items.ItemBase
import com.gyanburuworld.xlevel.domain.utils.InventoryUtils
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player

object WarriorItem : ItemBase() {
    override val name = "Warrior"
    override val item =
        InventoryUtils.createGuiItem(
            Material.GOLDEN_SWORD,
            name,
            "${ChatColor.GREEN} Click to choose this class"
        )

    private fun chooseClass(player: Player){
        // setar classe do player como a classe desse item
    }

    override fun action(player: Player) {
        val inventory = ConfirmInventory(item, ::chooseClass)
        inventory.openInventory(player)
    }
}