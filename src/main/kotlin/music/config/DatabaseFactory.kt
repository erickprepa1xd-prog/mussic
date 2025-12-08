package com.igra.music.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.withContext

object DatabaseFactory {

    fun init() {
        Database.connect(hikari())
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig().apply {
            jdbcUrl = "jdbc:postgresql://localhost:5434/tu_basededatos"
            driverClassName = "org.postgresql.Driver"
            username = "postgres"
            password = "root"   // cambia si usas otra

            maximumPoolSize = 3
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }
        return HikariDataSource(config)
    }

    // ✅ ESTE ES EL IMPORTANTE
    suspend fun <T> dbQuery(block: () -> T): T =
        withContext(Dispatchers.IO) {
            transaction { block() }
        }
}
