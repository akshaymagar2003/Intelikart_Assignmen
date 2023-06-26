package com.example.intelikartassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.intelikartassignment.network.Category

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val categories: MutableList<Category> = mutableListOf()

    fun setCategories(categories: List<Category>) {
        this.categories.clear()
        this.categories.addAll(categories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryName: TextView = itemView.findViewById(R.id.categoryName)
        private val categoryPhoto: ImageView = itemView.findViewById(R.id.categoryPhoto)
        private val subcategoryRecyclerView: RecyclerView = itemView.findViewById(R.id.subcategoryRecyclerView)
        private val subcategoryAdapter: SubcategoryAdapter = SubcategoryAdapter()

        init {
            subcategoryRecyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            subcategoryRecyclerView.adapter = subcategoryAdapter
        }

        fun bind(category: Category) {
            categoryName.text = category.name
            // Load category photo using a library like Picasso or Glide
            // Picasso.get().load(category.photo).into(categoryPhoto)

            subcategoryAdapter.setSubcategories(category.subcategories)
        }
    }
}



