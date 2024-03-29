package az.edu.bhos.l14todoapp.di

import az.edu.bhos.l14todoapp.data.TodoLocalData
import az.edu.bhos.l14todoapp.data.TodoLocalDataImpl
import org.koin.dsl.module
import az.edu.bhos.l14todoapp.flows.MainViewModel
import az.edu.bhos.l14todoapp.flows.edit.EditTodoViewModel
import az.edu.bhos.l14todoapp.data.TodoRepository
import az.edu.bhos.l14todoapp.data.TodoRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModelOf

val androidModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::EditTodoViewModel)

    single<TodoLocalData> { TodoLocalDataImpl() }
    factory<TodoRepository> { TodoRepositoryImpl(get()) }
}