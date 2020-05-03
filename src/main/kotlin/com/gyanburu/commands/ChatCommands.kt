package com.gyanburu.commands

import com.gyanburu.sql.PlayerDao
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.transactions.transaction

object ChatCommands {
    fun showStatus(player: Player) {
        transaction {
            val playerDao = PlayerDao.findById(player.uniqueId)!!
            player.sendMessage(ChatColor.YELLOW.toString() + "[xLevel]")
            player.sendMessage(ChatColor.DARK_RED.toString() + " Nome: " + ChatColor.GRAY + playerDao.nickname)
            player.sendMessage(ChatColor.GOLD.toString() + " Class: " + ChatColor.GRAY + "--")
            player.sendMessage(ChatColor.GREEN.toString() + " Level: " + ChatColor.GRAY + playerDao.level)
            player.sendMessage(ChatColor.DARK_GREEN.toString() + " Exp: " + ChatColor.GRAY + playerDao.exp)
        }
    }

    fun showClasses(player: Player) {
        player.sendMessage("")
        player.sendMessage(ChatColor.YELLOW.toString() + "[xL] " + ChatColor.LIGHT_PURPLE + "When you reach level 1 you can choose your class!")
        player.sendMessage("")
        player.sendMessage("" + ChatColor.BLUE + ChatColor.BOLD + " ~~~~~~~" + ChatColor.AQUA + "CLASSES" + ChatColor.BLUE + ChatColor.BOLD + "~~~~~~~")
        player.sendMessage(ChatColor.GOLD.toString() + "                Archer")
        player.sendMessage(ChatColor.GOLD.toString() + "                Warrior")
        player.sendMessage(ChatColor.GOLD.toString() + "                Mage")
        player.sendMessage(ChatColor.GOLD.toString() + "                Priest")
        player.sendMessage("" + ChatColor.BLUE + ChatColor.BOLD + " ~~~~~~~~~~~~~~~~~~~")
    }

