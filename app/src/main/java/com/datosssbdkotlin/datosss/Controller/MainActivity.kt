package com.datosssbdkotlin.datosss.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.datosssbdkotlin.datosss.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        idBtnMakeRegister.setOnClickListener {
            var intent= Intent(this, SignUpUser::class.java)
            startActivity(intent)
        }

        idBtnListDataUsers.setOnClickListener {
            var intent2= Intent(this, ListDataUsers::class.java)
            startActivity(intent2)
        }

    }
}