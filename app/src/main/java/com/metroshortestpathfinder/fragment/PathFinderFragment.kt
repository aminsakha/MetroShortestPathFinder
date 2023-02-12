package com.metroshortestpathfinder.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.metroshortestpathfinder.Result
import com.metroshortestpathfinder.databinding.FragmentPathFinderBinding
import com.metroshortestpathfinder.initiateStations
import com.metroshortestpathfinder.stationList


class PathFinderFragment : Fragment() {
    private var _binding: FragmentPathFinderBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPathFinderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiateStations(requireContext())
        val stationNames = mutableSetOf<String>()
        for (station in stationList) {
            stationNames.add(station.name)
        }
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.select_dialog_item,
            stationNames.toList()
        )
        binding.a1.threshold = 2
        binding.a2.threshold = 2
        binding.a1.setAdapter(adapter)
        binding.a2.setAdapter(adapter)
        var startNodeName = ""

        var destNodeName = ""

        binding.a1.onItemClickListener = OnItemClickListener { arg0, arg1, arg2, arg3 ->
            startNodeName = arg0.getItemAtPosition(arg2).toString()
        }
        binding.a2.onItemClickListener = OnItemClickListener { arg0, arg1, arg2, arg3 ->
            destNodeName = arg0.getItemAtPosition(arg2).toString()
        }

        binding.findPathBTN.setOnClickListener {
            val res = Result(requireContext(), startNodeName, destNodeName)
            Log.d("output", res.printResult().toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}