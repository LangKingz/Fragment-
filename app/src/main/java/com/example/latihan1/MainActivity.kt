package com.example.latihan1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // TODO: Set up your UI
        val fragmentManager = supportFragmentManager
        val homeFragment = Homefragment()
        val fragment = fragmentManager.findFragmentByTag(Homefragment::class.java.simpleName)

        if (fragment !is Homefragment){
            Log.d("MyFlexibleFragment", "Fragment Name : " + Homefragment::class.java.simpleName)
            fragmentManager.beginTransaction().add(R.id.frame_container,homeFragment,Homefragment::class.java.simpleName).commit()
        }
    }
}