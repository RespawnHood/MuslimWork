package com.example.muslimwork.video_kajian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.muslimwork.R
import com.example.muslimwork.databinding.ActivityDetailVideoKajianBinding
import com.example.muslimwork.video_kajian.model.VideoKajianModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class DetailVideoKajianActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailVideoKajianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVideoKajianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val paket =
            intent.getParcelableExtra<VideoKajianModel>(KUNCI_VIDEO_KAJIAN) as VideoKajianModel

        initView(paket)
    }

    private fun initView(paket: VideoKajianModel) {
        val youtubePlayer: YouTubePlayerView = binding.playerVideo
        lifecycle.addObserver(youtubePlayer)

        youtubePlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(paket.urlVideo, 0f)
            }
        })
        binding.tvTitle.text = paket.title
        binding.tvChannel.text = paket.channel
        binding.tvSpeaker.text = paket.speaker
        binding.tvSummary.text = paket.summary

        binding.ivShare.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Kajian Yang Berjudul \"${paket.title}\" " +
                        "Dibawakan Oleh ${paket.speaker} Di Channel " +
                        "${paket.channel} \n\n" +
                        "Link : https://www.youtube.com/watch?v=${paket.urlVideo}"
            )

            intent.type = "text/plain"
            startActivity(intent)
        }
    }

    companion object {
        const val KUNCI_VIDEO_KAJIAN = "data view"
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