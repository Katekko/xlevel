package com.gyanburuworld.xlevel.domain.utils

import net.kyori.adventure.text.TextComponent
import org.bukkit.event.inventory.InventoryInteractEvent

object InventoryUtils {
    fun getTitleFromEventComponent(event: InventoryInteractEvent) : String {
        val titleComponent = event.view.title() as TextComponent
        return titleComponent.content()
    }
}