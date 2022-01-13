package com.example.latihanui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ContentActivity3 : AppCompatActivity() {
    private var adapter3: RecyclerView.Adapter<*>? = null
    private lateinit var recyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content3)
        recyclerView2 = findViewById(R.id.viewMostView)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        with(recyclerView2) {
                this?.setLayoutManager(linearLayoutManager)
        }

        val ImageView9 = findViewById<ImageView>(R.id.img8)
        ImageView9.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            startActivity(intent)
        }
        val ImageView10 = findViewById<ImageView>(R.id.img9)
        ImageView10.setOnClickListener {
            val intent = Intent(this, ContentActivity2::class.java)
            startActivity(intent)
        }

        val mostviewed = ArrayList<MostViewedDomain>()
        with(recyclerView2) {
            mostviewed.add(
                MostViewedDomain(
                    "Avoskin Serum",
                    "Serum Alpha Arbutin 3% + Grapeseed Advanced Glow untuk mencerahkan kulit dan menjaga kulit tetap sehat dengan kandungan anti-oksidan yang tinggi.",
                    "avoskins"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Esqa Eyeshadow",
                    "The Goddess Eyeshadow Palette memiliki warna yang aman digunakan untuk sehari-hari maupun dalam acara formal.",
                    "esqas"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Loreal Mascara",
                    "Kamu bisa mendapatkan Bulu Mata yang Tebal, Lentik dan Panjang. L'Oreal Paris Volume Lash Paradise merupakan Maskara yang tahan air, dapat menambah volume pada bulu mata.",
                    "loreal"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Make Over Lip Cream",
                    "Diformulasi dengan tekstur creamy sehingga lip cream ini sangat mudah diaplikasikan. Kandungan pigmentasi warnanya yang sangat intens dapat mengcover bibir hanya dengan sekali usap.",
                    "makeovers"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Maybelline Highlighter",
                    "Highlighter yang  satu ini memberi efek chrome pada kulit, membuatnya bersinar serta memberi efek pantulan cahaya pada bagian terbaik dari wajah.",
                    "may"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Npure Sunscreen",
                    "N'PURE Cica Beat The Sun dapat melindungi kulit dari paparan sinar UVA & UVB sekaligus melembapkan dan menenangkan kulit.",
                    "npure"
                )
            )
            adapter3 = MostViewAdapter(mostviewed)
            this?.setAdapter(adapter3)
        }
    }
}