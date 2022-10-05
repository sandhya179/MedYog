package com.example.medyog

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.medyog.databinding.ActivityEditProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.util.*

class EditProfile : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    private lateinit var storage : FirebaseStorage
    private val user = Firebase.auth.currentUser!!
    private lateinit var selectedImg : Uri
    private lateinit var dialog : AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        dialog = AlertDialog.Builder(this)
//            .setMessage("Updating profile..")
//            .setCancelable(false)

        val username = binding.username
        val email = binding.email
        val name = binding.name
        val city = binding.city
        val state = binding.state
        val bio = binding.bio.text

        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        storage = FirebaseStorage.getInstance()

        user?.let {
            database.reference.child("users").child(user.uid).child("username").get().addOnSuccessListener {
                username.setText(it.value.toString())
            }.addOnFailureListener{
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
            }
            email.setText(user.email.toString().trim())
        }

        binding.userImage.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type ="image/*"
            startActivityForResult(intent ,1)
        }

        binding.saveBtn.setOnClickListener {
            var tempEmail = binding.email.text

            if(tempEmail.toString().isNotEmpty()) {
                user.updateEmail(tempEmail.toString().trim()).addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                    }else if(selectedImg != null){
                        Toast.makeText(this, "Information Updated Successfully", Toast.LENGTH_LONG)
                        .show()
                        uploadImage()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
                }
            }
            changeDatabaseInfo(user.uid, username.text.toString(), tempEmail.toString(), bio.toString(), selectedImg.toString(),
            state.toString())
        }
    }

    private fun uploadImage() {
        val reference = storage.reference.child("profileImage").child(Date().time.toString())
        reference.putFile(selectedImg)
//            .addOnCompleteListener{
//           if(it.isSuccessful){
//             reference.downloadUrl.addOnSuccessListener { task ->
//                   uploadPhoto(task.toString())
//
//                }
//           }
//        }
//   }
//  private fun uploadPhoto(imgUrl: String) {
//     //   val user = changeDatabaseInfo(user.uid,  selectedImg.toString())
//            database.reference.child
//

    }
    fun changeDatabaseInfo(userID: String, username: String, email: String, bio: String, userImage : String,state: String) {
        database.reference.child("users").child(userID).child("username").setValue(username)
        database.reference.child("users").child(userID).child("email").setValue(email)
        database.reference.child("users").child(userID).child("bio").setValue(bio)
        database.reference.child("users").child(userID).child("profilePic").setValue(userImage)
        database.reference.child("users").child(userID).child("State").setValue(state)
    }

    override fun onActivityResult( requestCode:Int , resultCode :  Int , data : Intent? ){
        super.onActivityResult( requestCode , resultCode,data)

        if(data != null){
          if( data.data != null){
              selectedImg = data.data!!

              binding.userImage.setImageURI(selectedImg)
          }
        }
    }




}