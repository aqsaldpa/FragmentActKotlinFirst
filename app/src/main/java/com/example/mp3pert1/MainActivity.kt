package com.example.mp3pert1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.mp3pert1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //fragment
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //fragment
        binding.Fragmentbtn1.setOnClickListener {

            replaceFragment(FragmentOne())
        }
        binding.Fragmentbtn2.setOnClickListener {
            replaceFragment(FragmentTwo())
        }

        val Secondbtn = findViewById<Button>(R.id.SecondActivityBtn)
        Secondbtn.setOnClickListener {
            val Intent = Intent(this, MainActivityTwo::class.java)
            startActivity(Intent)
        }
        val Secondbtn2 = findViewById<Button>(R.id.SecondActivityBtn2)
        Secondbtn2.setOnClickListener {
            val Intent = Intent(this, MainActivityThree::class.java)
            startActivity(Intent)
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}