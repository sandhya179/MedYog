package com.example.medyog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController

class IntermediateYoga : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intermediate_yoga)

        val youtubePlayerView: YouTubePlayerView = findViewById(R.id.youtube_player_view)
        val youTubePlayerViewSecond: YouTubePlayerView = findViewById(R.id.youtube_player_view_1)
        val youTubePlayerViewThird: YouTubePlayerView = findViewById(R.id.youtube_player_view_2)
        val youTubePlayerViewFour: YouTubePlayerView = findViewById(R.id.youtube_player_view_3)
        val youTubePlayerViewFive: YouTubePlayerView = findViewById(R.id.youtube_player_view_4)

        lifecycle.addObserver(youtubePlayerView)
        lifecycle.addObserver(youTubePlayerViewSecond)
        lifecycle.addObserver(youTubePlayerViewThird)
        lifecycle.addObserver(youTubePlayerViewFour)
        lifecycle.addObserver(youTubePlayerViewFive)

        val videoId = "3vK0EO2hzNA"
        val videoIdSecond = "NUKbdgxxNYE"
        val videoIdThird = "n_t5jOPre_E"
        val videoIdFour = "t9uyK4yxTb0"
        val videoIdFive = "7qVpqmtdTxA"

        youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0F)
            }
        })
        youTubePlayerViewSecond.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoIdSecond, 0F)
            }

        })

        youTubePlayerViewThird.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoIdThird, 0F)

            }
        })
        youTubePlayerViewFour.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoIdFour, 0F)

            }
        })
        youTubePlayerViewFive.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoIdFive, 0F)

            }
        })
        loadVideo(videoId, youtubePlayerView)
        loadVideo(videoIdSecond, youTubePlayerViewSecond)
        loadVideo(videoIdThird, youTubePlayerViewThird)
        loadVideo(videoIdFour, youTubePlayerViewFour)
        loadVideo(videoIdFive, youTubePlayerViewFive)
    }

    fun loadVideo(videoID: String, view: YouTubePlayerView) {
        val listener: YouTubePlayerListener = object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val defaultPlayerController: DefaultPlayerUiController = DefaultPlayerUiController(view, youTubePlayer)
                view.setCustomPlayerUi(defaultPlayerController.rootView)
            }
        }

        val options: IFramePlayerOptions = IFramePlayerOptions.Builder().controls(0).build()
        view.initialize(listener, options)
    }
}

