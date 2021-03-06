package ru.sorokin.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch
import ru.sorokin.recipeapp.adapter.MainCategoryAdapter
import ru.sorokin.recipeapp.adapter.SubCategoryAdapter
import ru.sorokin.recipeapp.database.RecipeDatabase
import ru.sorokin.recipeapp.entities.Category
import ru.sorokin.recipeapp.entities.CategoryItems
import ru.sorokin.recipeapp.entities.Recipes

class HomeActivity : BaseActivity() {
    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<Recipes>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        getDataFromDb()

        arrSubCategory.add(Recipes(1,"Beef and mustard pie"))
        arrSubCategory.add(Recipes(2,"Chicken and mushroom hotpot"))
        arrSubCategory.add(Recipes(3,"Banana pancakes"))
        arrSubCategory.add(Recipes(4,"kapsalon"))

        subCategoryAdapter.setData(arrSubCategory)



        rv_sub_category.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_sub_category.adapter = subCategoryAdapter


    }

    private fun getDataFromDb(){
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()
                mainCategoryAdapter.setData(arrMainCategory)
                rv_main_category.layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
                rv_main_category.adapter = mainCategoryAdapter
            }

        }
    }
}