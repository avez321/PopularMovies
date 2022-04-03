package com.example.moviesapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.MainActivity
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentSplashBinding
import kotlinx.coroutines.*


class SplashFragment : Fragment() {
    private lateinit var fragmentSplashBinding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentSplashBinding = FragmentSplashBinding.inflate(layoutInflater)

        (requireActivity() as MainActivity).supportActionBar?.hide()

        GlobalScope.launch {
            delay(3000)
            withContext(Dispatchers.Main){
                (requireActivity() as MainActivity).supportActionBar?.show()
                findNavController().navigate(R.id.action_splashScreenFragment_to_movieListFragment)
            }
        }

        return fragmentSplashBinding.root
    }
}