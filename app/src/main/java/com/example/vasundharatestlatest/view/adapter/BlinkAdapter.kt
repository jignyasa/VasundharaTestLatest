package com.example.vasundharatest.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.vasundharatest.listener.OnItemClickPositionListener
import com.example.vasundharatest.model.BlinkModel
import com.example.vasundharatestlatest.R
import com.example.vasundharatestlatest.databinding.ItemBlinkBinding

class BlinkAdapter(val listener: OnItemClickPositionListener) :
    Adapter<BlinkAdapter.BlinkViewHolder>() {
    lateinit var binding: ItemBlinkBinding
    var list = ArrayList<BlinkModel>()

    class BlinkViewHolder(view: View) : ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlinkViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_blink,
            parent,
            false
        )
        return BlinkViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: BlinkViewHolder, position: Int) {
        var data= list.get(position)
        binding.tvAppName.visibility=(if(data.isVisible) View.VISIBLE else View.GONE)
        binding.root.setOnClickListener { listener.onItemClick(position) }
    }

    fun addData(appList: ArrayList<BlinkModel>) {
         list = appList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}