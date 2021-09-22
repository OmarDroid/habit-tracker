package com.android.kotlin.habittracker.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.android.kotlin.habittracker.data.database.HabitDatabase
import com.android.kotlin.habittracker.data.models.Habit
import com.android.kotlin.habittracker.logic.repository.HabitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HabitViewModel(application: Application): AndroidViewModel(application) {
    private val repository: HabitRepository
    val getAllHabits: LiveData<List<Habit>>

    init {
        val habitDao = HabitDatabase.getDatabase(application).habitDao()
        repository = HabitRepository(habitDao)
        getAllHabits = repository.getAllHabits
    }
    fun addHabit(habit: Habit){
        viewModelScope.launch(Dispatchers.IO){
            repository.addHabit(habit)
        }
    }

    fun updateHabit(habit: Habit){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateHabit(habit)
        }
    }

    fun deleteHabit(habit: Habit){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteHabit(habit)
        }
    }

    fun deleteAllHabits(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllHabits()
        }
    }
}