package com.example.pdd_compose.domain.model.rank

data class RankModel(
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