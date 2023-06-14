package com.creativem.bibliotecaipuc.mp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.creativem.bibliotecaipuc.R
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Player.Listener
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerControlView
import java.util.ArrayList

class mp3Activity : AppCompatActivity(),Listener  {

    lateinit var  player: SimpleExoPlayer
    lateinit var  PlayerView: PlayerControlView
    lateinit var  mediaItemList: ArrayList<MediaItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mp3)

        mediaItemList = ArrayList()
        getRadios()
    }


    private fun getRadios(){

        val data = arrayOf(
            "https://play14.tikast.com:22038/stream?type=http&nocache=438",
            )
        for (posicion in data.indices){
            val item:MediaItem = MediaItem.Builder()
                .setUri(data.get(posicion))
                .build()
            mediaItemList.add(item)
        }
        PlayerMusic()
    }

    private fun PlayerMusic(){
        player = SimpleExoPlayer.Builder(this).build()
        PlayerView = findViewById(R.id.player)
        val param = PlaybackParameters(1f)
        player.playbackParameters = param
        player.addListener(this)
        player.repeatMode = Player.REPEAT_MODE_ALL
        PlayerView.player = player
        player.addMediaItems(mediaItemList)
        player.prepare()
    }
}