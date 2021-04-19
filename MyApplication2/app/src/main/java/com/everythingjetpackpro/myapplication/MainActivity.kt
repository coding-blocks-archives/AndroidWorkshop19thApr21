package com.everythingjetpackpro.myapplication

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

private var mSocket: Socket? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try {
            mSocket = IO.socket("https://game.stage.codeblitz.app/game")

        } catch (e: URISyntaxException) {
            Log.v("This is socket", "${e.localizedMessage}")
        }



    }

    fun conectSocke(view: View) {
        mSocket?.connect()

        mSocket?.on("init") { data ->
            Log.i("This is socket", "${data.toString()}")
        }
        Handler().postDelayed({
            Log.i("SOCKET", "${mSocket?.id()}")
        },5000)
        mSocket?.emit("join","xyz")
    }
}