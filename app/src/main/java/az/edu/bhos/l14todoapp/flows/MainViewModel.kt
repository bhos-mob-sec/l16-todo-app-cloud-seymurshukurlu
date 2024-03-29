package az.edu.bhos.l14todoapp.flows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.edu.bhos.l14todoapp.data.TodoRepository
import az.edu.bhos.l14todoapp.entities.TodoEntity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel(
    todoRepo: TodoRepository
) : ViewModel() {

    private val _todoEntities: MutableLiveData<List<TodoEntity>> = MutableLiveData()

    val todoEntities: LiveData<List<TodoEntity>>
        get() = _todoEntities

    init {
        todoRepo.observeTodoEntries()
            .onEach {
                _todoEntities.postValue(it)
            }.launchIn(viewModelScope)
    }
}