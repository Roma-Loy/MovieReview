package com.example.moviereview.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.moviereview.databinding.FragmentMovieListBinding

class MovieListFragment : Fragment() {

    lateinit var binding: FragmentMovieListBinding
    lateinit var adapter: MovieListAdapter
    lateinit var viewmodel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewmodel = ViewModelProvider(this).get(MovieListViewModel::class.java)
        binding = FragmentMovieListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieListAdapter { movie, position ->
            findNavController().navigate(MovieListFragmentDirections.actionMovieListFragmentToMovieInfoFragment())

        }
        binding.recycler.adapter = adapter
        viewmodel.getMovies()
        viewmodel.myMovies.observe(viewLifecycleOwner) {
            adapter.setMoviesList(it.body()!!.results)
        }


    }
}