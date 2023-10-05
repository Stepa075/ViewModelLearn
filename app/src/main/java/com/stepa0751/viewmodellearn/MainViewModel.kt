package com.stepa0751.viewmodellearn

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//Или,чтобы получить контекст, например для сообщения тост, можем писать так (только под андроид)
 class MainViewModel(application: Application, val text:String, val chislo:Int): AndroidViewModel(application)
//class MainViewModel: ViewModel()
    {
        val liveData = MutableLiveData<String>()
        val liveData1 = MutableLiveData<Int>()
    init {
        startTimer()
    }

    fun startTimer(){
        object: CountDownTimer(20000, 1000){
            override fun onTick(p0: Long) {
               liveData.value  = (p0/1000).toString()
               liveData1.value  = (chislo-p0).toInt()
            //binding.tx11.text = (p0/1000).toString()
            }

            override fun onFinish() {
                Toast.makeText(getApplication(), text, Toast.LENGTH_SHORT).show()

            }


        }.start()
    }
}