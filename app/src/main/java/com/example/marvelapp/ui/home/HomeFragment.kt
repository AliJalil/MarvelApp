package com.example.marvelapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.marvelapp.MarvelApplication
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.ui.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>()  {

    override val viewModel: HomeViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun setup() {
        binding.recyclerHome.adapter = CharacterAdapter(mutableListOf(), viewModel)
        (requireActivity().application  as MarvelApplication).container

    }

}