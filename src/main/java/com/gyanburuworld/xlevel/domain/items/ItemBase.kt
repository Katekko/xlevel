package com.gyanburuworld.xlevel.domain.items

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

abstract class ItemBase {
    abstract val name: String
    abstract val item: ItemStack
    abstract fun action(player: Player)

    fun isEqual(otherName: String) = name == otherName
}