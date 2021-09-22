package com.android.kotlin.habittracker.logic.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.kotlin.habittracker.data.models.Habit
import kotlinx.coroutines.selects.select

@Dao
interface HabitDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHabit(habit: Habit)
    @Update
    suspend fun updateHabit(habit: Habit)
    @Query("SELECT * FROM habit_table ORDER BY id DESC")
    fun getAllHabits():LiveData<List<Habit>>
    @Delete
    suspend fun deleteHabit(habit: Habit)
    @Query("DELETE FROM habit_table")
    suspend fun deleteAll()
}