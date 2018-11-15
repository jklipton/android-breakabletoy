package com.example.kon7865.transagotchi.util

import java.util.*

data class Gotchi(
    var name: String,
    var identity: String,
    var support: Int,
    var events: Set<Objects>
)