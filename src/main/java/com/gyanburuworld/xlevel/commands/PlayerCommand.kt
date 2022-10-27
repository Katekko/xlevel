package com.gyanburuworld.xlevel.commands

import com.gyanburuworld.xlevel.infrastructure.queries.PlayerQuery
import org.bukkit.ChatColor
import org.bukkit.entity.Player

object PlayerCommand {
    fun showStatus(player: Player) {
        val playerDao = PlayerQuery.findById(player.uniqueId)!!
        player.sendMessage(ChatColor.YELLOW.toString() + "[xLevel]")
        player.sendMessage(ChatColor.DARK_RED.toString() + " Nome: " + ChatColor.GRAY + playerDao.nickname)
        player.sendMessage(ChatColor.GOLD.toString() + " Class: " + ChatColor.GRAY + "--")
        player.sendMessage(ChatColor.GREEN.toString() + " Level: " + ChatColor.GRAY + playerDao.level)
        player.sendMessage(ChatColor.DARK_GREEN.toString() + " Exp: " + ChatColor.GRAY + playerDao.exp)
    }
}