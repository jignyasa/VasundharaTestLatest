package com.example.vasundharatest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeItem(@Expose @SerializedName("is_active")
                    val isActive: Int? = 0,
                    @Expose @SerializedName("sub_category")
                    val subCategory: List<SubCategoryItem>?,
                    @Expose @SerializedName("name")
                    val name: String? = "",
                    @Expose @SerializedName("id")
                    val id: Int? = 0,
                    @Expose @SerializedName("position")
                    val position: Int? = 0,
                    @Expose @SerializedName("catgeory")
                    val catgeory: String? = "")