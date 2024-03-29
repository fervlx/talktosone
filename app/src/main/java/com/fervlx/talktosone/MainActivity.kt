package com.fervlx.talktosone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.fervlx.talktosone.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {

            lifecycleScope.launch {
                binding.login.visibility = View.GONE
                binding.progress.visibility = View.VISIBLE

                tryLogin( binding.user.text.toString(), binding.pass.text.toString() )

                binding.login.visibility = View.GONE
                binding.progress.visibility = View.GONE
            }
        }
    }


    private suspend fun tryLogin( user: String, pass: String ) {

        delay( 2000 )

        Toast.makeText(this,
            "user: $user, pass: $pass",
            Toast.LENGTH_SHORT
        ).show()
    }
}