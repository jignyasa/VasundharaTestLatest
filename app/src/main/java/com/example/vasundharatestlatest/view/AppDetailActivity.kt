package com.example.vasundharatest.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vasundharatest.AppDetailsViewModel
import com.example.vasundharatest.Constant
import com.example.vasundharatest.listener.OnItemClickListener
import com.example.vasundharatest.model.SubCategoryItem
import com.example.vasundharatest.view.adapter.AppdetailAdapter
import com.example.vasundharatestlatest.R
import com.example.vasundharatestlatest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AppDetailActivity : AppCompatActivity(),OnItemClickListener {
    lateinit var viewModel: AppDetailsViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: AppdetailAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViewModel()
        initView()
        subscribeObserver()
    }

    private fun subscribeObserver() {
        viewModel.data.observe(this, Observer {
            if (it.first?.equals(Constant.DATA_LOADED) == true) {
                adapter.addData(viewModel.appDetailList)
            }
            when (it.first) {
                Constant.DATA_LOADED -> adapter.addData(viewModel.appDetailList)
                Constant.ERROR -> {
                    Toast.makeText(this@AppDetailActivity, it.second.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    private fun initView() {
        binding.viewModel=viewModel
        adapter = AppdetailAdapter(this)
        binding.rvAppDetails.adapter = adapter
        binding.rvAppDetails.layoutManager = LinearLayoutManager(this)
        binding.btnBlickBox.setOnClickListener {
            startActivity(Intent(this@AppDetailActivity,BlickActivity::class.java))
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this@AppDetailActivity).get(AppDetailsViewModel::class.java)
        viewModel.getData()
    }

    override fun onItemClick(data: SubCategoryItem) {
        val viewIntent = Intent(
            "android.intent.action.VIEW",
            Uri.parse("https://play.google.com/store/apps/details?id=${data.appLink}")
        )
        startActivity(viewIntent)
    }
}