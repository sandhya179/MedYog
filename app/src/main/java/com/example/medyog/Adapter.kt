package com.example.medyog

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.provider.Contacts.SettingsColumns.KEY
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.google.android.youtube.player.YouTubeThumbnailView
import com.squareup.picasso.Picasso
import io.grpc.InternalConfigSelector.KEY

class Adapter (
    private val context: Context,
    private val list: List<Model>

) : RecyclerView.Adapter<Adapter.ItemViewHolder>() {

//    @SuppressLint("SetJavaScriptEnabled")
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
//        val videoView: WebView = view.findViewById<WebView>(R.id.video_view)
        val youtublePlayer = view.findViewById<YouTubePlayerView>(R.id.youtubePlayer)
        val playBtn = view.findViewById<ImageButton>(R.id.btnPlay)
//        init {
//            videoView.webViewClient = WebViewClient()
//            videoView.webChromeClient = WebChromeClient()
//            videoView.settings.javaScriptEnabled = true
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item = list[position]
//        Picasso.get().load(item.url).into(holder.videoView)
//        holder.videoView.loadUrl(item.url)
        val YOUTUBE_API_KEY = "AIzaSyA_R6CuWpz9lD1mPI1MSaIBumZV57JiGj8"

        var youtubePlayerInit: YouTubePlayer.OnInitializedListener

        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(item.toString())
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(context, "failed", Toast.LENGTH_LONG).show()
            }
        }

    }
    override fun getItemCount(): Int {
        return list.size
    }
}