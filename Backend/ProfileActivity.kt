package com.example.latihanui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://kiiitsbeauty-78a46-default-rtdb.asia-southeast1.firebasedatabase.app/")
        databaseReference = database?.reference!!.child("profile")

        val MainBtn = findViewById<Button>(R.id.button9)
        MainBtn.setOnClickListener {
            val toMainActivity = Intent(this, MainActivity::class.java)
            startActivity(toMainActivity)
        }
        val TextView = findViewById<Button>(R.id.button2)
        TextView.setOnClickListener {
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val TextViews = findViewById<Button>(R.id.button6)
        TextViews.setOnClickListener {
            val intent= Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
        val user = auth.currentUser

        if (user != null){
            if (user.photoUrl != null){
                Picasso.get().load(user.photoUrl).into(imageView10)
            }else{
                Picasso.get().load("https://picsum.photos/id/1002/4312/2868").into(imageView10)
            }
            loadProfile()
        }
    }



    private fun loadProfile(){

        val user = auth.currentUser
        val userRef = databaseReference?.child(user?.uid!!)

        button4.text = user?.email

        userRef?.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                button5.text = snapshot.child("Username").value.toString()
                textView14.text = snapshot.child("Nama").value.toString()
                button3.text = snapshot.child("Number").value.toString()

            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        button2.setOnClickListener{
            auth.signOut()
            startActivity(Intent(this@ProfileActivity, LoginActivity::class.java))
            finish()
        }
    }
}