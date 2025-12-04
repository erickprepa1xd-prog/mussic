package com.igra.music.routes

import com.igra.music.models.*
import com.igra.music.services.ArtistaService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Route.artistasRoutes() {

    val service = ArtistaService()

    route("/artistas") {

        post {
            val request = call.receive<ArtistRequest>()
            val result = service.create(request)
            call.respond(result)
        }

        get {
            call.respond(service.getAll())
        }

        get("/{id}") {
            val id = UUID.fromString(call.parameters["id"])
            val artista = service.getById(id)
            if (artista != null)
                call.respond(artista)
            else
                call.respondText("Artista no encontrado")
        }

        delete("/{id}") {
            val id = UUID.fromString(call.parameters["id"])
            val deleted = service.delete(id)
            call.respond(mapOf("deleted" to deleted))
        }
    }
}
