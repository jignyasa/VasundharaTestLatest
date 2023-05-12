package com.example.vasundharatest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NativeAdd(@Expose @SerializedName("image")
                     val image: String? = "",
                     @Expose @SerializedName("is_active")
                     val isActive: Int? = 0,
                     @Expose @SerializedName("image_active")
                     val imageActive: Int? = 0,
                     @Expose @SerializedName("package_name")
                     val packageName: String? = "",
                     @Expose @SerializedName("playstore_link")
                     val playstoreLink: String? = "",
                     @Expose @SerializedName("id")
                     val id: Int? = 0,
                     @Expose @SerializedName("position")
                     val position: Int? = 0)