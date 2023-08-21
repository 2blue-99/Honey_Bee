package com.example.domain.usecase.bill

import android.graphics.Bitmap
import com.example.domain.model.receive.ServerPictureData
import com.example.domain.model.receive.ServerResponseData
import com.example.domain.repo.GeneralRepository

/**
 * 2023-07-23
 * pureum
 */
class GetPictureDataUseCase(
    private val generalRepository: GeneralRepository
) {
    suspend operator fun invoke(uid:String) : ServerPictureData {
        return generalRepository.getPictureDataUseCaseRepository(uid)
    }
}