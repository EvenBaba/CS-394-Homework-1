package com.evenbaba.cs394hw1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.evenbaba.cs394hw1.adapter.ItemAdapter
import com.evenbaba.cs394hw1.data.DataSource

class MainActivity : AppCompatActivity() {
    lateinit var recView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val games = DataSource(this).loadGames()

        recView = findViewById(R.id.recycleid)

        recView.adapter = ItemAdapter(games)
        recView.setHasFixedSize(true)

    }
}