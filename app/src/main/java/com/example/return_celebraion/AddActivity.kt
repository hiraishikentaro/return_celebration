package com.example.return_celebraion

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class AddActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val to_event_name = intent.getStringExtra("EVENT_NAME_KEY")

        val textView = findViewById<TextView>(R.id.addEventTitle)

        textView.text = to_event_name

    }
}