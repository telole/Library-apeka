package com.example.android_library

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

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
        val gambarUrl = intent.getStringExtra("gambar")

        tvJudulDetail.text = judul
        tvPenulisDetail.text = penulis
        tvTahunDetail.text = tahun

        Glide.with(this)
            .load(gambarUrl)
            .into(imgDetail)
    }
}
