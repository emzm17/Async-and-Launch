package com.example.coroutine1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    private val TAG: String = "KOTLINFUN"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
            printfollower()
        }

    }
   private suspend fun printfollower(){
        var fbfollower=0
        var instafollower=0
        val job=CoroutineScope(Dispatchers.IO).launch {
          fbfollower=getfollower()
         }
        val job1=CoroutineScope(Dispatchers.IO).launch {
           instafollower=Instagetfollower()
        }
        job.join()
        job1.join()
        Log.d(TAG,"FB-${fbfollower} ,Insta-${Instagetfollower()}")
   }


    private suspend fun getfollower():Int{
         delay(1000)
         return 54
    }
    private suspend fun Instagetfollower():Int{
        delay(1000)
        return 100
    }
}