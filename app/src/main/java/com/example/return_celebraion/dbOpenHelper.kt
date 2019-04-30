package com.example.return_celebraion

import android.content.Context
import android.database.sqlite.SQLiteDatabase

import org.jetbrains.anko.db.ManagedSQLiteOpenHelper
import org.jetbrains.anko.db.TEXT
import org.jetbrains.anko.db.createTable
import org.jetbrains.anko.db.INTEGER

val DB_TABLE_NAME = "eventdb.db"

class userDBHelper (var context: Context) : ManagedSQLiteOpenHelper(context, DB_TABLE_NAME, null, 1) {

    companion object {
        val tableName = "event"
        private var instance : userDBHelper? = null;

        fun getInstance(context: Context):userDBHelper{
            return instance ?: userDBHelper(context.applicationContext)!!
        }

    }

    override fun onCreate(db: SQLiteDatabase?) {
        // テーブルがなかったときに が呼ばれる
        // execSQL で　クエリSQL文を実行 これでDBの構造が決定
        db?.run {createTable(tableName, ifNotExists = true,
            columns = *arrayOf("eventname" to TEXT, "toname" to TEXT, "received" to TEXT, "date" to TEXT, "forpresent" to TEXT, "donecheck" to TEXT))

        }
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}
