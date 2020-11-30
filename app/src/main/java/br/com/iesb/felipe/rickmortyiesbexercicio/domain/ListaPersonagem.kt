package br.com.iesb.felipe.rickmortyiesbexercicio.domain

data class ListaPersonagem(
    var info: Informacao,
    var results: List<Personagem>
)