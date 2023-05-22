package com.example.moviereview.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviereview.Links.POSTER_BASE_URL
import com.example.moviereview.databinding.MovieItemBinding
import com.example.moviereview.model.Movie

class MovieListAdapter(val onClick: (model: Movie, position: Int) -> Unit) :
    RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private var moviesList = emptyList<Movie>()
    inner class MovieViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, position: Int) {
            var moviePosterPath = POSTER_BASE_URL + movie.poster_path

            with(binding) {
                binding.title.text = movie.title
                binding.description.text = movie.overview
                binding.releaseDate.text = movie.release_date

                btn.setOnClickListener {
                    onClick(movie, position)
                }

                Glide.with(binding.firstImage.context)
                    .load(moviePosterPath)
                    .into(binding.firstImage)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.bind(movie, position)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun setMoviesList(newList: List<Movie>) {
        val diffCallback = MovieDiffCallback(moviesList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        moviesList = newList
        diffResult.dispatchUpdatesTo(this)
    }

    inner class MovieDiffCallback(private val oldList: List<Movie>, private val newList: List<Movie>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}