package com.example.kotlinmvvmapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinmvvmapi.MainActivity
import com.example.kotlinmvvmapi.R
import com.example.kotlinmvvmapi.models.Product

class ProductAdapter(private val mList: List<Product>, private val mainActivity: MainActivity) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_product, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.textViewTitle.text = ItemsViewModel.title
        holder.textViewPrice.text = "Price: \u20B9 "+ItemsViewModel.price
        holder.textViewCategory.text = ItemsViewModel.category
        holder.textViewDescription.text = "Description- "+ItemsViewModel.description
        Glide.with(mainActivity).load(ItemsViewModel.image).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
        val textViewCategory: TextView = itemView.findViewById(R.id.textViewCategory)
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        val imageView : ImageView = itemView.findViewById(R.id.idImageView)
    }
}


