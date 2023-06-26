package com.example.intelikartassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.intelikartassignment.network.ApiService
import com.example.intelikartassignment.network.RetrofitClient
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        categoryAdapter = CategoryAdapter()
        recyclerView.adapter = categoryAdapter

        fetchCategories()
    }

    private fun fetchCategories() {
        val apiService = RetrofitClient.apiService

        GlobalScope.launch(Dispatchers.Main) {
            try {
                val categories = apiService.getCategories()
                categoryAdapter.setCategories(categories)
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Error fetching categories", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


