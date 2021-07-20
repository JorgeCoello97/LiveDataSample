package com.jorch.livedatasample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.jorch.livedatasample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val vm by viewModels<MainViewModel>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { vm.incrementCount() }

        vm.count.observe(this, Observer {
            binding.textView.text = "Counts: $it"
        })
    }
}