package ru.sorokin.recipeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.sorokin.recipeapp.dao.RecipeDao
import ru.sorokin.recipeapp.entities.Category
import ru.sorokin.recipeapp.entities.CategoryItems
import ru.sorokin.recipeapp.entities.Recipes
import ru.sorokin.recipeapp.entities.converter.CategoryListConverter

@Database(entities = [Recipes::class, CategoryItems::class, Category::class, CategoryListConverter::class], version = 1, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {
    companion object{

        var recipesDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if (recipesDatabase != null){
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }

    abstract fun recipeDao():RecipeDao
}