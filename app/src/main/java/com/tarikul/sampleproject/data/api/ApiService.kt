package com.tos.myapplication.data.api


import com.tarikul.sampleproject.data.api.Endpoint.DISCOVER_MOVIE
import com.tarikul.sampleproject.data.api.Endpoint.DISCOVER_TV
import com.tarikul.sampleproject.data.api.Endpoint.TRENDING_MOVIE
import com.tarikul.sampleproject.data.api.QueryMovie.API_KEY
import com.tarikul.sampleproject.data.api.QueryMovie.API_KEY_VALUE
import com.tarikul.sampleproject.data.api.QueryMovie.INCLUDE_ADULT
import com.tarikul.sampleproject.data.api.QueryMovie.INCLUDE_ADULT_DEFAULT
import com.tarikul.sampleproject.data.api.QueryMovie.INCLUDE_NULL_FIRST
import com.tarikul.sampleproject.data.api.QueryMovie.INCLUDE_NULL_FIRST_DEFAULT
import com.tarikul.sampleproject.data.api.QueryMovie.LANGUAGE
import com.tarikul.sampleproject.data.api.QueryMovie.LANGUAGE_DEFAULT
import com.tarikul.sampleproject.data.api.QueryMovie.PAGE
import com.tarikul.sampleproject.data.api.QueryMovie.SORT_BY
import com.tarikul.sampleproject.data.api.QueryMovie.SORT_BY_DEFAULT
import com.tarikul.sampleproject.data.api.QueryMovie.TIMEZONE
import com.tarikul.sampleproject.data.api.QueryMovie.TIMEZONE_DEFAULT
import com.tarikul.sampleproject.data.model.movieList.MovieListResponse
import com.tarikul.sampleproject.data.model.trendingList.TrendingListResponse
import com.tarikul.sampleproject.data.model.tvShowList.TvShowListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(DISCOVER_MOVIE)
    suspend fun getMovies(
        @Query(PAGE) page: Int,
        @Query(SORT_BY) sortBy: String = SORT_BY_DEFAULT,
        @Query(LANGUAGE) language: String = LANGUAGE_DEFAULT,
        @Query(INCLUDE_ADULT) includeAdult: Boolean = INCLUDE_ADULT_DEFAULT,
        @Query(API_KEY) apiKey: String = API_KEY_VALUE
    ): MovieListResponse

    @GET("$TRENDING_MOVIE{dayOrWeek}")
    suspend fun getTrendingMovies(
        @Path(value = "dayOrWeek", encoded = true) dayOrWeek: String,
        @Query(API_KEY) apiKey: String = API_KEY_VALUE
    ): TrendingListResponse


    @GET(DISCOVER_TV)
    suspend fun getTvShow(
        @Query(PAGE) page: Int,
        @Query(SORT_BY) sortBy: String = SORT_BY_DEFAULT,
        @Query(LANGUAGE) language: String = LANGUAGE_DEFAULT,
        @Query(API_KEY) apiKey: String = API_KEY_VALUE,
        @Query(TIMEZONE) timeZone: String = TIMEZONE_DEFAULT,
        @Query(INCLUDE_NULL_FIRST) includeNull: Boolean = INCLUDE_NULL_FIRST_DEFAULT
    ): TvShowListResponse

}