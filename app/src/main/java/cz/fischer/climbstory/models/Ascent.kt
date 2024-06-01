package cz.fischer.climbstory.models

import java.time.LocalDate

data class Ascent(
    val id: Int,
    val userId: Int,
    val styleId: Int,
    val routeId: Int,
    val date: LocalDate
)
