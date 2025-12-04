package com.igra.music.tables

import org.jetbrains.exposed.sql.Table
import java.util.*

object AlbumesTable : Table("albumes") {
    val id = uuid("id").clientDefault { UUID.randomUUID() }
    val title = varchar("title", 150)
    val releaseYear = integer("release_year")
    val artistId = uuid("artist_id")

    override val primaryKey = PrimaryKey(id)
}
