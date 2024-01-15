package com.example.animals.models

class ImagesModel : ArrayList<ImagesModelItem>()

data class ImagesModelItem(
    var height: Int,
    var id: String,
    var url: String,
    var width: Int
)