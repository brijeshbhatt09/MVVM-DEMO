package com.example.sbnridemo.ui

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sbnridemo.R
import com.example.sbnridemo.databinding.ActivityMainBinding
import com.example.sbnridemo.interfaces.ILoadMoreContent
import com.example.sbnridemo.model.HomeResponse
import com.example.sbnridemo.model.RowModel
import com.example.sbnridemo.ui.adapter.HomeAdapter
import com.example.sbnridemo.viewmodel.HomeViewModel


class MainActivity : AppCompatActivity(), ILoadMoreContent {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: HomeViewModel
    var list: ArrayList<RowModel?> = ArrayList()
    lateinit var adapter: HomeAdapter
    var pageRequest = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel

        adapter = HomeAdapter(this@MainActivity, this, list)
        binding.recyclerView.adapter = adapter
        observerResponse()
    }

    private fun observerResponse() {
        viewModel.getHomeResponse(pageRequest, "https://api.github.com/orgs/octokit/repos")!!.observe(
            this,
            Observer<HomeResponse?> { homeResponse ->
                if (homeResponse != null) {
                    homeResponse.getData()?.let { list.addAll(it) }
                    binding.recyclerView.post (
                        Runnable { adapter.notifyDataSetChanged()}
                    )

                    Handler().postDelayed({
                        viewModel.setLoading(false)
                    }, 500)
                }
            })
    }

    override fun loadMore() {
        pageRequest ++;
        observerResponse()
    }
}
