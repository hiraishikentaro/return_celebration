package com.example.return_celebraion

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.db.select
import org.jetbrains.anko.tableRow

class Detail_Activity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val to_event_name = intent.getStringExtra("EVENT_NAME_KEY")

        val textView = findViewById<TextView>(R.id.eventTitle)

        textView.text = to_event_name

        val helper = userDBHelper.getInstance(this)
        val dataList = helper.readableDatabase.select(userDBHelper.tableName, "toname", "received", "date", "forpresent", "donecheck")
            .whereArgs("eventname = {eventName}", "eventName" to to_event_name)
            .parseList(DetailEventDataParser())

        detailList.adapter = DetailEventAdapter(baseContext, R.layout.table).apply {
            addAll(dataList)
        }


        addDetail.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            intent.putExtra("EVENT_NAME_KEY",to_event_name)
            startActivity(intent)
        }
        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonList.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

    }
}