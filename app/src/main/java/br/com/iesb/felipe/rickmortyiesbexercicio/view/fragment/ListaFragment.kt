package br.com.iesb.felipe.rickmortyiesbexercicio.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.iesb.felipe.rickmortyiesbexercicio.R
import br.com.iesb.felipe.rickmortyiesbexercicio.databinding.FragmentListaBinding
import br.com.iesb.felipe.rickmortyiesbexercicio.view.adapter.RickAndMortyAdapter
import br.com.iesb.felipe.rickmortyiesbexercicio.viewmodel.RickAndMortyViewModel
import com.bumptech.glide.Glide.with
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.with
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.with
import com.squareup.picasso.Picasso


class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    private val viewModel: RickAndMortyViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListaBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerVieww()
    }

    private fun setupRecyclerVieww(){
        val recycleListView = binding.ryCharacteres
        recycleListView.layoutManager = LinearLayoutManager(context)

        viewModel.personagens.observe(viewLifecycleOwner) { list ->
            recycleListView.adapter = RickAndMortyAdapter(list) {

                var bundle = bundleOf("id" to it.id,
                "imagemAvatar" to it.image)
                findNavController().navigate(R.id.action_listaFragment_to_detalheFragment, bundle)
            }
        }

        viewModel.getCharacters()
    }


}