package com.balamcode.practicabanregio.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.balamcode.practicabanregio.databinding.FragmentListBinding
import com.balamcode.practicabanregio.di.PersonModule
import com.balamcode.practicabanregio.domain.models.ClickInterface

class PersonListFragment : Fragment(), ClickInterface {

    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: PersonAdapter
    private val viewModel: PersonViewModel by viewModels {
        PersonModule.providesPersonViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSettings()
    }

    private fun initSettings() {
        viewModel.uiState.observe(viewLifecycleOwner, uiStateObserver)
        viewModel.getPersonList()
        adapter = PersonAdapter(this)
        binding.rvPersonList.adapter = adapter
    }

    private val uiStateObserver = Observer<PersonUIState> { uiState ->
        when (uiState) {
            PersonUIState.Loading -> {

            }

            is PersonUIState.Fail -> {
                Toast.makeText(
                    requireContext(),
                    uiState.message.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

            is PersonUIState.ShowPersonList -> {
                adapter.addItem(uiState.list, uiState.showButton)
            }
        }
    }

    override fun loadMoreItems() {
        viewModel.getPersonList()
    }

}