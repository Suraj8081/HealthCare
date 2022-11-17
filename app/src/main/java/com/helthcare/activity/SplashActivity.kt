package com.helthcare.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.helthcare.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    var _binding:ActivitySplashBinding?=null
    val binding get()=_binding!!

    private val DELAY_TIME=3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(_binding!!.root)

        Handler().postDelayed(object :Runnable{
            override fun run() {
                Intent(this@SplashActivity,LoginActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            }

        },DELAY_TIME)

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}