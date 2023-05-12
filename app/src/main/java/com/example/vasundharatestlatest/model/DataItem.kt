package com.example.vasundharatest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataItem(@Expose @SerializedName("app_link")
                    val appLink: String? = "",
                    @Expose @SerializedName("full_thumb_image")
                    val fullThumbImage: String? = "",
                    @Expose @SerializedName("thumb_image")
                    val thumbImage: String? = "",
                    @Expose @SerializedName("splash_active")
                    val splashActive: Int? = 0,
                    @Expose @SerializedName("name")
                    val name: String? = "",
                    @Expose @SerializedName("package_name")
                    val packageName: String? = "",
                    @Expose @SerializedName("id")
                    val id: Int? = 0,
                    @Expose @SerializedName("position")
                    val position: Int? = 0,
                    @Expose @SerializedName("app_id")
                    val appId: Int? = 0)