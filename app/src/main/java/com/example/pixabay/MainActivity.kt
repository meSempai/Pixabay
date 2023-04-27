package com.example.pixabay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pixabay.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var page = 1
    var adapter = PixabayAdapter(arrayListOf())
    var word = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            newPageBtn.setOnClickListener {
                page++
                requestImages(page)
            }
            searchBtn.setOnClickListener {
                page = 1
                adapter.list.clear()
                requestImages(page)
            }

        }
    }

    private fun ActivityMainBinding.requestImages(page: Int) {
        RetrofitService().api.getImage(searchBtn.text.toString(), page)
            .enqueue(object : retrofit2.Callback<PixabayModel> {
                override fun onResponse(
                    call: Call<PixabayModel>,
                    response: Response<PixabayModel>
                ) {
                    response.body()?.let {
                        val list = it.hits
                        imageRecycler.adapter = PixabayAdapter(list)
                    }
                }

                override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                    Log.e("ololo", "onFailure:${t.message}")
                }
            })
    }
}