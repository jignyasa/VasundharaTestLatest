package com.example.vasundharatest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SubCategoryItem(@Expose @SerializedName("app_link")
                           val appLink: String? = "",
                           @Expose @SerializedName("is_active")
                           val isActive: Int? = 0,
                           @Expose @SerializedName("star")
                           val star: String? = "",
                           @Expose @SerializedName("image_active")
                           val imageActive: Int? = 0,
                           @Expose @SerializedName("installed_range")
                           val installedRange: String? = "",
                           @Expose @SerializedName("name")
                           val name: String? = "",
                           @Expose @SerializedName("icon")
                           val icon: String? = "",
                           @Expose @SerializedName("banner")
                           val banner: String? = "",
                           @Expose @SerializedName("id")
                           val id: Int? = 0,
                           @Expose @SerializedName("position")
                           val position: Int? = 0,
                           @Expose @SerializedName("banner_image")
                           val bannerImage: String? = "",
                           @Expose @SerializedName("app_id")
                           val appId: Int? = 0)