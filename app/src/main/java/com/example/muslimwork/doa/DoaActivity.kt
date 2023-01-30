package com.example.muslimwork.doa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.muslimwork.R
import com.example.muslimwork.databinding.ActivityDoaBinding

class DoaActivity : AppCompatActivity() {
    private lateinit var binding: com.example.muslimwork.databinding.ActivityDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarMenuDoa)

        initView()
    }
    private fun initView() {
        binding.cvPagimalam.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            // Kirim Data Ke DetailListDoaActivity
            intent.putExtra("ext_title", getString(R.string.text_pagi_amp_malam))
            intent.putExtra("ext_icon", R.drawable.ic_doa_pagi_malam)
            startActivity(intent)
        }
        binding.cvRumah.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_doa_rumah))
            intent.putExtra("ext_icon", R.drawable.ic_doa_rumah)
            startActivity(intent)
        }
        binding.cvMakanminum.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_doa_makanminum))
            intent.putExtra("ext_icon", R.drawable.ic_doa_makanminum)
            startActivity(intent)
        }
        binding.cvPerjalanan.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_doa_perjalanan))
            intent.putExtra("ext_icon", R.drawable.ic_doa_perjalanan)
            startActivity(intent)
        }
        binding.cvSholat.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_doa_sholat))
            intent.putExtra("ext_icon", R.drawable.ic_doa_sholat)
            startActivity(intent)
        }
        binding.cvEtikabaik.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_etika_baik))
            intent.putExtra("ext_icon", R.drawable.ic_etika)
            startActivity(intent)
        }
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