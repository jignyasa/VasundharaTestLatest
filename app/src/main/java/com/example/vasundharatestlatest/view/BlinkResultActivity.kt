package com.example.vasundharatest.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vasundharatest.Constant
import com.example.vasundharatest.listener.OnItemClickPositionListener
import com.example.vasundharatest.model.BlinkModel
import com.example.vasundharatest.view.adapter.BlinkAdapter
import com.example.vasundharatestlatest.R
import com.example.vasundharatestlatest.databinding.ActivityBlinkResultBinding

class BlinkResultActivity : AppCompatActivity(), OnItemClickPositionListener {
    lateinit var binding: ActivityBlinkResultBinding
    lateinit var adapter: BlinkAdapter
    var number = 0
    var list = ArrayList<BlinkModel>()
    lateinit var gridLayoutManager: GridLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_blink_result)
        initView()
    }

    private fun initView() {
        adapter = BlinkAdapter(this)
        binding.rvAppDetails.adapter = adapter
        gridLayoutManager=GridLayoutManager(this, 4)
        binding.rvAppDetails.layoutManager = gridLayoutManager
        binding.rvAppDetails.setHasFixedSize(true)
        if (intent.getIntExtra(Constant.NUMBER, 0) != null) {
            number = intent.getIntExtra(Constant.NUMBER, 0)
            if (number > 3 && number < 11) {
                for (i in 1..number*number) {
                    list.add(BlinkModel(i, true))
                }
                adapter.addData(list)
            }
        }

    }

    override fun onItemClick(position: Int) {
        var prev = 0
        var next = 0
        var listModified = ArrayList<BlinkModel>()
        listModified = list
        /* if(position==0){
            listModified.get(position).isVisible=false
        }
        if(position>0){
            listModified.get(position-1).isVisible=false
        }
        if(position<list.size){
            listModified.get(position+1).isVisible=false
        }*/
        try {
            var row = position / 4
            var col = position % 4
            for (i in 0..3) {
                var rowPos = row * (4) + i
                var colPos = i * 4 + col
                var rowView=gridLayoutManager.findViewByPosition(rowPos)
                if(rowView!=null){
                    rowView.visibility=View.GONE
                }

                var colView=gridLayoutManager.findViewByPosition(colPos)
                if(colView!=null){
                    colView.visibility=View.GONE
                }

            }
            /* if (row == col) {
                 listModified.get(row).isVisible = false
                 Log.e("data row==col",row.toString())
             } else if (row + col == list.size - 1) {
                 listModified.get(row + col).isVisible = false
                 Log.e("data row + col",(row + col).toString())
             }*/
        } catch (e: Exception) {

        }
        //adapter.addData(listModified)
    }

}