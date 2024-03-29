package az.edu.bhos.l14todoapp.entities

data class TodoEntity(
    val title: String,
    val completed: Boolean,
    val category: TodoCategory
)