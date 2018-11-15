package com.example.kon7865.transagotchi

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import kotlinx.android.synthetic.main.fragment_new_game2.*
import java.lang.Exception

class NewGameFragment2 : Fragment() {

    lateinit var newGameViewModel : NewGameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_game2, container, false )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newGameViewModel = ViewModelProviders.of(activity!!).get(NewGameViewModel::class.java)

        //fragment arrow controls
        btn_new_game_back.setOnClickListener{newGameViewModel.goPageFragment(0)}

        //name change listener
        et_gotchi_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                newGameViewModel.setChosenName(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        //support drop down listener
        sp_support.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                newGameViewModel.setSupportLevel(parent!!.getItemAtPosition(position))
            }
            override fun onNothingSelected(parent: AdapterView<*>?) { }
        }

        btn_new_game_start.setOnClickListener {
            try {
                newGameViewModel.saveNewGotchi(context!!)
            }
            catch( e: Exception) {
                tv_new_game_error.text = "Please enter a name for your Transagotchi!"
            }

        }
    }

}