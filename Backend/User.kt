package com.example.latihanui

import com.google.firebase.database.Exclude

data class User(val nama: String? = null, val username: String? = null, val number: String? = null, val email: String? = null, val password: String? = null, val uid: String? = null){
    @Exclude
    fun getMap(): Map<String, Any?> {
        return mapOf(
            "Nama" to nama,
            "Username" to username,
            "Number" to number,
            "Password" to password,
            "Uid" to uid,
            "Email" to email,
        )
    }
}