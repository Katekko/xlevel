package com.gyanburu

import com.gyanburu.events.BlockEvent
import com.gyanburu.events.InventoryEvent
import com.gyanburu.events.PlayerEvent
import com.gyanburu.sql.PlayerTable
import org.bukkit.plugin.java.JavaPlugin
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection
import java.util.logging.Logger

@Suppress("unused")
class Xlevel : JavaPlugin() {
    // TODO: Como aumentar a quantidade de RAM utilizada pelo servidor?
    override fun onEnable() {
        val absolutPath = dataFolder.absolutePath.substring(0, dataFolder.absolutePath.length - "xlevel".length)
        Database.connect("jdbc:sqlite:$absolutPath/xLevel-data/data.db", "org.sqlite.JDBC")
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(PlayerTable)
        }

        server.pluginManager.registerEvents(PlayerEvent(), this)
        server.pluginManager.registerEvents(BlockEvent(), this)
        server.pluginManager.registerEvents(InventoryEvent(), this)

        super.onEnable()
    }

}