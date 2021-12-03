package com.example.marvelapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.marvelapp.MarvelApplication
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.domain.HomeItem
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.ui.base.ParentAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    @Inject
    @Named("first_string")
    lateinit var injectedField: String

    override fun setup() {

        binding.recyclerHome.adapter = ParentAdapter(mutableListOf(), viewModel)


//        (requireActivity().application as MarvelApplication).container
//        Toast.makeText(requireContext(), injectedField, Toast.LENGTH_SHORT).show()
    }

}