package kg.geekstudio.main_domain.model.level

data class LevelModel(
    val id: Int,
    val name: String,
    val description: String,
    val order: Int,
    val passed_lessons : PassedLessonsModel?,
    val points: PointsModel?,
    val available: Boolean,
)

