package com.igra.music.routes

import com.igra.music.models.*
import com.igra.music.services.TrackService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.tracksRoutes() {

    val service = TrackService()

    route("/tracks") {

        post {
            val request = call.receive<TrackRequest>()
            val result = service.create(request)
            call.respond(result)
        }
    }
}
