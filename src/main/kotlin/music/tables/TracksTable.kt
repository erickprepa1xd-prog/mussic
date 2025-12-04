package com.igra.music.tables

import org.jetbrains.exposed.sql.Table
import java.util.*

object TracksTable : Table("tracks") {
    val id = uuid("id").clientDefault { UUID.randomUUID() }
    val title = varchar("title", 150)
    val duration = integer("duration")
    val albumId = uuid("album_id")

    override val primaryKey = PrimaryKey(id)
}
