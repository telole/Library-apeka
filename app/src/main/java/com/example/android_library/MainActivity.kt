package com.example.android_library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.BulletSpan
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val listBuku = listOf(
            Buku("Buku 1", "Penulis 1", "2023", R.drawable.icon),
            Buku("Buku 2", "Penulis 2", "2024", R.drawable.icon),
            Buku("Buku 3", "Penulis 3", "2022", R.drawable.icon)
        )

        recyclerView.adapter = BukuAdapter(listBuku)
    }
}
