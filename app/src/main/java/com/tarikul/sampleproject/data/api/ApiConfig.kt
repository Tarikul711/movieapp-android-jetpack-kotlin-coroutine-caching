package com.tarikul.sampleproject.data.api

/**
 *Created by tarikul on 28/9/20
 */

object BaseUrl {
    const val API_BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_IMAGES_URL = "https://image.tmdb.org/t/p/w185_and_h278_bestv2"
}

object Endpoint {
    const val DISCOVER_MOVIE = "discover/movie"
    const val TRENDING_MOVIE = "trending/all/"
    const val DISCOVER_TV = "discover/tv"
    const val MOVIE_DETAILS = "movie/"
}

object QueryMovie {
    const val API_KEY = "api_key"
    const val PAGE = "page"
    const val SORT_BY = "sort_by"
    const val LANGUAGE = "language"
    const val INCLUDE_ADULT = "include_adult"
    const val INCLUDE_VIDEO = "include_video"
    const val TIMEZONE = "timezone"
    const val INCLUDE_NULL_FIRST = "include_null_first_air_dates"


    const val SORT_BY_DEFAULT = "popularity.desc"
    const val LANGUAGE_DEFAULT = "en-US"
    const val TIMEZONE_DEFAULT = "America%2FNew_York"
    const val INCLUDE_ADULT_DEFAULT = false
    const val INCLUDE_VIDEO_DEFAULT = false
    const val INCLUDE_NULL_FIRST_DEFAULT = false

    const val API_KEY_VALUE = "c4519d9993a9c4b6576e45741333593a"
}