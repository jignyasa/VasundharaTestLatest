package com.example.vasundharatest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.vasundharatest.Constant
import com.example.vasundharatestlatest.R
import com.example.vasundharatestlatest.databinding.ActivityBlickBinding

class BlickActivity : AppCompatActivity() {
    lateinit var binding: ActivityBlickBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_blick)
        initView()
    }

    private fun initView() {
        binding.btnStart.setOnClickListener {
            if(binding.etNumber.length()>0 && binding.etNumber.text.toString().toInt()>3){
                startActivity(Intent(this@BlickActivity,BlinkResultActivity::class.java).putExtra(Constant.NUMBER,binding.etNumber.text.toString().toInt()))
            }else{
                Toast.makeText(this@BlickActivity,getString(R.string.enterProperValue),Toast.LENGTH_SHORT).show()
            }
        }
    }
}