package com.interview.eventtask.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.interview.eventtask.model.Event
import com.interview.eventtask.model.EventTaskModel

class DatabaseHandler (context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSIOM) {

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_EVENTS = "CREATE TABLE $TABLE_NAME_EVENTS " +
                "($ID Integer PRIMARY KEY, $NAME TEXT, $LOCAL_DATE TEXT, $LOCAL_TIME TEXT, $INFO TEXT)"

        val CREATE_TABLE_VENUES = "CREATE TABLE $TABLE_NAME_VENUE " +
                "($VENUE_ID Integer PRIMARY KEY, $CITY TEXT, $STATE TEXT, $COUNTRY TEXT, $LONGITUDE TEXT, $LATITUDE TEXT)"
        db?.execSQL(CREATE_TABLE_EVENTS)
        db?.execSQL(CREATE_TABLE_VENUES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Called when the database needs to be upgraded
    }

    //Inserting (Creating) data
    fun addUser(user: EventTaskModel): Boolean {
        //Create and/or open a database that will be used for reading and writing.
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME, user.name)
        values.put(LOCAL_DATE, user.localDate)
        values.put(LOCAL_TIME, user.localTime)
        val _success = db.insert(TABLE_NAME_EVENTS, null, values)
        db.close()
        Log.v("InsertedID", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }

    fun getAllEvent(): String {
        var allEvent: String = "";
        val db = readableDatabase
        val selectALLQuery = "SELECT * FROM $TABLE_NAME_EVENTS"
        val cursor = db.rawQuery(selectALLQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    var id = cursor.getString(cursor.getColumnIndex(ID))
                    var name = cursor.getString(cursor.getColumnIndex(NAME))
                    var date = cursor.getString(cursor.getColumnIndex(LOCAL_DATE))

                    allEvent = "$allEvent\n$id $name $date"
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return allEvent
    }

    companion object {
        private val DB_NAME = "UsersDB"
        private val DB_VERSIOM = 1;
        private val TABLE_NAME_EVENTS = "events"
        private val TABLE_NAME_VENUE = "venues"

        private val ID = "id"
        private val NAME = "name"
        private val LOCAL_DATE = "localDate"
        private val LOCAL_TIME = "localTime"
        private val INFO = "info"

        private val VENUE_ID = "id"
        private val CITY = "city"
        private val STATE = "state"
        private val COUNTRY = "country"
        private val LONGITUDE = "longitude"
        private val LATITUDE = "latitude"

    }
}