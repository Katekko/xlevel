package com.gyanburuworld.xlevel.events

import org.bukkit.Server
import org.bukkit.plugin.Plugin

class EventHandler {
    companion object{
        fun initializer(server : Server, plugin : Plugin){
            server.pluginManager.registerEvents(PlayerHandler(), plugin)
        }
    }
}