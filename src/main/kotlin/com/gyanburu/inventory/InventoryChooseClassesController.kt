package com.gyanburu.inventory

import com.gyanburu.commands.ChatCommands
import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object InventoryChooseClassesController : InventoryBase() {
    init {
        inventory = Bukkit.createInventory(this, 27, this.getTitleInventory())
        createInventory()
    }

    fun getTitleInventory(): String {
        return "${ChatColor.DARK_PURPLE} Choose Classes ${ChatColor.YELLOW} ~~"
    }

    //region Warrior Item
    private fun getWarriorItemName(): String {
        return "Warrior"
    }

    private fun getWarriorItemStack(): ItemStack {
        return InventoryUtil.createGuiItem(
            Material.GOLDEN_SWORD,
            getWarriorItemName(),
            "${ChatColor.GREEN} Click to pick that class",
            enchantment = Enchantment.DAMAGE_ALL
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
            "${ChatColor.GREEN} Click to pick that class",
            enchantment = Enchantment.DAMAGE_ALL
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
            "${ChatColor.GREEN} Click to pick that class",
            enchantment = Enchantment.DAMAGE_ALL
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
            "${ChatColor.GREEN} Click to pick that class",
            enchantment = Enchantment.DAMAGE_ALL
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
                val inventory = InventoryConfirmClassController(getWarriorItemStack())
                inventory.openInventory(player)
                null
            }
            getMageItemName() -> {
                val inventory = InventoryConfirmClassController(getMageItemStack())
                inventory.openInventory(player)
                null
            }
            getArcherItemName() -> {
                val inventory = InventoryConfirmClassController(getArcherItemStack())
                inventory.openInventory(player)
                null
            }
            getPriestItemName() -> {
                val inventory = InventoryConfirmClassController(getPriestItemStack())
                inventory.openInventory(player)
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

    fun chooseClass(chosenClass: ItemStack?, player: Player) {
        val className = chosenClass?.itemMeta?.displayName?.split("|")
        when (className?.last()?.trim()) {
            getWarriorItemName() -> {
                player.sendMessage("Warrior was chosen")
            }
            getMageItemName() -> {
                player.sendMessage("Mage was chosen")
            }
            getArcherItemName() -> {
                player.sendMessage("Archer was chosen")
            }
            getPriestItemName() -> {
                player.sendMessage("Priest was chosen")
            }
            else -> {
            }
        }
        player.closeInventory()
    }

    override fun createInventory() {
        inv.addItem(getWarriorItemStack())
        inv.setItem(3, getMageItemStack())
        inv.setItem(5, getArcherItemStack())
        inv.setItem(8, getPriestItemStack())
        inv.setItem(26, getBackItemStack())
    }
}