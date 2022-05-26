package com.example.livedatatosavestate.viewModel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val livedata = MutableLiveData<String>()

    init {
        startTimer()
    }

    private fun startTimer() {
        object : CountDownTimer(30000, 1000) {
            override fun onTick(count: Long) {
                livedata.value = (count / 1000).toString()
            }

            override fun onFinish() {
                livedata.value = "Finish"
            }
        }.start()
    }
}