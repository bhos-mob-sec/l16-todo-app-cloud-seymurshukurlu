package az.edu.bhos.l14todoapp.data

import az.edu.bhos.l14todoapp.entities.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun observeTodoEntries(): Flow<List<TodoEntity>>
    suspend fun save(todoEntity: TodoEntity)
}

class TodoRepositoryImpl(
    private val localData: TodoLocalData
) : TodoRepository {

    override fun observeTodoEntries(): Flow<List<TodoEntity>> {
        return localData.observeTodoItems()
    }

    override suspend fun save(todoEntity: TodoEntity) {
        localData.save(todoEntity)
    }

}