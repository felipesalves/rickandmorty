package br.com.iesb.felipe.rickmortyiesbexercicio.domain

import android.graphics.Bitmap

data class Personagem (
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