    fun infoWarrior(player: Player) {
        player.sendMessage(ChatColor.YELLOW.toString() + "[xLevel - " + ChatColor.BOLD + "Guerreiro" + ChatColor.YELLOW + "]")
        player.sendMessage(ChatColor.GRAY.toString() + " To" + ChatColor.RED + " select " + ChatColor.GRAY + "skill: " + ChatColor.LIGHT_PURPLE + "Right click in bone")
        player.sendMessage(ChatColor.GRAY.toString() + " To" + ChatColor.RED + " active " + ChatColor.GRAY + "skill: " + ChatColor.LIGHT_PURPLE + "Right click in sword")
        player.sendMessage(ChatColor.GRAY.toString() + " To" + ChatColor.RED + " use " + ChatColor.GRAY + "skill: " + ChatColor.LIGHT_PURPLE + "Attack with sword")
        player.sendMessage(ChatColor.GRAY.toString() + " ----- Skills ----- ")
        player.sendMessage(ChatColor.GREEN.toString() + "(1)" + ChatColor.GOLD + " Pushing       || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " -- ")
        player.sendMessage(ChatColor.GREEN.toString() + "(2)" + ChatColor.GOLD + " Bleeding      || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Red Mushroom ")
        player.sendMessage(ChatColor.GREEN.toString() + "(5)" + ChatColor.GOLD + " SkullSplitter  || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " -- ")
        player.sendMessage(ChatColor.GRAY.toString() + " ----- Buffs  ----- ")
        player.sendMessage(ChatColor.GREEN.toString() + "(3)" + ChatColor.GOLD + " Sprint         || " + ChatColor.AQUA + "Right click in" + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Sugar ")
        player.sendMessage(ChatColor.GREEN.toString() + "(4)" + ChatColor.GOLD + " Tank Mode    || " + ChatColor.AQUA + "Left click in" + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Obsidian ")
        player.sendMessage(ChatColor.GRAY.toString() + " -------------------")
    }

    fun infoMage(player: Player) {
        player.sendMessage(ChatColor.YELLOW.toString() + "[xLevel - " + ChatColor.BOLD + "Mage" + ChatColor.YELLOW + "]")
        player.sendMessage(ChatColor.GRAY.toString() + " To" + ChatColor.RED + " select " + ChatColor.GRAY + " skill: " + ChatColor.LIGHT_PURPLE + "Right click in book")
        player.sendMessage(ChatColor.GRAY.toString() + " To" + ChatColor.RED + " use " + ChatColor.GRAY + " skill: " + ChatColor.LIGHT_PURPLE + "Left click with stick")
        player.sendMessage(ChatColor.GRAY.toString() + " ----- Skills ----- ")
        player.sendMessage(ChatColor.GREEN.toString() + "(1)" + ChatColor.GOLD + " Energy Wave   || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Torch ")
        player.sendMessage(ChatColor.GREEN.toString() + "(2)" + ChatColor.GOLD + " Teleport        || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " -- ")
        player.sendMessage(ChatColor.GREEN.toString() + "(3)" + ChatColor.GOLD + " Ice Wind         || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Snow Ball ")
        player.sendMessage(ChatColor.GREEN.toString() + "(4)" + ChatColor.GOLD + " Leaves Jail     || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Leaves ")
        player.sendMessage(ChatColor.GREEN.toString() + "(5)" + ChatColor.GOLD + " THOR             || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Red stone Torch")
        player.sendMessage(ChatColor.GRAY.toString() + " -------------------")
    }

    fun infoArcher(player: Player) {
        player.sendMessage(ChatColor.YELLOW.toString() + "[xLevel - " + ChatColor.BOLD + "Archer" + ChatColor.YELLOW + "]")
        player.sendMessage(ChatColor.GRAY.toString() + " To" + ChatColor.RED + " select " + ChatColor.GRAY + "skill: " + ChatColor.LIGHT_PURPLE + "Right click in ARROW ")
        player.sendMessage(ChatColor.GRAY.toString() + " To" + ChatColor.RED + " use " + ChatColor.GRAY + " skill: " + ChatColor.LIGHT_PURPLE + "Shoot with the bow")
        player.sendMessage(ChatColor.GRAY.toString() + " ----- Skills ----- ")
        player.sendMessage(ChatColor.GREEN.toString() + "(1)" + ChatColor.GOLD + " Fire             || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Arrow ")
        player.sendMessage(ChatColor.GREEN.toString() + "(2)" + ChatColor.GOLD + " Invisibility      || " + ChatColor.AQUA + "Right click in " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Feather ")
        player.sendMessage(ChatColor.GREEN.toString() + "(3)" + ChatColor.GOLD + " Critical         || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Arrow ")
        player.sendMessage(ChatColor.GREEN.toString() + "(4)" + ChatColor.GOLD + " Teleport       || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Arrow ")
        player.sendMessage(ChatColor.GREEN.toString() + "(5)" + ChatColor.GOLD + " Poison          || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Arrow ")
        player.sendMessage(ChatColor.GRAY.toString() + " -------------------")
    }

    fun infoPriest(player: Player) {
        player.sendMessage(ChatColor.YELLOW.toString() + "[xLevel - " + ChatColor.BOLD + "Priest" + ChatColor.YELLOW + "]")
        player.sendMessage(ChatColor.GRAY.toString() + " To" + ChatColor.RED + " select " + ChatColor.GRAY + "skill: " + ChatColor.LIGHT_PURPLE + "Right click in book")
        player.sendMessage(ChatColor.GRAY.toString() + " To" + ChatColor.RED + " use " + ChatColor.GRAY + "skill: " + ChatColor.LIGHT_PURPLE + "Right click in axe")
        player.sendMessage(ChatColor.GRAY.toString() + " ----- Skills ----- ")
        player.sendMessage(ChatColor.GREEN.toString() + "(1)" + ChatColor.GOLD + " Heal              || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Wool ")
        player.sendMessage(ChatColor.GREEN.toString() + "(2)" + ChatColor.GOLD + " Summon Wolves || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Porkchop ")
        player.sendMessage(ChatColor.GRAY.toString() + " ----- Buffs  ----- ")
        player.sendMessage(ChatColor.GREEN.toString() + "(3)" + ChatColor.GOLD + " Defense         || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Wool ")
        player.sendMessage(ChatColor.GREEN.toString() + "(4)" + ChatColor.GOLD + " Strength        || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Wool ")
        player.sendMessage(ChatColor.GREEN.toString() + "(5)" + ChatColor.GOLD + " Speed            || " + ChatColor.AQUA + "Item " + ChatColor.GOLD + ": " + ChatColor.LIGHT_PURPLE + " Wool ")
        player.sendMessage(ChatColor.GRAY.toString() + " -------------------")
    }
}