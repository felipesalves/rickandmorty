package br.com.iesb.felipe.rickmortyiesbexercicio.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.iesb.felipe.rickmortyiesbexercicio.R
import br.com.iesb.felipe.rickmortyiesbexercicio.databinding.ItemCharacterBinding
import br.com.iesb.felipe.rickmortyiesbexercicio.domain.Personagem
import com.bumptech.glide.GenericTransitionOptions.with
import com.bumptech.glide.Glide.with
import com.squareup.picasso.Picasso
import java.security.AccessController.getContext

class RickAndMortyAdapter(
    private val characters: List<Personagem>,
    private val onItemClick: ((Personagem) -> Unit)
) : RecyclerView.Adapter<RickAndMortyAdapter.ViewHolder>(){

    override fun onCreateViewHolder( parent: ViewGroup,viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val binding = holder.binding
        binding?.character = characters[position]
        binding?.executePendingBindings()

        if (binding != null) {
            Picasso.get().load(binding?.character?.image).into(binding.imageView)
        }
    }

    override fun getItemCount(): Int = characters.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemCharacterBinding? = ItemCharacterBinding.bind(view)

        init {
            view.setOnClickListener{
                onItemClick.invoke(characters[adapterPosition])
            }
        }
    }

}