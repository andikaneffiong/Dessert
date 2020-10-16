package com.example.dessert

import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber
import java.util.logging.Handler

class DessertTimer(lifecycle: Lifecycle):LifecycleObserver{
    //the number of seconds counted since the timer started
    var secondsCount = 0

  //  /**
 //    *[handler]is a class meant to process a queue of messages(known as [andriod.os.Mesage]s
 //    * or actions(known as [Runnable]
  //   */

    private  var handler = android.os.Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

init {
    lifecycle.addObserver(this)
}

@OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer(){
        runnable = Runnable {
            secondsCount++
            Timber.i("Timer is at : $secondsCount")
            handler.postDelayed(runnable,1000)
        }
    handler.postDelayed(runnable,1000)

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopTimer(){
        handler.removeCallbacks(runnable)
    }
}