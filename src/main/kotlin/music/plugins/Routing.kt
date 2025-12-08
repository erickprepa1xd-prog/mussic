package com.igra.music.plugins

import com.igra.music.routes.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("API Music funcionando ✅")
        }

        artistasRoutes()
        albumesRoutes()
        tracksRoutes()
    }
}
