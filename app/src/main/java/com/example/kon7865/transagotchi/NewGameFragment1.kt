package com.example.kon7865.transagotchi

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_new_game1.*

class NewGameFragment1 : Fragment() {

    lateinit var newGameViewModel : NewGameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_game1, container, false ) as View
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newGameViewModel = ViewModelProviders.of(activity!!).get(NewGameViewModel::class.java)

        //toggle identity choices
        rb_ftm_choice.setOnClickListener{newGameViewModel.toggleIdentityChoice("ftm")}
        rb_mtf_choice.setOnClickListener{newGameViewModel.toggleIdentityChoice("mtf")}

        //button managers
        btn_new_game_next.setOnClickListener{newGameViewModel.goPageFragment(1)}
        btn_new_game_cancel.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
    }

}