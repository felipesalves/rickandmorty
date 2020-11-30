package br.com.iesb.felipe.rickmortyiesbexercicio.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.iesb.felipe.rickmortyiesbexercicio.databinding.FragmentDetalheBinding
import br.com.iesb.felipe.rickmortyiesbexercicio.viewmodel.RickAndMortyViewModel
import com.squareup.picasso.Picasso
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class DetalheFragment : Fragment() {


    private lateinit var binding: FragmentDetalheBinding
    private val viewModel: RickAndMortyViewModel by lazy{
        ViewModelProvider(this).get(RickAndMortyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalheBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterDetail()
    }

    private fun characterDetail(){
        val idCharacter = arguments?.getInt("id")
        val urlImagem = arguments?.getString("imagemAvatar")

        Picasso.get().load(urlImagem).into(binding.ivAvatar)

         idCharacter?.let { viewModel.getCharactersDetail(it) }
    }


}