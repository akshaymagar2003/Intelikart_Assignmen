package com.example.intelikartassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.intelikartassignment.network.Subcategory

class SubcategoryAdapter : RecyclerView.Adapter<SubcategoryAdapter.SubcategoryViewHolder>() {
    private val subcategories: MutableList<Subcategory> = mutableListOf()

    fun setSubcategories(subcategories: List<Subcategory>) {
        this.subcategories.clear()
        this.subcategories.addAll(subcategories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_subcategory, parent, false)
        return SubcategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubcategoryViewHolder, position: Int) {
        val subcategory = subcategories[position]
        holder.bind(subcategory)
    }

    override fun getItemCount(): Int {
        return subcategories.size
    }

    inner class SubcategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val subcategoryName: TextView = itemView.findViewById(R.id.subcategoryName)
        private val subcategoryPhoto: ImageView = itemView.findViewById(R.id.subcategoryPhoto)

        fun bind(subcategory: Subcategory) {
            subcategoryName.text = subcategory.name
            // Load subcategory photo using a library like Picasso or Glide
            // Picasso.get().load(subcategory.photo).into(subcategoryPhoto)
        }
    }
}

