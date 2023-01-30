package com.example.muslimwork.jadwal_sholat

import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.muslimwork.R
import com.example.muslimwork.databinding.ActivityJadwalSholatBinding
import com.example.muslimwork.databinding.ActivityMainBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.util.*

class JadwalSholatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJadwalSholatBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityJadwalSholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        initView()
        getDataJadwalSholat("depok")
    }

    private fun initView() {
        val waktu: Date = Calendar.getInstance().time
        val format = SimpleDateFormat("E, dd MMM", Locale.getDefault())
        val formattedDate: String = format.format(waktu)

        binding.tvDatePray.text = formattedDate

        getDataJadwalSholat("depok")
    }

    private fun getDataJadwalSholat(location: String) {
        val client = AsyncHttpClient()
        val url = "https://muslimsalat.com/$location/daily/5.json?apikey=04d5c84ca9103b515321e26e75da1fa3"

        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                binding.pbJadwalSholat.visibility = View.INVISIBLE
                val  responData = responseBody?.let { String(it) }

                // Parsing JSON (mengurai data JSON)
                try {
                    // 1. Mengambil Seluruh Data
                    val responObject = JSONObject(responData)

                    // 2. Mengambil Array Jadwal Sholat Dengan nama "items"
                    val prayTimeArray = responObject.getJSONArray("items")

                    // Cek Apakah Data Terambil
                    Log.d("Jadwal Sholat", "onSucces $prayTimeArray")

                    // 3. Mengambil JSONProjet dalam JSONArray dengan urutan ke 0
                    val prayTime = prayTimeArray.getJSONObject(0)

                    // 4. Tampilkan Data Dalam "items" ke komponen UI
                    binding.tvPrayTimeSubuh.text = prayTime.getString("fajr")
                    binding.tvPrayTimeSunrise.text = prayTime.getString("shurooq")
                    binding.tvPrayTimeDzuhur.text = prayTime.getString("dhuhr")
                    binding.tvPrayTimeAshar.text = prayTime.getString("asr")
                    binding.tvPrayTimeMaghrib.text = prayTime.getString("maghrib")
                    binding.tvPrayTimeIsya.text = prayTime.getString("isha")
                } catch (error: Exception){
                    Toast.makeText(this@JadwalSholatActivity, error.message, Toast.LENGTH_SHORT).show()
                    error.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                // Tampilkan Pesan Error
                Toast.makeText(this@JadwalSholatActivity, error?.message, Toast.LENGTH_SHORT).show()
            }

        })

    }
}
