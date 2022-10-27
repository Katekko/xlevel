package com.gyanburuworld.xlevel.domain.items

import org.bukkit.inventory.ItemStack

abstract class ItemBase {
    abstract val name: String
    abstract val item: ItemStack

    fun isEqual(otherName: String) = name == otherName
}