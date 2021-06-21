package com.datosssbdkotlin.datosss.Models

class Constantes {
    companion object{
        val NAME_DATA_BASE="USERS_BASE"
        val VERSION_DATA_BASE=1

        val COLUMN_0= "id"
        val COLUMN_1= "name"
        val COLUMN_2= "cedula"
        val COLUMN_3= "age"
        val COLUMN_4= "phone"

        val NAME_TABLE= "UserTable"

        val TABLE= " CREATE TABLE " + NAME_TABLE+
        " (" +
                COLUMN_0 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_1 + " TEXT , "+
                COLUMN_2 + " TEXT , "+
                COLUMN_3 + " TEXT , " +
                COLUMN_4 + " TEXT " +
        " ) "

        val CONSULTA=" SELECT * FROM " + NAME_TABLE + ""
    }
}