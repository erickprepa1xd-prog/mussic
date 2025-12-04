package com.igra.music.routes

import com.igra.music.models.*
import com.igra.music.services.AlbumService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Route.albumesRoutes() {

    val service = AlbumService()

    route("/albumes") {

        post {
            val request = call.receive<AlbumRequest>()
            val result = service.create(request)
            call.respond(result)
        }

        get("/{id}") {
            val id = UUID.fromString(call.parameters["id"])
            val album = service.getById(id)
            if (album != null)
                call.respond(album)
            else
                call.respondText("Álbum no encontrado")
        }
    }
}
