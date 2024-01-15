package com.example.animals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.animals.adapter.ImagesAdapter
import com.example.animals.databinding.ActivityMainBinding
import com.example.animals.viewmodel.ImagesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val imagesViewModel: ImagesViewModel by viewModels()
    private lateinit var imagesAdapter: ImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycleView()
    }

    private fun initRecycleView() {
        imagesAdapter =  ImagesAdapter()

        binding.mainRecyclerView.apply {
            adapter = imagesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        imagesViewModel.responseImages.observe(this) { listImages ->
            imagesAdapter.imageList = listImages
        }
    }
}