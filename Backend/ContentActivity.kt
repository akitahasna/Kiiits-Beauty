package com.example.latihanui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ContentActivity : AppCompatActivity() {
    private var adapter3: RecyclerView.Adapter<*>? = null
    private lateinit var recyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        recyclerView2 = findViewById(R.id.viewMostView)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        with(recyclerView2) {
                this?.setLayoutManager(linearLayoutManager)
        }

        val ImageView5 = findViewById<ImageView>(R.id.img2)
        ImageView5.setOnClickListener {
            val intent = Intent(this, ContentActivity2::class.java)
            startActivity(intent)
        }
        val ImageView6 = findViewById<ImageView>(R.id.img3)
        ImageView6.setOnClickListener {
            val intent = Intent(this, ContentActivity3::class.java)
            startActivity(intent)
        }

        val mostviewed = ArrayList<MostViewedDomain>()
        with(recyclerView2) {
            mostviewed.add(
                MostViewedDomain(
                    "Avoskin Serum",
                    "Serum yang memadukan Alpha Arbutin 3% dan ekstrak dari Grapeseed untuk mencerahkan kulit dan memudarkan noda bekas jerawat.",
                    "avoskins"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Make Over Lip Cream",
                    "Lip cream dengan bentuk liquid persembahan dari Make Over yang menghadirkan warna-warna intens dan menawan.",
                    "makeovers"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Esqa Eyeshadow",
                    "The Goddess Eyeshadow Palette menangkap warna sehari-hari yang memikat dengan 9 bayangan berpigmen dalam empat warna.",
                    "esqas"
                )
            )

            mostviewed.add(
                MostViewedDomain(
                    "Rojukiss Serum Mask",
                    "Masker perawatan wajah dengan 5x serum intensif untuk mencerahkan kulit kusam dan berbintik hitam.",
                    "rojukiss"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Loreal Mascara",
                    "L'Oreal Paris Volume Lash Paradise merupakan Maskara yang dapat menambah volume pada bulu mata.",
                    "loreal"
                )
            )
            mostviewed.add(
                MostViewedDomain(
                    "Maybelline Highlighter",
                    "highlighter yang memberi efek chrome pada kulit dan menonjolkan bagian terbaik dari wajah.",
                    "may"
                )
            )

            adapter3 = MostViewAdapter(mostviewed)
            this?.setAdapter(adapter3)
        }
    }
}