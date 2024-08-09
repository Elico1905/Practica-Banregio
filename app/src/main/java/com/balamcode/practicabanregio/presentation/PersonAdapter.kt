package com.balamcode.practicabanregio.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.balamcode.practicabanregio.databinding.ItemButtonBinding
import com.balamcode.practicabanregio.databinding.ItemPersonBinding
import com.balamcode.practicabanregio.domain.models.AdapterType
import com.balamcode.practicabanregio.domain.models.ClickInterface
import com.balamcode.practicabanregio.domain.models.ClientInformationModel

class PersonAdapter(private val listener: ClickInterface) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList = ArrayList<Any>()
    private var lastItem: String = "Button"
    fun addItem(list: List<Any>, showButton: Boolean) {
        if (itemList.isNotEmpty()) {
            itemList.removeLast()
        }
        itemList.addAll(list)
        if (showButton) {
            itemList.add(lastItem)
        }
        notifyItemRangeInserted(itemList.size, list.size)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            AdapterType.CLIENT.position -> {
                PersonViewHolder(
                    ItemPersonBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            AdapterType.BUTTON.position -> {
                ButtonViewHolder(
                    ItemButtonBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    listener
                )
            }

            else -> {
                throw IllegalArgumentException("Invalid view type")
            }

        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PersonViewHolder -> {
                holder.bind(itemList[position] as ClientInformationModel)
            }

            is ButtonViewHolder -> {
                holder.bind()
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is ClientInformationModel -> AdapterType.CLIENT.position
            else -> AdapterType.BUTTON.position

        }
    }

    inner class PersonViewHolder(
        private val binding: ItemPersonBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(person: ClientInformationModel) {
            binding.tvName.text = person.firstName
        }
    }

    inner class ButtonViewHolder(
        private val binding: ItemButtonBinding,
        private val listener: ClickInterface
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.btnLoadMoreItems.setOnClickListener {
                listener.loadMoreItems()
            }
        }
    }

}

