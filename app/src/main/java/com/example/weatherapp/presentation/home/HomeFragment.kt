package com.example.weatherapp.presentation.home

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.data.datasource.remote.api.network.NetworkState
import com.example.weatherapp.databinding.FragmentHomeBinding
import com.example.weatherapp.utils.checkDeviceLocationSettings
import com.example.weatherapp.utils.checkIfGPSIsEnabled
import com.example.weatherapp.utils.checkLocationPermission
import com.example.weatherapp.utils.showAlert
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var locationPermissionRequest: ActivityResultLauncher<String?>
    private lateinit var gpsLauncher: ActivityResultLauncher<IntentSenderRequest?>
    private var currentUserLocation: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)

        observeDate()
        binding.search.setOnEditorActionListener { text, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.getCurrentWeatherByLocation(text.text.toString())
            }
            false
        }

        handleClickListener()
        return binding.root
    }

    private fun handleClickListener() {
        binding.location.setOnClickListener {
            checkLocationPermission()
            binding.search.setText("")
        }

        binding.next5days.setOnClickListener {
            if (findNavController().currentDestination?.id == R.id.homeFragment) {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToForecastFragment(
                        currentUserLocation
                    )
                )
            }
        }
    }

    private fun observeDate() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.currentLocationFlow.collectLatest { response ->
                    when (response) {
                        NetworkState.Idle -> {}
                        NetworkState.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }

                        is NetworkState.Success -> {
                            binding.model = response.data
                            binding.progressBar.visibility = View.GONE

                        }

                        is NetworkState.Error -> {
                            binding.progressBar.visibility = View.GONE
                            showAlert(requireContext(), response.error ?: "")

                        }

                    }

                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (!isGranted) {
                binding.progressBar.visibility = View.GONE

                showAlert(
                    requireContext(),
                    "Location Required"
                ) {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    val uri = Uri.fromParts("package", requireActivity().packageName, null)
                    intent.data = uri
                    requireActivity().startActivity(intent)
                }
            } else {
                checkLocationPermission()
            }
        }

        gpsLauncher =
            registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult())
            { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    // Your logic
                    lifecycleScope.launch {
                        delay(3000)
                        callWeatherAPI()
                    }
                } else {
                    binding.progressBar.visibility = View.GONE

                    showAlert(
                        requireContext(),
                        "GPS Error"
                    ) {
                    }
                }
            }
        checkLocationPermission()
    }


    private fun checkLocationPermission() {
        binding.progressBar.visibility = View.VISIBLE
        requireContext().checkLocationPermission(
            onLocationPermissionGranted = {
                checkIfGPSIsEnabled()
            },
            onLocationPermissionDenied = { permission ->
                locationPermissionRequest.launch(permission)
            })
    }

    private fun checkIfGPSIsEnabled() {
        requireContext().checkIfGPSIsEnabled(
            onGpsClosed = { checkDeviceLocationSettings() },
            onGpsOpen = { callWeatherAPI() }
        )
    }

    private fun checkDeviceLocationSettings() {

        requireContext().checkDeviceLocationSettings { exception ->
            try {
                Snackbar.make(
                    binding.root,
                    "Error", Snackbar.LENGTH_INDEFINITE
                ).setAction("OK") {
                    val intentSenderRequest = IntentSenderRequest
                        .Builder(exception).build()
                    if (isAdded) {
                        gpsLauncher.launch(intentSenderRequest)
                    }
                }.show()
            } catch (sendEx: IntentSender.SendIntentException) {
                Log.d("TAG", "Error getting location settings resolution: " + sendEx.message)
            }
        }

    }


    fun callWeatherAPI() {

        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            checkLocationPermission()
            return
        }

        val mLocationRequest = LocationRequest.create()
        mLocationRequest.setInterval(60000)
        mLocationRequest.setFastestInterval(5000)
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        val mLocationCallback: LocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                val location = locationResult.lastLocation
                currentUserLocation = "${location.latitude},${location.longitude}"
                viewModel.getCurrentWeatherByLocation(currentUserLocation)

            }

        }
        LocationServices.getFusedLocationProviderClient(requireContext())
            .requestLocationUpdates(mLocationRequest, mLocationCallback, null)

    }

}