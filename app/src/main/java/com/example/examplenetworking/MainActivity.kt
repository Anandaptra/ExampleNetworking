package com.example.examplenetworking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examplenetworking.databinding.ActivityMainBinding
import com.example.examplenetworking.model.ResponseDataNewsItem
import com.example.examplenetworking.network.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataNews()
    }

    fun getDataNews() {
        RetrofitClient.instance.getAllNews().enqueue(object : retrofit2.Callback<List<ResponseDataNewsItem>>{
            override fun onResponse(
                call: Call<List<ResponseDataNewsItem>>,
                response: Response<List<ResponseDataNewsItem>>
            ) {
                if (response.isSuccessful) {
                    binding.rvNews.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    binding.rvNews.adapter = NewsAdapter(response.body()!!)
                }else {
                    Toast.makeText(this@MainActivity, "failed load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ResponseDataNewsItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "", Toast.LENGTH_SHORT).show()
            }

        })
    }
}