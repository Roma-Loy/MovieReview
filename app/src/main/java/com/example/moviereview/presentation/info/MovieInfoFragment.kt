package com.example.moviereview.presentation.info

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.moviereview.Links.POSTER_URL
import com.example.moviereview.databinding.FragmentMovieInfoBinding


class MovieInfoFragment : Fragment() {
    lateinit var binding: FragmentMovieInfoBinding
    lateinit var viewmodel: MovieInfoViewModel
    private val args: MovieInfoFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewmodel = ViewModelProvider(this).get(MovieInfoViewModel::class.java)
        binding = FragmentMovieInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.getMovies(args.movie.id)
        viewmodel.movieDetails.observe(viewLifecycleOwner) { response ->
            val movieDetails = response.body()
            if (movieDetails != null) {
                with(binding) {
                    movieOverviewLabel.text = movieDetails.title
                    movieReleaseDate.text = "Дата виходу: ${movieDetails.release_date}"
                    movieOverview.text = movieDetails.overview
                    movieRating.text = movieDetails.vote_average.toString()
                    tag.text = movieDetails.tagline

                    Glide.with(moviePoster.context)
                        .load(POSTER_URL + movieDetails.poster_path)
                        .into(moviePoster)

                }
            }
        }

    }
}