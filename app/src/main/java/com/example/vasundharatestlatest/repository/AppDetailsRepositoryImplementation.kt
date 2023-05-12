package com.example.vasundharatest.repository

import com.example.vasundharatest.model.ScreenInfoData
import com.example.vasundharatest.remote.RestApi
import io.reactivex.Observable
import javax.inject.Inject

class AppDetailsRepositoryImplementation @Inject constructor(val api:RestApi) :AppDetailRepository() {
    override fun getAppData(): Observable<ScreenInfoData> {
        return api.getData()
    }
}