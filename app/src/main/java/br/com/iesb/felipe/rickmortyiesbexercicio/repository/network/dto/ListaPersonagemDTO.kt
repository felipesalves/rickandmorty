package br.com.iesb.felipe.rickmortyiesbexercicio.repository.network.dto

import br.com.iesb.felipe.rickmortyiesbexercicio.domain.Informacao
import br.com.iesb.felipe.rickmortyiesbexercicio.domain.Locacao
import br.com.iesb.felipe.rickmortyiesbexercicio.domain.Origem
import br.com.iesb.felipe.rickmortyiesbexercicio.domain.Personagem

data class ListaPersonagemDTO(
    val info: Informacao,
    val results: List<PersonagemDTO>
)

data class  PersonagemDTO(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origem,
    val location: Locacao,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)