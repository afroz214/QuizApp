package com.smartherd.quizapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playVideo()

    }
    fun openActivity(view:View){
        startActivity(Intent(this@MainActivity, QuizActivity::class.java))
    }
    fun playVideo(){
        val video_uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_three)
        background_videoview.setVideoURI(video_uri)
        background_videoview.start()
    }
}
