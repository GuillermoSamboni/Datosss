package com.datosssbdkotlin.datosss.Models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.datosssbdkotlin.datosss.Models.Constantes.Companion.TABLE

class DbHelper(
    context: Context?
) : SQLiteOpenHelper(context, Constantes.NAME_DATA_BASE, null, Constantes.VERSION_DATA_BASE) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}