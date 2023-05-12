package com.example.vasundharatest.repository

import com.example.vasundharatest.model.ScreenInfoData
import io.reactivex.Observable

abstract class AppDetailRepository {
   abstract fun getAppData(): Observable<ScreenInfoData>
}