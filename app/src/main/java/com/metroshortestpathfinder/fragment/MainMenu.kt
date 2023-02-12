package com.metroshortestpathfinder.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.metroshortestpathfinder.R
import com.metroshortestpathfinder.databinding.ActivityMainBinding
import com.metroshortestpathfinder.databinding.FragmentMainMenuBinding

class MainMenu : Fragment() {
    private var _binding: FragmentMainMenuBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       binding.pathFinderCV.setOnClickListener {
           Navigation.findNavController(binding.pathFinderCV)
               .navigate(R.id.action_mainMenu_to_pathFinderFragment)
       }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}