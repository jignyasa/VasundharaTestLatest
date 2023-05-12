package com.example.vasundharatest.remote

import com.example.vasundharatest.model.ScreenInfoData
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {
    @GET("com.hd.camera.apps.high.quality")
    fun getData():Observable<ScreenInfoData>
}