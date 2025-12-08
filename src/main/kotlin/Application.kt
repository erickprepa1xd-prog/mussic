package com

import com.igra.music.plugins.configureMonitoring
import com.igra.music.plugins.configureHTTP
import com.igra.music.config.DatabaseFactory
import com.igra.music.plugins.configureSerialization
import com.igra.music.plugins.configureRouting
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {

    DatabaseFactory.init()
    configureMonitoring()
    configureSerialization()
    configureHTTP()
    configureRouting()
}
