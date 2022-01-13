package com.example.latihanui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ContentActivity2 : AppCompatActivity() {
    private var adapter3: RecyclerView.Adapter<*>? = null
    private lateinit var recyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content2)
        recyclerView2 = findViewById(R.id.viewMostView)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        with(recyclerView2) {
                this?.setLayoutManager(linearLayoutManager)
        }

        val ImageView7 = findViewById<ImageView>(R.id.img5)
        ImageView7.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            startActivity(intent)
        }
        val ImageView8 = findViewById<ImageView>(R.id.img6)
        ImageView8.setOnClickListener {
            val intent = Intent(this, ContentActivity3::class.java)
            startActivity(intent)
        }

        val mostviewed = ArrayList<MostViewedDomain>()
        with(recyclerView2) {
            mostviewed.add(
                MostViewedDomain(
                    "Npure Sunscreen",
                    "Tabir surya harian alami dengan SPF 50 PA ++++ menjaga kulit dari paparan sinar UVA & UVB sekaligus melembapkan dan menenangkan kulit.",
                    "npure"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Pyunkang Yul Cream",
                    "Pyunkang Yul Nutrition Cream adalah krim yang memberikan nutrisi dan kelembapan ke dalam kulit untuk menghasilkan kulit yang lebih cerah.",
                    "pyunkang"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Maybelline Lip Cream",
                    "Lip cream terbaik dari Maybelline yang semakin memperkuat karaktermu dengan tekstur cair dan melembabkan serta memberikan hasil warna intens.",
                    "maybelline"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Dear Me Beauty Foundation",
                    "Alas bedak cair ringan seperti non-komedogenik untuk menyatukan warna kulit yang tidak rata untuk hasil akhir kulit kedua yang halus dan abadi.",
                    "dearme"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Cosrx Facial Wash",
                    "Pembersih wajah dengan formula lembut yang bagus digunakan pada pagi hari yang mampu membersihkan kulit sensitif sekalipun.",
                    "cosrx"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Lacoco Essence",
                    "Dark Spot Essence merupakan essence yang Diformulasikan dengan bahan terbaik yang dapat membantu menjaga kulit tetap sehat.",
                    "lacoco"
                )
            )
            adapter3 = MostViewAdapter(mostviewed)
            this?.setAdapter(adapter3)
        }
    }
}