package com.example.composemovie.movieapp.core.data.remote

import com.example.composemovie.movieapp.core.data.remote.response.MovieDetailResponse
import com.example.composemovie.movieapp.core.data.remote.response.MovieResponse
import com.example.composemovie.movieapp.core.data.remote.response.MovieSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): MovieResponse

    @GET("search/multi")
    suspend fun searchMovie(
        @Query("page") page: Int,
        @Query("query") query: String
    ): MovieSearchResponse

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Query("movie_id") movieId: Int
    ): MovieDetailResponse

    @GET("movie/{movie_id}/similar")
    suspend fun getMoviesSimilar(
        @Query("movie_id") movieId: Int,
        @Query("page") page: Int
    ): MovieResponse
}