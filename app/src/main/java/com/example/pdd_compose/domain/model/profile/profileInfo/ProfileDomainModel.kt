package com.example.pdd_compose.domain.model.profile.profileInfo

data class ProfileDomainModel(
    val user: String?,
    val image:String,
    val completed_lesson: Int?,
    val completed_test: Int?,
    val total_points: Int?,
    val rank: String?,
    val next_rank:String?,
    val point_count:Int,
    val points_to_next_rank:Int
)