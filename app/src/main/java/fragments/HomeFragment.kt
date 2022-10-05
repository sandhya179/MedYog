package fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.medyog.R
import com.example.medyog.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//       val article = FragmentHomeBinding.inflate(layoutInflater)
//        article.articleFirst.setOnClickListener{
//            val openURL = Intent(Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("https://medyogarticle.blogspot.com/2022/09/explore-about-spirituality.html")
//            startActivity(openURL)
//        }
//
//        article.articleSecond.setOnClickListener{
//            val openURL = Intent(Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("https://medyogarticle.blogspot.com/2022/09/purpose-of-life.html")
//            startActivity(openURL)
//        }
//
//        article.articleThird.setOnClickListener{
//            val openURL = Intent(Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("https://medyogarticle.blogspot.com/2022/09/the-path-to-true-happiness.html")
//            startActivity(openURL)
//        }
//
//        article.articleFourth.setOnClickListener{
//            val openURL = Intent(Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("https://medyogarticle.blogspot.com/2022/09/the-chakra-system.html")
//            startActivity(openURL)
//        }

        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        webView = view.findViewById(R.id.social_web_view)

        loadWebView()
        // Inflate the layout for this fragment
        return view
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun loadWebView() {
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String?
            ): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }
        webView.loadUrl("https://isha.sadhguru.org/yoga/meditations/")
    }


}