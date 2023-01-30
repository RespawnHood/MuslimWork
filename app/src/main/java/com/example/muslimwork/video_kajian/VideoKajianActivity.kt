package com.example.muslimwork.video_kajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.muslimwork.R
import com.example.muslimwork.databinding.ActivityJadwalSholatBinding
import com.example.muslimwork.databinding.ActivityVideoKajianBinding
import com.example.muslimwork.video_kajian.adapter.AdapterKajian
import com.example.muslimwork.video_kajian.data.VideoKajianData
import com.example.muslimwork.video_kajian.model.VideoKajianModel

class VideoKajianActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoKajianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoKajianBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMenuKajian)
        initRecyclerView()
    }
    private fun initRecyclerView() {
        val list: ArrayList<VideoKajianModel> = arrayListOf()
        list.addAll(VideoKajianData.listData)

        binding.rvVideoKajian.setHasFixedSize(true)
        binding.rvVideoKajian.layoutManager = LinearLayoutManager(this@VideoKajianActivity)

        val adapterKajian = AdapterKajian(list)
        binding.rvVideoKajian.adapter = adapterKajian
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