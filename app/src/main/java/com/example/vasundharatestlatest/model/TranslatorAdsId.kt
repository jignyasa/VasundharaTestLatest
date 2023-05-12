package com.example.vasundharatest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TranslatorAdsId(@Expose @SerializedName("interstitial")
                           val interstitial: String? = "",
                           @Expose @SerializedName("banner")
                           val banner: String? = "")