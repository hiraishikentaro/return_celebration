package com.example.return_celebraion

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class userDBAdapter(mContext: Context){
    private val db: SQLiteDatabase
    private val userDB : userDBHelper

    init {
        userDB = userDBHelper(mContext)
        db = userDB.writableDatabase
    }

    fun addRecord(event_name : String, to_name : String, received : String, day :Int, present : String, check : Int ){
        val values = ContentValues()
        values.put("eventname", event_name)
        values.put("toname", to_name)
        values.put("received", received)
        values.put("date",day)
        values.put("forpresent", present)
        values.put("donecheck", check)

        db.insertOrThrow("event", null, values)
    }

    fun getEventList(): String{
        val selectQql : String = "select distinct eventname from " + "event"
        val cursor : Cursor = db.rawQuery(selectQql, arrayOf())

        var Result : String = ""

        try {
            if (cursor.moveToNext()){
                Result = cursor.getString(cursor.getColumnIndex("event_name"))
            }
        }finally {
            cursor.close()
        }
        return Result
    }



}