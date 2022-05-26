package com.example.livedatatosavestate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedatatosavestate.databinding.ActivityMainBinding
import com.example.livedatatosavestate.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initObservers()

    }

    fun initObservers() {
        viewModel.livedata.observe(this, Observer {
            binding.textView.text = it
        })

    }
}