package com.carol.musyoka.superhero.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carol.musyoka.superhero.R
import com.carol.musyoka.superhero.data.model.Hero
import kotlinx.android.synthetic.main.item_superhero.view.*

class MainAdapter(private val result: ArrayList<Hero>,
                  private val clickListener: (Long) -> Unit):
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(hero: Hero, clickListener: (Long) -> Unit ) {
            itemView.apply {
                superheroName.text = hero.name
                Glide.with(superheroImage.context)
                    .load(hero.image.md)
                    .into(superheroImage)

                superheroName.setOnClickListener { clickListener(hero.id) }
                superheroImage.setOnClickListener { clickListener(hero.id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false))

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(result[position],clickListener)
    }

    fun addSuperHeroes(hero: List<Hero>) {
        this.result.apply {
            clear()
            addAll(hero)
        }

    }
}