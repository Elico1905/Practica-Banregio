package com.balamcode.practicabanregio.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.balamcode.practicabanregio.R
import com.balamcode.practicabanregio.databinding.FragmentListBinding
import com.balamcode.practicabanregio.di.PersonModule
import com.balamcode.practicabanregio.domain.models.ClickInterface
import com.balamcode.practicabanregio.domain.models.ClientInformationModel
import com.balamcode.practicabanregio.domain.models.PageType

class PersonListFragment : Fragment(), ClickInterface {

    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: PersonAdapter
    private val viewModel: PersonViewModel by activityViewModels {
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
        adapter = PersonAdapter(this)
        binding.rvPersonList.adapter = adapter
        viewModel.getPersonList(PageType.PAGE_1.value)
        binding.btnOption1.setOnClickListener { viewModel.getPersonList(PageType.PAGE_1.value) }
        binding.btnOption2.setOnClickListener { viewModel.getPersonList(PageType.PAGE_2.value) }
        binding.btnOption3.setOnClickListener { viewModel.getPersonList(PageType.PAGE_3.value) }
    }

    private val uiStateObserver = Observer<PersonUIState> { uiState ->
        when (uiState) {
            PersonUIState.Loading -> {

            }

            is PersonUIState.Fail -> {
                Log.d("Documento", uiState.message.toString())
                Toast.makeText(
                    requireContext(),
                    uiState.message.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

            is PersonUIState.ShowPersonList -> {
                adapter.addItem(uiState.list)
            }
        }
    }

    override fun showDetails(item: ClientInformationModel) {
        viewModel.client = item

        findNavController().navigate(R.id.list_fragment_to_detail_fragment)
    }

}