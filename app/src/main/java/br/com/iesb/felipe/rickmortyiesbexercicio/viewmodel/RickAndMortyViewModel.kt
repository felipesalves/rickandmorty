package br.com.iesb.felipe.rickmortyiesbexercicio.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.iesb.felipe.rickmortyiesbexercicio.domain.Personagem
import br.com.iesb.felipe.rickmortyiesbexercicio.interactor.RickAndMortyInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext


class RickAndMortyViewModel(
    val app: Application
) : AndroidViewModel(app), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val interactor = RickAndMortyInteractor()

    val personagens = MutableLiveData<List<Personagem>>()
    var perseonagemDetail = MutableLiveData<Personagem>()


    fun getCharacters() {

        launch {
            try {
                val personagemList = interactor.getCharacters()

                personagens.value = personagemList

            } catch (t: Throwable) {
                Log.d("RickAndMorty", "Error on Coroutine getCharacters: ${t.localizedMessage}")
                Toast.makeText(app.applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getCharactersDetail(id: Int) {
        launch {
            try {
                val personagemDetail = interactor.getCharactersDetail(id)

                perseonagemDetail.value = personagemDetail

            } catch (t: Throwable) {
                Log.d("RickAndMorty", "Error on Coroutine getCharactersDetail: ${t.localizedMessage}")
                Toast.makeText(app.applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

}