package com.example.muslimwork.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.muslimwork.home.model.InspirationModel
import com.example.muslimwork.R

class InspirationAdapter
    // Menghubungkan Komponen Layout Dengan Kotlin
    (private val listInspiration: ArrayList<InspirationModel>) : RecyclerView.Adapter<InspirationAdapter.ViewHolder>() {

    // Menghubungkan Komponen Layout Dengan Kotlin
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Panggil imageview Pada File item_inspiration.xml pastebin.com/g21U041D
        var imgView: ImageView = itemView.findViewById(R.id.imageView)
    }

    // Membuat Tampilan Di Recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Panggil Layout item_inspiration dan masukan ke variable view
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_inspiration, parent, false)
        // Kirim view/layout item_inspiration ke ViewHolder
        return ViewHolder(view)
    }

    // Memasang Data Di Tampilan recyclerview
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Memanggil Masing2 Data Dari Parameter Berdasarkan Posisnya
        val inspiration = listInspiration[position]

        // Tampilankan Gambar Ke imageView
        holder.imgView.setImageResource(inspiration.inspirationImage)
    }

    // Menentukan Jumlah Data Di recyclerview
    override fun getItemCount(): Int {
        // Menampilkan Data Sebanyak Foto Yang Ada Di File InspirationData
        return listInspiration.size
    }

}