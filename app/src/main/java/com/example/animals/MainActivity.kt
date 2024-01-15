package com.example.animals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animals.adapter.ImagesAdapter
import com.example.animals.databinding.ActivityMainBinding
import com.example.animals.viewmodel.BreedsViewModel
import com.example.animals.viewmodel.BreedsViewModelImpl
import com.example.animals.viewmodel.ImagesViewModel
import com.example.animals.viewmodel.ImagesViewModelImpl
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val imagesViewModel: ImagesViewModel by viewModels<ImagesViewModelImpl>()
    private val breedsViewModel: BreedsViewModel by viewModels <BreedsViewModelImpl>()
    private lateinit var imagesAdapter: ImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUI()
    }

    private fun setUI() {
        imagesViewModel.loadDataImages()

        imagesAdapter =  ImagesAdapter()
        binding.mainRecyclerView.apply {
            adapter = imagesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
        imagesViewModel.responseImages.observe(this@MainActivity) { listImages ->
            imagesAdapter.imageList = listImages
        }

        imagesAdapter.onItemClick = { item ->
            val position = item.toString()
            Log.d("::MainActivity","imagesAdapter.onItemClick ${position}")
            breedsViewModel.loadDataBreeds(position)
        }

        breedsViewModel.responseBreeds.observe(this@MainActivity) { detailBreed ->

            val message = "Name: ${detailBreed.name} \n\n" +
                    "Temperament: ${detailBreed.temperament} \n\n"+
                    "Bred for: ${detailBreed.bred_for} "

            showDialogDetails(message)
        }
    }

    private fun showDialogDetails(message: String?) {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.dialog_title)
            .setMessage(message ?: "Au! au! - Infelizmente não temos detalhes.")
            .setPositiveButton(R.string.dialog_positive_button) { dialog, _ -> dialog.dismiss() }
            .setNegativeButton(R.string.dialog_negative_button) { dialog, _ -> dialog.dismiss() }
            .show()
    }

}