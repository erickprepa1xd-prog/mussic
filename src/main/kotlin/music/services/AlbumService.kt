package com.igra.music.services

import com.igra.music.config.DatabaseFactory.dbQuery
import com.igra.music.models.*
import com.igra.music.tables.AlbumesTable
import org.jetbrains.exposed.sql.*
import java.util.*

class AlbumService {

    suspend fun create(req: AlbumRequest): AlbumResponse = dbQuery {
        val id = UUID.randomUUID()

        AlbumesTable.insert {
            it[AlbumesTable.id] = id
            it[title] = req.title
            it[releaseYear] = req.releaseYear
            it[artistId] = req.artistId
        }

        AlbumResponse(id, req.title, req.releaseYear, req.artistId)
    }

    suspend fun getById(id: UUID): AlbumResponse? = dbQuery {
        AlbumesTable.select { AlbumesTable.id eq id }
            .map {
                AlbumResponse(
                    it[AlbumesTable.id],
                    it[AlbumesTable.title],
                    it[AlbumesTable.releaseYear],
                    it[AlbumesTable.artistId]
                )
            }.singleOrNull()
    }
}
