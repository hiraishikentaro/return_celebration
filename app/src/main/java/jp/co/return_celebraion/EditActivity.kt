package jp.co.return_celebraion

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit.*
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.update

class EditActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val to_event_name = intent.getStringExtra("EVENT_NAME_KEY")
        val toname = intent.getStringExtra("TO_NAME_KEY")
        val received = intent.getStringExtra("TO_REC")
        val present = intent.getStringExtra("FOR_PRESENT")


        findViewById<TextView>(R.id.editEventTitle).text = to_event_name
        findViewById<TextView>(R.id.editToName).text = toname

        findViewById<EditText>(R.id.editForReceived).setText(received)
        findViewById<EditText>(R.id.editForYou).setText(present)

        val helper = userDBHelper.getInstance(this)

        detailAdd.setOnClickListener {

            val for_received_edit = findViewById<EditText>(R.id.editForReceived)
            val for_received = for_received_edit.text.toString()

            val for_you_edit = findViewById<EditText>(R.id.editForYou)
            val for_you = for_you_edit.text.toString()

            if (toname.length == 0 || for_received.length == 0 || for_you.length == 0){
                toastMake("空白部分があります",0,-200)
            }
            else{
                helper.readableDatabase.update(userDBHelper.tableName, "received" to for_received, "forpresent" to for_you)
                    .whereSimple("toname = ?", toname).exec()
                val intent = Intent(this, Detail_Activity::class.java)
                intent.putExtra("EVENT_NAME_KEY",to_event_name)
                startActivity(intent)
            }
        }

        buttonDone.setOnClickListener {
            val for_received_edit = findViewById<EditText>(R.id.editForReceived)
            val for_received = for_received_edit.text.toString()

            val for_you_edit = findViewById<EditText>(R.id.editForYou)
            val for_you = for_you_edit.text.toString()

            if (toname.length == 0 || for_received.length == 0 || for_you.length == 0){
                toastMake("空白部分があります",0,-200)
            }
            else{
                helper.readableDatabase.update(userDBHelper.tableName, "received" to for_received, "forpresent" to for_you, "donecheck" to "1")
                    .whereSimple("toname = ?", toname).exec()
                val intent = Intent(this, Detail_Activity::class.java)
                intent.putExtra("EVENT_NAME_KEY",to_event_name)
                startActivity(intent)

            }
        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, Detail_Activity::class.java)
            intent.putExtra("EVENT_NAME_KEY",to_event_name)
            startActivity(intent)
        }

        buttonDelete.setOnClickListener {
            helper.readableDatabase.delete(userDBHelper.tableName, "toname = {toName}", "toName" to toname)
            val intent = Intent(this, Detail_Activity::class.java)
            intent.putExtra("EVENT_NAME_KEY",to_event_name)
            startActivity(intent)
        }
    }

    private fun toastMake(message: String, x: Int, y: Int) {
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_LONG)
        // 位置調整
        toast.setGravity(Gravity.CENTER, x, y)
        toast.show()
    }

}