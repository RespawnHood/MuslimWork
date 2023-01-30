package com.example.muslimwork.doa

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.muslimwork.doa.model.DoaModel
import com.example.muslimwork.R
import com.example.muslimwork.databinding.ActivityDetailListDoaBinding
import com.example.muslimwork.doa.adapter.DoaListAdapter
import com.example.muslimwork.doa.data.*


class ListDoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailListDoaBinding

    lateinit var title: String
    var logo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailListDoaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // Menerima Kiriman Data
        title = intent.getStringExtra("ext_title").toString()
        logo = intent.getIntExtra("ext_icon",8)

        setSupportActionBar(binding.toolbarListDoa)
        supportActionBar?.title = title

        initRecyclerView()
    }
    private fun initRecyclerView() {
        val list: ArrayList<DoaModel> = arrayListOf()

        when (title) {
            getString(R.string.text_pagi_amp_malam) -> list.addAll(DoaPagiDanMalamData.listDoaPagiDanMalamData)
            getString(R.string.text_doa_rumah) -> list.addAll(DoaRumahData.listDoaRumahData)
            getString(R.string.text_doa_makanminum) -> list.addAll(DoaMakananDanMinumanData.listDoaMakananDanMinumanData)
            getString(R.string.text_doa_perjalanan) -> list.addAll(DoaPerjalananData.listDoaPerjalananData)
            getString(R.string.text_doa_sholat) -> list.addAll(DoaSholatData.listDoaShalatData)
            getString(R.string.text_etika_baik) -> list.addAll(DoaEtikaBaikData.listDoaEtikaBaikData)
        }

        val adapterDoa = DoaListAdapter(list, title, logo)
        binding.rvDoa.setHasFixedSize(true)
        binding.rvDoa.layoutManager = LinearLayoutManager(this)
        val listDoa = DoaListAdapter(list, title, logo)
        binding.rvDoa.adapter = listDoa
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}