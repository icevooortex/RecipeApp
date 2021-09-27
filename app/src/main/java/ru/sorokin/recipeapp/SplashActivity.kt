package ru.sorokin.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Response
import ru.sorokin.recipeapp.entities.Category
import ru.sorokin.recipeapp.entities.CategoryItems
import ru.sorokin.recipeapp.interfaces.GetDataService
import ru.sorokin.recipeapp.retrofitclient.RetrofitClientInstance
import retrofit2.Callback

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        btnGetStarted.setOnClickListener {
            var intent = Intent(this@SplashActivity,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getCategories(){
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getCategoryList()
        call.enqueue(object : Callback<CategoryItems> {
            override fun onFailure(call: Call<CategoryItems>, t: Throwable) {

                loader.visibility = View.INVISIBLE
                Toast.makeText(this@SplashActivity, "Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(
                call: Call<CategoryItems>,
                response: Response<CategoryItems>
            ) {

                //insertDataIntoRoomDb(response.body())
            }

        })
    }

    fun insertDataIntoRoomDb(category: List<Category>?){

    }
}