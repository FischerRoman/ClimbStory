package cz.fischer.climbstory.repository

import android.content.Context
import cz.fischer.climbstory.DatabaseHelper
import cz.fischer.climbstory.models.Ascent
import java.time.LocalDate

class AscentRepository(context: Context) {

    private val databaseHelper: DatabaseHelper = DatabaseHelper(context)

    fun getAllAscents(): List<Ascent> {
        val db = databaseHelper.readableDatabase
        val cursor = db.query("Ascent", null, null, null, null, null, null)
        val ascents = mutableListOf<Ascent>()
        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow("ID"))
                val userId = getInt(getColumnIndexOrThrow("UserId"))
                val styleId = getInt(getColumnIndexOrThrow("StyleId"))
                val routeId = getInt(getColumnIndexOrThrow("RouteId"))
                val date = LocalDate.parse(getString(getColumnIndexOrThrow("Date")))  // Convert String to LocalDate
                val ascent = Ascent(id, userId, styleId, routeId, date)
                ascents.add(ascent)
            }
        }
        cursor.close()
        return ascents
    }
}
