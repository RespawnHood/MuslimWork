package com.example.muslimwork.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.muslimwork.R
import com.example.muslimwork.databinding.ActivityMainBinding
import com.example.muslimwork.doa.DoaActivity
import com.example.muslimwork.home.adapter.InspirationAdapter
import com.example.muslimwork.home.data.InspirationData
import com.example.muslimwork.home.model.InspirationModel
import com.example.muslimwork.jadwal_sholat.JadwalSholatActivity
import com.example.muslimwork.video_kajian.VideoKajianActivity
import com.example.muslimwork.zakat.ZakatActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    // Deklarasi Variable Keneksi Komponen xml Ke File Kotlin
    private lateinit var binding: ActivityMainBinding

    // Perintah Dalama OnCreate Akan Dijalankan Ketika Activity Pertama Dibuka
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi Variable Binding Dengan layoutInflater
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // setContentView(R.layout.activity_main)

        initNavMenu()
        initHeader()
        initRecyclerViewInpiration()
    }

    private fun initNavMenu() {
        // Memberikan Aksi Klik Pada Icon
        binding.ivIconMenuDoa.setOnClickListener {
            // Memulai Aktivitas Baru
            // Memberikan Intent Untuk Menunjukan Tujuan Pergi
            startActivity(Intent(this, DoaActivity::class.java))
        }
        binding.ivIconMenuKajian.setOnClickListener {
            startActivity(Intent(this, VideoKajianActivity::class.java))
        }
        binding.ivIconMenuPraytime.setOnClickListener {
            startActivity(Intent(this, JadwalSholatActivity::class.java))
        }
        binding.ivIconMenuZakat.setOnClickListener {
            startActivity(Intent(this, ZakatActivity::class.java))
        }
    }

    private fun initHeader() {
        // Mengambil Waktu Sekarang.
        val timeNow = Calendar.getInstance()

        // Menentukan Format Jam "HH" (Hour 2 Digit).
        val timeFormat = SimpleDateFormat("HH")

        // Membentuk Waktu Sekarang Hanya Jam Saja.
        val time = timeFormat.format(timeNow.time)

        // Menentukan Gambar Berdasarkan Jam Sekarang (Data Dari Variable Time)
        when {
            // Jam 00-06 Gambar Malam
            time.toInt() in 0..6 -> {
                // Ganti Gambar Jadi Malam
                binding.ivHeader.setImageResource(R.drawable.bg_malam)
            }
            // Jam 07-12 Gambar Pagi
            time.toInt() in 7..12 -> {
                binding.ivHeader.setImageResource(R.drawable.bg_pagi)
            }
            // Jam 13-18 Gambar Siang
            time.toInt() in 13..18 -> {
                binding.ivHeader.setImageResource(R.drawable.bg_sore)
            }
            // Jam 19-23 Gambar Malam
            time.toInt() in 19..23 -> {
                binding.ivHeader.setImageResource(R.drawable.bg_malam)
            }
        }
    }

    private fun initRecyclerViewInpiration() {
        // Buat Variable Penampung Kumpulan Data
        val list: ArrayList<InspirationModel> = arrayListOf()
        // Tambahkan Data Ke Dalam List Dari inspirationData
        list.addAll(InspirationData.listData)

        // Panggil adapter Dan Masukkan list Kedalamnya
        val inspirationAdapter = InspirationAdapter (list)

        // Pengaturan RecyclerView
        binding.rvInspiration.setHasFixedSize(true)
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        // Pasang Adapter Ke RecyclerView
        binding.rvInspiration.adapter = inspirationAdapter
    }

    // Perintah onPause Akan Dilakukan Ketika Activity Tertutup
    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause: Tertutup")
    }

    // Perintah Dalam onResume Akan Dilakukan Ketika Activity Dibuka Kembali
    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume: Dijalankan ")
    }
}


