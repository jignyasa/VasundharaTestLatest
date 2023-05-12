package com.example.vasundharatest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ScreenInfoData(@Expose @SerializedName("more_apps")
                          val moreApps: List<MoreAppsItem>?,
                          @Expose @SerializedName("native_add")
                          val nativeAdd: NativeAdd?,
                          @Expose @SerializedName("data")
                          val data: List<DataItem>?,
                          @Expose @SerializedName("translator_ads_id")
                          val translatorAdsId: TranslatorAdsId?,
                          @Expose @SerializedName("app_center")
                          val appCenter: List<AppCenterItem>?,
                          @Expose @SerializedName("message")
                          val message: String? = "",
                          @Expose @SerializedName("status")
                          val status: Int? = 0,
                          @Expose @SerializedName("home")
                          val home: List<HomeItem>?)