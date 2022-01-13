package com.example.latihanui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanui.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity(){
    lateinit var binding: ActivityRegisterBinding
    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    private var nama = ""
    private var email = ""
    private var number = ""
    private var username = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://kiiitsbeauty-78a46-default-rtdb.asia-southeast1.firebasedatabase.app/")
        databaseReference = database?.reference!!.child("profile")


        register()
    }

    private fun register(){
        //get data
        nama = binding.editNama.text.toString().trim()
        email = binding.editEmail.text.toString().trim()
        number = binding.editNumber.text.toString().trim()
        username = binding.editUsername.text.toString().trim()
        password = binding.editPassword.text.toString().trim()
        imgButtonAdd.setOnClickListener {

            if (TextUtils.isEmpty(editNama.text.toString())) {
                editNama.setError("Tolong isi Nama anda!")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(editEmail.text.toString())) {
                editEmail.setError("Tolong isi Email anda!")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(editNumber.text.toString())) {
                editNumber.setError("Tolong isi Nomor Telepon anda!")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(editUsername.text.toString())) {
                editUsername.setError("Tolong isi Username anda!")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(editPassword.text.toString())) {
                editPassword.setError("Tolong isi Password anda!")
                return@setOnClickListener
            } else if (chxbox.isChecked){
                finish()
            }


            auth.createUserWithEmailAndPassword(editEmail.text.toString(), editPassword.text.toString())
                .addOnCompleteListener() {
                    if(it.isSuccessful){
                        val currentUser = auth.currentUser
                        val currentUserDb = databaseReference?.child((currentUser?.uid!!))
                        currentUserDb?.child("Nama")?.setValue(editNama.text.toString())
                        currentUserDb?.child("Email")?.setValue(editEmail.text.toString())
                        currentUserDb?.child("Username")?.setValue(editUsername.text.toString())
                        currentUserDb?.child("Number")?.setValue(editNumber.text.toString())
                        currentUserDb?.child("Password")?.setValue(editPassword.text.toString())
                        chxbox.isChecked = true

                        Toast.makeText(this@RegisterActivity, "Registrasi Berhasil.", Toast.LENGTH_LONG).show()

                        finish()
                    }
                    else {
                        Toast.makeText(this@RegisterActivity, "Registrasi gagal, silahkan coba lagi.", Toast.LENGTH_LONG).show()
                    }
                }

        }
    }

}