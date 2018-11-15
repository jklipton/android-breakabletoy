package com.example.kon7865.transagotchi

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kon7865.transagotchi.util.Gotchi
import com.example.kon7865.transagotchi.util.NewGamePager
import kotlinx.android.synthetic.main.activity_new_game.*

class NewGameActivity : AppCompatActivity() {

    lateinit var newGameViewModel : NewGameViewModel

    fun showMTFAvatar() {
        iv_ftm_preview.visibility = View.INVISIBLE
        iv_mtf_preview.visibility = View.VISIBLE
    }

    fun showFTMAvatar() {
        iv_ftm_preview.visibility = View.VISIBLE
        iv_mtf_preview.visibility = View.INVISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        newGameViewModel = ViewModelProviders.of(this).get(NewGameViewModel::class.java)

        //viewpager
        if (vp_game_pages != null) {
            val adapter = NewGamePager(supportFragmentManager)
            vp_game_pages.adapter = adapter
        }

        //data change listener
        val gotchiObserver = Observer<Gotchi> { observed ->
            println("JEN OBSERVED:::::::::::" + observed)
            when (observed!!.identity){
                "ftm" -> showFTMAvatar()
                "mtf" -> showMTFAvatar()
            }
        }

        //view page listener
        val pageCountObserver = Observer<Int> { page ->
            vp_game_pages.currentItem = page!!
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        newGameViewModel.ObservableGotchi.observe(this, gotchiObserver)
        newGameViewModel.ObservablePageCount.observe(this, pageCountObserver)

    }
}
