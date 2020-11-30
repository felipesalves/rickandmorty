package br.com.iesb.felipe.rickmortyiesbexercicio.repository.network.service

import br.com.iesb.felipe.rickmortyiesbexercicio.repository.network.dto.ListaPersonagemDTO
import br.com.iesb.felipe.rickmortyiesbexercicio.repository.network.dto.PersonagemDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character")
    @Headers("Content-Type: application/json")
    suspend fun CharacterListAsync(): ListaPersonagemDTO

    @GET("character/{id}")
    @Headers("Content-Type: application/json")
    suspend fun CharacterDetailAsync(@Path("id") int: Int): PersonagemDTO

}