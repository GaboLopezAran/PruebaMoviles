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
<<<<<<< HEAD
        val mediaItem = MediaItem.fromUri("https://ftp.nluug.nl/pub/graphics/blender/demo/movies/Sintel.2010.720p.mkv")
=======
        val mediaItem = MediaItem.fromUri("https://3nvtw3l3ngz1d.pradoi.com/v/01/04709/emjcdztwo165_h/281532--b1f0edd8-e12c-467f-9ca6-65bc213674cf--yujp--2468939-streamwish.mp4?t=gCTe8i4Z7fa526AXA6e_gnEl_i5EUO" +
                "S0l7rphw5QgNU&s=1724116085&e=129600&f=23545352&sp=400&i=0.0")
>>>>>>> 650922fdb6f412e1306a990846775e009a9e8e3a
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