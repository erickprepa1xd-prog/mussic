package com.igra.music.models

import java.util.*

data class ArtistRequest(
    val name: String,
    val genre: String
)

data class ArtistResponse(
    val id: UUID,
    val name: String,
    val genre: String
)
