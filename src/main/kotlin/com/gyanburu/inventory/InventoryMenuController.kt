package com.gyanburu.inventory

import com.gyanburu.commands.ChatCommands
import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object InventoryMenuController : InventoryBase() {
    init {
        inventory = Bukkit.createInventory(this, 9, this.getTitleInventory())
        createInventory()
    }

    fun getTitleInventory(): String {
        return "${ChatColor.DARK_PURPLE} xLevel Menu ${ChatColor.YELLOW} ~~"
    }

    //region Menu Item
    private fun getMenuItemName(): String {
        return "xLevel Menu"
    }

    fun getMenuItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.BOOKSHELF,
            getMenuItemName(),
            "${ChatColor.LIGHT_PURPLE} Right click to open menu"
        )
    }
    //endregion

    //region Status Item
    private fun getStatusItemName(): String {
        return "Status"
    }

    private fun getStatusItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.WRITABLE_BOOK,
            getStatusItemName(),
            "${ChatColor.GREEN} Click to view your status"
        )
    }
    //endregion

    //region Choose Class Item
    private fun getChooseClassItemName(): String {
        return "Choose Class"
    }

    private fun getChooseClassItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.DIAMOND_SWORD,
            getChooseClassItemName(),
            "${ChatColor.GREEN} Click to choose your class",
            enchantment = Enchantment.DAMAGE_ALL
        )
    }
    //endregion

    //region Info Classes Item
    private fun getInfoClassesItemName(): String {
        return "Info Classes"
    }

    private fun getInfoClassItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.TORCH,
            getInfoClassesItemName(),
            "${ChatColor.GREEN} Click to view info about classes"
        )
    }
    //endregion

    fun isMenuItem(item: ItemStack?): Boolean {
        val itemName = item?.itemMeta?.displayName
        return itemName == getMenuItemName()
    }

    override fun executeCommand(item: ItemStack?, player: Player): ItemStack? {
        return when (item?.itemMeta?.displayName) {
            getStatusItemName() -> {
                player.closeInventory()
                ChatCommands.showStatus(player)
                null
            }
            getInfoClassesItemName() -> {
                InventoryInfoClassesController.openInventory(player)
                null
            }
            getChooseClassItemName() -> {
                InventoryChooseClassesController.openInventory(player)
                null
            }
            else -> {
                null
            }
        }
    }

    override fun createInventory() {
        inv.addItem(getStatusItemStack())
        inv.setItem(4, getChooseClassItemStack())
        inv.setItem(8, getInfoClassItemStack())
    }
}