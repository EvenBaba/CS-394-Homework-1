package com.evenbaba.cs394hw1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.evenbaba.cs394hw1.databinding.ActivityGameBinding

class GameDetailActivity : AppCompatActivity() {
    companion object{
        const val GAME_NAME = "game_name"
        const val GAME_DEV = "game_developer"
        const val GAME_DATE = "game_releasedate"
        const val GAME_IMAGE_ID = "game_image_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_game)
        val binding: ActivityGameBinding = DataBindingUtil.setContentView(this, R.layout.activity_game)

        val gameName = intent.getStringExtra(GAME_NAME)
        val gameDeveloper = intent.getStringExtra(GAME_DEV)
        val gameReleaseDate = intent.getStringExtra(GAME_DATE)
        val gameImageId = intent.getIntExtra(GAME_IMAGE_ID, 0)
        binding.gameImageView.setImageResource(gameImageId)


        binding.nameView.text = gameName
        binding.developerView.text = gameDeveloper
        binding.releaseView.text = gameReleaseDate

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}