package com.example.intelikartassignment.network

data class Category(
    val name: String,
    val photo: String,
    var subcategories: List<Subcategory>
)

