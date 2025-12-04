package com.igra.music.services

import com.igra.music.config.DatabaseFactory.dbQuery
import com.igra.music.models.*
import com.igra.music.tables.TracksTable
import org.jetbrains.exposed.sql.*
import java.util.*

class TrackService {

    fun create(req: TrackRequest): TrackResponse = dbQuery {
        val id = UUID.randomUUID()

        TracksTable.insert {
            it[TracksTable.id] = id
            it[title] = req.title
            it[duration] = req.duration
            it[albumId] = req.albumId
        }

        TrackResponse(id, req.title, req.duration, req.albumId)
    }
}
