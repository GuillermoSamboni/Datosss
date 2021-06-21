package com.datosssbdkotlin.datosss.Models

class User {
    var id=0
    var name = ""
    var cedula=""
    var age = ""
    var phone = ""


    constructor()

    constructor(id:Int, name: String, cedula: String, age: String, phone: String) {
        this.name = name
        this.cedula = cedula
        this.age = age
        this.phone = phone
    }

    constructor(name: String, cedula: String, age: String, phone: String) {
        this.name = name
        this.cedula = cedula
        this.age = age
        this.phone = phone
    }

    override fun toString(): String {
        return "User(id=$id, name='$name', cedula='$cedula', age='$age', phone='$phone')"
    }


}