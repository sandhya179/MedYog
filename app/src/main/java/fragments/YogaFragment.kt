package fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.medyog.*
import com.example.medyog.databinding.FragmentMeditateBinding
import com.example.medyog.databinding.FragmentYogaBinding

class YogaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentYogaBinding.inflate(layoutInflater)

        view.YogaBeginnerBtn.setOnClickListener{
            val intent = Intent(this@YogaFragment.requireContext(), TempBeginnerYoga::class.java)
            startActivity(intent)
        }

        view.YogaIntermediateBtn.setOnClickListener{
            val intent = Intent(this@YogaFragment.requireContext(), IntermediateYoga::class.java)
            startActivity(intent)
        }

        view.YogaAdvancedBtn.setOnClickListener{
            val intent = Intent(this@YogaFragment.requireContext(), AdvancedYoga::class.java)
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return view.root
    }


    }
