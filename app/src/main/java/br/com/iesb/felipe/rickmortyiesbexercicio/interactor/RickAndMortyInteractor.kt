package br.com.iesb.felipe.rickmortyiesbexercicio.interactor

import br.com.iesb.felipe.rickmortyiesbexercicio.domain.ListaPersonagem
import br.com.iesb.felipe.rickmortyiesbexercicio.domain.Personagem
import br.com.iesb.felipe.rickmortyiesbexercicio.repository.RickAndMortyRepository

class RickAndMortyInteractor {

    private val repository = RickAndMortyRepository()

    suspend fun getCharacters() : List<Personagem> {
       return repository.getCharacters()
    }

    suspend fun getCharactersDetail(id: Int) : Personagem {
        return repository.getCharactersDetail(id)
    }



}