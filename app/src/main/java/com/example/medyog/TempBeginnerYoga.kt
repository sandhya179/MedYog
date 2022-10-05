package com.example.medyog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController

class TempBeginnerYoga : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_beginner_yoga)

        val youtubePlayerView: YouTubePlayerView = findViewById(R.id.youtube_player_view)
        val youTubePlayerViewSecond: YouTubePlayerView = findViewById(R.id.youtube_player_view_1)
        val youTubePlayerViewThird: YouTubePlayerView = findViewById(R.id.youtube_player_view_2)
        val youTubePlayerViewFour: YouTubePlayerView = findViewById(R.id.youtube_player_view_3)
        val youTubePlayerViewFive: YouTubePlayerView = findViewById(R.id.youtube_player_view_4)
        val youTubePlayerViewSix: YouTubePlayerView = findViewById(R.id.youtube_player_view_5)
        val youTubePlayerViewSeven: YouTubePlayerView = findViewById(R.id.youtube_player_view_6)
        val youTubePlayerViewEight: YouTubePlayerView = findViewById(R.id.youtube_player_view_7)
        val youTubePlayerViewNine: YouTubePlayerView = findViewById(R.id.youtube_player_view_9)

        lifecycle.addObserver(youtubePlayerView)
        lifecycle.addObserver(youTubePlayerViewSecond)
        lifecycle.addObserver(youTubePlayerViewThird)
        lifecycle.addObserver(youTubePlayerViewFour)
        lifecycle.addObserver(youTubePlayerViewFive)
        lifecycle.addObserver(youTubePlayerViewSix)
        lifecycle.addObserver(youTubePlayerViewSeven)
        lifecycle.addObserver(youTubePlayerViewEight)
        lifecycle.addObserver(youTubePlayerViewNine)

        val videoId = "0vj3__k4Mss"
        val videoIdSecond = "QKDzmq3SWco"
        val videoIdThird = "Fyq3up4VMk8"
        val videoIdFour = "t9uyK4yxTb0"
        val videoIdFive = "7qVpqmtdTxA"
        val videoIdSix = "anawuUbr4p8"
        val videoIdSeven = "qmaMm2P6y78"
        val videoIdEight = "D3-4Bt0pvG4"
        val videoIdNine = "77rbj8hBU7Q"

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
        youTubePlayerViewNine.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoIdNine, 0F)

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
        loadVideo(videoIdNine, youTubePlayerViewNine)
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

