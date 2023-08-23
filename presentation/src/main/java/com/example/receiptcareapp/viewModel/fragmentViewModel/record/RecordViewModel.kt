package com.example.receiptcareapp.viewModel.fragmentViewModel.record

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.model.local.DomainRoomData
import com.example.domain.model.receive.bill.ServerBillData
import com.example.domain.usecase.bill.GetDataListUseCase
import com.example.domain.usecase.room.GetDataListRoomUseCase
import com.example.receiptcareapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import java.net.SocketTimeoutException
import javax.inject.Inject

/**
 * 2023-06-22
 * pureum
 */
@HiltViewModel
class RecordViewModel @Inject constructor(
    private val getRoomDataListUseCase: GetDataListRoomUseCase,
    private val getDataListUseCase: GetDataListUseCase,
): BaseViewModel() {

    val loading : MutableLiveData<Boolean> get() = isLoading

    //서버에서 받은 데이터 담는 박스
    private val _billList = MutableLiveData<ServerBillData?>()
    val billList: LiveData<ServerBillData?> get() = _billList

    //룸에서 받은 데이터 담는 박스
    private var _roomData = MutableLiveData<MutableList<DomainRoomData>>()
    val roomData: LiveData<MutableList<DomainRoomData>> get() = _roomData

    fun getLocalAllData() {
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            isLoading.postValue(true)
            val gap = getRoomDataListUseCase()
            Log.e("TAG", "receiveAllRoomData: $gap")
            _roomData.postValue(gap)
            isLoading.postValue(false)
        }
    }

    // Server 데이터 불러오는 부분
    fun getServerAllBillData() {
        modelScope.launch {
            isLoading.postValue(true)
            withTimeoutOrNull(waitTime){
                _billList.postValue(getDataListUseCase())
            } ?: throw SocketTimeoutException()
            isLoading.postValue(false)
        }
    }
}