package com.evenbaba.cs394hw1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.evenbaba.cs394hw1.R
import com.evenbaba.model.cs394hw1.model.Game
import com.evenbaba.cs394hw1.GameDetailActivity

class ItemAdapter(private val data: List<Game>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var game: Game

        val nameView: TextView = view.findViewById(R.id.nameTV)
        val developerView: TextView = view.findViewById(R.id.developerTV)
        init {
            view.setOnClickListener{
                val context = itemView.context
                val showIntent = Intent(context, GameDetailActivity::class.java)
                showIntent.putExtra(GameDetailActivity.GAME_NAME, game.name)
                showIntent.putExtra(GameDetailActivity.GAME_DEV, game.developer)
                showIntent.putExtra(GameDetailActivity.GAME_DATE, game.releasedate)
                showIntent.putExtra(GameDetailActivity.GAME_IMAGE_ID, game.imageId)
                context.startActivity(showIntent)
            }
        }
        fun bind(game: Game){
            this.game = game
            nameView.text = game.name
            developerView.text = game.releasedate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val game = data[position]
        holder.bind(game)
//        holder.nameView.text = game.name
//        holder.developerView.text = game.developer
    }
}