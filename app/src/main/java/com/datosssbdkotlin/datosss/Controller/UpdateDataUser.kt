package com.datosssbdkotlin.datosss.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.datosssbdkotlin.datosss.Models.DbManager
import com.datosssbdkotlin.datosss.Models.User
import com.datosssbdkotlin.datosss.R
import kotlinx.android.synthetic.main.activity_update_data_user.*

class UpdateDataUser : AppCompatActivity() {
    var db=DbManager(this)

    var id=""
    var name = ""
    var cedula=""
    var age = ""
    var phone = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data_user)
        datos()

        idBtnDeleteUser.setOnClickListener {
            update()
        }
        idBtnDeleteUser.setOnClickListener {
            delete()
        }

    }
    fun datos(){

        var bundle= intent.extras

        id = bundle?.get("id").toString()
        name = bundle?.get("name").toString()
        cedula = bundle?.get("cedula").toString()
        age = bundle?.get("age").toString()
        phone = bundle?.get("phone").toString()


        idTxtNameUpdate.setText(name.toString())
        idTxtCedulaUpdate.setText(cedula.toString())
        idTxtAgeUpdate.setText(age.toString())
        idTxtPhoneUpdate.setText(phone.toString())

    }
    fun update(){
        db.UpdateData(User(id.toInt(),idTxtNameUpdate.text.toString(),
            idTxtCedulaUpdate.text.toString(),
            idTxtAgeUpdate.text.toString(),
            idTxtPhoneUpdate.text.toString()))
    }
    fun delete(){

        db.deleteUser(User(id.toInt(),"", "", "", ""))

        var intent=Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

}