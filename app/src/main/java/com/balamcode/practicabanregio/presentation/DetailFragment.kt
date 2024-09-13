package com.balamcode.practicabanregio.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.balamcode.practicabanregio.databinding.FragmentDetailBinding
import com.balamcode.practicabanregio.di.PersonModule

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: PersonViewModel by activityViewModels {
        PersonModule.providesPersonViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSettings()
    }

    private fun initSettings() {
        viewModel.client?.let {
            binding.tv.text = it.firstName
        }
    }
}