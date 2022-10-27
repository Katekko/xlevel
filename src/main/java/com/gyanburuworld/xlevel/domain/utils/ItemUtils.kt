package com.gyanburuworld.xlevel.domain.utils

import net.kyori.adventure.text.TextComponent
import org.bukkit.inventory.ItemStack

object ItemUtils {
    fun getDisplayNameFromItemStack(item: ItemStack?) : String {
        if (item != null && item.itemMeta != null && item.itemMeta.hasDisplayName()) {
            val itemName = item.itemMeta?.displayName() as TextComponent
            return itemName.content()
        }

        return ""
    }
}