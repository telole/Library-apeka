package com.example.android_library

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class BukuAdapter(private val context: Context, private val listBuku: List<Buku>) :
    RecyclerView.Adapter<BukuAdapter.BookViewHolder>() {

    private var filteredList: MutableList<Buku> = listBuku.toMutableList()

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBuku: ImageView = itemView.findViewById(R.id.imgBuku)
        val tvJudul: TextView = itemView.findViewById(R.id.tvJudul)
        val tvPenulis: TextView = itemView.findViewById(R.id.tvPenulis)
        val tvTahun: TextView = itemView.findViewById(R.id.tvTahun)
        val btnLihat: Button = itemView.findViewById(R.id.btnLihat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_buku, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val buku = filteredList[position]
        holder.imgBuku.setImageResource(buku.gambar)
        holder.tvJudul.text = buku.judul
        holder.tvPenulis.text = buku.penulis
        holder.tvTahun.text = buku.tahun

        holder.btnLihat.setOnClickListener {
            val context = it.context
            AlertDialog.Builder(context)
                .setTitle("Lihat Detail?")
                .setMessage("Ingin melihat detail dari ${buku.judul}?")
                .setPositiveButton("Lihat") { _, _ ->
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("judul", buku.judul)
                    intent.putExtra("penulis", buku.penulis)
                    intent.putExtra("tahun", buku.tahun)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                }
                .setNegativeButton("Batal", null)
                .show()
        }


        }
    override fun getItemCount(): Int = listBuku.size

    }


