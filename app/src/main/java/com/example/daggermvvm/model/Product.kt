package com.example.daggermvvm.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonProperty

@Entity
data class Product(
    @JsonProperty("category")
    var category: String?,
    @JsonProperty("description")
    var description: String?,
    @JsonProperty("id")
    @PrimaryKey(autoGenerate = false)
    var id: Int?,
    @JsonProperty("image")
    var image: String?,
    @JsonProperty("price")
    var price: Double?,
    @JsonProperty("title")
    var title: String?
)