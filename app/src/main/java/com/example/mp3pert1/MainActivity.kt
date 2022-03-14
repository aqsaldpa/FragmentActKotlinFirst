package com.example.mp3pert1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.mp3pert1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var btnFragmentOne: Button
    private lateinit var btnFragmentTwo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFragmentOne = findViewById(R.id.Fragmentbtn1)
        btnFragmentTwo = findViewById(R.id.Fragmentbtn2)

        handleFragment()
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

    private fun handleFragment() {
        val fragmentone = FragmentOne()
        val fragmenttwo = FragmentTwo()


        btnFragmentOne.setOnClickListener {
            replaceFragment(fragmentone)
        }
        btnFragmentTwo.setOnClickListener {
            replaceFragment(fragmenttwo)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commitNow()
    }
}