package com.example.weatherapp.presentation.forecast

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.example.weatherapp.R
import com.example.weatherapp.data.datasource.remote.api.network.NetworkState
import com.example.weatherapp.databinding.FragmentForecastBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ForecastFragment : Fragment() {

    private lateinit var binding: FragmentForecastBinding
    private val viewModel: ForecastViewModel by viewModels()
    private val args: ForecastFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentForecastBinding.inflate(inflater)

        if (args.location.isNotEmpty()) {
            viewModel.getNextFiveDays(args.location)
        }

        observeData()
        return binding.root
    }

    private fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.forecastFlow.collectLatest { response ->
                    when (response) {
                        is NetworkState.Idle -> {}
                        is NetworkState.Loading -> {}
                        is NetworkState.Success -> {
                            binding.rvForecast.adapter = ForecastAdapter(response.data.forecast)
                        }

                        is NetworkState.Error -> {}
                    }
                }
            }
        }
    }

}