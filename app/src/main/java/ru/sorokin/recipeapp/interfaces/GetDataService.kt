package ru.sorokin.recipeapp.interfaces

import retrofit2.Call
import retrofit2.http.GET
import ru.sorokin.recipeapp.entities.Category
import ru.sorokin.recipeapp.entities.CategoryItems

interface GetDataService {
    @GET("/categories.php")
    fun getCategoryList(): Call<Category>
}