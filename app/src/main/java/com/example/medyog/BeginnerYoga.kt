package com.example.medyog

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
//import com.google.android.datatransport.runtime.TransportRuntime.initialize
import com.google.android.gms.common.api.internal.GoogleServices.initialize
//import com.google.android.gms.flags.FlagRegistry.initialize
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class BeginnerYoga : AppCompatActivity() {

     private lateinit var recyclerView: RecyclerView
     lateinit var adapter: Adapter

//    val VIDEO_ID = "0vj3__k4Mss"
//    val VIDEO_ID_SECOND = "QKDzmq3SWco"
//    val YOUTUBE_API_KEY = "AIzaSyA_R6CuWpz9lD1mPI1MSaIBumZV57JiGj8"
//
//    private lateinit var youtubePlayer: YouTubePlayerView
//    private lateinit var youtubePlayerTwo: YouTubePlayerView
//    private lateinit var btnPlay: ImageButton
//    private lateinit var btnPlaySecond: ImageButton
//
//    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener
 //     lateinit var youtubePlayerView: YouTubePlayerView
      lateinit var youtubePlayerListener : YouTubePlayerListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beginner_yoga)

//        val youtubePlayerView: YouTubePlayerView = findViewById(R.id.youtube_player_view)
//        lifecycle.addObserver(youtubePlayerView)



//        youtubePlayerView = findViewById(R.id.youtube_player_view)
//    lifecycle.addObserver(youtubePlayerView)
//    youtubePlayerView.initialize(youtubePlayerListener.toString() )
//
//        youtubePlayerView.getPlayerUiController()
//        youtubePlayerView.addYoutubePlayerListerner(object: AbstractYouTubePlayerListener() {
//            override fun onReady(youTubePlayer: YouTubePlayer) {
//                // loading the selected video
//                // into the YouTube Player
//                youTubePlayer.loadVideo(videoID, 0f)
//            }
//
//            override fun onStateChange(
//                youTubePlayer: YouTubePlayer,
//                state: PlayerConstants.PlayerState
//            ) {
//                // this method is called if video has ended,
//                super.onStateChange(youTubePlayer, state)
//            }
//        })



//
          val options: IFramePlayerOptions = IFramePlayerOptions.Builder().controls(0).build()
//
//        val listener = YouTubePlayerView.initialize(YouTubePlayerListener listener)
//



//        val myDataset = Datasource().loadModel()
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.adapter = Adapter(this@BeginnerYoga, myDataset)
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        recyclerView.setHasFixedSize(true)

//        fetchData()
//        youtubePlayer = findViewById(R.id.youtubePlayer)
//        youtubePlayerTwo = findViewById(R.id.youtubePlayerTwo)
//    //    btnPlay = findViewById(R.id.btnPlay)
//     //   btnPlaySecond = findViewById(R.id.btnPlaySecond)
//
//        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
//            override fun onInitializationSuccess(
//                p0: YouTubePlayer.Provider?,
//                p1: YouTubePlayer?,
//               // p2: YoutubePlayer?,
//                p2: Boolean
//            ) {
//                p1?.loadVideo(VIDEO_ID)
//        //        p1?.loadVideo(VIDEO_ID_SECOND)
//            }
//
//            override fun onInitializationFailure(
//                p0: YouTubePlayer.Provider?,
//                p1: YouTubeInitializationResult?
//            ) {
//                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//         btnPlay.setOnClickListener{
//             btnPlay.visibility = View.GONE
//             youtubePlayer.initialize(YOUTUBE_API_KEY,youtubePlayerInit)
//         }
//        btnPlaySecond.setOnClickListener{
//            btnPlaySecond.visibility = View.GONE
//            youtubePlayerTwo.initialize(YOUTUBE_API_KEY,youtubePlayerInit)
//        }
//    }
    }




//    fun fetchData() {
//
//        recyclerView = findViewById(R.id.recycler_view)
//        val requestQueue = Volley.newRequestQueue(this@BeginnerYoga)
//        val  stringRequest = StringRequest("https://www.googleapis.com/youtube/v3/search?part=snippet&channelid=UCLu1jSLRGzVgOsViFic42Gg&maxResullt=30&key=AIzaSyA_R6CuWpz9lD1mPI1MSaIBumZV57JiGj8",
//            Response.Listener{
////                final override fun onResponse(response: String) {
//                     try{
//                        val jsonObject = JSONObject(it)
//                        val jsonArray: JSONArray = jsonObject.getJSONArray("items")
//                        var i = 0
//                        while(i < jsonArray.length()) {
//
//                            val jsonObject1: JSONObject = jsonArray.getJSONObject(i)
//                            val jsonVideoId: JSONObject = jsonObject1.getJSONObject("id")
//                            val jsonSnippet: JSONObject = jsonObject1.getJSONObject("snippet")
//                            val jsonThumbnail: JSONObject = jsonSnippet.getJSONObject("thumbnails").getJSONObject("medium")
//
//                            val md: Model = Model()
//                            if(i != 1 && i != 2) {
//                                md.setvideoId(jsonVideoId.getString("videoId"))
//                                md.settitle(jsonSnippet.getString("title"))
//                                md.seturl(jsonThumbnail.getString("url"))
//                                list.add(md)
//                                i++
//                            }
//                        }
//                        Log.d("url", list.toString())
//
//                        if(list.size > 0) {
//                            adapter.notifyDataSetChanged()
//                        }
//                         val itemAdapter = Adapter(this@BeginnerYoga, list)
//
//                         adapter = itemAdapter
//                         recyclerView.layoutManager = LinearLayoutManager(this@BeginnerYoga, LinearLayoutManager.VERTICAL, false)
//
//                         recyclerView.adapter = adapter
//                     } catch (e: JSONException) {
//                         e.printStackTrace()
//                     }
////                 }
//           }, Response.ErrorListener {
//                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
//            })
//
//        requestQueue.add(stringRequest)
//    }
}