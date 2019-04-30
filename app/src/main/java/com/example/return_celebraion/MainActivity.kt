package com.example.return_celebraion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit private var userDB : userDBAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        userDB = userDBAdapter(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRegist.setOnClickListener{
            val intent = Intent(this, RegistActivity::class.java)
            startActivity(intent)
        }
        buttonManage.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }


    }
}
