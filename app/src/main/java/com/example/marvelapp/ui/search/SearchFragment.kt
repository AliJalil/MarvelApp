package com.example.marvelapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.marvelapp.MarvelApplication
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.databinding.FragmentSearchBinding
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.ui.home.CharacterAdapter
import com.example.marvelapp.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val viewModel: SearchViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

//    @Inject
//    @Named("first_string")
//    lateinit var injectedField: String

    override fun setup() {
        binding.searchRecycler.adapter = SearchAdapter(mutableListOf(), viewModel)
//        (requireActivity().application as MarvelApplication).container
//        Toast.makeText(requireContext(), injectedField, Toast.LENGTH_SHORT).show()
    }

}