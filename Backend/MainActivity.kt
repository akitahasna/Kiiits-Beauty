package com.example.latihanui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ImageView = findViewById<ImageView>(R.id.imageView3)
        ImageView.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        val ImageView2 = findViewById<TextView>(R.id.textView3)
        ImageView2.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            startActivity(intent)
        }
        val ImageView2a = findViewById<ImageView>(R.id.imageView4)
        ImageView2a.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            startActivity(intent)
        }
        val ImageView3 = findViewById<TextView>(R.id.textView4)
        ImageView3.setOnClickListener {
            val intent = Intent(this, ContentActivity2::class.java)
            startActivity(intent)
        }
        val ImageView3a = findViewById<ImageView>(R.id.imageView5)
        ImageView3a.setOnClickListener {
            val intent = Intent(this, ContentActivity2::class.java)
            startActivity(intent)
        }
        val ImageView4 = findViewById<TextView>(R.id.textView5)
        ImageView4.setOnClickListener {
            val intent = Intent(this, ContentActivity3::class.java)
            startActivity(intent)
        }
        val ImageView4a = findViewById<ImageView>(R.id.imageView6)
        ImageView4a.setOnClickListener {
            val intent = Intent(this, ContentActivity3::class.java)
            startActivity(intent)
        }
    }
}