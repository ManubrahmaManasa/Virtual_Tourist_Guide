package com.example.virtual_tourist_guide

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.virtual_tourist_guide.databinding.ActivityLogInBinding
import com.example.virtual_tourist_guide.viewmodels.SplashViewModel

class LogInActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModels()
    private lateinit var logInBonding:ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                splashViewModel.isLoading.value
            }
        }
        logInBonding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(logInBonding.root)

        logInBonding.newUserTv.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        logInBonding.logInBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}