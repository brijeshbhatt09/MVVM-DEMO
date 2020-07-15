package com.example.sbnridemo.ui

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sbnridemo.R
import com.example.sbnridemo.databinding.ActivityMainBinding
import com.example.sbnridemo.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel
    }

    private fun observerResponse() {
        viewModel.getHomeResponse("http://www.highwaypitstop.com/API/test.json")!!.observe(
            this,
            Observer<Any?> { homeResponse ->
                if (homeResponse != null) {
                    list.addAll(homeResponse.getData())
                    binding.recyclerView.adapter!!.notifyDataSetChanged()
                    Handler().postDelayed({
                        viewModel.setLoading(false)
                    }, 500)
                }
            })
    }
}
