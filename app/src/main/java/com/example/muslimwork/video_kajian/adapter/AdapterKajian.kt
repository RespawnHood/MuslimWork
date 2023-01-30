package com.example.muslimwork.video_kajian.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.muslimwork.R
import com.example.muslimwork.video_kajian.DetailVideoKajianActivity
import com.example.muslimwork.video_kajian.model.VideoKajianModel

// 1.
class AdapterKajian(private val dataList: ArrayList<VideoKajianModel>) :
    RecyclerView.Adapter<AdapterKajian.ViewHolder>() {

    // 2.
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivPhoto: ImageView = view.findViewById(R.id.iv_item_photo)
        var tvTitle: TextView = view.findViewById(R.id.tv_title)
        var tvSpeaker: TextView = view.findViewById(R.id.tv_speaker)
        var tvChannel: TextView = view.findViewById(R.id.tv_channel)
    }

    // 3.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_video_kajian, parent, false)

        return ViewHolder(view)
    }

    // 4.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Mengambil Data Berdasarkan No. Antrian
        val itemData = dataList[position]

        // Tempelkan Ke Komponen
        Glide.with(holder.itemView.context).load(itemData.thumbnail).into(holder.ivPhoto)
        holder.tvTitle.text = itemData.title
        holder.tvChannel.text = itemData.channel
        holder.tvSpeaker.text = itemData.speaker

        // Agar Bisa Di Klik Pindah Ke Detail
        holder.itemView.setOnClickListener { view ->
            val klikDetail = Intent(holder.itemView.context, DetailVideoKajianActivity::class.java)
            klikDetail.putExtra(DetailVideoKajianActivity.KUNCI_VIDEO_KAJIAN, itemData)
            view.context.startActivity(klikDetail)
        }
    }

    //
    override fun getItemCount(): Int {
        return dataList.size
    }
}
