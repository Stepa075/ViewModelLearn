package com.stepa0751.viewmodellearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stepa0751.viewmodellearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  mViewModel: MainViewModel
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mViewModel = ViewModelProvider(this, MainFactory(application, "Factory", chislo = 40000)).get(MainViewModel::class.java)
    }

    override fun onStart(){
        super.onStart()
        mViewModel.liveData.observe(this, Observer {
            binding.tx11.text = it.toString()

        })
        mViewModel.liveData1.observe(this, Observer {
            binding.tx22.text = it.toString()
        })

    }
}