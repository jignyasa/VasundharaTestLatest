package com.example.vasundharatest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vasundharatest.Constant
import com.example.vasundharatest.listener.OnItemClickPositionListener
import com.example.vasundharatest.model.BlinkModel
import com.example.vasundharatest.view.adapter.AppdetailAdapter
import com.example.vasundharatest.view.adapter.BlinkAdapter
import com.example.vasundharatestlatest.R
import com.example.vasundharatestlatest.databinding.ActivityBlinkResultBinding

class BlinkResultActivity : AppCompatActivity(),OnItemClickPositionListener {
    lateinit var binding: ActivityBlinkResultBinding
    lateinit var adapter: BlinkAdapter
    var number=0
    var list=ArrayList<BlinkModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_blink_result)
        initView()
    }

    private fun initView() {
        adapter = BlinkAdapter(this)
        binding.rvAppDetails.adapter = adapter
        binding.rvAppDetails.layoutManager = GridLayoutManager(this,4)
        binding.rvAppDetails.setHasFixedSize(true)
        if(intent.getIntExtra(Constant.NUMBER,0)!=null){
           number=intent.getIntExtra(Constant.NUMBER,0)
            if(number>3 && number<11){
                for(i in 1..number){
                    list.add(BlinkModel(i,true))
                }
                adapter.addData(list)
            }
        }

    }

    override fun onItemClick(position: Int) {
        var prev=0
        var next=0
        var listModified=ArrayList<BlinkModel>()
        listModified=list
        if(position>0){
            var data=list.get(position-1)
            data.isVisible=false
            listModified.add(position-1,data)
        }
        if(position<list.size-1){
            var data=list.get(position+1)
            data.isVisible=false
            listModified.add(position+1,data)
        }
        adapter.addData(listModified)

        }
}