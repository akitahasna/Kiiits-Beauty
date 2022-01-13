package com.example.latihanui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        val currentuser = auth.currentUser
        if(currentuser !=null){
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
        val DashboardBtn = findViewById<ImageButton>(R.id.imgButtonLog)
        DashboardBtn.setOnClickListener {
            val toMainActivity = Intent(this, MainActivity::class.java)
            startActivity(toMainActivity)
        }
        val TextView = findViewById<Button>(R.id.button)
        TextView.setOnClickListener {
            val intent= Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        login()
    }
    private fun login () {
        imgButtonLog.setOnClickListener{
            if (TextUtils.isEmpty(etEmail.text.toString())){
                etEmail.setError("Please enter email.")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(etPasswd.text.toString())) {
                etPasswd.setError("Please enter password.")
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(etEmail.text.toString(), etPasswd.text.toString())
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Login gagal, silahkan coba lagi.", Toast.LENGTH_LONG).show()
                    }
                }

        }
    }
}