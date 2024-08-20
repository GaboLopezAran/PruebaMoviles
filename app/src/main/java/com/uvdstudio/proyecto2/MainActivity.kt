package com.uvdstudio.proyecto2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

class MainActivity : AppCompatActivity() {
    private lateinit var player: ExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val playerView = findViewById<PlayerView>(R.id.player_view)

        // Crear una instancia de ExoPlayer
        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        // Configurar la fuente del medio
        val mediaItem = MediaItem.fromUri("https://ftp.nluug.nl/pub/graphics/blender/demo/movies/Sintel.2010.720p.mkv")
        player.setMediaItem(mediaItem)

        // Preparar y comenzar la reproducción
        player.prepare()
        player.play()
    }
    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

}