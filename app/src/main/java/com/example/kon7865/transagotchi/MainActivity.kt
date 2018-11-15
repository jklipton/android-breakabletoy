package com.example.kon7865.transagotchi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.kon7865.transagotchi.util.GameManager
import com.example.kon7865.transagotchi.util.Gotchi

class MainActivity : AppCompatActivity() {

    lateinit var new_game : Button
    lateinit var cont_game : Button
    var hasLoadableGame = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cont_game = findViewById(R.id.btn_continue_game)
        new_game = findViewById(R.id.btn_new_game)

        val savedGame : Gotchi = GameManager.loadGame(this)
        hasLoadableGame = (savedGame !== null && savedGame.identity !=="")

        if (hasLoadableGame) { cont_game.setVisibility(View.VISIBLE) }

        new_game.setOnClickListener {
            val intent = Intent(this, NewGameActivity::class.java)
            startActivity(intent)
        }

    }
}
