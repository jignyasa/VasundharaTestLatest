package com.example.vasundharatest.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.vasundharatest.listener.OnItemClickListener
import com.example.vasundharatest.model.SubCategoryItem
import com.example.vasundharatestlatest.R
import com.example.vasundharatestlatest.databinding.ItemAppDetailBinding

class AppdetailAdapter(val listener: OnItemClickListener) : Adapter<AppdetailAdapter.AppDetailViewHolder>() {
    lateinit var binding: ItemAppDetailBinding
    var list=ArrayList<SubCategoryItem>()
    class AppDetailViewHolder(view:View) :ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppDetailViewHolder {
        binding=DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_app_detail,parent,false)
        return AppDetailViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: AppDetailViewHolder, position: Int) {
        var data=list.get(position)
        binding.tvAppName.text=data.name
        binding.tvPrice.text=data.installedRange
        binding.ratingBar.rating=data.star?.let { it.toFloat() }?:0F
        Glide.with(binding.root.context).load(data.icon).placeholder(R.mipmap.ic_launcher).into(binding.ivAppIcon)
        binding.btnDownload.setOnClickListener {
            listener.onItemClick(data)
        }
    }

    fun addData(appList:ArrayList<SubCategoryItem>){
        list=appList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}