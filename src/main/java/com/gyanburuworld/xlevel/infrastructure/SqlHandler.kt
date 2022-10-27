package com.gyanburuworld.xlevel.infrastructure

import com.gyanburuworld.xlevel.infrastructure.daos.PlayerTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class SqlHandler {
    companion object {
        fun initialize(dataFolder : File) {
            val absolutPath = dataFolder.absolutePath.substring(0, dataFolder.absolutePath.length - "xlevel".length)
            Files.createDirectories(Paths.get("$absolutPath/xLevel-data/"))
            Database.connect("jdbc:sqlite:$absolutPath/xLevel-data/data.db", "org.sqlite.JDBC")
            TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
            transaction {
                addLogger(StdOutSqlLogger)
                SchemaUtils.create(PlayerTable)
            }
        }
    }
}