package com.example.muslimwork.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.muslimwork.R
import com.example.muslimwork.databinding.ActivityZakatBinding
import java.text.NumberFormat
import java.util.*

class ZakatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityZakatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityZakatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarZakat)
        initView()
    }

    private fun initView() {
        binding.btnZakat.setOnClickListener() {

            // Masukin Data Total Harta Dari User Ke Variable Total Harta
            val totalHarta = binding.etAmountZakat.getNumericValue()

            // Mengubah Format Dari etAmount(1000000000) --> 100.000.000
            val formatAmount = NumberFormat.getNumberInstance(Locale("id", "ID"))
                .format(binding.etAmountZakat.getNumericValue())
            binding.tvHartaAmount.text = "Rp $formatAmount"

            // Jika Harta Sudah Mencapai Nisab, Maka Hitung Zakat Dari Total Harta
            if (totalHarta.toInt()!! >= 85000000) {

                // Hitung Total Untuk Zakat Dengan Rumus Total Harta * (2,5/100)
                val zakat = totalHarta.toInt() * (2.5 / 100)

                // Hasil Perhitungan Zakat di format lagi agar tampilannya jadi 000.000
                val formatZakat = NumberFormat.getNumberInstance(Locale("id", "ID"))
                    .format(zakat)
                binding.tvAmountZakat.text = "Rp $formatZakat"
            } else {
                Toast.makeText(
                    this@ZakatActivity,
                    "Total Harta Masih Belum Mencapai Nisab  (85gr Emas",
                    Toast.LENGTH_LONG
                ).show()
                binding.tvAmountZakat.text = "Rp 0"
            }
        }
    }
}