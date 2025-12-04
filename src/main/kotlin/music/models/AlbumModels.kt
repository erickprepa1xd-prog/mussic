package com.igra.music.models

import java.util.*

data class AlbumRequest(
    val title: String,
    val releaseYear: Int,
    val artistId: UUID
)

data class AlbumResponse(
    val id: UUID,
    val title: String,
    val releaseYear: Int,
    val artistId: UUID
)
