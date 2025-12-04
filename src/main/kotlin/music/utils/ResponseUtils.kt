package com.igra.music.utils

import io.ktor.server.response.*
import io.ktor.server.application.*

suspend fun ApplicationCall.success(data: Any) {
    respond(mapOf("status" to "ok", "data" to data))
}

suspend fun ApplicationCall.error(message: String) {
    respond(mapOf("status" to "error", "message" to message))
}
