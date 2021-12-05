package com.example.marvelapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named
import androidx.navigation.fragment.findNavController
import com.example.marvelapp.R


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    @Inject
    @Named("first_string")
    lateinit var injectedField: String

    override fun setup() {
        binding.recyclerHome.adapter = HomeAdapter(mutableListOf(), viewModel)

        binding.searchBtn.setOnClickListener {
            homeToSearch()
        }
    }

    private fun homeToSearch() {
        val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
        val extras =
            FragmentNavigatorExtras(binding.searchBtn to getString(R.string.home_to_search_transition))
        findNavController().navigate(action, extras)
    }
}