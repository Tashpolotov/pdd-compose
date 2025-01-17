package kg.geekstudio.main_data.model.level

data class LevelDataModel(
    val id: Int,
    val name: String,
    val description: String,
    val order: Int,
    val passed_lessons : PassedLessonsDataModel?,
    val points: PointsDataModel?,
    val available: Boolean,
)
