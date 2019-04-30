package com.example.return_celebraion

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class ListActivity : AppCompatActivity() {
    lateinit private var userDB : userDBAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        userDB = userDBAdapter(this)
        var event_list : String = userDB.getEventList()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }
}