package com.gyanburuworld.xlevel.domain.inventory.main.items

import com.gyanburuworld.xlevel.domain.items.ItemBase
import com.gyanburuworld.xlevel.domain.utils.InventoryUtils
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player

object ChooseClassItem : ItemBase() {
    override val name =  "Choose Class"
    override val item =
        InventoryUtils.createGuiItem(
            Material.DIAMOND_SWORD,
            name,
            "${ChatColor.GREEN} Click to choose your class",
            enchantment = Enchantment.DAMAGE_ALL
        )
    override fun action(player: Player) {
        TODO("Not yet implemented")
    }
}