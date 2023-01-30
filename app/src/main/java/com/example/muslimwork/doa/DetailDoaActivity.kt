package com.example.muslimwork.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import com.example.muslimwork.R
import com.example.muslimwork.databinding.ActivityDetailDoaBinding
import com.example.muslimwork.doa.model.DoaModel

class DetailDoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDoaBinding

    companion object {
        const val EXTRA_DOA = "extra_doa"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_doa)

        binding = ActivityDetailDoaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Variable Untuk Menerima Data Dari Kiriman Adapter
        val doa = intent.getParcelableExtra<DoaModel>(EXTRA_DOA) as DoaModel

        // Menentukan actionbar Dengan Toolbar Pada Layout
        setSupportActionBar(binding.toolbarDetailDoa)
        supportActionBar?.title = doa.title

        // Menampilkan Data Ke Masing2 Komponen Layout
        binding.tvTitleDoa.text = doa.title
        binding.tvTitleArab.text = doa.doa
        binding.tvTitleArti.text = doa.translate
        binding.tvTitleLatin.text = doa.latin
        binding.tvTitleRiwayat.text = doa.profile
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}