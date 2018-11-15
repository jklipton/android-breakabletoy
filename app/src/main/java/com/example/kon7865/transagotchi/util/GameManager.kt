package com.example.kon7865.transagotchi.util

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson

abstract class GameManager {

    companion object {
        fun saveGame(gotchi: Gotchi, context: Context) {
            val prefEditor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            val gotchiJson = Gson().toJson(gotchi)
            prefEditor.putString("game", gotchiJson).apply()
        }

        fun loadGame(context: Context): Gotchi{
            val savedGame = PreferenceManager.getDefaultSharedPreferences(context)
            val gameJson = savedGame.getString("game", null)

            return if (gameJson !=null)
                Gson().fromJson(gameJson, Gotchi::class.java)
            else
                Gotchi("", "", 1, emptySet())
        }
    }

//    val gson = Gson()
//    lateinit var SAVED_GAME : Gotchi
//
//    fun checkForSavedGame(context: Context){
//        val savedGames = context.getSharedPreferences(SAVED_GAME, Context.MODE_PRIVATE)
//    }
//
//    fun loadSavedGame(gameId: Int) {
//     //return gotchi w/id
//    }
//
//    fun newGame(gotchi: NewGotchi) {
//
//
//        val gotchiJson = gson.toJson(gotchi)
//
//
//        //return gotchi w/id
//    }
//
//    fun saveGame(gotchi: Gotchi, gameId: Int) {
//
//
//        SharedPreferences sharedPreferences = getSharedPreferences("saved game", MODE_PRIVATE)
//        SharedPreferences.Editor editor = sharedpreferences.edit()
//        Gson gson = gson()
//        String json = gson.toJson(gotchi)
//        editor.putString("first game", json)
//        editor.apply()
//        //return gotchi w/id
//    }
}