package com.tarikul.sampleproject.data.model.tvShowList

data class TvShowListResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)