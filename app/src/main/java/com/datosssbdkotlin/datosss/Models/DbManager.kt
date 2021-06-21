package com.datosssbdkotlin.datosss.Models

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DbManager (context: Context){

    var dbHelper=DbHelper(context)

    var db: SQLiteDatabase? =null

    fun opneDbWrite(){
        db=dbHelper.writableDatabase
     }
    fun opneDbRead(){
        db=dbHelper.readableDatabase
    }
    fun dbClose(){
        if(db!=null){
            db?.close()
        }
    }
    //creamos metodo para insertar datos a la base de datso
    fun insertData(user: User):Long{

        opneDbWrite()
        var values = ContentValues()

        values.put(Constantes.COLUMN_1, user.name)
        values.put(Constantes.COLUMN_2, user.cedula)
        values.put(Constantes.COLUMN_3, user.age)
        values.put(Constantes.COLUMN_4, user.phone)

        var respuesta= db?.insert(Constantes.NAME_TABLE, null, values)

        return respuesta!!
        dbClose()

    }

    //creamos metodo para listar datos a la base de datso
    fun listData():MutableList<User> {
        opneDbRead()
        var lista:MutableList<User> = ArrayList()
        var respuesta = db?.rawQuery(Constantes.CONSULTA, null)
        if (respuesta!!.moveToFirst()){
            do{
                var user=User()
                user.id=respuesta.getString(respuesta.getColumnIndex(Constantes.COLUMN_0)).toInt()
                user.name=respuesta.getString(respuesta.getColumnIndex(Constantes.COLUMN_1))
                user.cedula=respuesta.getString(respuesta.getColumnIndex(Constantes.COLUMN_2))
                user.age=respuesta.getString(respuesta.getColumnIndex(Constantes.COLUMN_3))
                user.phone=respuesta.getString(respuesta.getColumnIndex(Constantes.COLUMN_4))

                lista.add(user)

            }while (respuesta.moveToNext())
        }
        return lista

        dbClose()
    }

    //creamos metodo para actualizar datos a la base de datos

    fun UpdateData(user: User):Int {
        opneDbWrite()

        var values = ContentValues()
        values.put(Constantes.COLUMN_1, user.name)
        values.put(Constantes.COLUMN_2, user.cedula)
        values.put(Constantes.COLUMN_3, user.age)
        values.put(Constantes.COLUMN_4, user.phone)

        var repuesta = db?.update(Constantes.NAME_TABLE, values, "id=? ", arrayOf(user.id.toString()))

        return repuesta!!

        dbClose()
    }

    //creamos metodo para actualizar datos a la base de datos

    fun deleteUser(user: User){
        opneDbWrite()
        db?.delete(Constantes.NAME_TABLE, "id=?", arrayOf(user.id.toString()))
        dbClose()
    }
}