package cz.fischer.climbstory

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "climbing_app.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE Country (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT NOT NULL)")
        db.execSQL("CREATE TABLE Scale (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT NOT NULL)")
        db.execSQL("CREATE TABLE Grade (ID INTEGER PRIMARY KEY AUTOINCREMENT, ScaleId INTEGER NOT NULL, Name TEXT NOT NULL, Weight INTEGER NOT NULL, FOREIGN KEY (ScaleId) REFERENCES Scale(ID))")
        db.execSQL("CREATE TABLE Style (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT NOT NULL, Abbreviation TEXT NOT NULL, Description TEXT)")
        db.execSQL("CREATE TABLE Area (ID INTEGER PRIMARY KEY AUTOINCREMENT, CountryId INTEGER NOT NULL, ScaleId INTEGER NOT NULL, Name TEXT NOT NULL, FOREIGN KEY (CountryId) REFERENCES Country(ID), FOREIGN KEY (ScaleId) REFERENCES Scale(ID))")
        db.execSQL("CREATE TABLE Sector (ID INTEGER PRIMARY KEY AUTOINCREMENT, AreaId INTEGER NOT NULL, Name TEXT NOT NULL, FOREIGN KEY (AreaId) REFERENCES Area(ID))")
        db.execSQL("CREATE TABLE Route (ID INTEGER PRIMARY KEY AUTOINCREMENT, SectorId INTEGER NOT NULL, Name TEXT NOT NULL, Length INTEGER NOT NULL, FOREIGN KEY (SectorId) REFERENCES Sector(ID))")
        db.execSQL("CREATE TABLE User (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT NOT NULL)")
        db.execSQL("CREATE TABLE Ascent (ID INTEGER PRIMARY KEY AUTOINCREMENT, UserId INTEGER NOT NULL, StyleId INTEGER NOT NULL, RouteId INTEGER NOT NULL, Date DATE NOT NULL, FOREIGN KEY (UserId) REFERENCES User(ID), FOREIGN KEY (StyleId) REFERENCES Style(ID), FOREIGN KEY (RouteId) REFERENCES Route(ID))")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Country")
        db.execSQL("DROP TABLE IF EXISTS Scale")
        db.execSQL("DROP TABLE IF EXISTS Grade")
        db.execSQL("DROP TABLE IF EXISTS Style")
        db.execSQL("DROP TABLE IF EXISTS Area")
        db.execSQL("DROP TABLE IF EXISTS Sector")
        db.execSQL("DROP TABLE IF EXISTS Route")
        db.execSQL("DROP TABLE IF EXISTS User")
        db.execSQL("DROP TABLE IF EXISTS Ascent")
        onCreate(db)
    }
}