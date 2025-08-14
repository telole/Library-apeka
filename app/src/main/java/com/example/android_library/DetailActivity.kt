package com.example.android_library

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgDetail = findViewById<ImageView>(R.id.imgBuku)
        val tvJudulDetail = findViewById<TextView>(R.id.tvJudul)
        val tvPenulisDetail = findViewById<TextView>(R.id.tvPenulis)
        val tvTahunDetail = findViewById<TextView>(R.id.tvTahun)

        val judul = intent.getStringExtra("judul")
        val penulis = intent.getStringExtra("penulis")
        val tahun = intent.getStringExtra("tahun")
        val gambar = intent.getIntExtra("gambar", 0)

        imgDetail.setImageResource(gambar)
        tvJudulDetail.text = judul
        tvPenulisDetail.text = penulis
        tvTahunDetail.text = tahun
    }
}
