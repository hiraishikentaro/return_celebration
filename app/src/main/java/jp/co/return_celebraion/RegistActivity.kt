package jp.co.return_celebraion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_regist.*

import android.view.Gravity
import android.widget.Toast


class RegistActivity : AppCompatActivity(){
    lateinit private var userDB : userDBAdapter
    override fun onCreate(savedInstanceState: Bundle?){
        userDB = userDBAdapter(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)


        buttonAdd.setOnClickListener {
            val eventname = getEventName()
            if (eventname.length == 0){
                toastMake("イベント名を入力してください",0,-200)
            }
            else {
                userDB.addRecord(eventname, "1","1","1","1",0)
                val intent = Intent(this, ListActivity::class.java)
                startActivity(intent)
            }

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

    fun getEventName():String{
        val eventName = findViewById<EditText>(R.id.newEventName)
        return eventName.text.toString()
    }

    private fun toastMake(message: String, x: Int, y: Int) {
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_LONG)
        // 位置調整
        toast.setGravity(Gravity.CENTER, x, y)
        toast.show()
    }


}