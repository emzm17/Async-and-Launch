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
        val fb=CoroutineScope(Dispatchers.IO).async{
          getfollower()
         }
        val insta=CoroutineScope(Dispatchers.IO).async {
            Instagetfollower()
        }
        Log.d(TAG,"FB-${fb.await()} ,Insta-${insta.await()}")
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