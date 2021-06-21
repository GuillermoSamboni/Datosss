package com.datosssbdkotlin.datosss.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.datosssbdkotlin.datosss.Models.DbManager
import com.datosssbdkotlin.datosss.Models.User
import com.datosssbdkotlin.datosss.R
import kotlinx.android.synthetic.main.activity_sign_up_user.*

class SignUpUser : AppCompatActivity() {

    var db = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_user)

        idBtnSaveRegister.setOnClickListener {
            insert()
        }

    }

     fun insert() {

         var user = User(idTxtName.text.toString(), idTxtCedula.text.toString(), idTxtAge.text.toString(), idTxtPhone.text.toString())
         var respuesta = db.insertData(user)

         if (respuesta > 0) {
             Toast.makeText(this, "SAVE REGISTER", Toast.LENGTH_SHORT).show()
         } else {
             Toast.makeText(this, "REGISTER NOT SAVE", Toast.LENGTH_SHORT).show()
         }
     }
}