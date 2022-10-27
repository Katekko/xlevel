package com.gyanburuworld.xlevel

import com.gyanburuworld.xlevel.events.EventHandler
import com.gyanburuworld.xlevel.infrastructure.SqlHandler
import org.bukkit.plugin.java.JavaPlugin

class Xlevel : JavaPlugin() {
    override fun onEnable() {
        SqlHandler.initialize(dataFolder)
        EventHandler.initializer(server, this)
        super.onEnable()
    }
}