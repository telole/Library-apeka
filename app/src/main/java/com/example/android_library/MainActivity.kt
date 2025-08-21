package com.example.android_library

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BukuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        ApiClient.instance.getBuku().enqueue(object : Callback<List<Buku>> {
            override fun onResponse(call: Call<List<Buku>>, response: Response<List<Buku>>) {
                if (response.isSuccessful) {
                    val bukuList = response.body() ?: emptyList()
                    adapter = BukuAdapter(applicationContext, bukuList)
                    recyclerView.adapter = adapter
                } else {
                    Toast.makeText(this@MainActivity, "Gagal ambil data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Buku>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("API_ERROR", t.message ?: "Unknown error")
            }
        })
    }
}
