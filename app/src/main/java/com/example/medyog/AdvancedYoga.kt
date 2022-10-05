package com.example.medyog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController

class AdvancedYoga : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_yoga)

        val youtubePlayerView: YouTubePlayerView = findViewById(R.id.youtube_player_view)
        val youTubePlayerViewSecond: YouTubePlayerView = findViewById(R.id.youtube_player_view_1)
        val youTubePlayerViewThird: YouTubePlayerView = findViewById(R.id.youtube_player_view_2)
        val youTubePlayerViewFour: YouTubePlayerView = findViewById(R.id.youtube_player_view_3)
        val youTubePlayerViewFive: YouTubePlayerView = findViewById(R.id.youtube_player_view_4)
        val youTubePlayerViewSix: YouTubePlayerView = findViewById(R.id.youtube_player_view_5)
        val youTubePlayerViewSeven: YouTubePlayerView = findViewById(R.id.youtube_player_view_6)
        val youTubePlayerViewEight: YouTubePlayerView = findViewById(R.id.youtube_player_view_7)

        lifecycle.addObserver(youtubePlayerView)
        lifecycle.addObserver(youTubePlayerViewSecond)
        lifecycle.addObserver(youTubePlayerViewThird)
        lifecycle.addObserver(youTubePlayerViewFour)
        lifecycle.addObserver(youTubePlayerViewFive)
        lifecycle.addObserver(youTubePlayerViewSix)
        lifecycle.addObserver(youTubePlayerViewSeven)
        lifecycle.addObserver(youTubePlayerViewEight)

        val videoId = "VrenTA2IFjI"
        val videoIdSecond = "YFm6FVGtbMk"
        val videoIdThird = "_NNnowkcIqU"
        val videoIdFour = "_NNnowkcIqU"
        val videoIdFive = "8PZJYywclA8"
        val videoIdSix = "ASNK54226ts"
        val videoIdSeven = "AlMHOGrE4uU"
        val videoIdEight = "wIJzVgTTVew"

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
        youTubePlayerViewSix.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoIdSix, 0F)

            }
        })

        youTubePlayerViewSeven.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoIdSeven, 0F)

            }
        })
        youTubePlayerViewEight.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoIdEight, 0F)

            }
        })

        loadVideo(videoId, youtubePlayerView)
        loadVideo(videoIdSecond, youTubePlayerViewSecond)
        loadVideo(videoIdThird, youTubePlayerViewThird)
        loadVideo(videoIdFour, youTubePlayerViewFour)
        loadVideo(videoIdFive, youTubePlayerViewFive)
        loadVideo(videoIdSix, youTubePlayerViewSix)
        loadVideo(videoIdSeven, youTubePlayerViewSeven)
        loadVideo(videoIdEight, youTubePlayerViewEight)
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