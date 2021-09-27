package ru.sorokin.recipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rv_main_category.view.*
import ru.sorokin.recipeapp.R
import ru.sorokin.recipeapp.entities.Recipes

class MainCategoryAdapter: RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var arrMainCategory = ArrayList<Recipes>()
    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    fun setData(arrData : List<Recipes>){
        arrMainCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.tv_dish_name.text = arrMainCategory[position].dishName
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }
}