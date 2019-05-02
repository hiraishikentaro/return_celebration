package com.example.return_celebraion

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*
import org.jetbrains.anko.db.select

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val helper = userDBHelper.getInstance(this)
        val dataList = helper.readableDatabase.select(userDBHelper.tableName,"eventname").distinct().parseList(EventListDataParser())

        list.adapter = EventListAdapter(baseContext, R.layout.row).apply {
            addAll(dataList)
        }

        list.setOnItemClickListener { adapterView, view, i, l ->
            val textView = view.findViewById<TextView>(R.id.rowEventName)
            //Toast.makeText(this,"Clicked: ${textView.text}", Toast.LENGTH_SHORT).show()
            val to_event_name = textView.text.toString()
            val intent = Intent(this, Detail_Activity::class.java)
            intent.putExtra("EVENT_NAME_KEY", to_event_name)
            startActivity(intent)
        }

        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}