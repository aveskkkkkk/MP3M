package com.example.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.AbsSeekBar
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.SeekBar
import androidx.core.os.postDelayed
import java.security.PrivateKey

class MainActivity : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private lateinit var runnable: Runnable
    private  var mediaPlayer: MediaPlayer?=null
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.first)
        seekBar = findViewById(R.id.sk)
        handler= Handler(Looper.getMainLooper())
        val mPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.second)
        val gPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.third)
        val pause = findViewById<ImageButton>(R.id.pause)
        val next = findViewById<Button>(R.id.Next)
        val prev = findViewById<Button>(R.id.prev)
        pause.setOnClickListener {
            if (!mediaPlayer.isPlaying && !mPlayer.isPlaying && !gPlayer.isPlaying) {
                ins()
                mPlayer.start()

            } else {
                mediaPlayer.pause()
                mPlayer.pause()
                gPlayer.pause()
                handler.removeCallbacks(runnable)
                seekBar.progress
            }
        }
        next.setOnClickListener {
            if (mediaPlayer.isPlaying) mediaPlayer.stop()
            mPlayer.start()

        }
        prev.setOnClickListener {
            if (mediaPlayer.isPlaying || mPlayer.isPlaying)
                mediaPlayer.stop()
            mPlayer.start()


        }


    }

    private fun ins() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TODO("Not yet implemented")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }


        })
        seekBar.max= mediaPlayer!!.duration
runnable= Runnable {
seekBar.progress=mediaPlayer!!.currentPosition
    handler.postDelayed(runnable,1000)
}
        handler.postDelayed(runnable,1000)
    }
}

