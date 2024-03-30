package az.edu.bhos.l14todoapp.data.dto

import az.edu.bhos.l14todoapp.entities.TodoEntity
import kotlinx.serialization.Serializable

// TODO complete the dto class
@Serializable
data class TodoRemoteDto(
    val title: String,
) {
    fun toEntity() = TodoEntity(
        id = "",
        title = title,
        completed = false,
        weekday = ""
    )
}