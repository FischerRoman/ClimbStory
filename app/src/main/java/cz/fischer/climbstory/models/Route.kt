package cz.fischer.climbstory.models

data class Route(
    val id: Int,
    val sectorId: Int,
    val name: String,
    val length: Int
)
