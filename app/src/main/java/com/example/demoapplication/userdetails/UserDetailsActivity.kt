package com.example.demoapplication.userdetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapplication.R
import com.example.demoapplication.databinding.ActivityUserDetailsBinding

class UserDetailsActivity : AppCompatActivity() {
    private val TAG = "UserDetailsActivity"
    private lateinit var binding: ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent;
        val name = intent.getStringExtra("Username")
        val designation = intent.getStringExtra("Designation")
        val address = intent.getStringExtra("Address")
        val contact = intent.getStringExtra("Contact")
        val email = intent.getStringExtra("Email")
        binding.name.text = "Name : $name"
        binding.designation.text = "Designation : $designation"
        binding.address.text = "Address : $address"
        binding.contact.text = "Contact : $contact"
        binding.email.text = "Email : $email"


        binding.removeUserButton.setOnClickListener(View.OnClickListener {

            Toast.makeText(
                this@UserDetailsActivity,
                "The User will be removed on calling the API !!",
                Toast.LENGTH_SHORT
            ).show()

        })

    }
}