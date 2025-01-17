package com.example.pdd_compose.data.mapper

import com.example.pdd_compose.data.model.profile.ProfileDataModel
import com.example.pdd_compose.data.model.rank.RankModelData
import com.example.pdd_compose.data.model.register.AccessModelData
import com.example.pdd_compose.domain.model.profile.profileInfo.ProfileDomainModel
import com.example.pdd_compose.domain.model.rank.RankModel
import com.example.pdd_compose.domain.model.register.AccessModel
import kg.geekstudio.main_data.model.level.LevelDataModel
import kg.geekstudio.main_data.model.level.PassedLessonsDataModel
import kg.geekstudio.main_data.model.level.PointsDataModel
import kg.geekstudio.main_domain.model.level.LevelModel
import kg.geekstudio.main_domain.model.level.PassedLessonsModel
import kg.geekstudio.main_domain.model.level.PointsModel

fun AccessModelData.toDomain() = AccessModel(
    user, refresh, access
)

fun ProfileDataModel.toProfile() = ProfileDomainModel(
    user,
    image,
    completed_lesson,
    completed_test,
    total_points,
    rank,
    next_rank,
    point_count,
    points_to_next_rank
)

fun RankModelData.toRank() = RankModel(
    completed_lesson, completed_test, id, image, is_current_user, rank, temp_rank, total_points, user
)

fun LevelDataModel.toLevel() = LevelModel(
    id, name, description, order, passed_lessons?.toPassed(), points?.toPoints(), available
)

fun PassedLessonsDataModel.toPassed() = PassedLessonsModel(
    user_lessons, level_lessons
)

fun PointsDataModel.toPoints() = PointsModel(
    user_points, level_points
)