package com.evenbaba.cs394hw1.data

import android.content.Context
import com.evenbaba.cs394hw1.R
import com.evenbaba.model.cs394hw1.model.Game

class DataSource(val context: Context) {
    fun getNames(): Array<String>{
        return context.resources.getStringArray(R.array.names)
    }
    fun getDevelopers(): Array<String>{
        return context.resources.getStringArray(R.array.developers)
    }
    fun getReleaseDates(): Array<String> {
        return context.resources.getStringArray(R.array.releasedates)
    }

    fun loadGames(): List<Game>{
        val namesList = getNames()
        val developerlist = getDevelopers()
        val datelist  = getReleaseDates()
        val imageIds = arrayOf(
            R.drawable.clashofclans,
            R.drawable.clashroyale,
            R.drawable.minecraft,
            R.drawable.geometrydash,
            R.drawable.subwaysurfers,
            R.drawable.jetpackjoyride,
            R.drawable.pokemongo,
            R.drawable.amongus,
            R.drawable.pubgmobile,
            R.drawable.crossyroad,
            R.drawable.templerun,
            R.drawable.roblox,
            R.drawable.akinator
        )

        val gameList = mutableListOf<Game>()
        for (i in namesList.indices){
            gameList.add(Game(namesList[i], developer = developerlist[i], releasedate = datelist[i], imageId = imageIds[i]))
        }
        return gameList
    }
}