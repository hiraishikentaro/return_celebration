package com.example.return_celebraion

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


val DB_TABLE_NAME = "event.db"

class userDBHelper (var mContext: Context?) : SQLiteOpenHelper(mContext, DB_TABLE_NAME, null, 1) {
    //  SQLiteOpenHelper
    // 第１引数 :
    // 第２引数 : データベースの名称
    // 第３引数 : null
    // 第４引数 : データベースのバージョン

    override fun onCreate(db: SQLiteDatabase?) {
        // テーブルがなかったときに が呼ばれる
        // execSQL で　クエリSQL文を実行 これでDBの構造が決定
        db?.execSQL(
            "CREATE TABLE " + DB_TABLE_NAME + " ( " +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "event_name text not null," +
                    "to_name text not null, "+
                    "received text not null " +
                    "date text not null, " +
                    "present text not null, " +
                    "check int not null, " +
                    ");")
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // バージョンが変わった時に実行される
        db?.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME + ";")
        onCreate(db);
        // 今回は,一度消して、作り直ししてます　
    }
}
