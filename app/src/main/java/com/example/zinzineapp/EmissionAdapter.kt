package com.example.zinzineapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class EmissionAdapter(private val emissions: List<Emission>) :
    RecyclerView.Adapter<EmissionAdapter.EmissionViewHolder>() {


    class EmissionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val durationTextView: TextView = itemView.findViewById(R.id.durationTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmissionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_emission, parent, false)
        return EmissionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EmissionViewHolder, position: Int) {
        val currentEmission = emissions[position]
        holder.titleTextView.text = currentEmission.titre
        holder.dateTextView.text = currentEmission.datepub
        holder.durationTextView.text = currentEmission.duree.toString()
        holder.descriptionTextView.text = currentEmission.descriptif
    }

    override fun getItemCount() = emissions.size
}


