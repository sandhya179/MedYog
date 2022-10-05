package com.example.medyog


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.medyog.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class SignUp : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var binding : ActivitySignUpBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener{
            val intent = Intent (this, Login::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener{
            val username = binding.usernameEt.text.toString()
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty() && username.isNotEmpty()) {
                if(pass == confirmPass) {
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener{
                        if(it.isSuccessful) {

                            database = FirebaseDatabase.getInstance().getReference("users")
                            val user = auth.currentUser
                            val User = User(username, email , pass)

                            if(user != null) {
                                database.child(user.uid).setValue(User)
                            }

//                            if (user != null) {
//                                database.child(user.uid).setValue(User).addOnSuccessListener {
//                                    binding.usernameEt.text?.clear()
//                                    binding.emailEt.text?.clear()
//                                    binding.passET.text?.clear()
//                                    binding.confirmPassEt.text?.clear()
//
//                                    Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
//
//                                }.addOnFailureListener{
//                                    Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
//
//                                    //  if(user != null){
//                                    //      database.child(user.uid).setValue(User)
//                                }
//                            }
                            val intent = Intent (this, Login::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show()

            }
        }

    }

}