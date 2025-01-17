package com.example.pdd_compose.data.model.rank

data class RankModelData(
    val completed_lesson: Int,
    val completed_test: Int,
    val id: Int,
    val image: String,
    val is_current_user: Boolean,
    val rank: String,
    val temp_rank: Int,
    val total_points: Int,
    val user: String
)