package com.mustafa.codechallenge.ui.view

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mustafa.codechallenge.data.model.StoryContent
import com.mustafa.codechallenge.databinding.ActivityMainBinding
import com.mustafa.codechallenge.ui.adapter.MainAdapter
import com.mustafa.codechallenge.ui.viewmodel.MainViewModel
import com.mustafa.codechallenge.utils.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter
    private lateinit var binding: ActivityMainBinding  //defining the binding class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //initializing the binding class
        setContentView(binding.root) // we now set the contentview as the binding.root
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        val gridLayout = GridLayoutManager(this, 2)

        when (Configuration.ORIENTATION_PORTRAIT) {
            resources.configuration.orientation -> gridLayout.spanCount = 2
            else -> gridLayout.spanCount = 3
        }

        binding.recyclerView.layoutManager = gridLayout
        adapter = MainAdapter(arrayListOf())
        binding.recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.brochures.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { brochures -> renderList(brochures) }
                    binding.recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun renderList(brochures: List<StoryContent>) {
        adapter.addData(brochures)
        adapter.notifyDataSetChanged()
    }
}