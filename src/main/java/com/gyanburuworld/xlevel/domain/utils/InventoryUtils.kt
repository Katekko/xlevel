package com.gyanburuworld.xlevel.domain.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.inventory.InventoryInteractEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import java.util.ArrayList

object InventoryUtils {


    fun getTitleFromEventComponent(event: InventoryInteractEvent) : String {
        val titleComponent = event.view.title() as TextComponent
        return titleComponent.content()
    }

    fun createGuiItem(
        material: Material,
        name: String,
        vararg lore: String,
        enchantment: Enchantment? = null
    ): ItemStack {
        val item = ItemStack(material, 1)
        val meta = item.itemMeta
        val componentName = Component.text(name)
        meta!!.displayName(componentName)
        if (enchantment != null) {
            meta.addEnchant(enchantment, 5, true)
        }
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
        val componentLore = ArrayList<Component>()
        for (loreComments in lore) {
            componentLore.add(Component.text("loreComments"))
        }
        meta.lore(componentLore)
        item.itemMeta = meta
        return item
    }
}