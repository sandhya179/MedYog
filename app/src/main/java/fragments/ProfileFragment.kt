package fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.medyog.EditProfile
import com.example.medyog.R
import com.example.medyog.User
import com.example.medyog.databinding.ActivityEditProfileBinding
import com.example.medyog.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val user = Firebase.auth.currentUser!!
    private lateinit var database: FirebaseDatabase
    private lateinit var auth : FirebaseAuth
//    private lateinit var databaseReference: FirebaseDatabase
//    private lateinit var user : User
    private lateinit var uid : String
    private lateinit var showUsername: TextView
    private lateinit var showBio : TextView
    lateinit var editProfileBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    @SuppressLint("LogConditional")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

       // database = FirebaseDatabase.getInstance()
        editProfileBtn = view.findViewById(R.id.editProfile)

        showUsername = view.findViewById(R.id.show_username)
        showBio = view.findViewById(R.id.show_bio)

        auth = FirebaseAuth.getInstance()

        uid = auth.currentUser?.uid.toString()

//        databaseReference = FirebaseDatabase.getInstance()

        database = FirebaseDatabase.getInstance()
        user.let {
            database.reference.child("users").child(user.uid).child("username").get().addOnSuccessListener {
                showUsername.setText(it.value.toString())

            }.addOnFailureListener {
                Log.d("userF", it.toString())
            }
            database.reference.child("users").child(user.uid).child("bio").get().addOnSuccessListener {
                showBio.setText(it.value.toString())
            }

        }



//       if(uid.isEmpty()){
//            getUserData()
//        }
//
        editProfileBtn.setOnClickListener{
            val intent = Intent(this@ProfileFragment.requireContext(),EditProfile::class.java)
            startActivity(intent)
        }

        return view
    }

//    private fun getUserData() {
//        val username = binding.showUsername
//        val bio = binding.showBio
//
//        databaseReference.child(uid).addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot){
//
//                val value = snapshot.getValue(String::class.java)
//                username.text = value
//                bio.text = value
//
////                user = snapshot.getValue(User :: class.java)!!
////                binding.showUsername.setText(user.username)
////                binding.showBio.setText(user.bio)
//            }
//            override fun onCancelled(error : DatabaseError){
////                Toast.makeText(this@ProfileFragment, "Error fetching data", Toast.LENGTH_LONG)
////                    .show()
//            }
//        })
//    }


}