package com.igra.music.services

import com.igra.music.config.DatabaseFactory.dbQuery
import com.igra.music.models.*
import com.igra.music.tables.ArtistasTable
import org.jetbrains.exposed.sql.*
import java.util.*
import org.jetbrains.exposed.sql.deleteWhere


class ArtistaService {

    suspend fun create(req: ArtistRequest): ArtistResponse = dbQuery {
        val id = UUID.randomUUID()

        ArtistasTable.insert {
            it[ArtistasTable.id] = id
            it[ArtistasTable.name] = req.name
            it[ArtistasTable.genre] = req.genre   // puede ser null
        }

        ArtistResponse(id, req.name, req.genre)
    }

    suspend fun getById(id: UUID): ArtistResponse? = dbQuery {
        ArtistasTable
            .select { ArtistasTable.id eq id }
            .map {
                ArtistResponse(
                    it[ArtistasTable.id],
                    it[ArtistasTable.name],
                    it[ArtistasTable.genre]   // <-- aquí estaba el error 2
                )
            }
            .singleOrNull()
    }

    suspend fun getAll(): List<ArtistResponse> = dbQuery {
        ArtistasTable
            .selectAll()
            .map {
                ArtistResponse(
                    it[ArtistasTable.id],
                    it[ArtistasTable.name],
                    it[ArtistasTable.genre]   // <-- aquí también
                )
            }
    }

  suspend fun delete(artistId: UUID): Boolean = dbQuery {
    ArtistasTable.deleteWhere { ArtistasTable.id eq artistId } > 0
}

}
