package br.com.iesb.felipe.rickmortyiesbexercicio.repository

import br.com.iesb.felipe.rickmortyiesbexercicio.domain.Personagem
import br.com.iesb.felipe.rickmortyiesbexercicio.repository.network.connector.Conector
import br.com.iesb.felipe.rickmortyiesbexercicio.repository.network.service.RickAndMortyService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class RickAndMortyRepository {
    private val conector: Conector = Conector()
    private val connector = conector.createConnector()

    suspend fun getCharactersDetail(id: Int): Personagem {
        val service = connector.create(RickAndMortyService::class.java)

        return withContext(Dispatchers.IO) {
            val result = service.CharacterDetailAsync(id)

            val  resposta =
                Personagem(
                    id = result.id,
                    name = result.name,
                    status = result.status,
                    species = result.species,
                    type = result.type,
                    gender = result.gender,
                    origin = result.origin,
                    location = result.location,
                    image = result.image,
                    episode = result.episode,
                    url = result.url,
                    created = result.created
                )

            resposta
        }
    }


    suspend fun getCharacters(): List<Personagem> {
        val service = connector.create(RickAndMortyService::class.java)

        return withContext(Dispatchers.IO) {
            val result = service.CharacterListAsync().results

            val  resposta = result.map { dto ->
                Personagem(
                    id = dto.id,
                    name = dto.name,
                    status = dto.status,
                    species = dto.species,
                    type = dto.type,
                    gender = dto.gender,
                    origin = dto.origin,
                    location = dto.location,
                    image = dto.image,
                    episode = dto.episode,
                    url = dto.url,
                    created = dto.created
                )

            }
            resposta
        }

    }

}