package com.balamcode.practicabanregio.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.balamcode.practicabanregio.databinding.ItemPersonBinding
import com.balamcode.practicabanregio.domain.models.ClientInformationModel

class PersonAdapter : RecyclerView.Adapter<PersonViewHolder>() {

    private var itemList = mutableListOf<ClientInformationModel>()

    fun addItem(list: List<ClientInformationModel>) {
        val startPosition = itemList.size
        itemList.addAll(list)
        notifyItemRangeInserted(startPosition, list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            ItemPersonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

}

class PersonViewHolder(
    private val binding: ItemPersonBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(person:  ClientInformationModel) {
        binding.tvName.text = person.firstName
    }

}