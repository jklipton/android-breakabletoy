package com.example.kon7865.transagotchi

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.kon7865.transagotchi.util.GameManager
import com.example.kon7865.transagotchi.util.Gotchi
import java.lang.Exception

class NewGameViewModel: ViewModel() {

    var ObservableGotchi: MutableLiveData<Gotchi> = MutableLiveData()
    var ObservablePageCount: MutableLiveData<Int> = MutableLiveData()

    fun getIdentityChoice() : LiveData<Gotchi> = ObservableGotchi
    fun getPageCount() : LiveData<Int> = ObservablePageCount

    init {
        ObservableGotchi.postValue(Gotchi("ftm", "", 3, emptySet()))
        ObservablePageCount.postValue(0)
    }

    fun toggleIdentityChoice(identity: String) {
        ObservableGotchi.postValue(ObservableGotchi.value!!.copy(identity = identity))
    }

    fun setSupportLevel(level: Any) {
        var supportInt: Int

        when(level) {
            "Low" -> supportInt = 1
            "Mid" -> supportInt = 2
            else -> supportInt = 3
        }

        ObservableGotchi.postValue(ObservableGotchi.value!!.copy(support = supportInt))
    }

    fun setChosenName(name: String) {
        ObservableGotchi.postValue(ObservableGotchi.value!!.copy(name = name))
    }

    fun goPageFragment(page: Int){
        ObservablePageCount.postValue(page)
    }

    fun saveNewGotchi(context: Context) {
        if (ObservableGotchi.value!!.name !== "") {
                val toSaveGotchi = Gotchi(
                    ObservableGotchi.value!!.name,
                    ObservableGotchi.value!!.identity,
                    ObservableGotchi.value!!.support,
                    ObservableGotchi.value!!.events
                )
                GameManager.saveGame(toSaveGotchi, context)
            }
        else {
            throw Exception("Gotchi Name must not be null")
        }
    }

}
