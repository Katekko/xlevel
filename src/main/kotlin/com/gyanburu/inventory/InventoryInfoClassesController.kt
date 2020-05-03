package com.gyanburu.inventory

import com.gyanburu.commands.ChatCommands
import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object InventoryInfoClassesController : InventoryBase() {
    init {
        inventory = Bukkit.createInventory(this, 27, this.getTitleInventory())
        createInventory()
    }

    fun getTitleInventory(): String {
        return "${ChatColor.DARK_PURPLE} Info Classes ${ChatColor.YELLOW} ~~"
    }

    //region Warrior Item
    private fun getWarriorItemName(): String {
        return "Warrior"
    }

    private fun getWarriorItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.GOLDEN_SWORD,
            getWarriorItemName(),
            "${ChatColor.GREEN} Click to see the info"
        )
    }
    //endregion

    //region Mage Item
    private fun getMageItemName(): String {
        return "Mage"
    }

    private fun getMageItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.BOOK,
            getMageItemName(),
            "${ChatColor.GREEN} Click to see the info"
        )
    }
    //endregion

    //region Archer Item
    private fun getArcherItemName(): String {
        return "Archer"
    }

    private fun getArcherItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.ARROW,
            getArcherItemName(),
            "${ChatColor.GREEN} Click to see the info"
        )
    }
    //endregion

    //region Priest Item
    private fun getPriestItemName(): String {
        return "Priest"
    }

    private fun getPriestItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.IRON_AXE,
            getPriestItemName(),
            "${ChatColor.GREEN} Click to see the info"
        )
    }
    //endregion

    //region Back Item
    private fun getBackItemName(): String {
        return "Back"
    }

    private fun getBackItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.POTATO,
            getBackItemName(),
            "${ChatColor.GREEN} Click to back"
        )
    }
    //endregion

    override fun executeCommand(item: ItemStack?, player: Player): ItemStack? {
        return when (item?.itemMeta?.displayName) {
            getWarriorItemName() -> {
                player.closeInventory()
                ChatCommands.infoWarrior(player)
                null
            }
            getMageItemName() -> {
                player.closeInventory()
                ChatCommands.infoMage(player)
                null
            }
            getArcherItemName() -> {
                player.closeInventory()
                ChatCommands.infoArcher( player)
                null
            }
            getPriestItemName() -> {
                player.closeInventory()
                ChatCommands.infoPriest(player)
                null
            }
            getBackItemName() -> {
                InventoryMenuController.openInventory(player)
                null
            }
            else -> {
                null
            }
        }
    }

    override fun createInventory() {
        inv.addItem(getWarriorItemStack())
        inv.setItem(3, getMageItemStack())
        inv.setItem(5, getArcherItemStack())
        inv.setItem(8, getPriestItemStack())
        inv.setItem(26, getBackItemStack())
    }
}