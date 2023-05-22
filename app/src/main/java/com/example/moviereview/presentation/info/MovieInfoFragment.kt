package com.example.moviereview.presentation.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.moviereview.databinding.FragmentMovieInfoBinding


class MovieInfoFragment : Fragment() {

    lateinit var binding: FragmentMovieInfoBinding
    lateinit var viewmodel: MovieInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewmodel = ViewModelProvider(this).get(MovieInfoViewModel::class.java)
        binding = FragmentMovieInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}