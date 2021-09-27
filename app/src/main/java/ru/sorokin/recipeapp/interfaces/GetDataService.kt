package ru.sorokin.recipeapp.interfaces

import retrofit2.Call
import retrofit2.http.GET
import ru.sorokin.recipeapp.entities.Category

interface GetDataService {
    @GET("/categories.php")
    fun getCategoryList(): Call<List<Category>>
}