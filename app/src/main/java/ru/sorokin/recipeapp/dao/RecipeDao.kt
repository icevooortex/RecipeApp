package ru.sorokin.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.sorokin.recipeapp.entities.Category
import ru.sorokin.recipeapp.entities.CategoryItems

@Dao
interface RecipeDao {

    @get:Query("SELECT * FROM category ORDER BY id DESC")
    val getAllCategory: List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: CategoryItems)

    @Query("DELETE FROM categoryitems")
    suspend fun clearDb()
}