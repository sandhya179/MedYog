package fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.medyog.AdvancedMeditate
import com.example.medyog.BeginnerMeditate
import com.example.medyog.IntermediateMeditate
import com.example.medyog.R
import com.example.medyog.databinding.FragmentMeditateBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController


class MeditateFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_meditate, container, false)


        val youtubePlayerView: YouTubePlayerView = view.findViewById(R.id.youtube_player_view)
        val youTubePlayerViewSecond: YouTubePlayerView = view.findViewById(R.id.youtube_player_view_1)
        val youTubePlayerViewThird: YouTubePlayerView = view.findViewById(R.id.youtube_player_view_2)
        val youTubePlayerViewFour: YouTubePlayerView = view.findViewById(R.id.youtube_player_view_3)
        val youTubePlayerViewFive: YouTubePlayerView = view.findViewById(R.id.youtube_player_view_4)
        val youTubePlayerViewSix: YouTubePlayerView = view.findViewById(R.id.youtube_player_view_5)
        val youTubePlayerViewSeven: YouTubePlayerView = view.findViewById(R.id.youtube_player_view_6)

        lifecycle.addObserver(youtubePlayerView)
        lifecycle.addObserver(youTubePlayerViewSecond)
        lifecycle.addObserver(youTubePlayerViewThird)
        lifecycle.addObserver(youTubePlayerViewFour)
        lifecycle.addObserver(youTubePlayerViewFive)
        lifecycle.addObserver(youTubePlayerViewSix)

        val videoId = "0vj3__k4Mss"
        val videoIdSecond = "QKDzmq3SWco"
        val videoIdThird = "Fyq3up4VMk8"
        val videoIdFour = "t9uyK4yxTb0"
        val videoIdFive = "7qVpqmtdTxA"
        val videoIdSix = "anawuUbr4p8"

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

        loadVideo(videoId, youtubePlayerView)
        loadVideo(videoIdSecond, youTubePlayerViewSecond)
        loadVideo(videoIdThird, youTubePlayerViewThird)
        loadVideo(videoIdFour, youTubePlayerViewFour)
        loadVideo(videoIdFive, youTubePlayerViewFive)
        loadVideo(videoIdSix, youTubePlayerViewSix)
        return view


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