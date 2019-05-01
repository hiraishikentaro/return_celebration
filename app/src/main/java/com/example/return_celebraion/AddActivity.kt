package com.example.return_celebraion

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import java.text.SimpleDateFormat
import java.util.*

class AddActivity :AppCompatActivity(){

    lateinit private var userDB : userDBAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        userDB = userDBAdapter(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val to_event_name = intent.getStringExtra("EVENT_NAME_KEY")

        val textView = findViewById<TextView>(R.id.addEventTitle)

        textView.text = to_event_name

        val df = SimpleDateFormat("yy/MM/dd")
        val date = Date()

        val today : String = df.format(date)


        detailAdd.setOnClickListener {
            val toname_edit = findViewById<EditText>(R.id.toName)
            val toname = toname_edit.text.toString()

            val for_received_edit = findViewById<EditText>(R.id.forReceived)
            val for_received = for_received_edit.text.toString()

            val for_you_edit = findViewById<EditText>(R.id.forYou)
            val for_you = for_you_edit.text.toString()

            if (toname.length == 0 || for_received.length == 0 || for_you.length == 0){
                toastMake("空白部分があります",0,-200)
            }
            else{
                userDB.addRecord(to_event_name, toname,for_received,today,for_you,0)
                val intent = Intent(this, Detail_Activity::class.java)
                intent.putExtra("EVENT_NAME_KEY",to_event_name)
                startActivity(intent)
            }
        }
    }


    private fun toastMake(message: String, x: Int, y: Int) {
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_LONG)
        // 位置調整
        toast.setGravity(Gravity.CENTER, x, y)
        toast.show()
    }


}