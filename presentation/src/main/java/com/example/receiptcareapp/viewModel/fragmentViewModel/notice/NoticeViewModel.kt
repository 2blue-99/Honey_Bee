package com.example.receiptcareapp.viewModel.fragmentViewModel.notice

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.domain.model.send.DomainGetNoticeListData
import com.example.domain.usecase.notice.GetNoticeListUseCase
import com.example.receiptcareapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

/**
 * 2023-08-13
 * pureum
 */
@HiltViewModel
class NoticeViewModel @Inject constructor(
    private val getNoticeListUseCase: GetNoticeListUseCase
) : BaseViewModel(){

    val loading : MutableLiveData<Boolean> get() = isLoading

    private val _response = MutableLiveData<MutableList<DomainGetNoticeListData>>()
    val response: MutableLiveData<MutableList<DomainGetNoticeListData>> get() = _response

    fun getNoticeList(){
        modelScope.launch {
            withTimeoutOrNull(waitTime){
                isLoading.postValue(true)
                _response.postValue(getNoticeListUseCase()!!)
                isLoading.postValue(false)
            }
        }
    }
}