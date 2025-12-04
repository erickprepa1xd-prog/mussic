package com.igra.music.tables

import org.jetbrains.exposed.sql.Table
import java.util.*

object ArtistasTable : Table("artistas") {
    val id = uuid("id").clientDefault { UUID.randomUUID() }
    val name = varchar("name", 100)
    val genre = varchar("genre", 50)

    override val primaryKey = PrimaryKey(id)
}
