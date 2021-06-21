package com.datosssbdkotlin.datosss.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.datosssbdkotlin.datosss.Models.DbManager
import com.datosssbdkotlin.datosss.Models.User
import com.datosssbdkotlin.datosss.R
import kotlinx.android.synthetic.main.activity_list_data_users.*
import kotlinx.android.synthetic.main.activity_main.*

class ListDataUsers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data_users)

        var dbManager=DbManager(this)

        var arrayAdapter=ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, dbManager.listData())

        idListDataUsers.adapter=arrayAdapter
        idListDataUsers.setOnItemClickListener { parent, view, position, id ->
            var datos= parent.getItemAtPosition(position).toString()
            var listaArray= datos.split(" ")
            var intent = Intent(this, UpdateDataUser::class.java)
            intent.putExtra("name", listaArray.get(0).toString())
            startActivity(intent)
        }
    }
}