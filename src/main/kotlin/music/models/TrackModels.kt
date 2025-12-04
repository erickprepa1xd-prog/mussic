package com.igra.music.models

import java.util.*

data class TrackRequest(
    val title: String,
    val duration: Int,
    val albumId: UUID
)

data class TrackResponse(
    val id: UUID,
    val title: String,
    val duration: Int,
    val albumId: UUID
)
