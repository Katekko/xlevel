package com.gyanburu.inventory

import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class InventoryConfirmClassController(private val pickedClass: ItemStack) :
    InventoryBase() {
    // TODO: Reformular essa classe, ficou muita gambiarra

    init {
        inventory = Bukkit.createInventory(this, 9, getTitleInventory())
        createInventory()
    }

    companion object {
        fun getTitleInventory(): String {
            return "${ChatColor.DARK_PURPLE} Confirm Class ${ChatColor.YELLOW} ~~"
        }
    }

    //region Confirm Item
    private fun getConfirmItemName(): String {
        return "Confirm"
    }

    private fun getConfirmItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.LIME_WOOL,
            "${getConfirmItemName()} | ${pickedClass.itemMeta?.displayName}",
            "${ChatColor.GREEN} Are u sure?"
        )
    }
    //endregion

    //region Deny Item
    private fun getDenyItemName(): String {
        return "Deny"
    }

    private fun getDenyItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.RED_WOOL,
            getDenyItemName(),
            "${ChatColor.GREEN} Are u sure?"
        )
    }
    //endregion

    override fun executeCommand(item: ItemStack?, player: Player): ItemStack? {
        val itemName = item?.itemMeta?.displayName?.split("|")
        return when (itemName?.first()?.trim()) {
            getConfirmItemName() -> {
                player.closeInventory()
                pickedClass
            }
            getDenyItemName() -> {
                player.closeInventory()
                null
            }
            else -> {
                null
            }
        }
    }

    override fun createInventory() {
        inv.addItem(getConfirmItemStack())
        inv.setItem(4, this.pickedClass)
        inv.setItem(8, getDenyItemStack())
    }
}