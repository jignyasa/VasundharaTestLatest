package com.example.vasundharatest

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vasundharatest.model.ScreenInfoData
import com.example.vasundharatest.model.SubCategoryItem
import com.example.vasundharatest.repository.AppDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(val repository: AppDetailRepository) : ViewModel() {
    var data = MutableLiveData<Pair<*, *>>()
    var appDetailList = ObservableArrayList<SubCategoryItem>()
    var progress = ObservableBoolean(false)
    fun getData() {
        progress.set(true)
        repository.getAppData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ScreenInfoData> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: ScreenInfoData) {
                    progress.set(false)
                    var subCategory = t.appCenter?.find { it.name == Constant.POPULAR_GAMES }
                    if (subCategory?.subCategory?.isEmpty()?.not() == true) {
                        subCategory.subCategory?.let {
                            appDetailList.addAll(it)
                        }
                        data.postValue(Pair(Constant.DATA_LOADED, appDetailList))
                    }
                    Log.e(AppDetailsViewModel::class.java.simpleName, t.appCenter.toString())
                }

                override fun onError(e: Throwable) {
                    progress.set(false)
                    data.postValue(Pair(Constant.ERROR, e.message.toString()))
                }

                override fun onComplete() {

                }

            })
    }
}